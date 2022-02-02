package home.domain;
public class MonthlyPayment {
    /**
     * attributes
     */
    private Double amount;
    private String month;

    /**
     * Constructor
     * @param amount
     * @param month
     */
    MonthlyPayment(){

    }

    public MonthlyPayment(Double amount, String month)  {

            this.amount = amount;
            this.month = month;

    }

    public MonthlyPayment(Double amount, int month)  {

        this.amount = amount;
        this.month = Integer.toString(month);

    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Returns amount
     * @return
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Returns month of payment
     * @return
     */
    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "MonthlyPayment:  " +
                "AMOUNT=" + amount +
                ", MONTH=" + month +
                ' ';
    }
}
