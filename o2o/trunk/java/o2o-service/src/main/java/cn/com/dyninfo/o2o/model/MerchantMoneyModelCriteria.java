package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantMoneyModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public MerchantMoneyModelCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBrankCardIsNull() {
            addCriterion("BRANK_CARD is null");
            return (Criteria) this;
        }

        public Criteria andBrankCardIsNotNull() {
            addCriterion("BRANK_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andBrankCardEqualTo(String value) {
            addCriterion("BRANK_CARD =", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardNotEqualTo(String value) {
            addCriterion("BRANK_CARD <>", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardGreaterThan(String value) {
            addCriterion("BRANK_CARD >", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardGreaterThanOrEqualTo(String value) {
            addCriterion("BRANK_CARD >=", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardLessThan(String value) {
            addCriterion("BRANK_CARD <", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardLessThanOrEqualTo(String value) {
            addCriterion("BRANK_CARD <=", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardLike(String value) {
            addCriterion("BRANK_CARD like", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardNotLike(String value) {
            addCriterion("BRANK_CARD not like", value, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardIn(List<String> values) {
            addCriterion("BRANK_CARD in", values, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardNotIn(List<String> values) {
            addCriterion("BRANK_CARD not in", values, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardBetween(String value1, String value2) {
            addCriterion("BRANK_CARD between", value1, value2, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankCardNotBetween(String value1, String value2) {
            addCriterion("BRANK_CARD not between", value1, value2, "brankCard");
            return (Criteria) this;
        }

        public Criteria andBrankNameIsNull() {
            addCriterion("BRANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBrankNameIsNotNull() {
            addCriterion("BRANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrankNameEqualTo(String value) {
            addCriterion("BRANK_NAME =", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameNotEqualTo(String value) {
            addCriterion("BRANK_NAME <>", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameGreaterThan(String value) {
            addCriterion("BRANK_NAME >", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRANK_NAME >=", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameLessThan(String value) {
            addCriterion("BRANK_NAME <", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameLessThanOrEqualTo(String value) {
            addCriterion("BRANK_NAME <=", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameLike(String value) {
            addCriterion("BRANK_NAME like", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameNotLike(String value) {
            addCriterion("BRANK_NAME not like", value, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameIn(List<String> values) {
            addCriterion("BRANK_NAME in", values, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameNotIn(List<String> values) {
            addCriterion("BRANK_NAME not in", values, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameBetween(String value1, String value2) {
            addCriterion("BRANK_NAME between", value1, value2, "brankName");
            return (Criteria) this;
        }

        public Criteria andBrankNameNotBetween(String value1, String value2) {
            addCriterion("BRANK_NAME not between", value1, value2, "brankName");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andPsIsNull() {
            addCriterion("PS is null");
            return (Criteria) this;
        }

        public Criteria andPsIsNotNull() {
            addCriterion("PS is not null");
            return (Criteria) this;
        }

        public Criteria andPsEqualTo(String value) {
            addCriterion("PS =", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotEqualTo(String value) {
            addCriterion("PS <>", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThan(String value) {
            addCriterion("PS >", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThanOrEqualTo(String value) {
            addCriterion("PS >=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThan(String value) {
            addCriterion("PS <", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThanOrEqualTo(String value) {
            addCriterion("PS <=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLike(String value) {
            addCriterion("PS like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotLike(String value) {
            addCriterion("PS not like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsIn(List<String> values) {
            addCriterion("PS in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotIn(List<String> values) {
            addCriterion("PS not in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsBetween(String value1, String value2) {
            addCriterion("PS between", value1, value2, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotBetween(String value1, String value2) {
            addCriterion("PS not between", value1, value2, "ps");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdIsNull() {
            addCriterion("HUIYUAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdIsNotNull() {
            addCriterion("HUIYUAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID =", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID <>", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdGreaterThan(Integer value) {
            addCriterion("HUIYUAN_ID >", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID >=", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLessThan(Integer value) {
            addCriterion("HUIYUAN_ID <", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLessThanOrEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID <=", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdIn(List<Integer> values) {
            addCriterion("HUIYUAN_ID in", values, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotIn(List<Integer> values) {
            addCriterion("HUIYUAN_ID not in", values, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdBetween(Integer value1, Integer value2) {
            addCriterion("HUIYUAN_ID between", value1, value2, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HUIYUAN_ID not between", value1, value2, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("MERCHANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("MERCHANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Integer value) {
            addCriterion("MERCHANT_ID =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Integer value) {
            addCriterion("MERCHANT_ID <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Integer value) {
            addCriterion("MERCHANT_ID >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MERCHANT_ID >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Integer value) {
            addCriterion("MERCHANT_ID <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Integer value) {
            addCriterion("MERCHANT_ID <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Integer> values) {
            addCriterion("MERCHANT_ID in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Integer> values) {
            addCriterion("MERCHANT_ID not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Integer value1, Integer value2) {
            addCriterion("MERCHANT_ID between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MERCHANT_ID not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdIsNull() {
            addCriterion("SHANGJIA_ID is null");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdIsNotNull() {
            addCriterion("SHANGJIA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdEqualTo(Integer value) {
            addCriterion("SHANGJIA_ID =", value, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdNotEqualTo(Integer value) {
            addCriterion("SHANGJIA_ID <>", value, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdGreaterThan(Integer value) {
            addCriterion("SHANGJIA_ID >", value, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHANGJIA_ID >=", value, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdLessThan(Integer value) {
            addCriterion("SHANGJIA_ID <", value, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdLessThanOrEqualTo(Integer value) {
            addCriterion("SHANGJIA_ID <=", value, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdIn(List<Integer> values) {
            addCriterion("SHANGJIA_ID in", values, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdNotIn(List<Integer> values) {
            addCriterion("SHANGJIA_ID not in", values, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdBetween(Integer value1, Integer value2) {
            addCriterion("SHANGJIA_ID between", value1, value2, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andShangjiaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SHANGJIA_ID not between", value1, value2, "shangjiaId");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("TIME like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("TIME not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("TIME not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}