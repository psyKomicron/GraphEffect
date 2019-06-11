package grapheffect_ia.Modules.automatonModuleDecision;

<<<<<<< .mine
import grapheffect_ia.Algo.ExploringPath;
import grapheffect_ia.Model.Map.Hexagon.Hexagon;
||||||| .r16
import grapheffect_ia.Algo.BfSearch;
import grapheffect_ia.Model.Map.Coordinate;
=======
import grapheffect_ia.AI;
import grapheffect_ia.Algo.BfSearch;
import grapheffect_ia.Model.Map.Coordinate;
>>>>>>> .r18

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
<<<<<<< .mine
		Hexagon shipHexagon = getMemoryModule().getMap().getHexagon(getMemoryModule().getSpaceShips().get(0).getPosition());
		Hexagon baseHexagon = getMemoryModule().getBaseHexagon();
		ExploringPath ep = new ExploringPath(getMemoryModule().getMap());
		ep.calculation(shipHexagon, baseHexagon);
		Hexagon destination = ep.getUnknownHexagonToVisit();
		
||||||| .r16
		BfSearch bfsearch = new BfSearch(this.getMemoryModule().getMap());
		bfsearch.calculation(this.getMemoryModule().getMap().getHexagon( getMemoryModule().getSpaceShips().get(0).getPosition() ));
		this.getMemoryModule().getSpaceShips().get(0).addOrders( bfsearch.getPath(getMemoryModule().getMap().getHexagon(new Coordinate(0,0))) );
		transition = new MovingState(this.getDecisionModule());
=======
		BfSearch bfsearch = new BfSearch(this.getMemoryModule().getMap());
		bfsearch.calculation(this.getMemoryModule().getMap().getHexagon( getMemoryModule().getSpaceShips().get(0).getPosition() ));
		this.getMemoryModule().getSpaceShips().get(0).addOrders( bfsearch.getPath(getMemoryModule().getMap().getHexagon(new Coordinate(0,0))) );
		transition = new MovingState(getAi());
>>>>>>> .r18
		return transition;
	}

}
