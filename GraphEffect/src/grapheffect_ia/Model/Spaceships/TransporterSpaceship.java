/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;

/**
 * @author julie
 *
 */
public class TransporterSpaceship extends Spaceship{
	private static int _transporter_count;

	public TransporterSpaceship(Coordinate position, String name) {
		super(position, name);
		_transporter_count++;
	}

	
	/**
	 * @see Spaceship
	 */
	@Override
	public TypeSpaceship getType() {
		return TypeSpaceship.TRANSPORTER;
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
		return _transporter_count;
	}

}
