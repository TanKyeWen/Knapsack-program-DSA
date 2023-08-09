import java.util.Map;
import java.util.HashMap;

public class map {
    private Map<String, Integer> myPrivateMap; //private instance of  map
    

    public map() {
        myPrivateMap = new HashMap<>(); //constructor
    }

    public Map<String, Integer> getMyPrivateMap() { //getter
        return myPrivateMap;
    }

    public void setMyPrivateMap(Map<String, Integer> myPrivateMap) { //setter
        this.myPrivateMap = myPrivateMap;
    }

    public void addToMap(String key, Integer value) { //add to map
        myPrivateMap.put(key, value);
    }

    public void printMapContents(){ //print map contents
        System.out.println(myPrivateMap);
    }
}
