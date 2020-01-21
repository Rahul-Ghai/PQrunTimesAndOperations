import java.util.TreeMap;//built in red black tree
import java.util.PriorityQueue;//built in binary heap
import java.util.Random;
public class Main{
  //Both Trees are made to handles doubles, making them potentially more versatile
  static TreeMap tm = new TreeMap();//static red black tree declaration
  //log n key comparisions to add
  //0 key comparisions to remove
  static PriorityQueue<WrappedInteger> pQueue = new PriorityQueue<WrappedInteger>();//static binary heap declaration 
  //0 key comparisions to remove (+ logn/2 to replace it)
  //log n key comparisiosn to add
  public static void main(String args[]){
    int test = 10;
    for(int i = 0;i<=4;i++){
      test *= 10;//sets test to the current power of 10 for iterations      
      PriorityBH(test);
      System.out.println();
      PriorityRBT(test);
      System.out.println();
    }
  }
  public static void PriorityBH(int test){
    Random rand = new Random();
    WrappedInteger.resetCount();
    for(int i = 0;i<test;i++){
      int  x = rand.nextInt(1000000) + 1;
      WrappedInteger num = new WrappedInteger(x);
      pQueue.add(num);
    }
    System.out.println(WrappedInteger.getCount()+" Key comparisions to Build BH");
    WrappedInteger.resetCount();
    long startTime = System.currentTimeMillis();
    for(int i = 0;i<test/10;i++){
      int  x = rand.nextInt(1000000) + 1;
      WrappedInteger num = new WrappedInteger(x);
      pQueue.add(num);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(WrappedInteger.getCount()+" Key comparisions to add BH");
    System.out.println("Execution time["+(test/10)+"] Heap Add size: "+ test +" was: " + ((endTime - startTime)/1000.0)+" seconds");
    WrappedInteger.resetCount();
    startTime = System.currentTimeMillis();
    for(int i = 0;i<test/10;i++)
      removeMaxBH(); 
    endTime = System.currentTimeMillis();
    System.out.println(WrappedInteger.getCount()+" Key comparisions to remove BH");
    System.out.println("Execution time["+(test/10)+"] Heap Remove size: "+ test +" was: " + ((endTime - startTime)/1000.0)+" seconds");
  }
  public static void removeMaxBH(){//remove methods altered to void to save time by removing print statements
    pQueue.poll();
  }
  public static void PriorityRBT(int test){
    Random rand = new Random();
    WrappedInteger.resetCount();
    for(int i = 0;i<test;i++){
      int  x = rand.nextInt(1000000) + 1;
      WrappedInteger num = new WrappedInteger(x);
      tm.put(num,num);
    }
    System.out.println(WrappedInteger.getCount()+" Key comparisions to Build RBT");
    WrappedInteger.resetCount();
    long startTime = System.currentTimeMillis();
    for(int i = 0;i<test/10;i++){
      int  x = rand.nextInt(1000000) + 1;
      WrappedInteger num = new WrappedInteger(x);
      tm.put(num,num);
    }
    System.out.println(WrappedInteger.getCount()+" Key comparisions to add RBT");
    long endTime = System.currentTimeMillis();
    System.out.println("Execution time["+(test/10)+"] RBT Add size: "+ test +" was: " + ((endTime - startTime)/1000.0)+" seconds");
    WrappedInteger.resetCount();
    startTime = System.currentTimeMillis();
    for(int i = 0;i<test/10;i++)
      removeMaxRBT();   
    endTime = System.currentTimeMillis();
    System.out.println(WrappedInteger.getCount()+" Key comparisions to remove RBT");
    System.out.println("Execution time["+(test/10)+"] RBT Remove size: "+ test +" was: " + ((endTime - startTime)/1000.0)+" seconds");
  }
  public static void removeMaxRBT(){//remove methods altered to void to save time by removing print statements
    //System.out.println(tm.lastKey());
    tm.remove(tm.lastKey());
  }
}