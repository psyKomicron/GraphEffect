/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapheffect_ia.Model.Map;

/**
 *
 * @author julie
 */
public class Coordinate {
    
    private int line;
    private int column;
    
    
    public Coordinate(int line, int column) {
        this.line = line;
        this.column = column;
    }
    
    
    public int getLine() {
        return line;
    }
  
    public int getColumn() {
        return column;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.line;
        hash = 11 * hash + this.column;
        return hash;
    }
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (this.line != other.line) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {  	
    	return " "+this.column+", "+this.line+" ";
    }
    
    
    /**
     * <p>Calculates the new coordinate when a movement has been made on the map.</p>
     * e.g. a ship moves TOP, then the new coordinates are (x-1, y).
     * @param movement movement that the ship will do.
     * @return Coordinate new coordinates according to the movement that the ship has made.
     */
    public Coordinate neighbour(TypeMovement movement) {
    	Coordinate coordinate = null;
    	int i = this.line;
    	int j = this.column;
    	if(j%2 == 0) {
    		switch(movement) {
    		case TOP :
    			coordinate = new Coordinate(i-1, j);
    			break;
    		case BOTTOM :
    			coordinate = new Coordinate(i+1, j);
    			break;
    		case TOP_LEFT :
    			coordinate = new Coordinate(i-1, j-1);
    			break;
    		case TOP_RIGHT :
    			coordinate = new Coordinate(i-1, j+1);
    			break;
    		case BOTTOM_RIGHT :
    			coordinate = new Coordinate(i, j+1);
    			break;
    		case BOTTOM_LEFT :
    			coordinate = new Coordinate(i, j-1);
    			break;
    		default :
    			coordinate = new Coordinate(-1, -1);
    		}
    	}
    	else if(j%2 != 0) {
    		switch(movement) {
    		case TOP :
    			coordinate = new Coordinate(i-1, j);
    			break;
    		case BOTTOM :
    			coordinate = new Coordinate(i+1, j);
    			break;
    		case TOP_LEFT :
    			coordinate = new Coordinate(i, j-1);
    			break;
    		case TOP_RIGHT :
    			coordinate = new Coordinate(i, j+1);
    			break;
    		case BOTTOM_RIGHT :
    			coordinate = new Coordinate(i+1, j+1);
    			break;
    		case BOTTOM_LEFT :
    			coordinate = new Coordinate(i+1, j-1);
    			break;
    		default :
    			coordinate = new Coordinate(-1, -1);
    		}
    	}
    	return coordinate;
    }
}
