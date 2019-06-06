/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;

/**
 * @author julie
 *
 */
public class ConstructorSpaceship extends Spaceship {
	private static int _constructor_count;

	public ConstructorSpaceship(Coordinate position, String name) {
		super(position, name);
		_constructor_count++;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.CONSTRUCTOR;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public void resetAp() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


	@Override
	public int getCount() {
		return _constructor_count;
	}

}
