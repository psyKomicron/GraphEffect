/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;

/**
 * @author julie
 *
 */
public class SpaceshipFactory {

	/**
	 * Constructs a spaceship of a specified type (arg), its place of creation coordinates and its name (used by the communication protocol).
	 * @param arg Type of spaceship to create (@see TypeSpaceShip)
	 * @param base Where the ship has been created
	 * @param name Name of the spaceship
	 * @return SpaceShip The spaceship created
	 * @throws NullPointerException
	 */
	public static Spaceship createSpaceship(TypeSpaceship arg, Coordinate base, String name) throws NullPointerException {
		Spaceship spaceship = null;
		switch(arg) {
		case EXPLORER :
			spaceship = new ExplorerSpaceship(base, name);
			break;
		case CONSTRUCTOR :
			spaceship = new ConstructorSpaceship(base, name);
			break;
		case TRANSPORTER :
			spaceship = new TransporterSpaceship(base, name);
			break;
		case FIGHTER :
			spaceship = new FighterSpaceship(base, name);
			break;
		default :
			throw new NullPointerException("\n default case on : \n\tSpaceShipFactory.createSpaceShip");
		}
		return spaceship;
	}
}
