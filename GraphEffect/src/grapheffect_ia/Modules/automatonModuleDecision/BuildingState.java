package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class BuildingState extends State {

	public BuildingState(AI ai) {
		super(ai);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "BUILDSHIP|Explorer";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		this.getMemoryModule().addSpaceships("Explorer");
		return new ManageSpaceshipsState(getAi());
	}

}
