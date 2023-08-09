import java.util.Map;
import java.util.HashMap;

public class map {
    private Map<String, Double, Double> myPrivateMap; //private instance of  map
    

    public map() {
        myPrivateMap = new HashMap<>(); //constructor
    }

    public Map<String, Double, Double> getMyPrivateMap() { //getter
        return myPrivateMap;
    }

    public void setMyPrivateMap(Map<String, Double, Double> myPrivateMap) { //setter
        this.myPrivateMap = myPrivateMap;
    }

    public void addToMap(String key, Double weight, Double value) { //add to map
        myPrivateMap.put(key, weight, value);
    }

    public void printMapContents(){ //print map contents
        System.out.println(myPrivateMap);
    }
}
