/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Model.Spaceships.Spaceship;

/**
 * @author julie
 *
 */
public class MovingState extends State {
	private Spaceship _spaceship;

	public MovingState(AI ai, Spaceship spaceship) {
		super(ai);
		_spaceship = spaceship;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		String message = "";
		if(_spaceship.getOrder() != null && _spaceship.canDoOrder()) {
			message = "MOVE|"+_spaceship.generateName()+"|"+_spaceship.getOrder().label;
		}
		return message;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		State transition = null;
		// setting the map for all spaceships
		if(_spaceship.getOrder() != null && _spaceship.canDoOrder()) {
			_spaceship.doOrder();
		}
		if(_spaceship.needUpdatedMap()) {
			this.getMemoryModule().updateMap(false);
			transition = new MapState(getAi());
		} else transition = new NeedSpaceshipState(getAi());
		return transition;
	}

}
