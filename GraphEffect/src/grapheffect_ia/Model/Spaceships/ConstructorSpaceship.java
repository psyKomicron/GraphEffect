/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Modules.Module_Memory;

/**
 * @author julie
 *
 */
public class ConstructorSpaceship extends Spaceship {
	private static int _constructor_count;

	public ConstructorSpaceship(Coordinate position, String name, Module_Memory memoryModule) {
		super(position, name, memoryModule);
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
