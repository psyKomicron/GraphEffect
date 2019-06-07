/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Map.Map;

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
	public static Spaceship createSpaceship(TypeSpaceship arg, Coordinate base, Map map) throws NullPointerException {
		Spaceship spaceship = null;
		switch(arg) {
		case EXPLORER :
			spaceship = new ExplorerSpaceship(base, TypeSpaceship.EXPLORER.label);
			break;
		case CONSTRUCTOR :
			spaceship = new ConstructorSpaceship(base, TypeSpaceship.CONSTRUCTOR.label);
			break;
		case TRANSPORTER :
			spaceship = new TransporterSpaceship(base, TypeSpaceship.TRANSPORTER.label);
			break;
		case FIGHTER :
			spaceship = new FighterSpaceship(base, TypeSpaceship.FIGHTER.label);
			break;
		default :
			throw new NullPointerException("\n default case on : \n\tSpaceShipFactory.createSpaceShip");
		}
		spaceship.setMap(map);
		return spaceship;
	}
}
