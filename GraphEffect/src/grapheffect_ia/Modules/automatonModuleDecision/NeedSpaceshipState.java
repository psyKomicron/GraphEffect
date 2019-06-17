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
		if(getMemoryModule().getSpaceshipsNumber() <= 10 && getMemoryModule().isCoordinateFree(getMemoryModule().getBase())) {
			transition = new BuildingState(getAi());
		} else transition = new ManageSpaceshipsState(getAi(), getMemoryModule().getCurrentSpaceship());
		return transition;
	}

}
