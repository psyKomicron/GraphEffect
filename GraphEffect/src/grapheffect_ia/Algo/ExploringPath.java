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
		int coutMin = Integer.MAX_VALUE;
		for(Hexagon hexa : _map.getHexagon()) {
			if(_pathFromBase.isReachable(hexa) && _pathFromShip.isReachable(hexa) && hexa.getType().equals(TypeHexagon.UNKNOW)) {
				int coutDistance = _pathFromBase.getDistance(hexa) + _pathFromShip.getDistance(hexa);
				int cout = coutDistance;
				if(cout < coutMin) {
					result = hexa;
					coutMin = cout;
				}
			}
		}
		return result;
	}

}
