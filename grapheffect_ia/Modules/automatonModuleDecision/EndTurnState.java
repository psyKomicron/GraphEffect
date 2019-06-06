/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class EndTurnState extends State {

	public EndTurnState(Module_Decision moduleDecision) {
		super(moduleDecision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String messageToSend() {
		return "ENDTURN";
	}

	@Override
	public State transition() {
		return new ManageSpaceshipState(getDecisionModule());
	}

}
