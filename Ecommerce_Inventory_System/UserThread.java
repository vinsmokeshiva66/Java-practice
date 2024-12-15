public class UserThread extends Thread {
    private DatabaseManager dbManager;
    private int productId;
    private int quantity;

    public UserThread(DatabaseManager dbManager, int productId, int quantity) {
        this.dbManager = dbManager;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        try {
            dbManager.purchaseProduct(productId, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
