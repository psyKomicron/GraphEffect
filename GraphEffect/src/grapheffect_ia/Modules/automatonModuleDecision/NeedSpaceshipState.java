package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class NeedSpaceshipState extends State {

	public NeedSpaceshipState(Module_Decision moduleDecision) {
		super(moduleDecision);
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
		if(!(this.getMemoryModule().getSpaceShips().isEmpty())) {
			transition = new ManageSpaceshipState(getDecisionModule());
		} else transition = new BuildingState(getDecisionModule());
		return transition;
	}

}
