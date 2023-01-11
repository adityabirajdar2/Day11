package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
   // public Demo() {  }
    String name;
    public static void main(String args[]){

    Demo user1= new Demo();
    Demo user2=new Demo();
    //Demo obj2=new Demo();
    user1.name="Aditya";
    user2.name="Rahul";

    ArrayList<Demo> obj1=new ArrayList<Demo>();
    obj1.add(user1);
    obj1.add(user2);
    System.out.println(obj1.get(0).name);
    System.out.println(obj1.get(1).name);
    obj1.remove(1);
    System.out.println( obj1.size());
    Demo user3=new Demo();
    user3.name="Ankita";
    obj1.add(user3);
    System.out.println(obj1.get(1).name);
    System.out.println( obj1.isEmpty());
    System.out.println( obj1.equals(obj1));


    ArrayList<Demo> obj2=new ArrayList<Demo>();
    Demo user4=new Demo();
    user4.name="Aditya";
    obj2.add(user4);
    //System.out.println (obj1.equals(obj2));
  
  
  




    //System.out.println( user1.equals(user4));
     Iterator obj3=obj1.iterator();
   while(obj3.hasNext())
   {
     Demo obj5 =(Demo)obj3.next();
    System.out.println(obj5.name);
   //}
   
}
}}