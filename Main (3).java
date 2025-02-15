import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. add product");
            System.out.println("2. remove product");
            System.out.println("3. update product");
            System.out.println("4. search product");
            System.out.println("5. list products");
            System.out.println("6.filter by price");
            System.out.println("7. exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("product name: ");
                    String name = scanner.nextLine();
                    System.out.println("product price: ");
                    int price = scanner.nextInt();
                    System.out.println("product description: ");
                    scanner.nextLine(); 
                    String description = scanner.nextLine();
                    System.out.println("product quantity: ");
                    int quantity = scanner.nextInt();
                    add(name, price, description, quantity);
                    break;

                case 2:
                    // Implement remove functionality 
                    System.out.println("enter product id or name: ");
                    if (scanner.hasNextInt()){
                        int productId = scanner.nextInt();
                        removeProduct(productId);
                    }
                    else{
                        String productName = scanner.nextLine();
                        removeProduct(productName);
                    }
                    
                    
                    
                    break;
// Implement update functionality 
                case 3:
                    
                     System.out.println("Enter product ID to update: ");
                    int productId = scanner.nextInt();
                    System.out.println("Choose field to update: 1. Price 2. Quantity");
                    int updateChoice = scanner.nextInt();
                    if (updateChoice == 1) {
                        System.out.println("Enter new price: ");
                        int newPrice = scanner.nextInt();
                        updateProductPrice(productId, newPrice);
                    } else if (updateChoice == 2) {
                        System.out.println("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        updateProductQuantity(productId, newQuantity);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                    
                    
// search product 
                case 4:
                    System.out.println("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    searchProduct(searchName);
                    break;
// show the list of items 
                case 5:
                    printList();
                    break;

              //Filter by pricing      
                    case 6:
                    {
                        System.out.println("enter the range of price: ");
                        int maxPrice= scanner.nextInt();
                        filterProduct(maxPrice);
                        break;
                    }

                case 7:
                    return;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    private static void printList() {
        for (Product product : listOfProducts) {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: " + product.getProductPrice());
            System.out.println("Description: " + product.getProductDescription());
            System.out.println("Quantity: " + product.getProductQuantity());
            System.out.println("---------------------------");
        }
    }

    public static void add(String name, int price, String description, int quantity) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size() + 1);
        listOfProducts.add(product);
    }
            // Implement remove functionality h
    public static void removeProduct(int id) {
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getProductId() == id) {
                listOfProducts.remove(i);
                break;
            }
        }

    }
    
    public static void removeProduct(String name) {
         for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getProductName().equalsIgnoreCase(name)) {
                listOfProducts.remove(i);
                break;
            }
        }
    }
    public static void searchProduct(String name) {
        boolean found = false;
        for (Product product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                System.out.println("ID: " + product.getProductId());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Price: " + product.getProductPrice());
                System.out.println("Description: " + product.getProductDescription());
                System.out.println("Quantity: " + product.getProductQuantity());
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with the name: " + name);
        }
    }

    
    
        // Implement update functionality 
    public static void updateProductPrice(int id, int newPrice) {
        for (Product product : listOfProducts) {
            if (product.getProductId() == id) {
                product.setProductPrice(newPrice);
                System.out.println("Product price updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }
    
    public static void updateProductQuantity(int id, int newQuantity) {
        for (Product product : listOfProducts) {
            if (product.getProductId() == id) {
                product.setProductQuantity(newQuantity);
                System.out.println("Product quantity updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }
    public static void filterProduct(int maxPrice) {
        boolean found = false;
        for (Product product : listOfProducts) {
            if (product.getProductPrice() <= maxPrice) {
                System.out.println("ID: " + product.getProductId());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Price: " + product.getProductPrice());
                System.out.println("Description: " + product.getProductDescription());
                System.out.println("Quantity: " + product.getProductQuantity());
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found under the price: " + maxPrice);
        }
    }
    
}




