/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class InitialState extends State {

	public InitialState(Module_Decision moduleDecision) {
		super(moduleDecision);
	}

	@Override
	public String messageToSend() {
		return "";
	}

	@Override
	public State transition() {
		return new MapState(getDecisionModule());
	}

	
}
