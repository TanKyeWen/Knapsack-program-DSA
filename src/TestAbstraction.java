public class TestAbstraction {
    public static void main(String[] args) {
        Abstraction abstraction = new Abstraction() {};

        abstraction.addToMap("ItemA", 2.5, 10.0);
        abstraction.addToMap("ItemB", 5.0, 20.0);

        abstraction.printItems();

        System.out.println("Map size: " + abstraction.mapSize());

        System.out.println(abstraction.searchItem("ItemA", 2.5, 10.0));
        System.out.println(abstraction.searchItem("ItemB", 5.0, 20.0));
        System.out.println(abstraction.searchItem("ItemC", 3.0, 15.0));

        System.out.println(abstraction.deleteItem("ItemA", 2.5, 10.0));
        System.out.println(abstraction.deleteItem("ItemB", 5.0, 15.0));

        abstraction.printItems();

        System.out.println("Map size: " + abstraction.mapSize());
    }
}



