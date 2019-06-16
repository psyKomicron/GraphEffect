package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;

/**
 * @author julie
 *
 */
public class MapState extends State {

	public MapState(AI ai) {
		super(ai);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "MAP";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		State transition = null;
		if(!(this.getMemoryModule().hasBase())) {
			transition = new BaseState(getAi());
		} else transition = new NeedSpaceshipState(getAi());
		return transition;
	}

}
