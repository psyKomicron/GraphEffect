/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class ManageSpaceshipState extends State {

	public ManageSpaceshipState(Module_Decision moduleDecision) {
		super(moduleDecision);
		// TODO Auto-generated constructor stub
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
		if(this.getMemoryModule().getSpaceShips().get(0).getAp() < 1) {
			transition = new EndTurnState(getDecisionModule());
		}
		else if(this.getMemoryModule().getSpaceShips().get(0).getAp() < 1 && this.getMemoryModule().getSpaceShips().get(0).getOrder() != null) {
			transition = new MovingState(getDecisionModule());
		}
		else {
			transition = new ChooseDestinationState(getDecisionModule());
		}
		return transition;
	}

}
