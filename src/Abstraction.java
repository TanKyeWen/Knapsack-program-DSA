import java.util.HashMap;
import java.util.Map;

public abstract class Abstraction{
    private Map<String, TripleValues> map;

    public Abstraction(){
        map = new HashMap<>();
    }

    public void put(String key, double value1, double value2) {
        map.put(key, new TripleValues(value1, value2));
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
}

class TripleValues {
    private double value1;
    private double value2;

    public TripleValues(double value1, double value2) {
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