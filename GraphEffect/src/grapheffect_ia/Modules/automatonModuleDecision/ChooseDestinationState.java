	package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Algo.ExploringPath;
import grapheffect_ia.Model.Map.Hexagon.Hexagon;
import grapheffect_ia.Model.Spaceships.Spaceship;

/**
 * @author julie
 *
 */
public class ChooseDestinationState extends State {
	private Spaceship _spaceship;

	public ChooseDestinationState(AI ai, Spaceship spaceship) {
		super(ai);
		_spaceship = spaceship;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		Hexagon shipHexagon = getMemoryModule().getMap().getHexagon(_spaceship.getPosition());
		Hexagon baseHexagon = getMemoryModule().getBaseHexagon();
		ExploringPath ep = new ExploringPath(getMemoryModule().getMap());
		ep.calculation(shipHexagon, baseHexagon);
		Hexagon destination = ep.getUnknownHexagonToVisit();
		if(destination == null || !(ep.isReachable(destination)) || destination.equals(shipHexagon)) {
			destination = ep.getUnknownHexagonToVisit();
			if(destination == null) {
				_spaceship.setInactive();
			} else {
				_spaceship.setGoalPosition(destination.getCoordinate());
			}
		}
		_spaceship.addOrders(ep.getPath(destination));
		return new MovingState(getAi(), getMemoryModule().getCurrentSpaceship());
	}

}
