package grapheffect_ia.Modules;

import java.util.ArrayList;
import java.util.HashMap;

import grapheffect_ia.AI;
import grapheffect_ia.Model.Map.Map;
import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Map.Hexagon.Hexagon;
import grapheffect_ia.Model.Spaceships.*;
import grapheffect_ia.Model.Spaceships.SpaceshipFactory;

/**
 * <p>Module in charge of the memory of our AI</p>
 * @author Matthieu
 */
public class Module_Memory extends Module  {

	private ArrayList<Spaceship> _spaceships;
	private ArrayList<Coordinate> _bases;
    private Coordinate _coordinateBase;
    private Map _map;
    private boolean _mapUpToDate;
    private int _numCurrentSpaceship;
	
    /**
     * <p>
     * Constructor. Uses the super constructor inherited from Module and instantiates the SpaceShip array.
     * </p>
     * @param ai Ai ?
     */
    public Module_Memory(AI ai) {
        super(ai);
        _spaceships = new ArrayList<>();
        _bases = new ArrayList<>();
       _numCurrentSpaceship = 0;
    }
    
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
     * Getter for _space_ships
     * @return Array list _spaceship
     */
    public ArrayList<Spaceship> getSpaceships() {
		return _spaceships;
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
    	for (Spaceship s : _spaceships) {
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
    
    /**
     * Return the number of spaceship of the given type
     * @param type Type of spaceship to count
     * @return Integer
     */
    public int getSpaceshipsNumber(TypeSpaceship type) {
    	int i = 0;
    	for(Spaceship ship : _spaceships) {
    		if(ship.getType().equals(type)) {
    			i++;
    		}
    	}
    	return i;
    }
    
    /**
     * Getter for Map._map.
     * @return Map _map attribute
     */
    public Map getMap() {
    	return this._map;
    }
    
    /**
     * <p>
     * Uses the fromString {@link grapheffect_ia.Modules.Module_Memory#fromString(String message)} static method to set the base for the game.
     * </p> 
     * @param message String sent by the server when asked for BASE command
     */
    public void setBase(String message) {
    	this._coordinateBase = Module_Memory.fromString(message);
    }
    
    public Coordinate getBase() {
    	return this._coordinateBase;
    }
    
    public Hexagon getBaseHexagon() {
    	return _map.getHexagon(_coordinateBase);
    }
    
    public Spaceship getCurrentSpaceship() {
    	return _spaceships.get(_numCurrentSpaceship);
    }
    
    /**
     * 
     */
    public void nextSpaceship() {
    	_numCurrentSpaceship++;
		_numCurrentSpaceship = _numCurrentSpaceship%_spaceships.size();
    }
    
    /**
     * <p>Add the spaceship specified by the method parameter to the {@link java.util.ArrayList} attribute</p>
     * <p>Type names :
     * 	<ul><li>Explorer</li></ul>
     * 	<ul><li>Constructor</li></ul>
     * 	<ul><li>Fighter</li></ul>
     * 	<ul><li>Transporter</li></ul>
     * </p>
     * <p>Print in the console if no case matches the type parameter</p>
     * @param type (String) type of the ship to add
     */
    public void addSpaceships(String type) {
    	switch(type) {
    	case "Explorer" :
			this._spaceships.add(SpaceshipFactory.createSpaceship(TypeSpaceship.EXPLORER, this._coordinateBase, _map, this));
    		break;
    	case "Constructor" :
    		this._spaceships.add(SpaceshipFactory.createSpaceship(TypeSpaceship.CONSTRUCTOR, this._coordinateBase, _map, this));
    		break;
    	case "Fighter" :
    		this._spaceships.add(SpaceshipFactory.createSpaceship(TypeSpaceship.FIGHTER, this._coordinateBase, _map, this));
    		break;
    	case "Transporter" :
    		this._spaceships.add(SpaceshipFactory.createSpaceship(TypeSpaceship.TRANSPORTER, this._coordinateBase, _map, this));
    		break;
    	default :
    		System.err.println("default case on Module_Memory.addSpaceShip ("+type+")");
    	}
    }
      
	/**
     * <p>
     * Creates a map with {@link Map#Map(String)}. The string used is given by the reaction module after it used the {@link Module_Memory#hasMap()} and
     * the method has return false.
     * </p> 
     * @param messageReceived message to generate the map from
     */
    public void generateMap(String messageReceived) {
    	_map = new Map(messageReceived);
        _mapUpToDate = true;
        for(Spaceship spaceship : _spaceships) {
        	spaceship.setMap(_map);
        }
    }
    
    /**
     * <p>
     * Check if the memory module has stored the map of the game.
     * If not the function raise a NullPointerException which is caught by the method thus returns false.
     * Else if the module has a map then the method returns true
     * </p>
     * @return boolean
     */
    public boolean hasMap() {
    	return this._mapUpToDate;
    }
    
    public void updateMap(boolean upToDate) {
    	_mapUpToDate = upToDate;
    	if(upToDate == false) {
			for(Spaceship spaceship : _spaceships) {
				spaceship.clearOrders();
			}
    	}
    }
    
    /**
     * <p>Translates the response of the server to the BASE command.</p>
     * <p>Splits the string parameter on ',' and cast the value to Integer</p>
     * @param message string sent back by the server (like X,Y ; X,Y being integers)
     * @return Coordinate created from the two parts of the string
     */
    public static Coordinate fromString(String message) {
        String[] translated_message = message.split(",");
        return new Coordinate(Integer.valueOf(translated_message[0]), Integer.valueOf(translated_message[1]));
    }
    
    /**
     * <p>
     * Check if the ai's memory module has or not its Coordinate attribute instantiated. Basically tells if the base has been asked and stored.
     * </p> 
     * @return boolean tells if the _map (Map) attribute has been instantiated.
     */
    public boolean hasBase() {
    	boolean b;
    	if(this._coordinateBase == null) {
    		b = false;
    	} else b = true;
    	return b;
    }
    
    public boolean isCoordinateFree(Coordinate c) {
    	boolean isFree = true;
    	for(Spaceship spaceship : _spaceships) {
    		if(spaceship.getPosition().equals(c)) {
    			isFree = false;
    		}
    	}
    	return isFree;
    }
}
