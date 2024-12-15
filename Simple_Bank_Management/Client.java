public class Client {
    public static void main(String[] args) {
        Bank bank = new Bank();
        String accountNumber = bank.createAccount("John Doe");
        
        bank.depositToAccount(accountNumber, 500);
        bank.withdrawFromAccount(accountNumber, 200);
        bank.checkBalance(accountNumber);
    }
}
