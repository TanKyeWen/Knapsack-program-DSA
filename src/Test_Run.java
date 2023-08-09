import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Test_Run {
    public static void main(String[] args) {
    	ArrayList<Product> productList = new ArrayList<>();
    	productList = read(); // read file
    	
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to add");
        System.out.println("Press 2 to search");
        System.out.println("Press 3 to update");
        System.out.println("Press 4 to delete");
        System.out.print("Enter input: ");
        String enter = input.next();
        
        if(enter.equals("1")) {
        	String product;
        	Double weight,value;
        	System.out.println("Enter Product name: ");
        	product = input.next();
        	System.out.println("Enter Product weight: ");
        	weight = input.nextDouble();
        	System.out.println("Enter Product value: ");
        	value = input.nextDouble();
        	Product nProduct = new Product(product,weight,value);
        	productList.add(nProduct);
        	
        	saveFile(productList); // Update file
        }
        
        else if(enter.equals("2")) { //search
        	System.out.println("Enter name of product: ");
        	String search = input.next();
        	
        	boolean productFound = false;
        	for (Product product : productList) { // Test using arrayList
                if (product.getName().equalsIgnoreCase(search)) {
                    System.out.println("Product: " + product.getName());
                    System.out.println("Weight: " + product.getWeight());
                    System.out.println("Price: " + product.getPrice());
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Product not found.");
            }
        }
        
        else if(enter.equals("3")){
        	
        }
        input.close();
    }
    
    public static ArrayList<Product> read(){// read text file and return arrayList
    	String filePath = "C:\\Users\\Lee\\eclipse-workspace\\PSDSA\\src\\Test\\Sample.txt";

        ArrayList<Product> List = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String name = parts[0];
                    double weight = Double.parseDouble(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    Product product = new Product(name, weight, price);
                    List.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List;
    }
    
    public static void saveFile(ArrayList<Product> productList) { // write text file
        String filePath = "C:\\Users\\Lee\\eclipse-workspace\\PSDSA\\src\\Test\\Sample.txt"; // Update this with the desired output file path

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : productList) {
                String line = product.getName() + " " + product.getWeight() + " " + product.getPrice();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("ArrayList saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error, update failed.");
        }
    }
}
