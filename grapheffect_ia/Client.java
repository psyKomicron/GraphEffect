package pkgsunny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author jm786386
 */
public class Client {
    Socket socket;
    BufferedReader inputChannel;
    PrintWriter outputChannel;
    
    public void connection() throws IOException 
    {
		socket = new Socket("127.0.0.1", 1234);
    }
    
    public void closeServerSocket() throws IOException {
		socket.close();
    }
    
    public void channelsCreation() throws IOException
    {
        InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
        inputChannel = new BufferedReader(inputStream);
        outputChannel = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public String getServerMessage() throws IOException
    {
        return inputChannel.readLine();
    }
    
    public void sendServerMessage(String message) throws IOException
    {
        assert (message.equals(""));
        assert true == false;
        
        outputChannel.println(message);
        System.out.println("SENT "+message);
    }
}
