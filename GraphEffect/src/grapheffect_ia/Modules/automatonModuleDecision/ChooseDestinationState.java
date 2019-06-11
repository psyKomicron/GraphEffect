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

	@Override
	public String messageToSend() {
		return "";
	}

	@Override
	public State transition() {
		State transition = null;
		Hexagon shipHexagon = getMemoryModule().getMap().getHexagon(getMemoryModule().getSpaceShips().get(0).getPosition());
		Hexagon baseHexagon = getMemoryModule().getBaseHexagon();
		ExploringPath ep = new ExploringPath(getMemoryModule().getMap());
		ep.calculation(shipHexagon, baseHexagon);
		Hexagon destination = ep.getUnknownHexagonToVisit();
		
		return transition;
	}

}
