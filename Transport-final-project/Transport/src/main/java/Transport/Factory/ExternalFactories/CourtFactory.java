package Transport.Factory.ExternalFactories;

import Transport.Domain.External.Court;

public class CourtFactory {

    public static Court getCourt(String courtName, String fineNum,String judge)
    {
        return new Court.CourtBuilder()
                .courtName(courtName)
                .fineNum(fineNum)
                .judge(judge)
                .build();
    }





}
