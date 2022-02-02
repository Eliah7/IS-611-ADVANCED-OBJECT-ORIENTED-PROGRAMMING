package home.domain;
import java.util.ArrayList;


public class MonthlyPaymentList {
    /**
     * attributes
     */
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

    public int getnMAX() {
        return nMAX;
    }



    public ArrayList<MonthlyPayment> getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(ArrayList<MonthlyPayment> monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    /**
     * Adds new payment to the payment list
     * @param payment
     * @return boolean
     */


    public Boolean add(MonthlyPayment payment){
        // check if monthly payment month <= 12 and > 1
//        if(!(Integer.parseInt(payment.getMonth()) >= 1 && Integer.parseInt(payment.getMonth()) <= 12)){
//            return false;
//        }
        // check if monthly payment not in monthlyPayments
        for (MonthlyPayment monthlyPayment: this.monthlyPayments) {
            if(monthlyPayment.getMonth() == payment.getMonth()){
                return false;
            }
        }

        return this.monthlyPayments.add(payment);
    }

    /**
     * Display payment History as String
     */
    public void displayPaymentHistoryAsString(){
        System.out.println(this.toString());
    }

    /**
     * Display payment History
     */
    public void displayPaymentHistory(){
        System.out.println("=== PAYMENT HISTORY === ");

        if(monthlyPayments.size() == 0){
            System.out.println('\t' +"NO PAYMENT FOUND.");
        }
        for (MonthlyPayment monthlyPayment: monthlyPayments) {
            System.out.println('\t' + monthlyPayment.toString());
        }
        System.out.println("=== PAYMENT HISTORY === ");

    }

    @Override
    public String toString() {
        return "MonthlyPaymentList" +
                monthlyPayments +
                ", nMAX=" + nMAX +
                '}';
    }
}
