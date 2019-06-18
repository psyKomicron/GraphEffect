package grapheffect_ia;

import grapheffect_ia.Modules.Module_Communication;
import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memory;
import grapheffect_ia.Modules.Module_Reaction;
import java.io.IOException;

/**
 * Main class of the AI
 * @author Matthieu
 */
public class AI {


    private Module_Communication moduleCommunication;                           //Module in charge of the communication with the server
    private Module_Decision moduleDecision;                                     //Module in charge of the decision making
    private Module_Memory moduleMemory;                                         //Module in charge of the memory
    private Module_Reaction moduleReaction;                                     //Module in charge of the reaction to an answer from the server
    private boolean isDiscussionOver;                                           //is the discussion with the server over ?
    private String messageSended;                                               //Last message sended to the server
    private String messageReceived;                                             //Last message received from the server
    
    //Constructeur de l'AI
    public AI() {
        this.messageSended = "";
        this.messageReceived = "";
        this.initialisation_Modules();
    }
    
    //Initialisation of the different modules
    private void initialisation_Modules() {
        this.moduleCommunication = new Module_Communication(this);
        this.moduleDecision = new Module_Decision(this);
        this.moduleMemory = new Module_Memory(this);
        this.moduleReaction = new Module_Reaction(this);
    }
    
    //Getter of the differents modules
    public Module_Communication getModuleCommunication() {
        return this.moduleCommunication;
    }
    public Module_Decision getModuleDecision() {
        return this.moduleDecision;
    }
    public Module_Memory getModuleMemory() {
        return this.moduleMemory;
    }
    public Module_Reaction getModuleReaction() {
        return this.moduleReaction;
    }
    
    //method to start the AI
    public void start() throws IOException {
        //START THE COMMUNICATION MODULE
            //connect to the server
        this.moduleCommunication.connexion();   
            //Creation of the channels
        this.moduleCommunication.channelsCreation();                                
        
        //Discussion loop
        this.isDiscussionOver = false;
        while(!isDiscussionOver) {
            //we receive a message
            messageReceived = moduleCommunication.receiveMessage();
            //we react to the message
            reactToReceivedMessage();
            //we decide what to do
            messageSended = determineNewAction();
            //we send the message to the server
            moduleCommunication.sendMessage(messageSended);
        }
        
    }
    
    
    //how to react to the message received
    private void reactToReceivedMessage() {
        this.moduleReaction.reactToReceivedMessage(messageSended,messageReceived);
    }
    
    //what to do next ?
    private String determineNewAction() {
        return this.moduleDecision.determineNewAction(messageReceived);
    }
    
    //stop the discussion with the server.
    public void stopDiscussion() {
        this.isDiscussionOver = true;
    }
}
