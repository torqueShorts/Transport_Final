package Transport.Domain.External;

public class Court {

    private String courtName;
    private String judge;
    private String fineNum;

    private Court()
    {

    }

    private Court(CourtBuilder builder)
    {
        this.courtName = builder.courtName;
        this.judge = builder.judge;
        this.fineNum = builder.fineNum;
    }

    public String getCourtName()
    {
        return courtName;
    }

    public String getJudge()
    {
        return judge;
    }

    public String getFineNum()
    {
        return fineNum;
    }

    public static class CourtBuilder
    {
        private String courtName;
        private String judge;
        private String fineNum;

        public CourtBuilder courtName(String courtName)
        {
            this.courtName = courtName;
            return this;
        }

        public CourtBuilder judge(String judge)
        {
            this.judge = judge;
            return this;
        }

        public CourtBuilder fineNum(String fineNum)
        {
            this.fineNum = fineNum;
            return this;
        }


        public Court build()
        {
            return new Court(this);
        }


    }

    @Override

    public String toString() {
        return "Court: \n Court name: " + courtName + "\n Judge name: " + judge + "\n fine Number: " + fineNum;
    }




}
