
import java.net.*;
import java.util.*;
import java.io.*;


public class Mainserver extends Thread {
	
	static int thread[]= {0,0,0};
	static int servers[]= {7777,8888,9999};
	static Queue<String> qu=new LinkedList<>();
	
	
	
	
	public static int loadbalancer() {
		int minloadserver=-1;
		int got=0;
		
		for(int i=0;i<thread.length;i++) {
			
			//check for window availability
			if(thread[i]==0) {
				thread[i]=1;
				minloadserver=i;
				got=1;
			}
			//window free 
			if(got==1) {
				break;
			}
		}
		System.out.println("window assign here is"+minloadserver);
		return minloadserver;
	}
	
	
	
	
	
	
	
	
	
  public static void main(String[] args) throws Exception {
   
      ServerSocket server=new ServerSocket(10000);
      
      
      //accept the incoming request
      thread1 task1=new thread1();
      task1.server=server;
      
      thread2 task2=new thread2();
      
      
      task1.start();
      task2.start();
      System.out.println("Main CONTROLLER STARTED......................");

      }

     
  }




