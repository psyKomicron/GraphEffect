/**
 * 
 */
package pkgsunny;

import java.util.ArrayList;

/**
 * @author julie
 *
 */
public class Resource {

	// see network protocol
    public final static String Empty = "empty";
    public final static String AstField = "asteroid field";
    public final static String Dur = "durantium";
    public final static String Thu = "Thulium";
    public final static String Star = "star";
    public final static String Plan = "planet";
    public final static String Xknown = "unknown";
	
	private String type;
	private Position position;
	
	public Resource(ArrayList<String> map) {
		for(int i = 0; i < map.size(); i++) {
			if(map.get(i).equals(Resource.Dur)) {
				this.type = Resource.Dur;
				this.position = new Position(i);
			}
			if(map.get(i).equals(Resource.AstField)){
				this.type = Resource.AstField;
				this.position = new Position(i);
			}
			if(map.get(i).equals(Resource.Empty)) {
				this.type = Resource.Empty;
				this.position = new Position(i);
			}
			if(map.get(i).equals(Resource.Plan)) {
				this.type = Resource.Plan;
				this.position = new Position(i);
			}
			if(map.get(i).equals(Resource.Star)) {
				this.type = Resource.Star;
				this.position = new Position(i);
			}
			if(map.get(i).equals(Resource.Thu)) {
				this.type = Resource.Thu;
				this.position = new Position(i);
			}
			if(map.get(i).equals(Resource.Xknown)) {
				this.type = Resource.Xknown;
				this.position = new Position(i);
			}
			else {
				type = "null";
				position = new Position(0, 0);
			}
		}
	}
	
}
