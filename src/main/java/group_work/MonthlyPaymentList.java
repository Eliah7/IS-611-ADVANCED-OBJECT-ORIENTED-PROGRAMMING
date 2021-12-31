package group_work;

import java.util.ArrayList;

public class MonthlyPaymentList {
    // attributes
    private ArrayList<MonthlyPayment> monthlyPayments;
    private final int nMAX = 12;

    /**
     * Constructor
     * @param monthlyPayments
     */
    public MonthlyPaymentList(ArrayList<MonthlyPayment> monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    /**
     * Constructor
     */
    public MonthlyPaymentList() {
        this.monthlyPayments = new ArrayList<>();
    }

    /**
     *
     * @param payment
     * @return
     */
    public Boolean add(MonthlyPayment payment){
        // check if monthly payment month <= 12 and > 1
        if(!(payment.getMonth() >= 1 && payment.getMonth() <= 12)){
            return false;
        }
        // check if monthly payment not in monthlyPayments
        for (MonthlyPayment monthlyPayment: this.monthlyPayments) {
            if(monthlyPayment.getMonth() == payment.getMonth()){
                return false;
            }
        }

        return this.monthlyPayments.add(payment);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "MonthlyPaymentList" +
                 monthlyPayments +
                ", nMAX=" + nMAX +
                '}';
    }

    /**
     *
     */
    public void displayMonthlyPaymentList(){
        System.out.println(this.toString());
    }

    /**
     *
     */
    public void displayPaymentHistory(){
        System.out.println(this);
        System.out.println("=== PAYMENT HISTORY === ");

        for (MonthlyPayment monthlyPayment: monthlyPayments) {
            System.out.println('\t' + monthlyPayment.toString());
        }
        System.out.println("=== PAYMENT HISTORY === ");

    }
}
