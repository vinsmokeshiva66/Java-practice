import java.util.Scanner;

public class ECommerceSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DatabaseManager dbManager = new DatabaseManager();

            while (true) {
                System.out.println("\nE-Commerce System Menu:");
                System.out.println("1. Add Product");
                System.out.println("2. View Products");
                System.out.println("3. Purchase Product");
                System.out.println("4. Simulate Concurrent Purchases");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.next();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter product stock: ");
                        int stock = scanner.nextInt();
                        dbManager.addProduct(name, price, stock);
                        break;
                    case 2:
                        dbManager.viewProducts();
                        break;
                    case 3:
                        System.out.print("Enter product ID: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        dbManager.purchaseProduct(productId, quantity);
                        break;
                    case 4:
                        System.out.print("Enter product ID for simulation: ");
                        int simProductId = scanner.nextInt();
                        System.out.print("Enter quantity per user: ");
                        int simQuantity = scanner.nextInt();

                        Thread user1 = new UserThread(dbManager, simProductId, simQuantity);
                        Thread user2 = new UserThread(dbManager, simProductId, simQuantity);

                        user1.start();
                        user2.start();

                        user1.join();
                        user2.join();
                        break;
                    case 5:
                        System.out.println("Exiting system.");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
