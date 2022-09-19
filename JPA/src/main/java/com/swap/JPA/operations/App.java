package com.swap.JPA.operations;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args ){
        Student student = new Student();
        student.setId(101);
        student.setName("Swapnil");
        student.setCity("Jalgaon");
        
        Student student1 = new Student();
        student1.setId(102);
        student1.setName("Ramesh");
        student1.setCity("Nashik");
        
        Student student2 = new Student();
        student2.setId(103);
        student2.setName("Madhuri");
        student2.setCity("Pune");
        
        StudentRepository repository = new StudentRepository();
       
        student = repository.addStudent(student);
        repository.addStudent(student1);
        repository.addStudent(student2);
        
        System.out.println("Number of students: " + repository.count());
        repository.findSortingByName().forEach(System.out::println);
       
        System.out.println("Added Student: " + student);
        
        student = repository.findStudent(student.getId());
        
        System.out.println("Found Student: " + student);
        
        student.setName("Ajit");
        
        student = repository.updateStudent(student);
        
        System.out.println("Updated Student: " + student);
        
        repository.deleteStudent(student);
        
        System.out.println("Deleted Student: " + student);
        
        
        repository.findNames().forEach(System.out::println);
        repository.findCities().forEach(System.out::println);
        for(Object[] o: repository.getData()) {
        	System.out.println(Arrays.toString(o));
        }
       
        System.out.println(repository.findById(103));
        
        repository.findNameStartWith("Ra").forEach(System.out::println);
        
        System.out.println(repository.updateNameById("abc", 103));
       
        for(Object[] o: repository.getData()) {
        	System.out.println(Arrays.toString(o));
        }
        
        repository.deleteById(103);
        
        ;
        
        repository.close();    
    }
}
