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
		// getMemoryModule().nextSpaceship();
		State newState = new EndTurnState(getAi());
		int sumAp = 0;
		for(Spaceship s : getMemoryModule().getSpaceships()) {
			sumAp += s.getAp();
		}
		if(sumAp > 0) {
			while(this.getMemoryModule().getCurrentSpaceship().getAp() == 0) {
				this.getMemoryModule().nextSpaceship();
			}
			newState = new MovingState(getAi(), getMemoryModule().getCurrentSpaceship());
			if(getMemoryModule().getCurrentSpaceship().getOrder() == null) {
				newState = new ChooseDestinationState(getAi(), getMemoryModule().getCurrentSpaceship());
			}
		}
		return newState;
	}

}
