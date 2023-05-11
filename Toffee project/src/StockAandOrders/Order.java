package StockAandOrders;
import Customer.* ;
import java.util.Scanner;
import java.lang.System;
import  Finance.*;

    public class Order {
        private double totalPrice;
        private ShoppingCart cart;
        private String dateCheckout;
        private Address shippingAddress;
        private PaymentMethod payment;
        private String orderID;
        private User user;

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public ShoppingCart getCart() {
            return cart;
        }

        public void setCart(ShoppingCart cart) {
            this.cart = cart;
        }

        public String getDateCheckout() {
            return dateCheckout;
        }

        public void setDateCheckout(String dateCheckout) {
            this.dateCheckout = dateCheckout;
        }

        public Address getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public PaymentMethod getPaymentMethod() {
            return payment;
        }

        public void setPaymentMethod(PaymentMethod payment) {
            this.payment = payment;
        }

        public String getOrderID() {
            return orderID;
        }

        public void setOrderID(String orderID) {
            this.orderID = orderID;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void chooseNewAddress(Address address) {
            shippingAddress = address;
        }


        public void deleteOrder(Order order) {
            if (order != null) {
                // remove the order from the user's order list
                User user = order.getUser();
                if (user != null) {
                    user.getOrders().remove(order);
                }

                // clear the order's cart
                ShoppingCart cart = order.getCart();
                if (cart != null) {
                    cart.deleteCart();
                }

                // set the order's user and cart to null
                order.setUser(null);
                order.setCart(null);
            }
        }

        public void useLoyaltyPoints(int points) {
            if(user.getLoyaltyPoints() > points){
                totalPrice -= points;
                user.setLoyaltyPoints(user.getLoyaltyPoints() - points);
            }
            else{
                System.out.println("not enough Loyalty Points");
            }
        }



        public void showOrderDetails() {
            System.out.println("Order ID: " + orderID);
            System.out.println("User: " + user.getName());
            System.out.println("Shipping Address: " + shippingAddress.toString());
            System.out.println("Payment Method: " + payment.toString());
            System.out.println("Date Checkout: " + dateCheckout);
            System.out.println("Total Price: " + totalPrice);
            System.out.println("Items in Cart:");
            cart.showCart();
        }
    }




