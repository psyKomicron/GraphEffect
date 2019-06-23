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
public class FighterSpaceship extends Spaceship {
	private static int _fighter_count;

	/**
	 * @deprecated
	 * {@inheritDoc}
	 */
	public FighterSpaceship(Coordinate position, String name, Module_Memory memoryModule) {
		super(position, name, memoryModule, -1);
		_fighter_count++;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.FIGHTER;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetAp() {
		throw new UnsupportedOperationException();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCount() {
		return _fighter_count;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void behaviorEvolution() {
	}
}
