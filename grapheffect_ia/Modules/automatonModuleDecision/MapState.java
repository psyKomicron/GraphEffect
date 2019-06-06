package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class MapState extends State {

	public MapState(Module_Decision moduleDecision) {
		super(moduleDecision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String messageToSend() {
		return "MAP";
	}

	@Override
	public State transition() {
		State transition = null;
		if(this.getMemoryModule().hasBase()) {
			transition = new BaseState(getDecisionModule());
		}
		else transition = new NeedSpaceshipState(getDecisionModule());
		return transition;
	}

}
