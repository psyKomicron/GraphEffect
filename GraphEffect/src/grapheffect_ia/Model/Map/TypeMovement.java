package grapheffect_ia.Model.Map;

/**
*
* @author julie
*/
public enum TypeMovement {
	TOP("Top"), 
	BOTTOM("Bottom"),
	TOP_LEFT("TopLeft"),
	TOP_RIGHT("TopRight"),
	BOTTOM_LEFT("BottomLeft"),
	BOTTOM_RIGHT("BottomRight");
	
	public final String label;
	
	private TypeMovement(String s) {
		label = s;
	}
}
