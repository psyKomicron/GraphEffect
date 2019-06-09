/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapheffect_ia.Model.Map.Hexagon;

import java.util.ArrayList;

import grapheffect_ia.Model.Map.Coordinate;

/**
 *
 * @author julie
 */
public abstract class Hexagon {
    private Coordinate coordinate;
    private ArrayList<Hexagon> neighbours;
    
    
    public Hexagon(Coordinate coord) {
    	neighbours = new ArrayList<>();
        coordinate = coord;
    }
    
    public Coordinate getCoordinate() {
        return this.coordinate;
    }
    
    public ArrayList<Hexagon> getNeighbours() {
    	return this.neighbours;
    }
    
    public void addNeighbours(Hexagon neighbour) {
    	this.neighbours.add(neighbour);
    }
    
    /**
     * Returns the type of this hexagon, according to the TypeHexagon enumeration
     * @return TypeHexagon
     */
    public abstract TypeHexagon getType();
    
    public abstract boolean isAccessible();
}
