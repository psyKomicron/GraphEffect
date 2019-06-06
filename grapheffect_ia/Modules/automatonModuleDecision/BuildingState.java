package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class BuildingState extends State {

	public BuildingState(Module_Decision moduleDecision) {
		super(moduleDecision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String messageToSend() {
		return "BUILD|Explorer";
	}

	@Override
	public State transition() {
		this.getMemoryModule().addSpaceShips("Explorer");
		return new ManageSpaceshipState(getDecisionModule());
	}

}
