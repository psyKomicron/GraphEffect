/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class MovingState extends State {

	public MovingState(AI ai) {
		super(ai);
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public String messageToSend() {
		String message = "";
		if(this.getMemoryModule().getSpaceships().get(0).getOrder() != null) {
			message = "MOVE|"+this.getMemoryModule().getSpaceships().get(0).generateName()+"|"+this.getMemoryModule().getSpaceships().get(0).getOrder().label;
		}
		return message;
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public State transition() {
		State transition = null;
		// setting the map for all spaceships
		if(this.getMemoryModule().getSpaceships().get(0).getOrder() != null) {
			this.getMemoryModule().getSpaceships().get(0).doOrder();
		}
		if(this.getMemoryModule().getSpaceships().get(0).needUpdatedMap()) {
			this.getMemoryModule().updateMap(false);
			transition = new MapState(getAi());
		} else transition = new ManageSpaceshipsState(getAi());
		return transition;
	}

}
