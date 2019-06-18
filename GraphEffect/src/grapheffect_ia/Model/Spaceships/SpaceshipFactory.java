/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Map.Map;
import grapheffect_ia.Modules.Module_Memory;

/**
 * @author julie
 *
 */
public class SpaceshipFactory {
	public static int _SpaceshipsNumber;

	/**
	 * Constructs a spaceship of a specified type (arg), its place of creation coordinates and its name (used by the communication protocol).
	 * @param arg Type of spaceship to create (@see TypeSpaceShip)
	 * @param base Where the ship has been created
	 * @param map Map for the spaceship
	 * @return SpaceShip The spaceship created
	 * @throws NullPointerException if the arg value does'n match any TypeSpaceship values
	 */
	public static Spaceship createSpaceship(TypeSpaceship arg, Coordinate base, Map map, Module_Memory memoryModule) throws NullPointerException {
		Spaceship spaceship = null;
		switch(arg) {
		case EXPLORER :
			spaceship = new ExplorerSpaceship(base, TypeSpaceship.EXPLORER.label, memoryModule);
			break;
		case CONSTRUCTOR :
			spaceship = new ConstructorSpaceship(base, TypeSpaceship.CONSTRUCTOR.label, memoryModule);
			break;
		case TRANSPORTER :
			spaceship = new TransporterSpaceship(base, TypeSpaceship.TRANSPORTER.label, memoryModule);
			break;
		case FIGHTER :
			spaceship = new FighterSpaceship(base, TypeSpaceship.FIGHTER.label, memoryModule);
			break;
		default :
			throw new NullPointerException("\n default case on : \n\tSpaceShipFactory.createSpaceShip");
		}
		_SpaceshipsNumber++;
		spaceship.setMap(map);
		spaceship.setNumber(spaceship.getCount());
		return spaceship;
	}
}
