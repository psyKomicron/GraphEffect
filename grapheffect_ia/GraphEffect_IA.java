package grapheffect_ia;

import java.io.IOException;
import java.net.ConnectException;

/**
 * 
 * @author Matthieu
 */
public class GraphEffect_IA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            AI sunny = new AI();
            sunny.start();
            sunny.getModuleCommunication().connexion();
        } 
        catch(ConnectException ce) {
        	System.err.println("Server Not Found");
        }
        catch (IOException ex) {
        	System.err.println("Stream error");
        	ex.printStackTrace();
        }
        catch (NullPointerException npe) {
        	System.err.println("Server unexpectedly shuted down");
        	npe.printStackTrace();
        }
    }
    
}
