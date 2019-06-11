package grapheffect_ia.Model.Map;

import grapheffect_ia.Model.Map.Hexagon.Hexagon;
import grapheffect_ia.Model.Map.Hexagon.HexagonFactory;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author julie
 */
public class Map {
    
    private HashMap<Coordinate, Hexagon> _hexagons;
    
    public Map(String messageReceived) {
        _hexagons = new HashMap<>();
        for(int i = 0; i < 41; i++) {
            for(int j = 0; j < 55; j++) {
                this.addHexagon(new Coordinate(i, j), messageReceived.charAt(j +(55*i)));
            }
        }
        for(int i = 0; i < 41; i++) {
        	for(int j = 0; j < 55; j++) {
        		Coordinate cooHexagon = new Coordinate(i, j);
        		for(TypeMovement movement : TypeMovement.values()) {
        			Coordinate cooNeighbour = cooHexagon.neighbour(movement);
        			if(this._hexagons.get(cooNeighbour) != null) {
        				this._hexagons.get(cooHexagon).addNeighbours(this._hexagons.get(cooNeighbour));
        			}
        		}
        	}
        }
    }
    
    /**
     * Creates and add an hexagon with the char and coordinate given in parameter
     * @param coordinate Where to create the hexagon
     * @param letter type of hexagon
     */
    private void addHexagon(Coordinate coordinate, char letter) {
        this._hexagons.put(coordinate, HexagonFactory.createHexagon(coordinate, letter));
    }
    
    /**
     * Get the hexagon from the HashMap. If the hexagon isn't in the HashMap the method returns null.
     * @param position Coordinate of the hexagon to search
     * @return the hexagon at the right coordinate, and if not found : null
     */
    public Hexagon getHexagon(Coordinate position) {
    	Hexagon hexagon = null;
    	for(Hexagon h : _hexagons.values()) {
    		if(h.getCoordinate().equals(position)) {
    			hexagon = h;
    		}
    	}
    	return hexagon;
    }
    
    public Collection<Hexagon> getHexagon() {
    	return _hexagons.values();
    }
    
} 
