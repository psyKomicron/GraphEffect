/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapheffect_ia.Model.Map.Hexagon;

import grapheffect_ia.Model.Map.Coordinate;

/**
 *
 * @author julie
 */
public class HexagonFactory {
    
    public static Hexagon createHexagon(Coordinate coordinate, char c) {
    	Hexagon hexa;
    	
    	switch(c) {
    	case 'D' :
    		hexa = new Hexagon_Asteroids(coordinate);
    		break;
    	case 'A' :
    		hexa = new Hexagon_Asteroids(coordinate);
    		break;
    	case 'E' :
    		hexa = new Hexagon_Empty(coordinate);
    		break;
    	case 'P' :
    		hexa = new Hexagon_Planet(coordinate);
    		break;
    	case 'S' :
    		hexa = new Hexagon_Star(coordinate);
    		break;
    	case 'T' :
    		hexa = new Hexagon_Asteroids(coordinate);
    		break;
    	case 'X' :
    		hexa = new Hexagon_Unkown(coordinate);
    		break;
    	default :
    		throw new UnsupportedOperationException();
    	}
    	return hexa;
    }
}
