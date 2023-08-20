import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class thread1 extends Mainserver{
	ServerSocket server;
	public void run() {
		 
		  Socket s;
		  
		try {
			while(true) {
			  System.out.println("running thread1");
			  s = server.accept();
			  System.out.println("accepted request...");
			  String str1="";
	    	  DataInputStream din=new DataInputStream(s.getInputStream());
	          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	          //from the user we are getting his client id
	          str1=din.readUTF();
	          System.out.println("client_id"+str1);
	          if(str1.equals("server_1"))thread[0]=0;
	          else if(str1.equals("server_2"))thread[1]=0;
	          else if(str1.equals("server_3"))thread[2]=0;
	          else qu.add(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

}
