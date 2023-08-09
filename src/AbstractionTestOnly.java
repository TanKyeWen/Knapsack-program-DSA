public class AbstractionTestOnly{
    public static void main(String[] args){
       ConcreteAbstraction ab = new ConcreteAbstraction();
        ab.put("Key1", 10.5, 20.3); //inserter
        ab.put("Key2", 15.2, 30.7); //inserter
        ab.printMapValues();  //print values
    }
}

class ConcreteAbstraction extends Abstraction {
    // You can add additional methods or fields specific to this subclass if needed
}