package group_work;

import java.util.UUID;

public class Member {
    // attributes
    private String membershipNumber;
    private MonthlyPaymentList monthlyPaymentList;

    /**
     * Constructor
     */
    public Member() {
        this.membershipNumber =  UUID.randomUUID().toString();
        this.monthlyPaymentList = new MonthlyPaymentList();
    }

    /**
     *
     * @param membershipNumber
     */
    public Member(String membershipNumber) {
        this.membershipNumber = membershipNumber;
        this.monthlyPaymentList = new MonthlyPaymentList();
    }

    /**
     *
     * @param membershipNumber
     * @param monthlyPaymentList
     */
    public Member(String membershipNumber, MonthlyPaymentList monthlyPaymentList) {
        this.membershipNumber = membershipNumber;
        this.monthlyPaymentList = monthlyPaymentList;
    }

    /**
     *
     */
    public void displayPaymentHistory(){
       this.monthlyPaymentList.displayPaymentHistory();
    }

    /**
     *
     * @param payment
     * @return
     */
    public boolean recordPayment(MonthlyPayment payment){
        return this.monthlyPaymentList.add(payment);
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public MonthlyPaymentList getMonthlyPaymentList() {
        return monthlyPaymentList;
    }

    @Override
    public String toString() {
        return membershipNumber;
    }
}
