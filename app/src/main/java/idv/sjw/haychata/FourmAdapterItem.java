package idv.sjw.haychata;

import java.util.Date;

public class FourmAdapterItem {
    public String subject;
    public String lastUpdateDate;
    public String loastUpdateUserNickname;

    FourmAdapterItem(String subject,String lastUpdateDate,String loastUpdateUserNickname){
        this.subject = subject;
        this.lastUpdateDate = lastUpdateDate;
        this.loastUpdateUserNickname = loastUpdateUserNickname;
    }

}
