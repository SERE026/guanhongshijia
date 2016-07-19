package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class ResControlRelModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResControlRelModelCriteriaBuilder() {
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

        public Criteria andAccessobjIsNull() {
            addCriterion("ACCESSOBJ is null");
            return (Criteria) this;
        }

        public Criteria andAccessobjIsNotNull() {
            addCriterion("ACCESSOBJ is not null");
            return (Criteria) this;
        }

        public Criteria andAccessobjEqualTo(String value) {
            addCriterion("ACCESSOBJ =", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjNotEqualTo(String value) {
            addCriterion("ACCESSOBJ <>", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjGreaterThan(String value) {
            addCriterion("ACCESSOBJ >", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESSOBJ >=", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjLessThan(String value) {
            addCriterion("ACCESSOBJ <", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjLessThanOrEqualTo(String value) {
            addCriterion("ACCESSOBJ <=", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjLike(String value) {
            addCriterion("ACCESSOBJ like", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjNotLike(String value) {
            addCriterion("ACCESSOBJ not like", value, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjIn(List<String> values) {
            addCriterion("ACCESSOBJ in", values, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjNotIn(List<String> values) {
            addCriterion("ACCESSOBJ not in", values, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjBetween(String value1, String value2) {
            addCriterion("ACCESSOBJ between", value1, value2, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccessobjNotBetween(String value1, String value2) {
            addCriterion("ACCESSOBJ not between", value1, value2, "accessobj");
            return (Criteria) this;
        }

        public Criteria andAccesstypeIsNull() {
            addCriterion("ACCESSTYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccesstypeIsNotNull() {
            addCriterion("ACCESSTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccesstypeEqualTo(String value) {
            addCriterion("ACCESSTYPE =", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotEqualTo(String value) {
            addCriterion("ACCESSTYPE <>", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeGreaterThan(String value) {
            addCriterion("ACCESSTYPE >", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESSTYPE >=", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeLessThan(String value) {
            addCriterion("ACCESSTYPE <", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeLessThanOrEqualTo(String value) {
            addCriterion("ACCESSTYPE <=", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeLike(String value) {
            addCriterion("ACCESSTYPE like", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotLike(String value) {
            addCriterion("ACCESSTYPE not like", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeIn(List<String> values) {
            addCriterion("ACCESSTYPE in", values, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotIn(List<String> values) {
            addCriterion("ACCESSTYPE not in", values, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeBetween(String value1, String value2) {
            addCriterion("ACCESSTYPE between", value1, value2, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotBetween(String value1, String value2) {
            addCriterion("ACCESSTYPE not between", value1, value2, "accesstype");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("GROUP_ID like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("GROUP_ID not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andRcIdIsNull() {
            addCriterion("RC_ID is null");
            return (Criteria) this;
        }

        public Criteria andRcIdIsNotNull() {
            addCriterion("RC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRcIdEqualTo(String value) {
            addCriterion("RC_ID =", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotEqualTo(String value) {
            addCriterion("RC_ID <>", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdGreaterThan(String value) {
            addCriterion("RC_ID >", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdGreaterThanOrEqualTo(String value) {
            addCriterion("RC_ID >=", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdLessThan(String value) {
            addCriterion("RC_ID <", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdLessThanOrEqualTo(String value) {
            addCriterion("RC_ID <=", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdLike(String value) {
            addCriterion("RC_ID like", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotLike(String value) {
            addCriterion("RC_ID not like", value, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdIn(List<String> values) {
            addCriterion("RC_ID in", values, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotIn(List<String> values) {
            addCriterion("RC_ID not in", values, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdBetween(String value1, String value2) {
            addCriterion("RC_ID between", value1, value2, "rcId");
            return (Criteria) this;
        }

        public Criteria andRcIdNotBetween(String value1, String value2) {
            addCriterion("RC_ID not between", value1, value2, "rcId");
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