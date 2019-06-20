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
public class ExplorerSpaceship extends Spaceship {
	private static int _explorerCount;
	// final fields

	public ExplorerSpaceship(Coordinate position, String name, Module_Memory memoryModule) {
		super(position, name, memoryModule, 6, 10, 0, 0, 0);
		_explorerCount++;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.EXPLORER;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetAp() {
		this.setAp(6);
	}
	
	
	@Override
	public int getCount() {
		return _explorerCount;
	}


	@Override
	public void behaviourEvolution() {
		// TODO Auto-generated method stub
		
	}

}
