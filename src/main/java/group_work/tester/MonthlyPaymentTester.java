package group_work.tester;

import group_work.MonthlyPayment;

public class MonthlyPaymentTester {
    public static void main(String[] args) {
        MonthlyPayment monthlyPayment = null;
        try {
            monthlyPayment = new MonthlyPayment(200000.0,1);
            System.out.println("Month:" + monthlyPayment.getMonth());
            System.out.println("Amount:" + monthlyPayment.getAmount());
            System.out.println("Amount:" + monthlyPayment);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
