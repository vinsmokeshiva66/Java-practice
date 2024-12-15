public class Client {
    public static void main(String args[]){
        User user1=new User("Shiva");
        user1.register_user("shiva");
        user1.getWallet().add_money(user1, 100);
        user1.getWallet().withdraw(user1, 30);
        user1.getWallet().check_balance(user1);
    }
}
