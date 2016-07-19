package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class ShowGoodModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShowGoodModelCriteriaBuilder() {
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

        public Criteria andShowGoodIdIsNull() {
            addCriterion("SHOW_GOOD_ID is null");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdIsNotNull() {
            addCriterion("SHOW_GOOD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdEqualTo(String value) {
            addCriterion("SHOW_GOOD_ID =", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdNotEqualTo(String value) {
            addCriterion("SHOW_GOOD_ID <>", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdGreaterThan(String value) {
            addCriterion("SHOW_GOOD_ID >", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOW_GOOD_ID >=", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdLessThan(String value) {
            addCriterion("SHOW_GOOD_ID <", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdLessThanOrEqualTo(String value) {
            addCriterion("SHOW_GOOD_ID <=", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdLike(String value) {
            addCriterion("SHOW_GOOD_ID like", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdNotLike(String value) {
            addCriterion("SHOW_GOOD_ID not like", value, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdIn(List<String> values) {
            addCriterion("SHOW_GOOD_ID in", values, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdNotIn(List<String> values) {
            addCriterion("SHOW_GOOD_ID not in", values, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdBetween(String value1, String value2) {
            addCriterion("SHOW_GOOD_ID between", value1, value2, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andShowGoodIdNotBetween(String value1, String value2) {
            addCriterion("SHOW_GOOD_ID not between", value1, value2, "showGoodId");
            return (Criteria) this;
        }

        public Criteria andClinetIdIsNull() {
            addCriterion("CLINET_ID is null");
            return (Criteria) this;
        }

        public Criteria andClinetIdIsNotNull() {
            addCriterion("CLINET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClinetIdEqualTo(String value) {
            addCriterion("CLINET_ID =", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdNotEqualTo(String value) {
            addCriterion("CLINET_ID <>", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdGreaterThan(String value) {
            addCriterion("CLINET_ID >", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdGreaterThanOrEqualTo(String value) {
            addCriterion("CLINET_ID >=", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdLessThan(String value) {
            addCriterion("CLINET_ID <", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdLessThanOrEqualTo(String value) {
            addCriterion("CLINET_ID <=", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdLike(String value) {
            addCriterion("CLINET_ID like", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdNotLike(String value) {
            addCriterion("CLINET_ID not like", value, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdIn(List<String> values) {
            addCriterion("CLINET_ID in", values, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdNotIn(List<String> values) {
            addCriterion("CLINET_ID not in", values, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdBetween(String value1, String value2) {
            addCriterion("CLINET_ID between", value1, value2, "clinetId");
            return (Criteria) this;
        }

        public Criteria andClinetIdNotBetween(String value1, String value2) {
            addCriterion("CLINET_ID not between", value1, value2, "clinetId");
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

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("TIME not between", value1, value2, "time");
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