package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class FindPasswordModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public FindPasswordModelCriteria() {
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

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andFindtimeIsNull() {
            addCriterion("FINDTIME is null");
            return (Criteria) this;
        }

        public Criteria andFindtimeIsNotNull() {
            addCriterion("FINDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFindtimeEqualTo(String value) {
            addCriterion("FINDTIME =", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotEqualTo(String value) {
            addCriterion("FINDTIME <>", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeGreaterThan(String value) {
            addCriterion("FINDTIME >", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeGreaterThanOrEqualTo(String value) {
            addCriterion("FINDTIME >=", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLessThan(String value) {
            addCriterion("FINDTIME <", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLessThanOrEqualTo(String value) {
            addCriterion("FINDTIME <=", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLike(String value) {
            addCriterion("FINDTIME like", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotLike(String value) {
            addCriterion("FINDTIME not like", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeIn(List<String> values) {
            addCriterion("FINDTIME in", values, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotIn(List<String> values) {
            addCriterion("FINDTIME not in", values, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeBetween(String value1, String value2) {
            addCriterion("FINDTIME between", value1, value2, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotBetween(String value1, String value2) {
            addCriterion("FINDTIME not between", value1, value2, "findtime");
            return (Criteria) this;
        }

        public Criteria andEditstatIsNull() {
            addCriterion("EDITSTAT is null");
            return (Criteria) this;
        }

        public Criteria andEditstatIsNotNull() {
            addCriterion("EDITSTAT is not null");
            return (Criteria) this;
        }

        public Criteria andEditstatEqualTo(String value) {
            addCriterion("EDITSTAT =", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatNotEqualTo(String value) {
            addCriterion("EDITSTAT <>", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatGreaterThan(String value) {
            addCriterion("EDITSTAT >", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatGreaterThanOrEqualTo(String value) {
            addCriterion("EDITSTAT >=", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatLessThan(String value) {
            addCriterion("EDITSTAT <", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatLessThanOrEqualTo(String value) {
            addCriterion("EDITSTAT <=", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatLike(String value) {
            addCriterion("EDITSTAT like", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatNotLike(String value) {
            addCriterion("EDITSTAT not like", value, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatIn(List<String> values) {
            addCriterion("EDITSTAT in", values, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatNotIn(List<String> values) {
            addCriterion("EDITSTAT not in", values, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatBetween(String value1, String value2) {
            addCriterion("EDITSTAT between", value1, value2, "editstat");
            return (Criteria) this;
        }

        public Criteria andEditstatNotBetween(String value1, String value2) {
            addCriterion("EDITSTAT not between", value1, value2, "editstat");
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