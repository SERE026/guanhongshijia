package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class OgnzInfoModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public OgnzInfoModelCriteria() {
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

        public Criteria andIndexOrderIsNull() {
            addCriterion("INDEX_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIsNotNull() {
            addCriterion("INDEX_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andIndexOrderEqualTo(Integer value) {
            addCriterion("INDEX_ORDER =", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotEqualTo(Integer value) {
            addCriterion("INDEX_ORDER <>", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderGreaterThan(Integer value) {
            addCriterion("INDEX_ORDER >", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("INDEX_ORDER >=", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLessThan(Integer value) {
            addCriterion("INDEX_ORDER <", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLessThanOrEqualTo(Integer value) {
            addCriterion("INDEX_ORDER <=", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIn(List<Integer> values) {
            addCriterion("INDEX_ORDER in", values, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotIn(List<Integer> values) {
            addCriterion("INDEX_ORDER not in", values, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_ORDER between", value1, value2, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_ORDER not between", value1, value2, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIsusedIsNull() {
            addCriterion("ISUSED is null");
            return (Criteria) this;
        }

        public Criteria andIsusedIsNotNull() {
            addCriterion("ISUSED is not null");
            return (Criteria) this;
        }

        public Criteria andIsusedEqualTo(String value) {
            addCriterion("ISUSED =", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotEqualTo(String value) {
            addCriterion("ISUSED <>", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedGreaterThan(String value) {
            addCriterion("ISUSED >", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedGreaterThanOrEqualTo(String value) {
            addCriterion("ISUSED >=", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLessThan(String value) {
            addCriterion("ISUSED <", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLessThanOrEqualTo(String value) {
            addCriterion("ISUSED <=", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLike(String value) {
            addCriterion("ISUSED like", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotLike(String value) {
            addCriterion("ISUSED not like", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedIn(List<String> values) {
            addCriterion("ISUSED in", values, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotIn(List<String> values) {
            addCriterion("ISUSED not in", values, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedBetween(String value1, String value2) {
            addCriterion("ISUSED between", value1, value2, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotBetween(String value1, String value2) {
            addCriterion("ISUSED not between", value1, value2, "isused");
            return (Criteria) this;
        }

        public Criteria andIsognzIsNull() {
            addCriterion("ISOGNZ is null");
            return (Criteria) this;
        }

        public Criteria andIsognzIsNotNull() {
            addCriterion("ISOGNZ is not null");
            return (Criteria) this;
        }

        public Criteria andIsognzEqualTo(String value) {
            addCriterion("ISOGNZ =", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzNotEqualTo(String value) {
            addCriterion("ISOGNZ <>", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzGreaterThan(String value) {
            addCriterion("ISOGNZ >", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzGreaterThanOrEqualTo(String value) {
            addCriterion("ISOGNZ >=", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzLessThan(String value) {
            addCriterion("ISOGNZ <", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzLessThanOrEqualTo(String value) {
            addCriterion("ISOGNZ <=", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzLike(String value) {
            addCriterion("ISOGNZ like", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzNotLike(String value) {
            addCriterion("ISOGNZ not like", value, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzIn(List<String> values) {
            addCriterion("ISOGNZ in", values, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzNotIn(List<String> values) {
            addCriterion("ISOGNZ not in", values, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzBetween(String value1, String value2) {
            addCriterion("ISOGNZ between", value1, value2, "isognz");
            return (Criteria) this;
        }

        public Criteria andIsognzNotBetween(String value1, String value2) {
            addCriterion("ISOGNZ not between", value1, value2, "isognz");
            return (Criteria) this;
        }

        public Criteria andOgnzNameIsNull() {
            addCriterion("OGNZ_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOgnzNameIsNotNull() {
            addCriterion("OGNZ_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOgnzNameEqualTo(String value) {
            addCriterion("OGNZ_NAME =", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameNotEqualTo(String value) {
            addCriterion("OGNZ_NAME <>", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameGreaterThan(String value) {
            addCriterion("OGNZ_NAME >", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameGreaterThanOrEqualTo(String value) {
            addCriterion("OGNZ_NAME >=", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameLessThan(String value) {
            addCriterion("OGNZ_NAME <", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameLessThanOrEqualTo(String value) {
            addCriterion("OGNZ_NAME <=", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameLike(String value) {
            addCriterion("OGNZ_NAME like", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameNotLike(String value) {
            addCriterion("OGNZ_NAME not like", value, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameIn(List<String> values) {
            addCriterion("OGNZ_NAME in", values, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameNotIn(List<String> values) {
            addCriterion("OGNZ_NAME not in", values, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameBetween(String value1, String value2) {
            addCriterion("OGNZ_NAME between", value1, value2, "ognzName");
            return (Criteria) this;
        }

        public Criteria andOgnzNameNotBetween(String value1, String value2) {
            addCriterion("OGNZ_NAME not between", value1, value2, "ognzName");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
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