package ArrayList;

import java.util.LinkedList;

public class LinklistDemo {
    String name;


    public static void main(String[] args) {
        LinklistDemo user1=new LinklistDemo();
        LinklistDemo user2=new LinklistDemo();
        //user1.name="Aditya";
        //user2.name="Rahul";

        LinkedList<String> list=new LinkedList<String>();
        list.push("ADITYA");
        list.push("Sham");
        list.push("Virat");
        System.out.println( list.getLast());
        System.out.println(list);
        System.out.println("First:");
        System.out.println(list.getFirst());
    }

    
}
