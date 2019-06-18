package grapheffect_ia.Modules;

import grapheffect_ia.AI;
import grapheffect_ia.Modules.automatonModuleDecision.*;

/**
 * Module in charge of taking decision
 * @author Matthieu
 */
public class Module_Decision extends Module {
	private State _state;

	public Module_Decision(AI ai) {
		super(ai);
		_state = new InitialState(ai);
	}

	//Main method for the decision making
	public String determineNewAction(String messageReceived) {
		String answer = "";
		while(answer == "") {
			_state = _state.transition();
			answer = _state.messageToSend();
		}
		System.err.println(_state);
		return answer;
	}
}
