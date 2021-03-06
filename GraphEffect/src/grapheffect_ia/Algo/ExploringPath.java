/**
 * 
 */
package grapheffect_ia.Algo;

import java.util.ArrayList;

import grapheffect_ia.Model.Map.*;
import grapheffect_ia.Model.Map.Hexagon.Hexagon;
import grapheffect_ia.Model.Map.Hexagon.TypeHexagon;

/**
 * @author julie
 *
 */
public class ExploringPath {
	private Map _map;
	private BfSearch _pathFromShip;
	private BfSearch _pathFromBase;
	
	public ExploringPath(Map map) {
		_map = map;
		_pathFromShip = new BfSearch(map);
		_pathFromBase = new BfSearch(map);
	}
	
	public void calculation(Hexagon shipHexagon, Hexagon baseHexagon) {
		_pathFromShip.calculation(shipHexagon);
		_pathFromBase.calculation(baseHexagon);
	}
	
	public ArrayList<TypeMovement> getPath(Hexagon end) {
		return _pathFromShip.getPath(end);
	}
	
	/**
	 * 
	 * @return Hexagon
	 */
	public Hexagon getUnknownHexagonToVisit() {
		Hexagon result = null;
		int minCost = Integer.MAX_VALUE;
		for(Hexagon hexa : _map.getHexagons()) {
			if(_pathFromBase.isReachable(hexa) && _pathFromShip.isReachable(hexa) && hexa.getType().equals(TypeHexagon.UNKNOW)) {
				int distanceCost = _pathFromBase.getDistance(hexa) + _pathFromShip.getDistance(hexa);
				int neighborCost = 0;
				for(Hexagon neighbor : hexa.getNeighbours()) {
					if(!(neighbor.getType().equals(TypeHexagon.UNKNOW))) {
						neighborCost++;
					}
				}
				int cost = distanceCost + neighborCost;
				if(cost < minCost) {
					result = hexa;
					minCost = cost;
				}
			}
		}
		return result;
	}
	
	public boolean isReachable(Hexagon hexa) {
		return hexa.isAccessible();
	}

}
