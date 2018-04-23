package idv.sjw.haychata;

import java.util.ArrayList;
import java.util.Date;

public class FourmAdapterItem {
    public String subject;
    public Long lastUpdateDate;
    public String loastUpdateUserNickname;
    public String key;

    FourmAdapterItem(String subject,Long lastUpdateDate,String loastUpdateUserNickname,String key){
        this.subject = subject;
        this.lastUpdateDate = lastUpdateDate;
        this.loastUpdateUserNickname = loastUpdateUserNickname;
        this.key = key;
    }

}
