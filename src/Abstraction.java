import java.util.HashMap;
import java.util.Map;


public abstract class Abstraction implements Interface{
    protected Map<String, TripleValues> map;  //private instance for Map

    public Abstraction(){                   //constructor for Map
        map = new HashMap<>();
    }

    public double getValue1(String key) {
        TripleValues tripleValues = map.get(key);
        if (tripleValues != null) {
            return tripleValues.getValue1();
        }
        throw new IllegalArgumentException("Key not found: " + key);
    }

    public double getValue2(String key) {
        TripleValues tripleValues = map.get(key);
        if (tripleValues != null) {
            return tripleValues.getValue2();
        }
        throw new IllegalArgumentException("Key not found: " + key);
    }

    public void printMapValues() {
        System.out.println("Map values:");
        for (Map.Entry<String, TripleValues> entry : map.entrySet()) {
            String key = entry.getKey();
            TripleValues values = entry.getValue();
            System.out.println("Key: " + key + ", Value 1: " + values.getValue1() + ", Value 2: " + values.getValue2());
        }
    }


    public void updateValues(String key, double newValue1, double newValue2) {      //update the value in the map
        if (map.containsKey(key)) {
            TripleValues existingValues = map.get(key);
            if (existingValues.getValue1() == newValue1 && existingValues.getValue2() == newValue2) {
                System.out.println("Error: Values are the same. No update performed.");
            } else {
                map.put(key, new TripleValues(newValue1, newValue2));
                System.out.println("Values updated successfully.");
            }
        } else {
            System.out.println("Key not found: " + key);
        }
    }

   public abstract void put(String key, double value1, double value2);

   public abstract void deleteLine(String key);    //delete the value in the map

}

class TripleValues {                // triple values class
    private double value1;          // private instance for value 1
    private double value2;          // private instance for value 2

    public TripleValues(double value1, double value2) {             //constructor 
        this.value1 = value1;
        this.value2 = value2;
    }

    public double getValue1() {     
        return value1;
    }

    public double getValue2() {
        return value2;
    }

}