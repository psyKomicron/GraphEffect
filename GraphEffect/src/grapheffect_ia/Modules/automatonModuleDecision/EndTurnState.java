/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Modules.Module_Decision;

/**
 * @author julie
 *
 */
public class EndTurnState extends State {

	public EndTurnState(AI ai) {
		super(ai);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public String messageToSend() {
		return "ENDTURN";
	}

	/**
	 * @see {@link grapheffect_ia.Modules.automatonModule.State}
	 */
	@Override
	public State transition() {
		return new ManageSpaceshipState(getAi());
	}

}
