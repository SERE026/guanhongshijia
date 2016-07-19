package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class CarsBoxModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CarsBoxModelCriteria() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("CAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("CAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(String value) {
            addCriterion("CAR_ID =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(String value) {
            addCriterion("CAR_ID <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(String value) {
            addCriterion("CAR_ID >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("CAR_ID >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(String value) {
            addCriterion("CAR_ID <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(String value) {
            addCriterion("CAR_ID <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLike(String value) {
            addCriterion("CAR_ID like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotLike(String value) {
            addCriterion("CAR_ID not like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<String> values) {
            addCriterion("CAR_ID in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<String> values) {
            addCriterion("CAR_ID not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(String value1, String value2) {
            addCriterion("CAR_ID between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(String value1, String value2) {
            addCriterion("CAR_ID not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("GOODS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("GOODS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("GOODS_NAME =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("GOODS_NAME <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("GOODS_NAME >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_NAME >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("GOODS_NAME <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("GOODS_NAME <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("GOODS_NAME like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("GOODS_NAME not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("GOODS_NAME in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("GOODS_NAME not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("GOODS_NAME between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("GOODS_NAME not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameIsNull() {
            addCriterion("MERCHANTS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameIsNotNull() {
            addCriterion("MERCHANTS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameEqualTo(String value) {
            addCriterion("MERCHANTS_NAME =", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameNotEqualTo(String value) {
            addCriterion("MERCHANTS_NAME <>", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameGreaterThan(String value) {
            addCriterion("MERCHANTS_NAME >", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANTS_NAME >=", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameLessThan(String value) {
            addCriterion("MERCHANTS_NAME <", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameLessThanOrEqualTo(String value) {
            addCriterion("MERCHANTS_NAME <=", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameLike(String value) {
            addCriterion("MERCHANTS_NAME like", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameNotLike(String value) {
            addCriterion("MERCHANTS_NAME not like", value, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameIn(List<String> values) {
            addCriterion("MERCHANTS_NAME in", values, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameNotIn(List<String> values) {
            addCriterion("MERCHANTS_NAME not in", values, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameBetween(String value1, String value2) {
            addCriterion("MERCHANTS_NAME between", value1, value2, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andMerchantsNameNotBetween(String value1, String value2) {
            addCriterion("MERCHANTS_NAME not between", value1, value2, "merchantsName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andActInfoIsNull() {
            addCriterion("ACT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andActInfoIsNotNull() {
            addCriterion("ACT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andActInfoEqualTo(String value) {
            addCriterion("ACT_INFO =", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoNotEqualTo(String value) {
            addCriterion("ACT_INFO <>", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoGreaterThan(String value) {
            addCriterion("ACT_INFO >", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_INFO >=", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoLessThan(String value) {
            addCriterion("ACT_INFO <", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoLessThanOrEqualTo(String value) {
            addCriterion("ACT_INFO <=", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoLike(String value) {
            addCriterion("ACT_INFO like", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoNotLike(String value) {
            addCriterion("ACT_INFO not like", value, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoIn(List<String> values) {
            addCriterion("ACT_INFO in", values, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoNotIn(List<String> values) {
            addCriterion("ACT_INFO not in", values, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoBetween(String value1, String value2) {
            addCriterion("ACT_INFO between", value1, value2, "actInfo");
            return (Criteria) this;
        }

        public Criteria andActInfoNotBetween(String value1, String value2) {
            addCriterion("ACT_INFO not between", value1, value2, "actInfo");
            return (Criteria) this;
        }

        public Criteria andSpecValIsNull() {
            addCriterion("SPEC_VAL is null");
            return (Criteria) this;
        }

        public Criteria andSpecValIsNotNull() {
            addCriterion("SPEC_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValEqualTo(String value) {
            addCriterion("SPEC_VAL =", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValNotEqualTo(String value) {
            addCriterion("SPEC_VAL <>", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValGreaterThan(String value) {
            addCriterion("SPEC_VAL >", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValGreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VAL >=", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValLessThan(String value) {
            addCriterion("SPEC_VAL <", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValLessThanOrEqualTo(String value) {
            addCriterion("SPEC_VAL <=", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValLike(String value) {
            addCriterion("SPEC_VAL like", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValNotLike(String value) {
            addCriterion("SPEC_VAL not like", value, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValIn(List<String> values) {
            addCriterion("SPEC_VAL in", values, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValNotIn(List<String> values) {
            addCriterion("SPEC_VAL not in", values, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValBetween(String value1, String value2) {
            addCriterion("SPEC_VAL between", value1, value2, "specVal");
            return (Criteria) this;
        }

        public Criteria andSpecValNotBetween(String value1, String value2) {
            addCriterion("SPEC_VAL not between", value1, value2, "specVal");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("GOOD_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("GOOD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Integer value) {
            addCriterion("GOOD_ID =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Integer value) {
            addCriterion("GOOD_ID <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Integer value) {
            addCriterion("GOOD_ID >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOOD_ID >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Integer value) {
            addCriterion("GOOD_ID <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOOD_ID <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Integer> values) {
            addCriterion("GOOD_ID in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Integer> values) {
            addCriterion("GOOD_ID not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("GOOD_ID between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOOD_ID not between", value1, value2, "goodId");
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