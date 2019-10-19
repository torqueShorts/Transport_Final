package Transport.Domain.External;

public class Verdict {

    private String fineNum;
    private boolean reason;
    private int reducedAmount;
    private boolean warrant;

    private Verdict()
    {

    }

    private Verdict(VerdictBuilder builder)
    {
        this.fineNum = builder.fineNum;
        this.reason = builder.reason;
        this.reducedAmount = builder.reducedAmount;
        this.warrant = builder.warrant;
    }

    public String getFineNum(){ return fineNum; }

    public boolean getReason()
    {
        return reason;
    }

    public int getReducedAmount()
    {
        return reducedAmount;
    }

    public boolean getWarrant()
    {
        return warrant;
    }

    public static class VerdictBuilder
    {
        private String fineNum;
        private boolean reason;
        private int reducedAmount;
        private boolean warrant;

        public VerdictBuilder fineNum(String fineNum)
        {
            this.fineNum = fineNum;
            return this;
        }


        public VerdictBuilder reason(boolean reason)
        {
            this.reason = reason;
            return this;
        }

        public VerdictBuilder reducedAmount(int reducedAmount)
        {
            this.reducedAmount = reducedAmount;
            return this;
        }

        public VerdictBuilder warrant(boolean warrant)
        {
            this.warrant = warrant;
            return this;
        }


        public Verdict build()
        {
            return new Verdict(this);
        }


    }

    public String toString()
    {
        return "Trial: \nFine number: " + fineNum + "\nReason valid: " + reason + "\nReduced amount: " + reducedAmount + "\nWarrant: " + warrant;
    }


}
