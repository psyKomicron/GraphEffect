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
public class Hexagon_Empty extends Hexagon {

    public Hexagon_Empty(Coordinate coord) {
        super(coord);
    }

    @Override
    public TypeHexagon getType() {
        return TypeHexagon.EMPTY;
    }

	@Override
	public boolean isAccessible() {
		return true;
	}
    
}
