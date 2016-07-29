package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Card;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class QueryCardResult extends PageResult {

    private List<Card> cardList;

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
