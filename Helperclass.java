package HashMap;

import java.util.HashMap;

import java.util.Scanner;
import java.util.Map.Entry;

import MultipleInheritance.student;

public class Helperclass extends Studentclass {
    
    HashMap<Integer,Studentclass> map=new HashMap<Integer,Studentclass>();
    Scanner sc=new Scanner(System.in);



public void addStudent(){
    //HashMap<Integer,Helperclass> map=new HashMap<Integer,Helperclass>();
    Helperclass obj=new Helperclass();
    
    System.out.println("Enter Rollno:");
    int rollno=sc.nextInt();
    if(!map.containsKey(rollno)){
    System.out.println("Enter Name of Student");
    obj.name=sc.next();
    System.out.println("Enter place of Student");
    obj.place=sc.next();
    System.out.println("Enter college of Student");
    obj.college=sc.next();
    System.out.println("Enter Branch of Student");
    obj.branch=sc.next();
    
    map.put(rollno,obj);
    }
    else{
        System.out.println("Use another Rollno which doesn't exit in our database:\n");
    }
    }
    //for (Map.Entry<Integer, String> m : map.entrySet()) {
      //  System.out.println(m.getKey() + " " + m.getValue());}
        


void delete(){
    System.out.print("Enter the roll no: ");
        int rollno = sc.nextInt();
        if (map.remove(rollno)!=null) {
            System.out.printf("You deleted rollno:%d\n",rollno);
        } else {
            System.out.println("Roll number dosent exist in our data .");
        }
    }


public void searchStudent() {
    System.out.print("\nEnter the roll no: you want to search ");
    int rollno = sc.nextInt();
    if (map.isEmpty()) {
        System.out.println("No Students in data please Add Students:");
    }
    if (map.containsKey(rollno)) {
        System.out.println("\nName: "+ map.get(rollno).name);
        System.out.println("College: "+ map.get(rollno).college);
        System.out.println("Place: "+ map.get(rollno).place);
        System.out.println("Branch: "+ map.get(rollno).branch + "\n");
    } else {
        System.out.println("Roll number dosent exist in our database");
    }
}

public void display(){
    if (map.isEmpty()) {
        System.out.println("It'sEmpty , Enter Data First\n");
    }
    else{
         //for (Map.Entry<Integer, String> m : map.entrySet()) {
      //  System.out.println(m.getKey() + " " + m.getValue());}
        System.out.println("\nStudent Details:");
        for (Entry<Integer, Studentclass> m : map.entrySet()) {
            System.out.println("Roll No: "+m.getKey());
            System.out.println("Student's name: "+m.getValue().name);
            System.out.println("College: "+m.getValue().college);
            System.out.println("Place: "+m.getValue().place);
            System.out.println("Branch: " + m.getValue().branch + "\n");
        }
    }

    

}

    public static void main(String[] args) {
        //HashMap<Integer,String> map=new HashMap<Integer,String>();
        Helperclass obj=new Helperclass();

        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter Case\n 1:addStudentDetails\n 2:DisplayStudents\n 3:DeleteStudent\n 4:Search\n 5:Exit");
            int choice=sc.nextInt();
            switch (choice) {
    
                case 1:
    
                    obj.addStudent();
    
                    break;
    
                case 2:
    
                    obj.display();
    
                    break;
                
                case 3:
                    obj.delete();
                    break;
                
                case 4:
                    obj.searchStudent();
                case 5:
                    System.exit(1);
                break;
            }

    




        
    
    
}}}
