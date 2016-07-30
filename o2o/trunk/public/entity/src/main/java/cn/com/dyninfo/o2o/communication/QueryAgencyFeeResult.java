package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.AgencyFeeItem;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class QueryAgencyFeeResult extends PageResult {

    //总资产
    private double currentMoney;
    //最近佣金
    private double recentMoney;
    //累计佣金
    private double totalMoney;
    //数据截至时间
    private String dataDate;
    //佣金明细
    private List<AgencyFeeItem> agencyFeeItemList;

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public double getRecentMoney() {
        return recentMoney;
    }

    public void setRecentMoney(double recentMoney) {
        this.recentMoney = recentMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public List<AgencyFeeItem> getAgencyFeeItemList() {
        return agencyFeeItemList;
    }

    public void setAgencyFeeItemList(List<AgencyFeeItem> agencyFeeItemList) {
        this.agencyFeeItemList = agencyFeeItemList;
    }

    @Override
    public String toString() {
        return "QueryAgencyFeeResult{" +
                "currentMoney=" + currentMoney +
                ", recentMoney=" + recentMoney +
                ", totalMoney=" + totalMoney +
                ", dataDate='" + dataDate + '\'' +
                ", agencyFeeItemList=" + agencyFeeItemList +
                '}';
    }
}
