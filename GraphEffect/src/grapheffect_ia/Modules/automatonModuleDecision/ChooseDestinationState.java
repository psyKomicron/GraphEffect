package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Algo.BfSearch;
import grapheffect_ia.Model.Map.Coordinate;

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
		BfSearch bfsearch = new BfSearch(this.getMemoryModule().getMap());
		bfsearch.calculation(this.getMemoryModule().getMap().getHexagon( getMemoryModule().getSpaceShips().get(0).getPosition() ));
		this.getMemoryModule().getSpaceShips().get(0).addOrders( bfsearch.getPath(getMemoryModule().getMap().getHexagon(new Coordinate(0,0))) );
		transition = new MovingState(getAi());
		return transition;
	}

}
