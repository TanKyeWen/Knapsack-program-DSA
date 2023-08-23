import java.util.HashMap;
import java.util.Map;

public class AbstractionTestOnly{
    public static void main(String[] args){
       ConcreteAbstraction ab = new ConcreteAbstraction();
        ab.put("Key1", 10.5, 20.3,20.3);     //inserter
        ab.put("Key2", 15.2, 30.7,20.3); 
        ab.put("Key3", 16.2, 31.7,20.3);
        ab.put("Key4", 18.2, 32.7,20.3);
        ab.put("Key5", 20.2, 36.7,20.3);
        ab.updateValues("Key1", 10.5, 20.3,20.3);  // Update with same values
        ab.updateValues("Key1", 12.0, 22.0,20.3);  // Update with different values/
        ab.deleteLine("Key1");    //inserter
        ab.printMapValues();  //print values
    }
}

class ConcreteAbstraction extends Abstraction {
    // You can add additional methods or fields specific to this subclass if needed
    
    public void put(String key, double value1, double value2,double value3) {
        map.put(key, new TripleValues(value1, value2,value3));
    }

    public void deleteLine(String key) {    //delete the value in the map
        map.remove(key);
    }
}