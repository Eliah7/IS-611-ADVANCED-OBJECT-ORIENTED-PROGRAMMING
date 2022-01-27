package home.domain;

import java.util.UUID;

public class Member {
    /**
     * Attributes
     */
    private String memberName;
    private String membershipNumber;
    private MonthlyPaymentList monthlyPaymentList;

    /**
     * Constructor
     */
    public Member() {
        this.memberName = "New Member";
        this.membershipNumber =  UUID.randomUUID().toString();
        this.monthlyPaymentList = new MonthlyPaymentList();
    }

    /**
     * Constructor that accept membershipNo as param
     * @param membershipNumber
     */
    public Member(String membershipNumber) {
        this.memberName = "New Member";
        this.membershipNumber = membershipNumber;
        this.monthlyPaymentList = new MonthlyPaymentList();
    }

    /**
     * Constructor that accept membershipNo and the name of the member
     * @param membershipNumber
     * @param name
     */
    public Member(String membershipNumber, String name) {
        this.memberName = name;
        this.membershipNumber = membershipNumber;
        this.monthlyPaymentList = new MonthlyPaymentList();
    }

    /**
     * Constructor that accept membershipNo and paymentList
     * @param membershipNumber
     * @param monthlyPaymentList
     */
    public Member(String membershipNumber, MonthlyPaymentList monthlyPaymentList) {
        this.memberName = "New Member";
        this.membershipNumber = membershipNumber;
        this.monthlyPaymentList = monthlyPaymentList;
    }

    /**
     * Display payment history
     */
    public void displayPaymentHistory(){
       this.monthlyPaymentList.displayPaymentHistory();
    }

    /**
     * Adds payment to the payment List
     * @param payment
     * @return boolean
     */
    public boolean recordPayment(MonthlyPayment payment){
        return this.monthlyPaymentList.add(payment);
    }

    /**
     * Gets Membership Number
     * @return membershipNumber:String
     */
    public String getMembershipNumber() {
        return membershipNumber;
    }

    /**
     * Returns the name of the member
     * @return memberName: String
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * Gets monthly payment List
     * @return
     */
    public MonthlyPaymentList getMonthlyPaymentList() {
        return monthlyPaymentList;
    }

    @Override
    public String toString() {
        return membershipNumber + " --> " + memberName;
    }
}
