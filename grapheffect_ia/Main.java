/**
 * 
 */
package pkgsunny;

import java.io.IOException;
/**
 * @author julie
 *
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client server = new Client();
        Map m = new Map();
        boolean connected = false;
        String serverMessage = "";
        
        try {
            server.connection();
            System.out.println("-- CONNECTION PASSED --");
            
            server.channelsCreation();
            System.out.println("-- CHANNELS CREATION PASSED --");
            
            connected = true;
            
    	/**
    	 * application logic here
    	 */
            if(connected) {
            	System.out.println("Connecting to the server");
            	
            	try {
	                if(serverMessage.equalsIgnoreCase("debut")) {
	                    server.sendServerMessage("MAP");
	                    String map = server.getServerMessage();
	                    
	                    server.sendServerMessage("GOLD");
	                    String gold = server.getServerMessage();
	                    
	                    System.out.println("MAP : "+map);
	                    System.out.println("GOLD : "+gold);
	                    m.addMap(map);
	                    
	                    System.out.println("map done");
	                    
	                    /**
		                try {
		                	server.sendServerMessage("ENDTURN");
		                }
		                catch(IOException e) {
			                System.out.println("Error occurred when sending message");
			                e.printStackTrace();
		                }
		                catch(Exception e) {
		                	System.out.println("Error occurred");
		                	e.printStackTrace();
		                }
		                **
		                */
	                }
            	}
            	catch(NullPointerException npe) {
            		System.out.println("Null pointer error : ");
            		npe.printStackTrace();
            	}
            	catch(IOException ioe) {
        			server.closeServerSocket();
        			
            		System.out.println("Error occured when talking to the server\n\tDisconnected from the server");
            		ioe.printStackTrace();
            	}
            	finally {
            		String toMap;
            		System.out.println("Finally reached\nTo map : \t");
            		try {
            			toMap = m.toString();
            			System.out.println(toMap);
            		}
            		catch(NullPointerException npe) {
            			System.out.println("Map object does not exist :");
            			npe.printStackTrace();
            		}

            		try {
            			server.sendServerMessage("END");
            			serverMessage = server.getServerMessage();
            			if(serverMessage.equals("END")) {
            				try {
            					server.closeServerSocket();
            					System.out.println("\tClosed server socket");
            				}
            				catch(IOException ioe) {
            					System.out.println("\tError ending server socket : ");
            					ioe.printStackTrace();
            				}
            			}
            		}
            		catch(IOException ioe) {
            			System.out.println("Stream/IO error occured (sending server END) :");
            			ioe.printStackTrace();
            		}
            		
            	}
            }
        }
        catch(java.net.ConnectException ce) {
        	System.out.println("Connection error (try to start the server)");
        	ce.printStackTrace();
        }
        catch(java.net.SocketException se) {
        	System.out.println("Socket error (server shutdown unexpectedly) :");
        	se.printStackTrace();
        }
        catch(IOException ioe) {
    		System.out.print("Stream/IO error occured : ");
        	ioe.printStackTrace();
        }
        catch(NullPointerException npe) {
        	System.out.println("Null Pointer : ");
        	npe.printStackTrace();
        }
    }
    
}
