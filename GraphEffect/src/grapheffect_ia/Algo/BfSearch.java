/**
 *
 */
package grapheffect_ia.Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

import grapheffect_ia.Model.Map.Hexagon.*;
import grapheffect_ia.Model.Map.*;

/**
 * @author julie
 *
 */
public class BfSearch {

    private HashMap<Hexagon, Integer> _distances;
    //private Map _map;

    	
    public BfSearch(Map map) {
        //this._map = map;
    	_distances = new HashMap<>();
    }

    /**
     * Calculates the distance from an hexagon all its neighbors 
     * @param start hexagon to start calculating distances from
     */
    public void calculation(Hexagon start) {
        ArrayList<Hexagon> toCheck = new ArrayList<>();
        _distances.clear();
        toCheck.add(start);
        _distances.put(start, 0);
        while (!toCheck.isEmpty()) {
            Hexagon HexaInProgress = toCheck.get(0);
            toCheck.remove(0);
            for (Hexagon v : HexaInProgress.getNeighbours()) {
                if (_distances.get(v) == null) {
                    if (v.isAccessible()) {
                        _distances.put(v, _distances.get(HexaInProgress) + 1);
                        toCheck.add(v);
                    } else {
                        _distances.put(v, -1);
                    }
                }
            }
        }
    }	
    
    /**
     * Getter for a specific hexagon inside the HashMap _distances attribute.
     * @param hexa hexagon to look
     * @return Integer distance from hexa to the start
     */
    public int getDistance(Hexagon hexa) {
        return this._distances.get(hexa);
    }

    
    /**
     * Gives the movement to do to go to the start hexagon to the end hexagon.
     * @param start current position of the ship
     * @param end where you want the ship to go
     * @return TypeMovement movement to make to go to 'start' to 'end'
     */
    private TypeMovement movement(Hexagon start, Hexagon end) {
        TypeMovement t = null;
        for (TypeMovement move : TypeMovement.values()) {
            if (start.getCoordinate().neighbour(move).equals(end.getCoordinate())) {
                t = move;
            }
        }
        return t;
    }

    
    /**
     * Gives a path from the hexagon at the beginning of the HashMap to the method parameter 'end'
     * @param end hexagon where the path has to stop
     * @return array (ArrayList) of TypeMovement
     */
    public ArrayList<TypeMovement> getPath(Hexagon end) {
        ArrayList<TypeMovement> path_movements = new ArrayList<>();
        Hexagon hexa_in_progress = end;
        boolean end_distance_null = false;
        try {
        	this.getDistance(end);
        } catch(NullPointerException npe) {
        	end_distance_null = true;
        }
        if(!(end_distance_null || this.getDistance(end) == -1)) {
	        while (this.getDistance(hexa_in_progress) > 0) {
	            Hexagon previous_hexa = null;
	            // searching for the previous Hexagon
	            for (Hexagon h : hexa_in_progress.getNeighbours()) {
	                if (this.getDistance(h) == this.getDistance(hexa_in_progress) - 1) {
	                    previous_hexa = h;
	                }
	            }
	            // use private method movement to store into the path array
	            path_movements.add(this.movement(previous_hexa, hexa_in_progress));
	            hexa_in_progress = previous_hexa;
	        }
	        //reversing array list to get a real path
	        Collections.reverse(path_movements);
        }
        return path_movements;
    }
    
    public boolean isReachable(Hexagon hexa) {
    	boolean reachable = false;
    	if(_distances.get(hexa) != null && _distances.get(hexa) > -1	) {
			reachable = true;
    	}
    	return reachable;
    }
    
}
