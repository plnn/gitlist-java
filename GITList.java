/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author erdem
 */
public class GITList<E> {
    
    public static class Node<E> {
        
        public Node<E> next;
        public Node<E> prev;
        private static final int cap=10;
        public E[] data=(E[])new Object[cap];
        
        /**/
        Node(E obj){
            next=null;prev=null;
            data[0]=obj;
            
        }
        
        /*nodun constructoru*/
        Node(){
            next=null;
            prev=null;
        }
        /*iki parametreli constructor*/
        Node(E[] i,int s){
            int m;
            for(m=0;m<i.length;++m)
                data[m]=i[m];
            prev=null;
            next=null;
            
        }
        /*dort parametreli constructor*/
        Node(Node n,Node p,E[] d,int s){
            next=n;
          prev=p;
            int i;
            for(i=0;i<d.length || i<10;++i) {
                data[i]=d[i];
            }
         
        }
       
      
        
}
    
  
    /*GITlistin head ve taili ve kac tane nodu oldugu nu tutan integer data field i*/
    private Node<E> head=null;
    private Node<E> t=null;
    private int size=0;
    private int nodeIndex=0;
    
    /*GITList in default constructoru*/
    GITList(){
        
    }
    /*parametreli constructor*/
    GITList(Node<E> h,Node<E> p,int s){
        head=h;
        t=p;
        size=s;
    }
    /*parametreli constructor*/
    GITList(Node<E> h,int s){
        head=h;
        t=h;
        size=s;
    }
    
    /*iterator ic classi*/
    private  class GITIterator<E> implements ListIterator<E>{
        
        /*arrayin elemanına referans*/
        private E data;
        /*constructorda belirlenen indexteki noda ait referans*/
        private Node<E> nextItem;
        /*next ve previos tarafindan donen son item a referans*/
        private Node<E> lastReturned;
        /*index constructorda nodun arrayinin elemanını indexi*/
        private int index=0;
        
        private final int  capacity=10;
        /*flag eleman ekleme durumunda elemanın eklenecek posizyonuna göre belirleniyor*/
        private int flag=1;
        /*bos constructor*/
        public GITIterator(){
            nextItem=(Node<E>) head;
            lastReturned=null;
            index=0;
            flag=0;
        }
        
        /*i degerine karsılık gelen nod ve indexi set eder*/
        public GITIterator(int i){
            if(i<0 || i>size)
                throw new IndexOutOfBoundsException("index "+i);
            lastReturned=null;
            
          
            if(i==size)
            {
             /*arrayin en son elemanıysa nextItem arayı gosterecek null yani*/
              if(size%capacity==0)
                   nextItem=null;
              else/*degilse nextItem taili gosterecek her sekilde*/
                  nextItem=(Node<E>) t;
            }
            
            else{
                /*i size a eşit degilse head den başlayarak i nin degerine 
                 varana dek capacity kadar artıp iden buyuk olana dek
                 * for calısır nextItem ve index set eder*/
                    nextItem= (Node<E>)head;
                 
                       
                for(index=capacity;index<=i;index+=capacity)
                        nextItem=nextItem.next;
                
                index=i%capacity;
               
               data=nextItem.data[index];      
              
            }
            
            
        }
        
        
        @Override
        /*bir arraydaki en sondaki elemani gosteriyorsa ve next in gosterdigi
         * bir node varsa next i vardır yada ortalardaysa bir sonraki eleman
         var mı*/
        
        public boolean hasNext() {
            if(index==capacity-1 && nextItem.next!=null)
                return true;
            return nextItem.data[index+1]!=null;
        }
        /*bir sonraki array elemanı mevcut mu diye bakar
        */
        @Override
        public E next(){
            if(!hasNext())
                throw new NoSuchElementException("invalid");
            
            if(index%capacity==capacity-1){
                data=nextItem.data[capacity-1];
                nextItem=nextItem.next;
                index=0;
            
            }
            
            else{
                data=nextItem.data[index];
             ++index;
            }
            return data;
        }
        /*bir önceki array eleamnı var mı */
        @Override
        public boolean hasPrevious() {
            return ((nextItem==null && size!=0) || nextItem.data[index-1]!= null
                    || index==0 && nextItem.prev!=null);


        }
            /*hasPrev true ise bir önceki arry elemanını return eder*/
        @Override
        public E previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException("invalid ");
            }
           if(index%capacity==0){
               data=nextItem.prev.data[capacity-1];
               nextItem=nextItem.prev;
               index=capacity-1;
               lastReturned=nextItem;
           }
           else{
               data=nextItem.data[index-1];
               lastReturned=nextItem;
               --index;
           }
               return data;
           
        }
        /*indexi return eder*/
        @Override
        public int nextIndex() {
            return index;
            
        }
           /*bir önceki indexi dondurur*/
        @Override
        public int previousIndex() {
        
            return index-1;
        }
        /*constructorda belirlenen indexteki elemanı siler*/
        @Override
        public void remove() {
        if(lastReturned==null)
             throw new IllegalStateException();
         if(lastReturned==t && size%capacity==index){
             t.data[index]=null;
             --index;
         }
         /*bastan silme*/
         else if(lastReturned==head && index==1){
             int i;
             Node<E> a=new Node<E>();
             a=lastReturned;
             if(size>9){
             while(a!=t){
                 for(i=1;i<9;++i)
                     a.data[i-1]=a.data[i];
                 a.data[capacity-1]=a.next.data[0];
                 a=a.next;
                 
             }
             }
             else{
                
                 for(i=index;i<capacity-2;++i)
                     a.data[i]=a.data[i-1];
             }
             if(size%capacity==0)
             while(a.next!=null ){
                 for(i=0;i<capacity-1;++i)
                 a.data[capacity-1]=a.next.data[i];
                 a=a.next;
             }
             else{
                 while(hasNext()){
                     while(a.next!=null){
                         for(i=0;i<capacity-1;++i)
                             a.data[capacity-1]=a.next.data[i];
                     }
                 }
             }
       
        }
        }
    
        /*indexteki elemanın oldugu yere parametreyi yerlestirir*/
        @Override
        public void set(E e) {
            nextItem.data[index]=e;
        }
        /*contructorda indexi set edip oraya ekleme yapar araya ekleme basa 
         durumunda oradaki elemandan da dahil kaydırma yapar */
        @Override
        public void add(E e) {
            
            if(head==null){
                Node<E> n=new Node<E>(e);
                head=(Node) n;
                t=(Node) n;
              
                
            }
            /*en basa ekleme durumu*/
            else if(nextItem==head && flag==3){
              
                       Node<E> a=new Node<E>();
                a=(Node<E>) t;
                /*nodların hepsi tam dolu yeni yer açar ve sondaki
                 elemandan itibaren kaydırma yapar*/
                if(size%capacity==0){
                    Node<E> n=new Node<E>(a.data[capacity-1]);
                    n.prev=a;
                    a.next=n;
                    t=(Node) n;
                  
                    int i;
                    i=capacity-1;
                    while(a!=null){
                        if(i==0){
                             if(a.prev==null)
                                break;
                            a.data[i]=a.prev.data[capacity-1];
                            a=a.prev;
                           
                            i=capacity-1;
                            
                            
                        }
                        a.data[i]=a.data[i-1];
                        
                        --i;
                        
                    }
                    a.data[0]=e;
                   
                }
                /*tum nodlar dolu degilse indexin oldugu yerden itibaren 
                 kaydırma yapılır*/
                else{
                    int indx=index;
                    int i;
                    i=size%capacity;
                 
                   while(a!=null){
                       
                      while(i>=0){
                        if(i==0 && a.prev!=null){
                            if(a==null)
                                break;
                            a.data[i]=a.prev.data[capacity-1];
                            
                            i=capacity-1;
                          
                     
                        }
                        else if(i!=0){
                          a.data[i]=a.data[i-1];
                        
                        }
                        --i;
                       
                        }
                      a=a.prev;
                    }
                   
                    
                    nextItem.data[index]=e;
                    
               
                }
               
               
        } 
            /*sona ekleme*/
            else if( flag==0){
                int indx=index;
               /*tum nodlar doluysa yer acar oraya e yi ekler*/
                if(size%capacity==0){
                   Node<E> n=new Node<E>();
                    n.data[0]=e;
                    n.prev=(Node<E>) t;
                    t.next=(Node) n;
                    t=(Node) n;
                    nextItem=n;
                 
                }
                else{
                    /*direk sona ekler*/
                    
                    nextItem.data[size%capacity]=e;
                     
                    /*int i;
                    for(i=size%capacity-1;i<(size%capacity)-index+1;i--){
                        nextItem.data[i+1]=nextItem.data[i];
                      
                    }
                    nextItem.data[index]=e;*/
                     }
                   
            }
            /*ortaya ekleme*/
            else if(flag!=3 && flag!=0){
                int j;
                /*tum nodlar dolu yeni yer acar indexe kadar kaydırma yapar indexe e yi ekler*/
                if(size%capacity==0){
                    Node<E> n=new Node<E>();
                    n.data[0]=(E) t.data[capacity-1];
                    Node<E> a=new Node<E>();
                    a=(Node<E>) t;
                    int i;
                    while(a!=nextItem){
                        for(i=capacity-2;i>0;--i)
                            a.data[i+1]=a.data[i];
                        if(i==0){
                            a.data[0]=a.prev.data[capacity-1];
                            a=a.prev;
                           
                        }
                       
                    }
                    for(i=capacity-2,j=0;i>0 && j<capacity-index;--i,++j)
                        a.data[i+1]=a.data[i];
                        a.data[index]=e;
                       
                }
                /*tum nodlar dolu degilse dolulugun oldugu yerden itibaren kaydırır indexe e yi ekler*/
                else{
                  
                        Node<E> a=new Node();
                        a=(Node<E>) t;
                        int i;
                        int m;
                    
                        i=size%capacity;
                        m=i;
                        while(a.prev!=null &&  a!=nextItem){
                           
                            
                            for(m=i;m>0;--m){
                                a.data[m]=a.data[m-1];
                              
                            }
                             if(m==0){
                                if(a.prev==null)
                                    break;
                                a.data[0]=a.prev.data[capacity-1];
                                a=a.prev;
                                i=capacity-1;
                                
                            }
                        }
                        int k;
                        for(m=capacity-1;m>index;--m){
                                a.data[m]=a.data[m-1];
                            
                            }
                      
                        a.data[index]=e;
                       
                     
            }
          
                
    }
        ++size;
        index=(index+1)%capacity;
        }
        /*size ve indexi return eder*/
        public int getIndex(){
            return index;
        }
        public int getSize(){
            return size;
        }
        
       
    }
    /*ilk basa ekleme*/
    public void addFirst(E obj){
        
        GITIterator<E> iter=new GITIterator();
     iter.flag=1;
        iter.add(obj);
       
    }
    /* en sona ekleme*/
    public void addLast(E obj){
        GITIterator<E> itr=new GITIterator(size);
         itr.flag=0;
        itr.add(obj);
       
    }
    /*belirtilen indexe elemanı ekler*/
    public void add(int index,E obj){
        GITIterator<E> iter = new GITIterator(index);
      
       //iter.flag=3;
        iter.add(obj);
   
    }
    /*ilk elemanı return eder*/
    public E getFirst(){
       GITIterator<E> iter=new GITIterator<E>(0);
        return iter.data;
        
    }
    /*son elemanı return eder*/
    public E getLast(){
        GITIterator<E> iter=new GITIterator<E>(size-1);
        
       return iter.data;
    }
    /*i nin ulundugu indexteki elemanı return eder*/
    public E get(int index){
        GITIterator<E> iter=new GITIterator<E>(index);
        return iter.data;
    }
    /* bir iterator return eder*/
    public GITIterator<E> listIterator(){
        return new GITIterator<E>();
    }
    /*belirtilen index e set edilen bir iterator return eder*/
    public GITIterator<E> listIterator(int index){
        return new GITIterator(index);
    }
}