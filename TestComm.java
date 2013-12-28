package socketComm;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class TestComm {
	public static void main(String args[]){
	ServerSocket servSock = null;
	try{
	 servSock= new ServerSocket(5679);
	
	}
	catch(IOException e){
		System.err.println("Could not listen on port: 5678.");
        System.exit(1);
	}
	Socket cliSock =null;
	while(true){
	try{
		cliSock = servSock.accept();
	}
	catch(IOException e){
		System.err.println("Could not accept connection on port: 5679.");
        System.exit(1);
	}
	String buf=null;
	try {
		PrintWriter out= new PrintWriter(cliSock.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(cliSock.getInputStream()));
		while ((buf = in.readLine())!=null){
			out.println("got it");
			System.out.println(buf);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
}
