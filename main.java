/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

/**
 *
 * @author erdem
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
     String [] s=new String[3];
     s[0]="mehmet";
     s[1]="selim";
     s[2]="murat";
     String m="ali";
     String n="asim";
     String k="gh";
     GITList<String> g=new GITList<String>();
     g.addFirst(s[0]);
     g.addLast(s[1]);
     g.addFirst(s[2]);
     g.addFirst(m);
     g.addLast(n);
     g.add(3, k);
     g.add(0, k);
    g.addLast(s[2]);
     g.add(2, n);
     g.addLast(k);
     g.addLast(n);
     //g.add(0, m);
System.out.print("aranan"+g.get(2));

    
      
    }
}
