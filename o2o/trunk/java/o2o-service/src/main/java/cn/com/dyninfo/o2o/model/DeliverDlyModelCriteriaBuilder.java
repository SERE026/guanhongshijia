package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class DeliverDlyModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliverDlyModelCriteriaBuilder() {
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

        public Criteria andDeliverIdIsNull() {
            addCriterion("DELIVER_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeliverIdIsNotNull() {
            addCriterion("DELIVER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverIdEqualTo(Integer value) {
            addCriterion("DELIVER_ID =", value, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdNotEqualTo(Integer value) {
            addCriterion("DELIVER_ID <>", value, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdGreaterThan(Integer value) {
            addCriterion("DELIVER_ID >", value, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELIVER_ID >=", value, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdLessThan(Integer value) {
            addCriterion("DELIVER_ID <", value, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdLessThanOrEqualTo(Integer value) {
            addCriterion("DELIVER_ID <=", value, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdIn(List<Integer> values) {
            addCriterion("DELIVER_ID in", values, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdNotIn(List<Integer> values) {
            addCriterion("DELIVER_ID not in", values, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdBetween(Integer value1, Integer value2) {
            addCriterion("DELIVER_ID between", value1, value2, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDeliverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DELIVER_ID not between", value1, value2, "deliverId");
            return (Criteria) this;
        }

        public Criteria andDlyIdIsNull() {
            addCriterion("DLY_ID is null");
            return (Criteria) this;
        }

        public Criteria andDlyIdIsNotNull() {
            addCriterion("DLY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDlyIdEqualTo(Integer value) {
            addCriterion("DLY_ID =", value, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdNotEqualTo(Integer value) {
            addCriterion("DLY_ID <>", value, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdGreaterThan(Integer value) {
            addCriterion("DLY_ID >", value, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DLY_ID >=", value, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdLessThan(Integer value) {
            addCriterion("DLY_ID <", value, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdLessThanOrEqualTo(Integer value) {
            addCriterion("DLY_ID <=", value, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdIn(List<Integer> values) {
            addCriterion("DLY_ID in", values, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdNotIn(List<Integer> values) {
            addCriterion("DLY_ID not in", values, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdBetween(Integer value1, Integer value2) {
            addCriterion("DLY_ID between", value1, value2, "dlyId");
            return (Criteria) this;
        }

        public Criteria andDlyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DLY_ID not between", value1, value2, "dlyId");
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