package Customer;
import StockAandOrders.* ;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;
public class User {
    private String name;
    private String email;
    private String password;
    private Address address;
    private String status;
    private int loyaltyPoints;
    private String PhoneNumber;
    private String ID;
    private ArrayList<Voucher> vouchers =  new ArrayList<Voucher>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(ArrayList<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public void addVoucher(Voucher voucher) {
        vouchers.add(voucher);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public void buyVouchers(Voucher voucher  , User  user)
    {
        user.getVouchers().add(voucher);
        System.out.println("Congratulations! You have successfully bought a voucher worth " + voucher.getMoney() + " points.");
    }

    public int redeemVoucher(Voucher voucher) {
        if (voucher == null) {
            System.out.println("Invalid voucher.");
            return 0;
        }

        if (!vouchers.contains(voucher)) {
            System.out.println("You do not own this voucher.");
            return 0;
        }

        System.out.println("Congratulations! You have successfully redeemed a voucher worth " + voucher.getMoney() );
        vouchers.remove((voucher));
        return voucher.getMoney();
    }


    public void showOrderHistory() {
        System.out.println("This is all your orders");
        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println();
        }
    }

    public void reOrder(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to re-order this order? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            ShoppingCart cart = order.getCart();
            // Create a new order with the same items as the original order
            Order newOrder = new Order();
            newOrder.setCart(cart);
            saveOrder(newOrder);
            System.out.println("Your order has been placed successfully.");
        } else {
            System.out.println("Okay, order not re-ordered.");
        }
    }

    public void showProfile(User user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Address: " + user.getAddress().toString());
        System.out.println("Phone: " + user.getPhoneNumber());
        System.out.println("Loyalty points: " + user.getLoyaltyPoints());
    }
}
