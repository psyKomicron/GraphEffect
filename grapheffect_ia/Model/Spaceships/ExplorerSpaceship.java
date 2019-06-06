/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;

/**
 * @author julie
 *
 */
public class ExplorerSpaceship extends Spaceship {
	private static int _explorer_count;

	public ExplorerSpaceship(Coordinate position, String name) {
		super(position, name);
		_explorer_count++;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.EXPLORER;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public void resetAp() {
		this.setAp(6);
	}
	
	
	@Override
	public int getCount() {
		return _explorer_count;
	}

}
