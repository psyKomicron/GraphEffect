/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;

/**
 * @author julie
 *
 */
public class FighterSpaceship extends Spaceship {
	private static int _fighter_count;

	public FighterSpaceship(Coordinate position, String name) {
		super(position, name);
		_fighter_count++;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.FIGHTER;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public void resetAp() {
		throw new UnsupportedOperationException();
	}


	@Override
	public int getCount() {
		return _fighter_count;
	}
}
