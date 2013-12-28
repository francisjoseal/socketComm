package socketComm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	public static void main(String args[]){
	Socket cliSock=null;
	PrintWriter out = null;
    BufferedReader in = null;
	try{
		cliSock =new Socket("127.0.0.1",5679);
		if(cliSock.isConnected()){
			System.out.println("I am connected to port 5679! ");
		}else {
			System.out.println("Not connected to any port! ");
		}
		
		out = new PrintWriter(cliSock.getOutputStream());
		in = new BufferedReader(new InputStreamReader(cliSock.getInputStream()));
	
	}catch (UnknownHostException e) {
        System.err.println("Don't know about host: localhost.");
        System.exit(1);
    }
	
	catch(IOException e){
		 System.err.println("Couldn't get I/O for "
                 + "the connection to: localhost.");
		 System.exit(1);
	}
	BufferedReader stdIn = new BufferedReader(
            new InputStreamReader(System.in));
	BufferedReader sockInp = null;
	try {
		sockInp = new BufferedReader(
		      new InputStreamReader(cliSock.getInputStream()));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String userInput;
	//String sockInput;

	try {
		while ((userInput = stdIn.readLine()) != null) {
		    out.println("User has entered data!");
		    System.out.println("echo: " + userInput);
		}
		
/*		while((sockInput = sockInp.readLine()) != null){
			System.out.println("echo: " + sockInput);
		}*/
	out.close();
	in.close();
	stdIn.close();
	//sockInp.close();  
	cliSock.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}