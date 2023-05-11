package Finance;

import StockAandOrders.* ;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;

public class Cash extends PaymentMethod {
    private String paymentID;

    public Cash(Order order, String paymentID) {
        super(order);
        this.paymentID = paymentID;
    }

    public void verifyPayment() {
        System.out.println("Payment verified for order " + order.getOrderID() + " using cash.");
    }
}

