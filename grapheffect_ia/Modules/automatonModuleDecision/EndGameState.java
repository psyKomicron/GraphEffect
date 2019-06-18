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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "END";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		getAi().stopDiscussion();
		return new InitialState(getAi());
	}

}
