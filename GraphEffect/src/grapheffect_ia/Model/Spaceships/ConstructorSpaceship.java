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
		super(position, name, memoryModule, 3, 0, 10, 0, 0);
		_constructor_count++;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.CONSTRUCTOR;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetAp() {
		setAp(3);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCount() {
		return _constructor_count;
	}

	/**
	 * {@inheritDoc}
	 * need to define the behavior of a constructor, and then it's evolution
	 */
	public void behaviourEvolution() {
	}

}
