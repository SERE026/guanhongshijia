package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

/**
 * 银行卡
 */
public class Card extends BaseEntity {
    //银行卡号
    private String cardNo;
    //发卡行
    private String bankName;
    //状态
    private String status;
    //类型
    private String type;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNo='" + cardNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
