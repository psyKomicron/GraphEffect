/**
 * 
 */
package grapheffect_ia.Model.Spaceships.Coefficient;

/**
 * @author julie
 * Class used to store the decision "flavors" of ships. 
 * Will be changed to a read/write file class (.xml). 
 */
public class AffinityCoeff {

	private int _buildCoeff;
	private int _fightCoeff;
	private int _transportCoeff;
	private int _exploreCoeff;
	
	public AffinityCoeff(int build, int fight, int transport, int explore) {
		_buildCoeff = build;
		_fightCoeff = fight;
		_transportCoeff = transport;
		_exploreCoeff = explore;
	}
	
	/********************************************************
	 * 
	 * 					GETTERS/SETTERS
	 * 
	 ********************************************************/
	
	public int getBuildCoeff() {
		return _buildCoeff;
	}

	public void setBuildCoeff(int _buildCoeff) {
		this._buildCoeff = _buildCoeff;
	}

	public int getFightCoeff() {
		return _fightCoeff;
	}

	public void setFightCoeff(int _fightCoeff) {
		this._fightCoeff = _fightCoeff;
	}

	public int getTransportCoeff() {
		return _transportCoeff;
	}

	public void setTransportCoeff(int _transportCoeff) {
		this._transportCoeff = _transportCoeff;
	}

	public int getExploreCoeff() {
		return _exploreCoeff;
	}

	public void setExploreCoeff(int _exploreCoeff) {
		this._exploreCoeff = _exploreCoeff;
	}
}
