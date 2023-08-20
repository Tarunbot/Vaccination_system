
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;



class Multiclient extends Thread{
   ServerSocket recieves;
   Socket s1;
   int socketid;

   public Multiclient(){

   }
   public Multiclient(ServerSocket rec,Socket s,int sockid){
           recieves=rec;
		   s1=s;
		   socketid=sockid;
   }

   public void run(){

      try {
		
	   DataOutputStream dout1=new DataOutputStream(s1.getOutputStream());
	   //taking the input from the user
	   BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));

       //client id
	   String id=""+socketid;

	   //sending the id to the main server(requesting for a server)
	   dout1.writeUTF(id);
	   dout1.flush();
	   //---------------------


	   //listening to the reply
	   System.out.println("waiting.................int the queue");
	   Socket recieve_socket=recieves.accept();
	   System.out.println("connected.................");
	   DataInputStream din1=new DataInputStream(recieve_socket.getInputStream());
	   String strd=din1.readUTF();
       dout1.close();
	   recieve_socket.close();
	   din1.close();
	   s1.close();
	   recieves.close();
	   //recieveing

	   int token=Integer.valueOf(strd);
	   System.out.println(token);
       Socket socket=new Socket("127.0.0.1",token);
       DataInputStream recieve=new DataInputStream(socket.getInputStream());
       DataOutputStream send=new DataOutputStream(socket.getOutputStream());
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       send.writeUTF("Patient_Id"+socketid);
       send.flush();
       String clientMessage="",serverMessage="";
       while(!clientMessage.equals("bye")){
    	long n=(long)(Math.random()*Integer.MAX_VALUE);
    	for(long i=0;i<n;i++) {
    		if(i%1000000==0)
             System.out.println("processing your insulin");
    	}
    	System.out.println("Insulin completed");
        clientMessage="bye";
        send.writeUTF(clientMessage);
        send.flush();
        serverMessage=recieve.readUTF();
        break;
    }
        send.close();
        send.close();
        socket.close();
  
   
   } catch (Exception e) {
	// TODO: handle exception
   }
}
}
public class client extends Multiclient{
	
	
	public static void main(String[] args) throws Exception {
	  int socketid=1234;
	  for(int i=0;i<20;i++){
	  
	  ServerSocket recieves=new ServerSocket(socketid);
      Socket s1=new Socket("localhost",10000);  
      Multiclient mc=new Multiclient(recieves,s1,socketid);
	  mc.start();
	  socketid++;
	}
	  //connected to sending one(gives)
	  
	
  }
  }

