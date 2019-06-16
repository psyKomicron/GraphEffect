package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class NeedSpaceshipState extends State {

	public NeedSpaceshipState(AI ai) {
		super(ai);
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
		if(!(this.getMemoryModule().getSpaceships().isEmpty())) {
			transition = new ManageSpaceshipsState(getAi());
		} else transition = new BuildingState(getAi());
		return transition;
	}

}
