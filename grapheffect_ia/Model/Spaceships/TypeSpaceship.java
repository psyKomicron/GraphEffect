package grapheffect_ia.Model.Spaceships;

/**
 * 
 */

/**
 * @author julie
 *
 */
public enum TypeSpaceship {
	EXPLORER("Explorer"), 
	CONSTRUCTOR("Constructor"),
	TRANSPORTER("Transporter"),
	FIGHTER("Fighter");
	
	public final String label;
	
	private TypeSpaceship(String s) {
		this.label = s;
	}
}
