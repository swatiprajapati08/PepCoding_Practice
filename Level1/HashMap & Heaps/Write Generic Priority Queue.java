import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue<T> {
      ArrayList<T> data;
      Comparator comp;
      

    public PriorityQueue() {
      data = new ArrayList<>();
      comp = null;
    }
      
       public PriorityQueue(Comparator comp) {
      data = new ArrayList<>();
      this.comp = comp;
    }


    public void add(T val) {
      data.add(val);
      upHeapify(data.size() - 1);
    }
      

    private void upHeapify(int i){
        if(i == 0) return;

        int pi = (i - 1) / 2;
        if(isSmaller(i,pi) == true){
            swap(i,pi);
            upHeapify(pi);
        }
    }

    public T remove() {
       if(this.size() == 0){
          System.out.println("Underflow");
          return null;
      }

        // 1. swap the data.get(0) and data.get(last index)

        swap(0,data.size() - 1);

        // 2. remove last index
        T val = data.remove(data.size() - 1);
        
        downHeapify(0);
        return val;
    }
      
      public boolean isSmaller(int i, int j)
      {
          if(comp == null){
          Comparable ith = (Comparable) data.get(i);
          Comparable jth = (Comparable) data.get(j);
          
          if(ith.compareTo(jth) < 0)
              return true;
          else
              return false;
          }
          else{
              
              T ith = data.get(i);
              T jth = data.get(j);
              
              if(comp.compare(ith,jth) < 0)
                  return true;
              else
                  return false;
          }
      }

    private void swap(int i, int j){
        T ith = data.get(i);
        T jth = data.get(j);
         
        data.set(i, jth);
        data.set(j, ith);
    }

    private void downHeapify(int pi){

        int min = pi;

        int li = 2 * pi + 1;
        if(li < data.size() && isSmaller(li,min) == true)
        min = li;
        
        int ri = 2 * pi + 2;
        if(ri < data.size() && isSmaller(ri,min) == true)
        min = ri;

        if(min != pi)
        {
            swap(min,pi);
            downHeapify(min);
        }
    }

    public T peek() {
      if(this.size() == 0){
          System.out.println("Underflow");
          return null;
      }
      return data.get(0);
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
      
      PriorityQueue<Student> pq = new PriorityQueue<>( new StudentHtComparator());
      
      pq.add(new Student(2,183,55));
      pq.add(new Student(7,186,50));
      pq.add(new Student(19,185,78));
      pq.add(new Student(28,167,65));
      pq.add(new Student(27,173,45));
      
      while(pq.size() > 0)
      {
          System.out.println(pq.remove());
      }
    }
    
   static class Student implements Comparable<Student> {
        int rno;
        int ht;
        int wt;
        
        Student(){}
        
        Student(int rno , int ht, int wt){
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }
        
        public int compareTo(Student other){
            return this.rno - other.rno;
        }
        
       public String toString(){
           return "Roll No :" + this.rno + " Height : " +this.ht + " Weight" + this.wt;
       }
    }
    
    static class StudentHtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2){
            return s1.ht - s2.ht;}
    }
    
     static class StudentWtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;}
    }
    
    
  }
