/**
 * 
 */
package pkgsunny;

import java.util.ArrayList;

/**
 *
 * @author julie
 */
public class Map {
    
	private final int lenght = 41;
	private final int width = 55;
	
    private ArrayList<String> map;
    private ArrayList<Resource> resources;    
    
    public Map() {
    	map = new ArrayList<>();
    	resources = new ArrayList<>();
    }
    
    
    /**
     * Construct the map and the resource map from a string
     * @param s server answer to MAP command
     */
    public void addMap(String s) {
    	char[] list = s.toCharArray();
        for(char hexa : list) {
            map.add(Character.toString(hexa));
        }
        
        // processing the String map to a Resource map
        for(String str : map) {
        	resources.add(new Resource(map));
        }
    }
    
    
    /**
     * Rebuild the server's response to MAP command (testing purposes) with the right values of the String (X = unknown slot)
     */
    @Override
    public String toString() {
    	String str = "";
    	int i = 0;
    	
    	for(String s : map) {
    		if(i > 20) {
    			str += "\n";
    			i = 0;
    		}
    		if(s.equals("E")) {
    			str += Resource.Empty;
    		}
    		if(s.equals("A")) {
    			str += Resource.AstField;
    		}
    		if(s.equals("D")) {
    			str += Resource.Dur;
    		}
    		if(s.equals("T")) {
    			str += Resource.Thu;
    		}
    		if(s.equals("S")) {
    			str += Resource.Star;
    		}
    		if(s.equals("P")) {
    			str += Resource.Plan;
    		}
    		if(s.equals("X")) {
    			str += Resource.Xknown;
    		}
    		str += " | ";
    		i++;
    	}
    	
    	return str;
    }
     
}
