package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class NeedSpaceshipState extends State {

	public NeedSpaceshipState(Module_Decision moduleDecision) {
		super(moduleDecision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String messageToSend() {
		return "";
	}

	@Override
	public State transition() {
		State transition = null;
		if(this.getMemoryModule().getSpaceShips() != null) {
			transition = new ManageSpaceshipState(getDecisionModule());
		} else transition = new BuildingState(getDecisionModule());
		return transition;
	}

}
