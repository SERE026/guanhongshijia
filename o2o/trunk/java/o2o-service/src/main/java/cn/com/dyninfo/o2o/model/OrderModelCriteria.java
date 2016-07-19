package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class OrderModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public OrderModelCriteria() {
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNull() {
            addCriterion("ADDRESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("ADDRESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(String value) {
            addCriterion("ADDRESS_ID =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(String value) {
            addCriterion("ADDRESS_ID <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(String value) {
            addCriterion("ADDRESS_ID >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS_ID >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(String value) {
            addCriterion("ADDRESS_ID <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS_ID <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLike(String value) {
            addCriterion("ADDRESS_ID like", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotLike(String value) {
            addCriterion("ADDRESS_ID not like", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<String> values) {
            addCriterion("ADDRESS_ID in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<String> values) {
            addCriterion("ADDRESS_ID not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(String value1, String value2) {
            addCriterion("ADDRESS_ID between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(String value1, String value2) {
            addCriterion("ADDRESS_ID not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNull() {
            addCriterion("COUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNotNull() {
            addCriterion("COUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCountIdEqualTo(String value) {
            addCriterion("COUNT_ID =", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotEqualTo(String value) {
            addCriterion("COUNT_ID <>", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThan(String value) {
            addCriterion("COUNT_ID >", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThanOrEqualTo(String value) {
            addCriterion("COUNT_ID >=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThan(String value) {
            addCriterion("COUNT_ID <", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThanOrEqualTo(String value) {
            addCriterion("COUNT_ID <=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLike(String value) {
            addCriterion("COUNT_ID like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotLike(String value) {
            addCriterion("COUNT_ID not like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdIn(List<String> values) {
            addCriterion("COUNT_ID in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotIn(List<String> values) {
            addCriterion("COUNT_ID not in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdBetween(String value1, String value2) {
            addCriterion("COUNT_ID between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotBetween(String value1, String value2) {
            addCriterion("COUNT_ID not between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("CITY_ID like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("CITY_ID not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(String value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(String value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(String value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(String value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLike(String value) {
            addCriterion("PROVINCE_ID like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotLike(String value) {
            addCriterion("PROVINCE_ID not like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<String> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<String> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(String value1, String value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("SENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("SENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(String value) {
            addCriterion("SENDTIME =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(String value) {
            addCriterion("SENDTIME <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(String value) {
            addCriterion("SENDTIME >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("SENDTIME >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(String value) {
            addCriterion("SENDTIME <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(String value) {
            addCriterion("SENDTIME <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLike(String value) {
            addCriterion("SENDTIME like", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotLike(String value) {
            addCriterion("SENDTIME not like", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<String> values) {
            addCriterion("SENDTIME in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<String> values) {
            addCriterion("SENDTIME not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(String value1, String value2) {
            addCriterion("SENDTIME between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(String value1, String value2) {
            addCriterion("SENDTIME not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendstateIsNull() {
            addCriterion("SENDSTATE is null");
            return (Criteria) this;
        }

        public Criteria andSendstateIsNotNull() {
            addCriterion("SENDSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andSendstateEqualTo(String value) {
            addCriterion("SENDSTATE =", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotEqualTo(String value) {
            addCriterion("SENDSTATE <>", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateGreaterThan(String value) {
            addCriterion("SENDSTATE >", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateGreaterThanOrEqualTo(String value) {
            addCriterion("SENDSTATE >=", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateLessThan(String value) {
            addCriterion("SENDSTATE <", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateLessThanOrEqualTo(String value) {
            addCriterion("SENDSTATE <=", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateLike(String value) {
            addCriterion("SENDSTATE like", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotLike(String value) {
            addCriterion("SENDSTATE not like", value, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateIn(List<String> values) {
            addCriterion("SENDSTATE in", values, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotIn(List<String> values) {
            addCriterion("SENDSTATE not in", values, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateBetween(String value1, String value2) {
            addCriterion("SENDSTATE between", value1, value2, "sendstate");
            return (Criteria) this;
        }

        public Criteria andSendstateNotBetween(String value1, String value2) {
            addCriterion("SENDSTATE not between", value1, value2, "sendstate");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("IS_PAY is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("IS_PAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(String value) {
            addCriterion("IS_PAY =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(String value) {
            addCriterion("IS_PAY <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(String value) {
            addCriterion("IS_PAY >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PAY >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(String value) {
            addCriterion("IS_PAY <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(String value) {
            addCriterion("IS_PAY <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLike(String value) {
            addCriterion("IS_PAY like", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotLike(String value) {
            addCriterion("IS_PAY not like", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<String> values) {
            addCriterion("IS_PAY in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<String> values) {
            addCriterion("IS_PAY not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(String value1, String value2) {
            addCriterion("IS_PAY between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(String value1, String value2) {
            addCriterion("IS_PAY not between", value1, value2, "isPay");
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

        public Criteria andPaytimeIsNull() {
            addCriterion("PAYTIME is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("PAYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(String value) {
            addCriterion("PAYTIME =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(String value) {
            addCriterion("PAYTIME <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(String value) {
            addCriterion("PAYTIME >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYTIME >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(String value) {
            addCriterion("PAYTIME <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(String value) {
            addCriterion("PAYTIME <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLike(String value) {
            addCriterion("PAYTIME like", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotLike(String value) {
            addCriterion("PAYTIME not like", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<String> values) {
            addCriterion("PAYTIME in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<String> values) {
            addCriterion("PAYTIME not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(String value1, String value2) {
            addCriterion("PAYTIME between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(String value1, String value2) {
            addCriterion("PAYTIME not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andShouMenIsNull() {
            addCriterion("SHOU_MEN is null");
            return (Criteria) this;
        }

        public Criteria andShouMenIsNotNull() {
            addCriterion("SHOU_MEN is not null");
            return (Criteria) this;
        }

        public Criteria andShouMenEqualTo(String value) {
            addCriterion("SHOU_MEN =", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenNotEqualTo(String value) {
            addCriterion("SHOU_MEN <>", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenGreaterThan(String value) {
            addCriterion("SHOU_MEN >", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenGreaterThanOrEqualTo(String value) {
            addCriterion("SHOU_MEN >=", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenLessThan(String value) {
            addCriterion("SHOU_MEN <", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenLessThanOrEqualTo(String value) {
            addCriterion("SHOU_MEN <=", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenLike(String value) {
            addCriterion("SHOU_MEN like", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenNotLike(String value) {
            addCriterion("SHOU_MEN not like", value, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenIn(List<String> values) {
            addCriterion("SHOU_MEN in", values, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenNotIn(List<String> values) {
            addCriterion("SHOU_MEN not in", values, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenBetween(String value1, String value2) {
            addCriterion("SHOU_MEN between", value1, value2, "shouMen");
            return (Criteria) this;
        }

        public Criteria andShouMenNotBetween(String value1, String value2) {
            addCriterion("SHOU_MEN not between", value1, value2, "shouMen");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("POSTCODE like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("POSTCODE not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andShouPhoneIsNull() {
            addCriterion("SHOU_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andShouPhoneIsNotNull() {
            addCriterion("SHOU_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andShouPhoneEqualTo(String value) {
            addCriterion("SHOU_PHONE =", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneNotEqualTo(String value) {
            addCriterion("SHOU_PHONE <>", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneGreaterThan(String value) {
            addCriterion("SHOU_PHONE >", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SHOU_PHONE >=", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneLessThan(String value) {
            addCriterion("SHOU_PHONE <", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneLessThanOrEqualTo(String value) {
            addCriterion("SHOU_PHONE <=", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneLike(String value) {
            addCriterion("SHOU_PHONE like", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneNotLike(String value) {
            addCriterion("SHOU_PHONE not like", value, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneIn(List<String> values) {
            addCriterion("SHOU_PHONE in", values, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneNotIn(List<String> values) {
            addCriterion("SHOU_PHONE not in", values, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneBetween(String value1, String value2) {
            addCriterion("SHOU_PHONE between", value1, value2, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouPhoneNotBetween(String value1, String value2) {
            addCriterion("SHOU_PHONE not between", value1, value2, "shouPhone");
            return (Criteria) this;
        }

        public Criteria andShouTelIsNull() {
            addCriterion("SHOU_TEL is null");
            return (Criteria) this;
        }

        public Criteria andShouTelIsNotNull() {
            addCriterion("SHOU_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andShouTelEqualTo(String value) {
            addCriterion("SHOU_TEL =", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelNotEqualTo(String value) {
            addCriterion("SHOU_TEL <>", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelGreaterThan(String value) {
            addCriterion("SHOU_TEL >", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelGreaterThanOrEqualTo(String value) {
            addCriterion("SHOU_TEL >=", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelLessThan(String value) {
            addCriterion("SHOU_TEL <", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelLessThanOrEqualTo(String value) {
            addCriterion("SHOU_TEL <=", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelLike(String value) {
            addCriterion("SHOU_TEL like", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelNotLike(String value) {
            addCriterion("SHOU_TEL not like", value, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelIn(List<String> values) {
            addCriterion("SHOU_TEL in", values, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelNotIn(List<String> values) {
            addCriterion("SHOU_TEL not in", values, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelBetween(String value1, String value2) {
            addCriterion("SHOU_TEL between", value1, value2, "shouTel");
            return (Criteria) this;
        }

        public Criteria andShouTelNotBetween(String value1, String value2) {
            addCriterion("SHOU_TEL not between", value1, value2, "shouTel");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdIsNull() {
            addCriterion("ADDRESSINFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdIsNotNull() {
            addCriterion("ADDRESSINFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdEqualTo(String value) {
            addCriterion("ADDRESSINFO_ID =", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdNotEqualTo(String value) {
            addCriterion("ADDRESSINFO_ID <>", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdGreaterThan(String value) {
            addCriterion("ADDRESSINFO_ID >", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESSINFO_ID >=", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdLessThan(String value) {
            addCriterion("ADDRESSINFO_ID <", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdLessThanOrEqualTo(String value) {
            addCriterion("ADDRESSINFO_ID <=", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdLike(String value) {
            addCriterion("ADDRESSINFO_ID like", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdNotLike(String value) {
            addCriterion("ADDRESSINFO_ID not like", value, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdIn(List<String> values) {
            addCriterion("ADDRESSINFO_ID in", values, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdNotIn(List<String> values) {
            addCriterion("ADDRESSINFO_ID not in", values, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdBetween(String value1, String value2) {
            addCriterion("ADDRESSINFO_ID between", value1, value2, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andAddressinfoIdNotBetween(String value1, String value2) {
            addCriterion("ADDRESSINFO_ID not between", value1, value2, "addressinfoId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("SEND_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("SEND_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(String value) {
            addCriterion("SEND_TYPE =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(String value) {
            addCriterion("SEND_TYPE <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(String value) {
            addCriterion("SEND_TYPE >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TYPE >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(String value) {
            addCriterion("SEND_TYPE <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(String value) {
            addCriterion("SEND_TYPE <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLike(String value) {
            addCriterion("SEND_TYPE like", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotLike(String value) {
            addCriterion("SEND_TYPE not like", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<String> values) {
            addCriterion("SEND_TYPE in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<String> values) {
            addCriterion("SEND_TYPE not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(String value1, String value2) {
            addCriterion("SEND_TYPE between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(String value1, String value2) {
            addCriterion("SEND_TYPE not between", value1, value2, "sendType");
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

        public Criteria andHuiyuanIdEqualTo(String value) {
            addCriterion("HUIYUAN_ID =", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotEqualTo(String value) {
            addCriterion("HUIYUAN_ID <>", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdGreaterThan(String value) {
            addCriterion("HUIYUAN_ID >", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdGreaterThanOrEqualTo(String value) {
            addCriterion("HUIYUAN_ID >=", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLessThan(String value) {
            addCriterion("HUIYUAN_ID <", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLessThanOrEqualTo(String value) {
            addCriterion("HUIYUAN_ID <=", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLike(String value) {
            addCriterion("HUIYUAN_ID like", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotLike(String value) {
            addCriterion("HUIYUAN_ID not like", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdIn(List<String> values) {
            addCriterion("HUIYUAN_ID in", values, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotIn(List<String> values) {
            addCriterion("HUIYUAN_ID not in", values, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdBetween(String value1, String value2) {
            addCriterion("HUIYUAN_ID between", value1, value2, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotBetween(String value1, String value2) {
            addCriterion("HUIYUAN_ID not between", value1, value2, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("GOODS_ID like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("GOODS_ID not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdIsNull() {
            addCriterion("SENDORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSendorderIdIsNotNull() {
            addCriterion("SENDORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSendorderIdEqualTo(String value) {
            addCriterion("SENDORDER_ID =", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdNotEqualTo(String value) {
            addCriterion("SENDORDER_ID <>", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdGreaterThan(String value) {
            addCriterion("SENDORDER_ID >", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("SENDORDER_ID >=", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdLessThan(String value) {
            addCriterion("SENDORDER_ID <", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdLessThanOrEqualTo(String value) {
            addCriterion("SENDORDER_ID <=", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdLike(String value) {
            addCriterion("SENDORDER_ID like", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdNotLike(String value) {
            addCriterion("SENDORDER_ID not like", value, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdIn(List<String> values) {
            addCriterion("SENDORDER_ID in", values, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdNotIn(List<String> values) {
            addCriterion("SENDORDER_ID not in", values, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdBetween(String value1, String value2) {
            addCriterion("SENDORDER_ID between", value1, value2, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andSendorderIdNotBetween(String value1, String value2) {
            addCriterion("SENDORDER_ID not between", value1, value2, "sendorderId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNull() {
            addCriterion("PAYMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("PAYMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(String value) {
            addCriterion("PAYMENT_ID =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(String value) {
            addCriterion("PAYMENT_ID <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(String value) {
            addCriterion("PAYMENT_ID >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_ID >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(String value) {
            addCriterion("PAYMENT_ID <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_ID <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLike(String value) {
            addCriterion("PAYMENT_ID like", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotLike(String value) {
            addCriterion("PAYMENT_ID not like", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<String> values) {
            addCriterion("PAYMENT_ID in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<String> values) {
            addCriterion("PAYMENT_ID not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(String value1, String value2) {
            addCriterion("PAYMENT_ID between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_ID not between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdIsNull() {
            addCriterion("REFUNDORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdIsNotNull() {
            addCriterion("REFUNDORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdEqualTo(String value) {
            addCriterion("REFUNDORDER_ID =", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdNotEqualTo(String value) {
            addCriterion("REFUNDORDER_ID <>", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdGreaterThan(String value) {
            addCriterion("REFUNDORDER_ID >", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("REFUNDORDER_ID >=", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdLessThan(String value) {
            addCriterion("REFUNDORDER_ID <", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdLessThanOrEqualTo(String value) {
            addCriterion("REFUNDORDER_ID <=", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdLike(String value) {
            addCriterion("REFUNDORDER_ID like", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdNotLike(String value) {
            addCriterion("REFUNDORDER_ID not like", value, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdIn(List<String> values) {
            addCriterion("REFUNDORDER_ID in", values, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdNotIn(List<String> values) {
            addCriterion("REFUNDORDER_ID not in", values, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdBetween(String value1, String value2) {
            addCriterion("REFUNDORDER_ID between", value1, value2, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andRefundorderIdNotBetween(String value1, String value2) {
            addCriterion("REFUNDORDER_ID not between", value1, value2, "refundorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdIsNull() {
            addCriterion("RETURNEDORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdIsNotNull() {
            addCriterion("RETURNEDORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdEqualTo(String value) {
            addCriterion("RETURNEDORDER_ID =", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdNotEqualTo(String value) {
            addCriterion("RETURNEDORDER_ID <>", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdGreaterThan(String value) {
            addCriterion("RETURNEDORDER_ID >", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("RETURNEDORDER_ID >=", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdLessThan(String value) {
            addCriterion("RETURNEDORDER_ID <", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdLessThanOrEqualTo(String value) {
            addCriterion("RETURNEDORDER_ID <=", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdLike(String value) {
            addCriterion("RETURNEDORDER_ID like", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdNotLike(String value) {
            addCriterion("RETURNEDORDER_ID not like", value, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdIn(List<String> values) {
            addCriterion("RETURNEDORDER_ID in", values, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdNotIn(List<String> values) {
            addCriterion("RETURNEDORDER_ID not in", values, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdBetween(String value1, String value2) {
            addCriterion("RETURNEDORDER_ID between", value1, value2, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReturnedorderIdNotBetween(String value1, String value2) {
            addCriterion("RETURNEDORDER_ID not between", value1, value2, "returnedorderId");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("RECEIVE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("RECEIVE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("RECEIVE_ADDRESS >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("RECEIVE_ADDRESS <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("RECEIVE_ADDRESS like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("RECEIVE_ADDRESS not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("RECEIVE_ADDRESS in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("RECEIVE_ADDRESS not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("RECEIVE_ADDRESS between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_ADDRESS not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeIsNull() {
            addCriterion("APPLY_REFUND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeIsNotNull() {
            addCriterion("APPLY_REFUND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeEqualTo(Integer value) {
            addCriterion("APPLY_REFUND_TIME =", value, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeNotEqualTo(Integer value) {
            addCriterion("APPLY_REFUND_TIME <>", value, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeGreaterThan(Integer value) {
            addCriterion("APPLY_REFUND_TIME >", value, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPLY_REFUND_TIME >=", value, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeLessThan(Integer value) {
            addCriterion("APPLY_REFUND_TIME <", value, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeLessThanOrEqualTo(Integer value) {
            addCriterion("APPLY_REFUND_TIME <=", value, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeIn(List<Integer> values) {
            addCriterion("APPLY_REFUND_TIME in", values, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeNotIn(List<Integer> values) {
            addCriterion("APPLY_REFUND_TIME not in", values, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_REFUND_TIME between", value1, value2, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andApplyRefundTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_REFUND_TIME not between", value1, value2, "applyRefundTime");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeIsNull() {
            addCriterion("RECEIVE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeIsNotNull() {
            addCriterion("RECEIVE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeEqualTo(String value) {
            addCriterion("RECEIVE_CODE =", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotEqualTo(String value) {
            addCriterion("RECEIVE_CODE <>", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeGreaterThan(String value) {
            addCriterion("RECEIVE_CODE >", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_CODE >=", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeLessThan(String value) {
            addCriterion("RECEIVE_CODE <", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_CODE <=", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeLike(String value) {
            addCriterion("RECEIVE_CODE like", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotLike(String value) {
            addCriterion("RECEIVE_CODE not like", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeIn(List<String> values) {
            addCriterion("RECEIVE_CODE in", values, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotIn(List<String> values) {
            addCriterion("RECEIVE_CODE not in", values, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeBetween(String value1, String value2) {
            addCriterion("RECEIVE_CODE between", value1, value2, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_CODE not between", value1, value2, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("DISCOUNT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("DISCOUNT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(Double value) {
            addCriterion("DISCOUNT_PRICE =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(Double value) {
            addCriterion("DISCOUNT_PRICE <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(Double value) {
            addCriterion("DISCOUNT_PRICE >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("DISCOUNT_PRICE >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(Double value) {
            addCriterion("DISCOUNT_PRICE <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(Double value) {
            addCriterion("DISCOUNT_PRICE <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<Double> values) {
            addCriterion("DISCOUNT_PRICE in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<Double> values) {
            addCriterion("DISCOUNT_PRICE not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(Double value1, Double value2) {
            addCriterion("DISCOUNT_PRICE between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(Double value1, Double value2) {
            addCriterion("DISCOUNT_PRICE not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDlyCodeIsNull() {
            addCriterion("DLY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDlyCodeIsNotNull() {
            addCriterion("DLY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDlyCodeEqualTo(String value) {
            addCriterion("DLY_CODE =", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeNotEqualTo(String value) {
            addCriterion("DLY_CODE <>", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeGreaterThan(String value) {
            addCriterion("DLY_CODE >", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DLY_CODE >=", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeLessThan(String value) {
            addCriterion("DLY_CODE <", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeLessThanOrEqualTo(String value) {
            addCriterion("DLY_CODE <=", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeLike(String value) {
            addCriterion("DLY_CODE like", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeNotLike(String value) {
            addCriterion("DLY_CODE not like", value, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeIn(List<String> values) {
            addCriterion("DLY_CODE in", values, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeNotIn(List<String> values) {
            addCriterion("DLY_CODE not in", values, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeBetween(String value1, String value2) {
            addCriterion("DLY_CODE between", value1, value2, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andDlyCodeNotBetween(String value1, String value2) {
            addCriterion("DLY_CODE not between", value1, value2, "dlyCode");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNull() {
            addCriterion("RECEIVE_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNotNull() {
            addCriterion("RECEIVE_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL =", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL <>", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThan(String value) {
            addCriterion("RECEIVE_EMAIL >", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL >=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThan(String value) {
            addCriterion("RECEIVE_EMAIL <", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL <=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLike(String value) {
            addCriterion("RECEIVE_EMAIL like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotLike(String value) {
            addCriterion("RECEIVE_EMAIL not like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIn(List<String> values) {
            addCriterion("RECEIVE_EMAIL in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotIn(List<String> values) {
            addCriterion("RECEIVE_EMAIL not in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailBetween(String value1, String value2) {
            addCriterion("RECEIVE_EMAIL between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_EMAIL not between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andIpaytimeIsNull() {
            addCriterion("IPAYTIME is null");
            return (Criteria) this;
        }

        public Criteria andIpaytimeIsNotNull() {
            addCriterion("IPAYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andIpaytimeEqualTo(Integer value) {
            addCriterion("IPAYTIME =", value, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeNotEqualTo(Integer value) {
            addCriterion("IPAYTIME <>", value, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeGreaterThan(Integer value) {
            addCriterion("IPAYTIME >", value, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IPAYTIME >=", value, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeLessThan(Integer value) {
            addCriterion("IPAYTIME <", value, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeLessThanOrEqualTo(Integer value) {
            addCriterion("IPAYTIME <=", value, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeIn(List<Integer> values) {
            addCriterion("IPAYTIME in", values, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeNotIn(List<Integer> values) {
            addCriterion("IPAYTIME not in", values, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeBetween(Integer value1, Integer value2) {
            addCriterion("IPAYTIME between", value1, value2, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIpaytimeNotBetween(Integer value1, Integer value2) {
            addCriterion("IPAYTIME not between", value1, value2, "ipaytime");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNull() {
            addCriterion("IS_REFUND is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNotNull() {
            addCriterion("IS_REFUND is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundEqualTo(String value) {
            addCriterion("IS_REFUND =", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotEqualTo(String value) {
            addCriterion("IS_REFUND <>", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThan(String value) {
            addCriterion("IS_REFUND >", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThanOrEqualTo(String value) {
            addCriterion("IS_REFUND >=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThan(String value) {
            addCriterion("IS_REFUND <", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThanOrEqualTo(String value) {
            addCriterion("IS_REFUND <=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLike(String value) {
            addCriterion("IS_REFUND like", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotLike(String value) {
            addCriterion("IS_REFUND not like", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundIn(List<String> values) {
            addCriterion("IS_REFUND in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotIn(List<String> values) {
            addCriterion("IS_REFUND not in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundBetween(String value1, String value2) {
            addCriterion("IS_REFUND between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotBetween(String value1, String value2) {
            addCriterion("IS_REFUND not between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("ORDER_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("ORDER_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Double value) {
            addCriterion("ORDER_PRICE =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Double value) {
            addCriterion("ORDER_PRICE <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Double value) {
            addCriterion("ORDER_PRICE >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("ORDER_PRICE >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Double value) {
            addCriterion("ORDER_PRICE <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Double value) {
            addCriterion("ORDER_PRICE <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Double> values) {
            addCriterion("ORDER_PRICE in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Double> values) {
            addCriterion("ORDER_PRICE not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Double value1, Double value2) {
            addCriterion("ORDER_PRICE between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Double value1, Double value2) {
            addCriterion("ORDER_PRICE not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("ORIGINAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("ORIGINAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(Double value) {
            addCriterion("ORIGINAL_PRICE >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(Double value) {
            addCriterion("ORIGINAL_PRICE <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(Double value) {
            addCriterion("ORIGINAL_PRICE <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<Double> values) {
            addCriterion("ORIGINAL_PRICE in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<Double> values) {
            addCriterion("ORIGINAL_PRICE not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(Double value1, Double value2) {
            addCriterion("ORIGINAL_PRICE between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(Double value1, Double value2) {
            addCriterion("ORIGINAL_PRICE not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("POINT is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("POINT is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(Integer value) {
            addCriterion("POINT =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(Integer value) {
            addCriterion("POINT <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(Integer value) {
            addCriterion("POINT >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("POINT >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(Integer value) {
            addCriterion("POINT <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(Integer value) {
            addCriterion("POINT <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<Integer> values) {
            addCriterion("POINT in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<Integer> values) {
            addCriterion("POINT not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(Integer value1, Integer value2) {
            addCriterion("POINT between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(Integer value1, Integer value2) {
            addCriterion("POINT not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andProtectPriceIsNull() {
            addCriterion("PROTECT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andProtectPriceIsNotNull() {
            addCriterion("PROTECT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andProtectPriceEqualTo(Double value) {
            addCriterion("PROTECT_PRICE =", value, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceNotEqualTo(Double value) {
            addCriterion("PROTECT_PRICE <>", value, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceGreaterThan(Double value) {
            addCriterion("PROTECT_PRICE >", value, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PROTECT_PRICE >=", value, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceLessThan(Double value) {
            addCriterion("PROTECT_PRICE <", value, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceLessThanOrEqualTo(Double value) {
            addCriterion("PROTECT_PRICE <=", value, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceIn(List<Double> values) {
            addCriterion("PROTECT_PRICE in", values, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceNotIn(List<Double> values) {
            addCriterion("PROTECT_PRICE not in", values, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceBetween(Double value1, Double value2) {
            addCriterion("PROTECT_PRICE between", value1, value2, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andProtectPriceNotBetween(Double value1, Double value2) {
            addCriterion("PROTECT_PRICE not between", value1, value2, "protectPrice");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNull() {
            addCriterion("RECEIVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("RECEIVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateEqualTo(String value) {
            addCriterion("RECEIVE_DATE =", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotEqualTo(String value) {
            addCriterion("RECEIVE_DATE <>", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThan(String value) {
            addCriterion("RECEIVE_DATE >", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_DATE >=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThan(String value) {
            addCriterion("RECEIVE_DATE <", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_DATE <=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLike(String value) {
            addCriterion("RECEIVE_DATE like", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotLike(String value) {
            addCriterion("RECEIVE_DATE not like", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIn(List<String> values) {
            addCriterion("RECEIVE_DATE in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotIn(List<String> values) {
            addCriterion("RECEIVE_DATE not in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateBetween(String value1, String value2) {
            addCriterion("RECEIVE_DATE between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_DATE not between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNull() {
            addCriterion("RECEIVE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNotNull() {
            addCriterion("RECEIVE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameEqualTo(String value) {
            addCriterion("RECEIVE_NAME =", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotEqualTo(String value) {
            addCriterion("RECEIVE_NAME <>", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThan(String value) {
            addCriterion("RECEIVE_NAME >", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NAME >=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThan(String value) {
            addCriterion("RECEIVE_NAME <", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NAME <=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLike(String value) {
            addCriterion("RECEIVE_NAME like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotLike(String value) {
            addCriterion("RECEIVE_NAME not like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIn(List<String> values) {
            addCriterion("RECEIVE_NAME in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotIn(List<String> values) {
            addCriterion("RECEIVE_NAME not in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameBetween(String value1, String value2) {
            addCriterion("RECEIVE_NAME between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_NAME not between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNull() {
            addCriterion("RECEIVE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNotNull() {
            addCriterion("RECEIVE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneEqualTo(String value) {
            addCriterion("RECEIVE_PHONE =", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotEqualTo(String value) {
            addCriterion("RECEIVE_PHONE <>", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThan(String value) {
            addCriterion("RECEIVE_PHONE >", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_PHONE >=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThan(String value) {
            addCriterion("RECEIVE_PHONE <", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_PHONE <=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLike(String value) {
            addCriterion("RECEIVE_PHONE like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotLike(String value) {
            addCriterion("RECEIVE_PHONE not like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIn(List<String> values) {
            addCriterion("RECEIVE_PHONE in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotIn(List<String> values) {
            addCriterion("RECEIVE_PHONE not in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneBetween(String value1, String value2) {
            addCriterion("RECEIVE_PHONE between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_PHONE not between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIsNull() {
            addCriterion("MARCHANTS_ID is null");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIsNotNull() {
            addCriterion("MARCHANTS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID =", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID <>", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdGreaterThan(Integer value) {
            addCriterion("MARCHANTS_ID >", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID >=", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLessThan(Integer value) {
            addCriterion("MARCHANTS_ID <", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLessThanOrEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID <=", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIn(List<Integer> values) {
            addCriterion("MARCHANTS_ID in", values, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotIn(List<Integer> values) {
            addCriterion("MARCHANTS_ID not in", values, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdBetween(Integer value1, Integer value2) {
            addCriterion("MARCHANTS_ID between", value1, value2, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MARCHANTS_ID not between", value1, value2, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andReceiveTelIsNull() {
            addCriterion("RECEIVE_TEL is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTelIsNotNull() {
            addCriterion("RECEIVE_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTelEqualTo(String value) {
            addCriterion("RECEIVE_TEL =", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotEqualTo(String value) {
            addCriterion("RECEIVE_TEL <>", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelGreaterThan(String value) {
            addCriterion("RECEIVE_TEL >", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TEL >=", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelLessThan(String value) {
            addCriterion("RECEIVE_TEL <", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TEL <=", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelLike(String value) {
            addCriterion("RECEIVE_TEL like", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotLike(String value) {
            addCriterion("RECEIVE_TEL not like", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelIn(List<String> values) {
            addCriterion("RECEIVE_TEL in", values, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotIn(List<String> values) {
            addCriterion("RECEIVE_TEL not in", values, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelBetween(String value1, String value2) {
            addCriterion("RECEIVE_TEL between", value1, value2, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_TEL not between", value1, value2, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("REFUND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("REFUND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Integer value) {
            addCriterion("REFUND_TIME =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Integer value) {
            addCriterion("REFUND_TIME <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Integer value) {
            addCriterion("REFUND_TIME >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("REFUND_TIME >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Integer value) {
            addCriterion("REFUND_TIME <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Integer value) {
            addCriterion("REFUND_TIME <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Integer> values) {
            addCriterion("REFUND_TIME in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Integer> values) {
            addCriterion("REFUND_TIME not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Integer value1, Integer value2) {
            addCriterion("REFUND_TIME between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("REFUND_TIME not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andShippingPriceIsNull() {
            addCriterion("SHIPPING_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceIsNotNull() {
            addCriterion("SHIPPING_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPriceEqualTo(Double value) {
            addCriterion("SHIPPING_PRICE =", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceNotEqualTo(Double value) {
            addCriterion("SHIPPING_PRICE <>", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceGreaterThan(Double value) {
            addCriterion("SHIPPING_PRICE >", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("SHIPPING_PRICE >=", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceLessThan(Double value) {
            addCriterion("SHIPPING_PRICE <", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceLessThanOrEqualTo(Double value) {
            addCriterion("SHIPPING_PRICE <=", value, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceIn(List<Double> values) {
            addCriterion("SHIPPING_PRICE in", values, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceNotIn(List<Double> values) {
            addCriterion("SHIPPING_PRICE not in", values, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceBetween(Double value1, Double value2) {
            addCriterion("SHIPPING_PRICE between", value1, value2, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPriceNotBetween(Double value1, Double value2) {
            addCriterion("SHIPPING_PRICE not between", value1, value2, "shippingPrice");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andCountyIdIsNull() {
            addCriterion("COUNTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCountyIdIsNotNull() {
            addCriterion("COUNTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCountyIdEqualTo(String value) {
            addCriterion("COUNTY_ID =", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotEqualTo(String value) {
            addCriterion("COUNTY_ID <>", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdGreaterThan(String value) {
            addCriterion("COUNTY_ID >", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY_ID >=", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLessThan(String value) {
            addCriterion("COUNTY_ID <", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLessThanOrEqualTo(String value) {
            addCriterion("COUNTY_ID <=", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLike(String value) {
            addCriterion("COUNTY_ID like", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotLike(String value) {
            addCriterion("COUNTY_ID not like", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdIn(List<String> values) {
            addCriterion("COUNTY_ID in", values, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotIn(List<String> values) {
            addCriterion("COUNTY_ID not in", values, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdBetween(String value1, String value2) {
            addCriterion("COUNTY_ID between", value1, value2, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotBetween(String value1, String value2) {
            addCriterion("COUNTY_ID not between", value1, value2, "countyId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdIsNull() {
            addCriterion("DLYTYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdIsNotNull() {
            addCriterion("DLYTYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdEqualTo(Integer value) {
            addCriterion("DLYTYPE_ID =", value, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdNotEqualTo(Integer value) {
            addCriterion("DLYTYPE_ID <>", value, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdGreaterThan(Integer value) {
            addCriterion("DLYTYPE_ID >", value, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DLYTYPE_ID >=", value, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdLessThan(Integer value) {
            addCriterion("DLYTYPE_ID <", value, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("DLYTYPE_ID <=", value, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdIn(List<Integer> values) {
            addCriterion("DLYTYPE_ID in", values, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdNotIn(List<Integer> values) {
            addCriterion("DLYTYPE_ID not in", values, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdBetween(Integer value1, Integer value2) {
            addCriterion("DLYTYPE_ID between", value1, value2, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andDlytypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DLYTYPE_ID not between", value1, value2, "dlytypeId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdIsNull() {
            addCriterion("WLCOMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdIsNotNull() {
            addCriterion("WLCOMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID =", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdNotEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID <>", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdGreaterThan(Integer value) {
            addCriterion("WLCOMPANY_ID >", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID >=", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdLessThan(Integer value) {
            addCriterion("WLCOMPANY_ID <", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID <=", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdIn(List<Integer> values) {
            addCriterion("WLCOMPANY_ID in", values, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdNotIn(List<Integer> values) {
            addCriterion("WLCOMPANY_ID not in", values, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("WLCOMPANY_ID between", value1, value2, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WLCOMPANY_ID not between", value1, value2, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andDlyIsNull() {
            addCriterion("DLY is null");
            return (Criteria) this;
        }

        public Criteria andDlyIsNotNull() {
            addCriterion("DLY is not null");
            return (Criteria) this;
        }

        public Criteria andDlyEqualTo(String value) {
            addCriterion("DLY =", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotEqualTo(String value) {
            addCriterion("DLY <>", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyGreaterThan(String value) {
            addCriterion("DLY >", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyGreaterThanOrEqualTo(String value) {
            addCriterion("DLY >=", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyLessThan(String value) {
            addCriterion("DLY <", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyLessThanOrEqualTo(String value) {
            addCriterion("DLY <=", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyLike(String value) {
            addCriterion("DLY like", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotLike(String value) {
            addCriterion("DLY not like", value, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyIn(List<String> values) {
            addCriterion("DLY in", values, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotIn(List<String> values) {
            addCriterion("DLY not in", values, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyBetween(String value1, String value2) {
            addCriterion("DLY between", value1, value2, "dly");
            return (Criteria) this;
        }

        public Criteria andDlyNotBetween(String value1, String value2) {
            addCriterion("DLY not between", value1, value2, "dly");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("PLAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("PLAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(Integer value) {
            addCriterion("PLAY_TYPE =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(Integer value) {
            addCriterion("PLAY_TYPE <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(Integer value) {
            addCriterion("PLAY_TYPE >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLAY_TYPE >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(Integer value) {
            addCriterion("PLAY_TYPE <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PLAY_TYPE <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<Integer> values) {
            addCriterion("PLAY_TYPE in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<Integer> values) {
            addCriterion("PLAY_TYPE not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_TYPE between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PLAY_TYPE not between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andTradenoIsNull() {
            addCriterion("TRADENO is null");
            return (Criteria) this;
        }

        public Criteria andTradenoIsNotNull() {
            addCriterion("TRADENO is not null");
            return (Criteria) this;
        }

        public Criteria andTradenoEqualTo(String value) {
            addCriterion("TRADENO =", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotEqualTo(String value) {
            addCriterion("TRADENO <>", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoGreaterThan(String value) {
            addCriterion("TRADENO >", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADENO >=", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLessThan(String value) {
            addCriterion("TRADENO <", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLessThanOrEqualTo(String value) {
            addCriterion("TRADENO <=", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLike(String value) {
            addCriterion("TRADENO like", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotLike(String value) {
            addCriterion("TRADENO not like", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoIn(List<String> values) {
            addCriterion("TRADENO in", values, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotIn(List<String> values) {
            addCriterion("TRADENO not in", values, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoBetween(String value1, String value2) {
            addCriterion("TRADENO between", value1, value2, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotBetween(String value1, String value2) {
            addCriterion("TRADENO not between", value1, value2, "tradeno");
            return (Criteria) this;
        }

        public Criteria andPointPriceIsNull() {
            addCriterion("POINT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPointPriceIsNotNull() {
            addCriterion("POINT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPointPriceEqualTo(Double value) {
            addCriterion("POINT_PRICE =", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceNotEqualTo(Double value) {
            addCriterion("POINT_PRICE <>", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceGreaterThan(Double value) {
            addCriterion("POINT_PRICE >", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("POINT_PRICE >=", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceLessThan(Double value) {
            addCriterion("POINT_PRICE <", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceLessThanOrEqualTo(Double value) {
            addCriterion("POINT_PRICE <=", value, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceIn(List<Double> values) {
            addCriterion("POINT_PRICE in", values, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceNotIn(List<Double> values) {
            addCriterion("POINT_PRICE not in", values, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceBetween(Double value1, Double value2) {
            addCriterion("POINT_PRICE between", value1, value2, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andPointPriceNotBetween(Double value1, Double value2) {
            addCriterion("POINT_PRICE not between", value1, value2, "pointPrice");
            return (Criteria) this;
        }

        public Criteria andIsendtimeIsNull() {
            addCriterion("ISENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andIsendtimeIsNotNull() {
            addCriterion("ISENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andIsendtimeEqualTo(Integer value) {
            addCriterion("ISENDTIME =", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeNotEqualTo(Integer value) {
            addCriterion("ISENDTIME <>", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeGreaterThan(Integer value) {
            addCriterion("ISENDTIME >", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISENDTIME >=", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeLessThan(Integer value) {
            addCriterion("ISENDTIME <", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeLessThanOrEqualTo(Integer value) {
            addCriterion("ISENDTIME <=", value, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeIn(List<Integer> values) {
            addCriterion("ISENDTIME in", values, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeNotIn(List<Integer> values) {
            addCriterion("ISENDTIME not in", values, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeBetween(Integer value1, Integer value2) {
            addCriterion("ISENDTIME between", value1, value2, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsendtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ISENDTIME not between", value1, value2, "isendtime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeIsNull() {
            addCriterion("ISURETIME is null");
            return (Criteria) this;
        }

        public Criteria andIsuretimeIsNotNull() {
            addCriterion("ISURETIME is not null");
            return (Criteria) this;
        }

        public Criteria andIsuretimeEqualTo(Integer value) {
            addCriterion("ISURETIME =", value, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeNotEqualTo(Integer value) {
            addCriterion("ISURETIME <>", value, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeGreaterThan(Integer value) {
            addCriterion("ISURETIME >", value, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISURETIME >=", value, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeLessThan(Integer value) {
            addCriterion("ISURETIME <", value, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeLessThanOrEqualTo(Integer value) {
            addCriterion("ISURETIME <=", value, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeIn(List<Integer> values) {
            addCriterion("ISURETIME in", values, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeNotIn(List<Integer> values) {
            addCriterion("ISURETIME not in", values, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeBetween(Integer value1, Integer value2) {
            addCriterion("ISURETIME between", value1, value2, "isuretime");
            return (Criteria) this;
        }

        public Criteria andIsuretimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ISURETIME not between", value1, value2, "isuretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeIsNull() {
            addCriterion("SURETIME is null");
            return (Criteria) this;
        }

        public Criteria andSuretimeIsNotNull() {
            addCriterion("SURETIME is not null");
            return (Criteria) this;
        }

        public Criteria andSuretimeEqualTo(String value) {
            addCriterion("SURETIME =", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeNotEqualTo(String value) {
            addCriterion("SURETIME <>", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeGreaterThan(String value) {
            addCriterion("SURETIME >", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeGreaterThanOrEqualTo(String value) {
            addCriterion("SURETIME >=", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeLessThan(String value) {
            addCriterion("SURETIME <", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeLessThanOrEqualTo(String value) {
            addCriterion("SURETIME <=", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeLike(String value) {
            addCriterion("SURETIME like", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeNotLike(String value) {
            addCriterion("SURETIME not like", value, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeIn(List<String> values) {
            addCriterion("SURETIME in", values, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeNotIn(List<String> values) {
            addCriterion("SURETIME not in", values, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeBetween(String value1, String value2) {
            addCriterion("SURETIME between", value1, value2, "suretime");
            return (Criteria) this;
        }

        public Criteria andSuretimeNotBetween(String value1, String value2) {
            addCriterion("SURETIME not between", value1, value2, "suretime");
            return (Criteria) this;
        }

        public Criteria andPriceSumIsNull() {
            addCriterion("PRICE_SUM is null");
            return (Criteria) this;
        }

        public Criteria andPriceSumIsNotNull() {
            addCriterion("PRICE_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andPriceSumEqualTo(Float value) {
            addCriterion("PRICE_SUM =", value, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumNotEqualTo(Float value) {
            addCriterion("PRICE_SUM <>", value, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumGreaterThan(Float value) {
            addCriterion("PRICE_SUM >", value, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumGreaterThanOrEqualTo(Float value) {
            addCriterion("PRICE_SUM >=", value, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumLessThan(Float value) {
            addCriterion("PRICE_SUM <", value, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumLessThanOrEqualTo(Float value) {
            addCriterion("PRICE_SUM <=", value, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumIn(List<Float> values) {
            addCriterion("PRICE_SUM in", values, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumNotIn(List<Float> values) {
            addCriterion("PRICE_SUM not in", values, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumBetween(Float value1, Float value2) {
            addCriterion("PRICE_SUM between", value1, value2, "priceSum");
            return (Criteria) this;
        }

        public Criteria andPriceSumNotBetween(Float value1, Float value2) {
            addCriterion("PRICE_SUM not between", value1, value2, "priceSum");
            return (Criteria) this;
        }

        public Criteria andIsReturnIsNull() {
            addCriterion("IS_RETURN is null");
            return (Criteria) this;
        }

        public Criteria andIsReturnIsNotNull() {
            addCriterion("IS_RETURN is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturnEqualTo(String value) {
            addCriterion("IS_RETURN =", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotEqualTo(String value) {
            addCriterion("IS_RETURN <>", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnGreaterThan(String value) {
            addCriterion("IS_RETURN >", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnGreaterThanOrEqualTo(String value) {
            addCriterion("IS_RETURN >=", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLessThan(String value) {
            addCriterion("IS_RETURN <", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLessThanOrEqualTo(String value) {
            addCriterion("IS_RETURN <=", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnLike(String value) {
            addCriterion("IS_RETURN like", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotLike(String value) {
            addCriterion("IS_RETURN not like", value, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnIn(List<String> values) {
            addCriterion("IS_RETURN in", values, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotIn(List<String> values) {
            addCriterion("IS_RETURN not in", values, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnBetween(String value1, String value2) {
            addCriterion("IS_RETURN between", value1, value2, "isReturn");
            return (Criteria) this;
        }

        public Criteria andIsReturnNotBetween(String value1, String value2) {
            addCriterion("IS_RETURN not between", value1, value2, "isReturn");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("ENDTIME like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("ENDTIME not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(Integer value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(Integer value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(Integer value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(Integer value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<Integer> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<Integer> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andHuistatIsNull() {
            addCriterion("HUISTAT is null");
            return (Criteria) this;
        }

        public Criteria andHuistatIsNotNull() {
            addCriterion("HUISTAT is not null");
            return (Criteria) this;
        }

        public Criteria andHuistatEqualTo(String value) {
            addCriterion("HUISTAT =", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatNotEqualTo(String value) {
            addCriterion("HUISTAT <>", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatGreaterThan(String value) {
            addCriterion("HUISTAT >", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatGreaterThanOrEqualTo(String value) {
            addCriterion("HUISTAT >=", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatLessThan(String value) {
            addCriterion("HUISTAT <", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatLessThanOrEqualTo(String value) {
            addCriterion("HUISTAT <=", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatLike(String value) {
            addCriterion("HUISTAT like", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatNotLike(String value) {
            addCriterion("HUISTAT not like", value, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatIn(List<String> values) {
            addCriterion("HUISTAT in", values, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatNotIn(List<String> values) {
            addCriterion("HUISTAT not in", values, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatBetween(String value1, String value2) {
            addCriterion("HUISTAT between", value1, value2, "huistat");
            return (Criteria) this;
        }

        public Criteria andHuistatNotBetween(String value1, String value2) {
            addCriterion("HUISTAT not between", value1, value2, "huistat");
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