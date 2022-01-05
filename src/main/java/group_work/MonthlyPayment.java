package group_work;

public class MonthlyPayment {
    // attributes
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
     *
     * @return
     */
    public Double getAmount() {
        return amount;
    }

    /**
     *
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
