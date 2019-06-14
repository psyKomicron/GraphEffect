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
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public String messageToSend() {
		return "BUILDSHIP|Explorer";
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public State transition() {
		this.getMemoryModule().addSpaceships("Explorer");
		return new ManageSpaceshipsState(getAi());
	}

}
