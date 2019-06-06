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

/**
 * @author julie
 */
public abstract class Spaceship {
	private Coordinate _position;
	private ArrayList<TypeMovement> _orders;
	private int _ap;
	private String _name;
	private Map _map;
	
	
	/**
	 * Constructs a spaceship with its position and name 
	 * @param position
	 * @param name
	 */
	public Spaceship(Coordinate position, String name) {
		_position = position;
		_orders = new ArrayList<>();
		_ap = 6;
		_name = name;
	}

	/**
	 * Constructs a spaceship with it's starting coordinates
	 * @param position
	 */
	public Spaceship(Coordinate position) {
		_position = position;
		_orders = new ArrayList<>();
		_ap = 6;
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	/**
	 * Used to get the right name of the spaceship (look at the NetworkProtocol.pdf file). But for now it does not work :(
	 * @return number of instances of the spaceship's type
	 */
	public abstract int getCount();
		
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
		TypeMovement order = this.getOrder(); 
		_position = _position.neighbour(order);
		_ap -= 1;
		_orders.remove(this.getOrder());
	}
	
	/**
	 * <p>Gets and return the first movement from _orders (ArrayList<Movement>)</p>
	 * @throws IndexOutOfBoundsException if the order array (_order attribute) is empty
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
	 * Gets and return the value at the specified index
	 * @param index, index value to retrieve
	 * @return TypeMovement, movement at specified index
	 */
	public TypeMovement getOrder(int index) {
		return _orders.get(index);
	}
	
	public void clearOrders() {
		_orders.clear();
	}
	
	// Abstract methods
	/**
	 * Return the type of this spaceship
	 * @return TypeSpaceShip, type of the spaceship (see {@link grapheffect_ia.Model.SpaceShips.TypeSpaceShip})
	 */
	public abstract TypeSpaceship getType();
	
	/**
	 * Reset the AP of this ship (Action Points)
	 */
	public abstract void resetAp();

	public String generateName() {
		return this.getName()+"_"+this.getCount();
	}
	
	public void setMap(Map map) {
		_map = map;
	}
	
	public boolean needUpdatedMap() {
		boolean needUpdatedMap = false;
		for(Hexagon hexagon : _map.getHexagon(_position).getNeighbours()) {
			for(Hexagon n : _map.getHexagon(hexagon.getCoordinate()).getNeighbours()) {
				if(n.getType() == TypeHexagon.UNKNOW) {
					needUpdatedMap = true;
				}
			}
		}
		return needUpdatedMap;
	}
	
}
