package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Algo.ExploringPath;
import grapheffect_ia.Model.Map.Hexagon.Hexagon;

/**
 * @author julie
 *
 */
public class ChooseDestinationState extends State {

	public ChooseDestinationState(AI ai) {
		super(ai);
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
		/*
		Hexagon shipHexagon = getMemoryModule().getMap().getHexagon(getMemoryModule().getSpaceship().get(0).getPosition());
		Hexagon baseHexagon = getMemoryModule().getBaseHexagon();
		ExploringPath ep = new ExploringPath(getMemoryModule().getMap());
		ep.calculation(shipHexagon, baseHexagon);
		Hexagon destination = ep.getUnknownHexagonToVisit();
		getMemoryModule().getSpaceship().get(0).addOrders(ep.getPath(destination));
		return new MovingState(getAi());
		*/
		try {
			Hexagon shipHexagon = getMemoryModule().getMap().getHexagon(getMemoryModule().getSpaceships().get(0).getPosition());
			Hexagon baseHexagon = getMemoryModule().getBaseHexagon();
			ExploringPath ep = new ExploringPath(getMemoryModule().getMap());
			ep.calculation(shipHexagon, baseHexagon);
			Hexagon destination = ep.getUnknownHexagonToVisit();
			if(destination == null || !(destination.isAccessible()) || destination.equals(shipHexagon)) {
				destination = ep.getUnknownHexagonToVisit();
				getMemoryModule().getSpaceships().get(0).setGoalPosition(destination.getCoordinate());
			}
			getMemoryModule().getSpaceships().get(0).addOrders(ep.getPath(destination));
			return new MovingState(getAi());
		}
		catch(NullPointerException npe) {
			return new EndGameState(getAi());
		}
	}

}
