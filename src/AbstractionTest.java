public class AbstractionTest {
    public static void main(String[] args) {
        Abstraction itemMap = new Abstraction(){};

        System.out.println(itemMap.searchItem(2.5, 10.0));
        System.out.println(itemMap.searchItem(1.0, 6.0));

        System.out.println(itemMap.deleteItem(2.5, 10.0));
        System.out.println(itemMap.deleteItem(1.0, 5.0));

        itemMap.addToMap(2.0, 8.0);
        itemMap.addToMap(3.5, 15.0);

        itemMap.printItems();
    }
}
