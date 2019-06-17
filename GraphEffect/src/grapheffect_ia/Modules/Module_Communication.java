package grapheffect_ia.Modules;

import grapheffect_ia.AI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * module in charge of the communication to and from the server
 * @author Matthieu
 */
public class Module_Communication extends Module {

    private Socket socket;
    private BufferedReader inputChannel;
    private PrintWriter outputChannel;
    
    public Module_Communication(AI ai) {
        super(ai);
    }
    
    //Connect the client to the server
    public void connexion() throws IOException {
        //creation of the socket between the client and the server
        this.socket = new Socket("127.0.0.1",1234);
    }
    
    //creation of the two channels
    public void channelsCreation() throws IOException {
        //creation of the input channel
        InputStreamReader iSReader = new InputStreamReader(this.socket.getInputStream());
        this.inputChannel = new BufferedReader(iSReader);
        //creation of the output channel
        this.outputChannel = new PrintWriter(this.socket.getOutputStream(),true);
    }

    //send a message to the server
    public void sendMessage(String message) {
        System.out.println(">>"+message);
        this.outputChannel.println(message);
    }
    
    //Receive a message from the server
    public String receiveMessage() throws IOException {
        String message = this.inputChannel.readLine();
        System.out.println("<<"+message);
        return message;
    }
    
}
