/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class EndTurnState extends State {

	public EndTurnState(AI ai) {
		super(ai);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "ENDTURN";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		return new ManageSpaceshipsState(getAi(), getMemoryModule().getCurrentSpaceship());
	}

}
