/**
 * 
 */
package grapheffect_ia.Modules.Data;

import java.util.ArrayList;
import java.util.HashMap;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Spaceships.Spaceship;
import grapheffect_ia.Model.Spaceships.TypeSpaceship;

/**
 * @author julie
 *
 */
public class Data {
	private ArrayList<Spaceship> _spaceships;
	private ArrayList<Coordinate> _bases;
	// primitives
	
	public Data() {
	}
	
	public Data(ArrayList<Spaceship> spaceships, ArrayList<Coordinate> bases) {
		_spaceships = spaceships;
		_bases = bases;
	}
	
	/*********************************************************
	 * 
	 * 						GETTERS/SETTERS
	 * 
	 *********************************************************/
	
	public ArrayList<Spaceship> getSpaceships() {
		return _spaceships;
	}
	
	public void setSpaceships(ArrayList<Spaceship> param) {
		_spaceships = param;
	}
	
	
	public ArrayList<Coordinate> getBases() {
		return _bases;
	}
	
	public void setBases(ArrayList<Coordinate> param) {
		_bases = param;
	}
	
	/*********************************************************
	 * 
	 * 					INSTANCE METHODS
	 * 
	 *********************************************************/
	
	/**
     * Return number of spaceships on the map
     * @return int Number of spaceships on the map
     */
    public int countOfAllSpaceships() {
    	int countOfAllSpaceships = 0;
    	HashMap<TypeSpaceship, Integer> hashmap = getSpaceshipsNumber();
    	for(Integer i : hashmap.values()) {
    		countOfAllSpaceships += i; 
    	}
    	return countOfAllSpaceships;
    }
    
    /**
     * <p>Calculates the number of each spaceship on the map, then store each value into an HashMap with the corresponding spaceship type.</p>
     * @return HashMap of {@linkplain grapheffect_ia.Model.Spaceships.TypeSpaceship}, Integer
     */
    public HashMap<TypeSpaceship, Integer> getSpaceshipsNumber() {
    	HashMap<TypeSpaceship, Integer> num = new HashMap<>();
    	int numberOfConstructors = 0;
    	int numberOfExplorers = 0;
    	int numberOfFighters = 0;
    	int numberOfTransporters = 0;
    	for (Spaceship s : getSpaceships()) {
    		if (s.getType().equals(TypeSpaceship.CONSTRUCTOR)) {
    			numberOfConstructors++;
    		}
    		if (s.getType().equals(TypeSpaceship.EXPLORER)) {
    			numberOfExplorers++;
    		}
    		if (s.getType().equals(TypeSpaceship.FIGHTER)) {
    			numberOfFighters++;
    		}
    		if (s.getType().equals(TypeSpaceship.TRANSPORTER)) {
    			numberOfTransporters++;
    		}
    	}
    	num.put(TypeSpaceship.CONSTRUCTOR, numberOfConstructors);
    	num.put(TypeSpaceship.EXPLORER, numberOfExplorers);
    	num.put(TypeSpaceship.FIGHTER, numberOfFighters);
    	num.put(TypeSpaceship.TRANSPORTER, numberOfTransporters);
    	return num;
    }
	
} //class end
