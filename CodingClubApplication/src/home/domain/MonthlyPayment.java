package home.domain;
public class MonthlyPayment {
    /**
     * attributes
     */
    private Double amount;
    private int month;

    /**
     * Constructor
     * @param amount
     * @param month
     */
    public MonthlyPayment(Double amount, int month)  {

            this.amount = amount;
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
    public int getMonth() {
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
