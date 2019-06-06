/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class MovingState extends State {

	public MovingState(Module_Decision moduleDecision) {
		super(moduleDecision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String messageToSend() {
		String message = "";
		if(this.getMemoryModule().getSpaceShips().get(0).getOrder() != null) {
			message = "MOVE|"+this.getMemoryModule().getSpaceShips().get(0).generateName()+"|"+this.getMemoryModule().getSpaceShips().get(0).getOrder().label;
		}
		return message;
	}

	@Override
	public State transition() {
		State transition = null;
		if(this.getMemoryModule().getSpaceShips().get(0).getOrder() != null) {
			this.getMemoryModule().getSpaceShips().get(0).doOrder();
		}
		if(this.getMemoryModule().getSpaceShips().get(0).needUpdatedMap()) {
			this.getMemoryModule().updateMap(true);
			transition = new MapState(getDecisionModule());
		} else transition = new ManageSpaceshipState(this.getDecisionModule());
		return transition;
	}

}
