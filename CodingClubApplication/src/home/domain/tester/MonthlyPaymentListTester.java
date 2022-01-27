package home.domain.tester;

import home.domain.MonthlyPayment;
import home.domain.MonthlyPaymentList;

public class MonthlyPaymentListTester {
    public static void main(String[] args) {
        MonthlyPaymentList monthlyPaymentList = new MonthlyPaymentList();
        MonthlyPayment monthlyPayment = new MonthlyPayment(2000.0,1);
        monthlyPaymentList.add(monthlyPayment);
        System.out.println(monthlyPaymentList);
        monthlyPaymentList.displayPaymentHistory();
    }
}
