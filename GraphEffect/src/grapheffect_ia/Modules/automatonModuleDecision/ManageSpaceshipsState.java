/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class ManageSpaceshipsState extends State {

	public ManageSpaceshipsState(AI ai) {
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
		if(this.getMemoryModule().getSpaceShips().get(0).getAp() < 1) {
			transition = new EndTurnState(getAi());
			System.out.println("if");
		}
		else if(this.getMemoryModule().getSpaceShips().get(0).getAp() < 1 && this.getMemoryModule().getSpaceShips().get(0).getOrder() != null) {
			transition = new MovingState(getAi());
			System.out.println("else if");
		}
		else {
			transition = new ChooseDestinationState(getAi());
			System.out.println("else");
		}
		return transition;
	}

}
