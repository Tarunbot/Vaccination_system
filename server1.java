import java.util.*;
import java.net.*;
import java.sql.Timestamp;

import java.io.*;
public class server1  {
	
	public static int lock=0;
	
	
  public static void main(String[] args) throws Exception {
    try{
      
    	ServerSocket server=new ServerSocket(7777);
        System.out.println("Server 7777 Started ....");
     
        while(true){
        
         //server accept the client connection request
       
            java.util.Date date= new java.util.Date();
            String str=""+date.getTime();
       
            System.out.println("Window is free Now ...............");
        
            Socket serverClient=server.accept(); 
          
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
	        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
	        String clientMessage="", serverMessage="";
			String clientid=inStream.readUTF();
	        while(!clientMessage.equals("bye")){
	           clientMessage=inStream.readUTF();
	           System.out.println("Patient Connected -----------------"+clientid);
			   
			   System.out.println("Vaccination is in process");
			   System.out.println("Getting  vaccinated :)");
               long n=(long)(Math.random()*Integer.MAX_VALUE);
			   while(n>0){
				n--;
			   }
	           serverMessage="Your  Vaccination is in process";
	           outStream.writeUTF(serverMessage);
	           outStream.flush();
	       
	        }
	      //after client finishes the work set lock again to 0
	      
	      Socket s1=new Socket("localhost",10000);  
          DataOutputStream dout1=new DataOutputStream(s1.getOutputStream());
	  	  dout1.writeUTF("server_1");
	  	  dout1.flush();
	  	  dout1.close();
	      s1.close();
	      
	      //-----------------
	      
	      inStream.close();
	      outStream.close();
	      serverClient.close();
        
       
       
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
}






