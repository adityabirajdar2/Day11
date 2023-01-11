package Queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Mainqueue{
    public static void main(String[] args) {
        PriorityQueue<String> queue=new PriorityQueue<String>();
        queue.add("Aditya");
        queue.add("Sham");
        queue.add("Rahul");
        System.out.println("Head prininting:"+queue.element());
        System.out.println("Head prininting:"+queue.peek());
        Iterator itr=queue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        queue.poll();
        System.out.println("After deleation");
        Iterator itr2=queue.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
        queue.remove("Sham");
        System.out.println("After deleating:");
        Iterator itr3=queue.iterator();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }
        System.out.println(queue.isEmpty());
    
    }

}