package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class BuildingState extends State {

	public BuildingState(Module_Decision moduleDecision) {
		super(moduleDecision);
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
		this.getMemoryModule().addSpaceShips("Explorer");
		return new ManageSpaceshipState(getDecisionModule());
	}

}
