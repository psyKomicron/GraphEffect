package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class BaseState extends State {

	public BaseState(Module_Decision moduleDecision) {
		super(moduleDecision);
	}

	@Override
	public String messageToSend() {
		return "BASE";
	}

	@Override
	public State transition() {
		return new NeedSpaceshipState(getDecisionModule());
	}

}
