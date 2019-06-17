/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Model.Spaceships.Spaceship;

/**
 * @author julie
 *
 */
public class ManageSpaceshipsState extends State {
	private Spaceship _spaceship;

	public ManageSpaceshipsState(AI ai, Spaceship spaceship) {
		super(ai);
		_spaceship = spaceship;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		State transition = null;
		if(this.getMemoryModule().getSpaceships().get(0).getAp() < 1) {
			transition = new EndTurnState(getAi());
		}
		else if(this.getMemoryModule().getSpaceships().get(0).getAp() >= 1 && this.getMemoryModule().getSpaceships().get(0).getOrder() != null) {
			transition = new MovingState(getAi());
		}
		else {
			transition = new ChooseDestinationState(getAi());
		}
		return transition;
	}

}
