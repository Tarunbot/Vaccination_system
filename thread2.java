
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class thread2 extends Mainserver {

	public void run() {
		
		int touseserver=loadbalancer();
		int processesd=0;
  	  
		try {
			  while(true) {
				if(processesd==0 && touseserver!=-1){

				}else{
					touseserver=loadbalancer();
					processesd=0;
				}
 
			  	String str2="",str="";
				
			  	if(touseserver!=-1 && qu.isEmpty()==false) {
			    processesd=1;
				System.out.println(Arrays.toString(thread));
				System.out.println("Vaccination allotment to window "+servers[touseserver]);
	            if(!qu.isEmpty() && touseserver!=-1) { 
	            System.out.println(qu.toString());
	      	    str=qu.poll();
	      	    System.out.println("processing..."+str);
	      	    System.out.println(qu.toString());
	      	    Socket s1 = new Socket("localhost",Integer.valueOf(str));
	            DataOutputStream dout=new DataOutputStream(s1.getOutputStream());
	            System.out.println("Client Says: "+str);
	            str2+=servers[touseserver];
	            dout.writeUTF(str2);
	            dout.flush();
	           }
			  }else{
				System.out.println("i am outside the loop"+qu.toString());
			  }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
            
        }
	}

