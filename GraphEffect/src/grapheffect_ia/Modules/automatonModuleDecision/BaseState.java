package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class BaseState extends State {

	public BaseState(AI ai) {
		super(ai);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "BASE";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		return new NeedSpaceshipState(getAi());
	}

}
