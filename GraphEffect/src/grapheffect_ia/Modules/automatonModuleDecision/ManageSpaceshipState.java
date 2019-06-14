/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class ManageSpaceshipState extends State {

	public ManageSpaceshipState(AI ai) {
		super(ai);
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public String messageToSend() {
		return "";
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public State transition() {
		State transition = null;
		if(this.getMemoryModule().getSpaceships().get(0).getAp() < 1) {
			transition = new EndTurnState(getAi());
		}
		else if(this.getMemoryModule().getSpaceships().get(0).getAp() < 1 && this.getMemoryModule().getSpaceships().get(0).getOrder() != null) {
			transition = new MovingState(getAi());
		}
		else {
			transition = new ChooseDestinationState(getAi());
		}
		return transition;
	}

}
