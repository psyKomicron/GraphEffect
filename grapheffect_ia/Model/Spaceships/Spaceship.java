/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import java.util.ArrayList;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Map.Map;
import grapheffect_ia.Model.Map.TypeMovement;
import grapheffect_ia.Model.Map.Hexagon.Hexagon;
import grapheffect_ia.Model.Map.Hexagon.TypeHexagon;
import grapheffect_ia.Modules.Module_Memory;

/**
 * @author julie
 */
public abstract class Spaceship {
	private Coordinate _position;
	private Coordinate _goalPosition;
	private Module_Memory _memoryModule;
	private Map _map;
	private String _name;
	
	private ArrayList<TypeMovement> _orders;
	
	private int _ap;
	private int _number;
	private boolean _active;	
	
	/**
	 * Constructs a spaceship with its position and name 	
	 * @param position position where the spaceship has been built
	 * @param name name of the spaceship
	 * @param memoryModule no description to make here
	 * @param ap number of action points of the spaceship. Specified internally by each subclass constructor
	 */
	public Spaceship(Coordinate position, String name, Module_Memory memoryModule, int ap) {
		_position = position;
		_orders = new ArrayList<>();
		_ap = ap;
		_name = name;
		_memoryModule = memoryModule;
		_active = true;
	}
	
	/**
	 * Constructs a spaceship with it's starting coordinates
	 * @deprecated
	 * @param position position where the spaceship has been built
	 */
	public Spaceship(Coordinate position) {
		_position = position;
		_orders = new ArrayList<>();
		_ap = 6;
	}


//********************************************************
// 
//					Getters/setters
//
//********************************************************
	
	public void setNumber(int n) {
		_number = n;
	}
	
	protected String getName() {
		return this._name;
	}
	
	protected void setName(String name) {
		_name = name;
	}
	
	/**
	 * Gets and return the value at the specified index
	 * @param index, index value to retrieve
	 * @return TypeMovement, movement at specified index
	 */
	public TypeMovement getOrder(int index) {
		return _orders.get(index);
	}
	
	/**
	 * <p>Gets and return the first movement from _orders (ArrayList<Movement>)</p>
	 * @return TypeMovement, first movement from _orders
	 */
	public TypeMovement getOrder() {
		TypeMovement order;
		try {
			order = _orders.get(0);
		} catch(IndexOutOfBoundsException ioobe) {
			order = null;
		}
		return order;
	}
		
	/**
	 * _position getter
	 * @return Coordinate, value of _position attribute
	 */
	public Coordinate getPosition() {
		return this._position;
	}
		
	/**
	 * _ap getter
	 * @return integer, value of _ap attribute
	 */
	public int getAp() {
		return this._ap;
	}
	
	/**
	 * _ap setter. Used to reset or change the aps of a ship
	 * @param ap, value setting _ap attribute
	 */
	public void setAp(int ap) {
		this._ap = ap;
	}
	
	public void setMap(Map map) {
		_map = map;
	}
	
	public void setGoalPosition(Coordinate c) {
		_goalPosition = c;
	}
	
	public Coordinate getGoalPosition() {
		return _goalPosition;
	}
	
	public void setInactive() {
		_active = false;
	}

	public boolean isActive() {
		return _active;
	}


//********************************************************
// 
//						Others
//
//********************************************************
	
	/**
	 * Add each movement from variable (list) to the _order attribute (which is an array)
	 * @param list, array of each type movement for the ship to do
	 */
	public void addOrders(ArrayList<TypeMovement> list) {
		for(TypeMovement movement : list) {
			this._orders.add(movement);
		}
	}

	/**
	 * <p>Moves this ship according to the first 'order' stored in the _order array list, change the spaceship's position and remove 1 action point.</p>
	 * <p>Finally removes the order that has just been executed from the order array</p>
	 */
	public void doOrder() throws NullPointerException {
		if (canDoOrder()) {
			_position = _position.neighbour(this.getOrder());
			_orders.remove(this.getOrder());
		}
		_ap -= 1;
	}
	
	public void clearOrders() {
		_orders.clear();
	}
	
	/**
	 * <p>Uses the static attribute of the spaceship and its type (name) to make a string like :</p>
	 * <p>Explorer_1</p>
	 * @return String
	 */
	public String generateName() {
		return getName()+"_"+_number;
	}
	
	public boolean needUpdatedMap() throws NullPointerException {
		boolean needUpdatedMap = false;
		if(_map == null) {
			throw new NullPointerException("Map has not been instantiated");
		}
		for(Hexagon hex1 : _map.getHexagon(_position).getNeighbours()) {
			for(Hexagon hex2 : _map.getHexagon(hex1.getCoordinate()).getNeighbours()) {
				if(hex2.getType() == TypeHexagon.UNKNOW) {
					needUpdatedMap = true;
				}
			}
		}
		return needUpdatedMap;
	}
	
	/**
	 * Check if where the spaceship is headed is free
	 * @return boolean
	 */
	public boolean canDoOrder() {
		boolean canDoOrder;
		if(getOrder() != null && _memoryModule.isCoordinateFree(_position.neighbour(getOrder()))) {
			canDoOrder = true;
		} else canDoOrder = false;
		return canDoOrder;
	}
	
	
//********************************************************
// 
//					Abstract methods
//
//********************************************************
	
	/**
	 * Return the type of this spaceship
	 * @return TypeSpaceShip, type of the spaceship (see {@link grapheffect_ia.Model.Spaceships.TypeSpaceship})
	 */
	public abstract TypeSpaceship getType();
	
	/**
	 * Reset the AP of this ship (Action Points)
	 */
	public abstract void resetAp();

	/**
	 * Return the number of instances of this spaceship's type (look at the NetworkProtocol.pdf file).
	 * @return number of instances of the spaceship's type
	 */
	public abstract int getCount();
	
}
