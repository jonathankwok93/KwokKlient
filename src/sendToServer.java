import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class sendToServer extends Thread {

		

		Socket client = null;
		static Socket socket;
		
		String statusBuffer = new String();
		String input;
		String output;
		PrintWriter out = null;
		BufferedReader in = null;
		
		
		public void server(String input) throws Exception{
		
		try{
			PrintWriter out = null;
			socket = new Socket("localhost", 8888);
			out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String messagefromserver;
		String messagefromclient = null;
		
		while(messagefromclient != null){
			out.println(messagefromclient);
			
			if(messagefromclient.equals("close")){
				break;
			}
			messagefromclient = stdIn.readLine();
		}
		
		out.close();
		in.close();
		socket.close();
		
	}
}
