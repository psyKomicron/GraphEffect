/**
 * 
 */
package grapheffect_ia.Modules;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Spaceships.*;

/**
 * @author julie
 *
 */
public class SpaceShipFactory {

	public static Spaceship createSpaceShip(TypeSpaceship arg, Coordinate base, String name) throws NullPointerException {
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
			throw new NullPointerException("default case on : \n\tSpaceShipFactory.createSpaceShip");
		}
		return spaceship;
	}
}
