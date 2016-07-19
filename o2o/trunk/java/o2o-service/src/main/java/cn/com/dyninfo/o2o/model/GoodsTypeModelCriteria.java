package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsTypeModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public GoodsTypeModelCriteria() {
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

        public Criteria andLinkbrankIsNull() {
            addCriterion("LINKBRANK is null");
            return (Criteria) this;
        }

        public Criteria andLinkbrankIsNotNull() {
            addCriterion("LINKBRANK is not null");
            return (Criteria) this;
        }

        public Criteria andLinkbrankEqualTo(String value) {
            addCriterion("LINKBRANK =", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankNotEqualTo(String value) {
            addCriterion("LINKBRANK <>", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankGreaterThan(String value) {
            addCriterion("LINKBRANK >", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankGreaterThanOrEqualTo(String value) {
            addCriterion("LINKBRANK >=", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankLessThan(String value) {
            addCriterion("LINKBRANK <", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankLessThanOrEqualTo(String value) {
            addCriterion("LINKBRANK <=", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankLike(String value) {
            addCriterion("LINKBRANK like", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankNotLike(String value) {
            addCriterion("LINKBRANK not like", value, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankIn(List<String> values) {
            addCriterion("LINKBRANK in", values, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankNotIn(List<String> values) {
            addCriterion("LINKBRANK not in", values, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankBetween(String value1, String value2) {
            addCriterion("LINKBRANK between", value1, value2, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andLinkbrankNotBetween(String value1, String value2) {
            addCriterion("LINKBRANK not between", value1, value2, "linkbrank");
            return (Criteria) this;
        }

        public Criteria andOwnspecIsNull() {
            addCriterion("OWNSPEC is null");
            return (Criteria) this;
        }

        public Criteria andOwnspecIsNotNull() {
            addCriterion("OWNSPEC is not null");
            return (Criteria) this;
        }

        public Criteria andOwnspecEqualTo(String value) {
            addCriterion("OWNSPEC =", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecNotEqualTo(String value) {
            addCriterion("OWNSPEC <>", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecGreaterThan(String value) {
            addCriterion("OWNSPEC >", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecGreaterThanOrEqualTo(String value) {
            addCriterion("OWNSPEC >=", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecLessThan(String value) {
            addCriterion("OWNSPEC <", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecLessThanOrEqualTo(String value) {
            addCriterion("OWNSPEC <=", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecLike(String value) {
            addCriterion("OWNSPEC like", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecNotLike(String value) {
            addCriterion("OWNSPEC not like", value, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecIn(List<String> values) {
            addCriterion("OWNSPEC in", values, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecNotIn(List<String> values) {
            addCriterion("OWNSPEC not in", values, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecBetween(String value1, String value2) {
            addCriterion("OWNSPEC between", value1, value2, "ownspec");
            return (Criteria) this;
        }

        public Criteria andOwnspecNotBetween(String value1, String value2) {
            addCriterion("OWNSPEC not between", value1, value2, "ownspec");
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