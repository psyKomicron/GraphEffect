/**
 * 
 */
package grapheffect_ia.Model.Spaceships;

import grapheffect_ia.Model.Map.Coordinate;
import grapheffect_ia.Model.Spaceships.Coefficient.AffinityCoeff;
import grapheffect_ia.Modules.Module_Memory;

/**
 * @author julie
 *
 */
public class ExplorerSpaceship extends Spaceship {
	private static int _explorerCount;

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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCount() {
		return _explorerCount;
	}

	/**
	 * {@inheritDoc}
	 * <p>coeff stands for : {@linkplain Spaceship#getCoeffs()} and percent for {@linkplain grapheffect_ia.Model.Map.Map#getPercentExploredFloat} 
	 *  <ul>
	 *   <li>if percent inferior to 0.25 it stays to 10 (base value)</li>
	 * 	 <li>if percent superior to 0.25 and inferior to 50 : coeff = 5 </li>
	 * 	 <li>if percent superior to 0.25 and inferior to 0.75 : coeff = 7</li>
	 * 	 <li>if percent superior to 0.25 and superior to 0.75 : coeff = 10</li>
	 * </ul>
	 */
	@Override
	public void behaviourEvolution() {
		AffinityCoeff coeff = getCoeffs();
		float percent = this.getMemoryModule().getMap().getPercentExploredFloat();
		if (percent > 0.25) {
			if (percent > 0.50) {
				if (percent < 0.75) 
					coeff.setExploCoeff(10);
				else
					coeff.setExploCoeff(7);
			}
			else {
				coeff.setExploCoeff(5);
			}
		}
	}

}
