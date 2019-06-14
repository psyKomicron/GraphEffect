package grapheffect_ia.Modules;

import java.util.ArrayList;

import grapheffect_ia.AI;
import grapheffect_ia.Model.Spaceships.Spaceship;

/**
 * Module in charge of the reaction to the different answers of the server
 * @author Matthieu
 */
public class Module_Reaction extends Module {
	private AI _ai;

    public Module_Reaction(AI ai) {
        super(ai);
        _ai = ai;
    }
    
    
    //Main method for the reaction to a received message
    public void reactToReceivedMessage(String messageSended, String messageReceived) {
        switch(messageSended) {
            case "END" :
                getAI().stopDiscussion();
                break;
            case "MAP" :
                reactionMap(messageReceived);
                break;
            case "BASE" :
            	reactionBase(messageReceived);
            	break;
            case "ENDTURN" :
            	reactionEndTurn(messageReceived);
            	break;
        }
    }
    
    
    private void reactionMap(String messageReceived) {
    	_ai.getModuleMemory().generateMap(messageReceived);
    }

    
    private void reactionBase(String messageReceived) {
    	_ai.getModuleMemory().setBase(messageReceived);
    }
    
    private void reactionEndTurn(String messageReceived) {
    	if(messageReceived.equalsIgnoreCase("OK")) {
    		ArrayList<Spaceship> array = _ai.getModuleMemory().getSpaceship();
    		for(Spaceship sp : array) {
    			sp.resetAp();
    		}
    	}
    }
    
}
