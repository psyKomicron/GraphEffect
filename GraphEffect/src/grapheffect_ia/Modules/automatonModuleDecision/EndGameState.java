/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class EndGameState extends State {

	public EndGameState(AI ai) {
		super(ai);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String messageToSend() {
		return "END";
	}

	@Override
	public State transition() {
		getAi().stopDiscussion();
		return null;
	}

}
