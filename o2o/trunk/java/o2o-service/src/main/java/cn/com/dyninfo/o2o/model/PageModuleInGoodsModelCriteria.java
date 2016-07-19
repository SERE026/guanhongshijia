package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class PageModuleInGoodsModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public PageModuleInGoodsModelCriteria() {
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

        public Criteria andPagemoduleIdIsNull() {
            addCriterion("PAGEMODULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdIsNotNull() {
            addCriterion("PAGEMODULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdEqualTo(Integer value) {
            addCriterion("PAGEMODULE_ID =", value, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdNotEqualTo(Integer value) {
            addCriterion("PAGEMODULE_ID <>", value, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdGreaterThan(Integer value) {
            addCriterion("PAGEMODULE_ID >", value, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAGEMODULE_ID >=", value, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdLessThan(Integer value) {
            addCriterion("PAGEMODULE_ID <", value, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdLessThanOrEqualTo(Integer value) {
            addCriterion("PAGEMODULE_ID <=", value, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdIn(List<Integer> values) {
            addCriterion("PAGEMODULE_ID in", values, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdNotIn(List<Integer> values) {
            addCriterion("PAGEMODULE_ID not in", values, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdBetween(Integer value1, Integer value2) {
            addCriterion("PAGEMODULE_ID between", value1, value2, "pagemoduleId");
            return (Criteria) this;
        }

        public Criteria andPagemoduleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PAGEMODULE_ID not between", value1, value2, "pagemoduleId");
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

        public Criteria andIndexsIsNull() {
            addCriterion("INDEXS is null");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNotNull() {
            addCriterion("INDEXS is not null");
            return (Criteria) this;
        }

        public Criteria andIndexsEqualTo(Integer value) {
            addCriterion("INDEXS =", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotEqualTo(Integer value) {
            addCriterion("INDEXS <>", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThan(Integer value) {
            addCriterion("INDEXS >", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThanOrEqualTo(Integer value) {
            addCriterion("INDEXS >=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThan(Integer value) {
            addCriterion("INDEXS <", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThanOrEqualTo(Integer value) {
            addCriterion("INDEXS <=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsIn(List<Integer> values) {
            addCriterion("INDEXS in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotIn(List<Integer> values) {
            addCriterion("INDEXS not in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsBetween(Integer value1, Integer value2) {
            addCriterion("INDEXS between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotBetween(Integer value1, Integer value2) {
            addCriterion("INDEXS not between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("EXPIRE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("EXPIRE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(String value) {
            addCriterion("EXPIRE_TIME =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(String value) {
            addCriterion("EXPIRE_TIME <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(String value) {
            addCriterion("EXPIRE_TIME >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXPIRE_TIME >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(String value) {
            addCriterion("EXPIRE_TIME <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(String value) {
            addCriterion("EXPIRE_TIME <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLike(String value) {
            addCriterion("EXPIRE_TIME like", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotLike(String value) {
            addCriterion("EXPIRE_TIME not like", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<String> values) {
            addCriterion("EXPIRE_TIME in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<String> values) {
            addCriterion("EXPIRE_TIME not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(String value1, String value2) {
            addCriterion("EXPIRE_TIME between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(String value1, String value2) {
            addCriterion("EXPIRE_TIME not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdIsNull() {
            addCriterion("SHANGJIAINFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdIsNotNull() {
            addCriterion("SHANGJIAINFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID =", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdNotEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID <>", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdGreaterThan(Integer value) {
            addCriterion("SHANGJIAINFO_ID >", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID >=", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdLessThan(Integer value) {
            addCriterion("SHANGJIAINFO_ID <", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID <=", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdIn(List<Integer> values) {
            addCriterion("SHANGJIAINFO_ID in", values, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdNotIn(List<Integer> values) {
            addCriterion("SHANGJIAINFO_ID not in", values, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdBetween(Integer value1, Integer value2) {
            addCriterion("SHANGJIAINFO_ID between", value1, value2, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SHANGJIAINFO_ID not between", value1, value2, "shangjiainfoId");
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