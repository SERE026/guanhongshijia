package cn.com.dyninfo.o2o.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponModelCriteriaBuilder() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BEGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BEGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("BEGIN_TIME =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("BEGIN_TIME <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("BEGIN_TIME >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("BEGIN_TIME <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("BEGIN_TIME <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("BEGIN_TIME in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("BEGIN_TIME not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
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

        public Criteria andTypeEqualTo(Boolean value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Boolean value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Boolean value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Boolean value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Boolean> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Boolean> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReduceValueIsNull() {
            addCriterion("REDUCE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andReduceValueIsNotNull() {
            addCriterion("REDUCE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andReduceValueEqualTo(BigDecimal value) {
            addCriterion("REDUCE_VALUE =", value, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueNotEqualTo(BigDecimal value) {
            addCriterion("REDUCE_VALUE <>", value, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueGreaterThan(BigDecimal value) {
            addCriterion("REDUCE_VALUE >", value, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_VALUE >=", value, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueLessThan(BigDecimal value) {
            addCriterion("REDUCE_VALUE <", value, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_VALUE <=", value, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueIn(List<BigDecimal> values) {
            addCriterion("REDUCE_VALUE in", values, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueNotIn(List<BigDecimal> values) {
            addCriterion("REDUCE_VALUE not in", values, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_VALUE between", value1, value2, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andReduceValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_VALUE not between", value1, value2, "reduceValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueIsNull() {
            addCriterion("DISCOUNT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDiscountValueIsNotNull() {
            addCriterion("DISCOUNT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountValueEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE =", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueNotEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE <>", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueGreaterThan(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE >", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE >=", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueLessThan(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE <", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT_VALUE <=", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueIn(List<BigDecimal> values) {
            addCriterion("DISCOUNT_VALUE in", values, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueNotIn(List<BigDecimal> values) {
            addCriterion("DISCOUNT_VALUE not in", values, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISCOUNT_VALUE between", value1, value2, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISCOUNT_VALUE not between", value1, value2, "discountValue");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontIsNull() {
            addCriterion("MAX_AMOUONT is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontIsNotNull() {
            addCriterion("MAX_AMOUONT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontEqualTo(BigDecimal value) {
            addCriterion("MAX_AMOUONT =", value, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontNotEqualTo(BigDecimal value) {
            addCriterion("MAX_AMOUONT <>", value, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontGreaterThan(BigDecimal value) {
            addCriterion("MAX_AMOUONT >", value, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_AMOUONT >=", value, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontLessThan(BigDecimal value) {
            addCriterion("MAX_AMOUONT <", value, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_AMOUONT <=", value, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontIn(List<BigDecimal> values) {
            addCriterion("MAX_AMOUONT in", values, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontNotIn(List<BigDecimal> values) {
            addCriterion("MAX_AMOUONT not in", values, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_AMOUONT between", value1, value2, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andMaxAmouontNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_AMOUONT not between", value1, value2, "maxAmouont");
            return (Criteria) this;
        }

        public Criteria andConstraintValueIsNull() {
            addCriterion("CONSTRAINT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andConstraintValueIsNotNull() {
            addCriterion("CONSTRAINT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintValueEqualTo(BigDecimal value) {
            addCriterion("CONSTRAINT_VALUE =", value, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueNotEqualTo(BigDecimal value) {
            addCriterion("CONSTRAINT_VALUE <>", value, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueGreaterThan(BigDecimal value) {
            addCriterion("CONSTRAINT_VALUE >", value, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONSTRAINT_VALUE >=", value, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueLessThan(BigDecimal value) {
            addCriterion("CONSTRAINT_VALUE <", value, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONSTRAINT_VALUE <=", value, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueIn(List<BigDecimal> values) {
            addCriterion("CONSTRAINT_VALUE in", values, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueNotIn(List<BigDecimal> values) {
            addCriterion("CONSTRAINT_VALUE not in", values, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONSTRAINT_VALUE between", value1, value2, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andConstraintValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONSTRAINT_VALUE not between", value1, value2, "constraintValue");
            return (Criteria) this;
        }

        public Criteria andSameUseIsNull() {
            addCriterion("SAME_USE is null");
            return (Criteria) this;
        }

        public Criteria andSameUseIsNotNull() {
            addCriterion("SAME_USE is not null");
            return (Criteria) this;
        }

        public Criteria andSameUseEqualTo(Boolean value) {
            addCriterion("SAME_USE =", value, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseNotEqualTo(Boolean value) {
            addCriterion("SAME_USE <>", value, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseGreaterThan(Boolean value) {
            addCriterion("SAME_USE >", value, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("SAME_USE >=", value, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseLessThan(Boolean value) {
            addCriterion("SAME_USE <", value, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseLessThanOrEqualTo(Boolean value) {
            addCriterion("SAME_USE <=", value, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseIn(List<Boolean> values) {
            addCriterion("SAME_USE in", values, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseNotIn(List<Boolean> values) {
            addCriterion("SAME_USE not in", values, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseBetween(Boolean value1, Boolean value2) {
            addCriterion("SAME_USE between", value1, value2, "sameUse");
            return (Criteria) this;
        }

        public Criteria andSameUseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("SAME_USE not between", value1, value2, "sameUse");
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