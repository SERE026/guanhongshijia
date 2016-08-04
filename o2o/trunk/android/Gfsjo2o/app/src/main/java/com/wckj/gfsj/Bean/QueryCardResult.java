package com.wckj.gfsj.Bean;


import com.wckj.gfsj.Bean.Base.PageResult;
import com.wckj.gfsj.Bean.entity.Card;

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

    @Override
    public String toString() {
        return "QueryCardResult{" +
                "cardList=" + cardList +
                '}';
    }
}
