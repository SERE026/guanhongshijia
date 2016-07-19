package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class ActiveMemberInfoModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActiveMemberInfoModelCriteriaBuilder() {
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

        public Criteria andLevIsNull() {
            addCriterion("LEV is null");
            return (Criteria) this;
        }

        public Criteria andLevIsNotNull() {
            addCriterion("LEV is not null");
            return (Criteria) this;
        }

        public Criteria andLevEqualTo(Integer value) {
            addCriterion("LEV =", value, "lev");
            return (Criteria) this;
        }

        public Criteria andLevNotEqualTo(Integer value) {
            addCriterion("LEV <>", value, "lev");
            return (Criteria) this;
        }

        public Criteria andLevGreaterThan(Integer value) {
            addCriterion("LEV >", value, "lev");
            return (Criteria) this;
        }

        public Criteria andLevGreaterThanOrEqualTo(Integer value) {
            addCriterion("LEV >=", value, "lev");
            return (Criteria) this;
        }

        public Criteria andLevLessThan(Integer value) {
            addCriterion("LEV <", value, "lev");
            return (Criteria) this;
        }

        public Criteria andLevLessThanOrEqualTo(Integer value) {
            addCriterion("LEV <=", value, "lev");
            return (Criteria) this;
        }

        public Criteria andLevIn(List<Integer> values) {
            addCriterion("LEV in", values, "lev");
            return (Criteria) this;
        }

        public Criteria andLevNotIn(List<Integer> values) {
            addCriterion("LEV not in", values, "lev");
            return (Criteria) this;
        }

        public Criteria andLevBetween(Integer value1, Integer value2) {
            addCriterion("LEV between", value1, value2, "lev");
            return (Criteria) this;
        }

        public Criteria andLevNotBetween(Integer value1, Integer value2) {
            addCriterion("LEV not between", value1, value2, "lev");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMeberIdIsNull() {
            addCriterion("MEBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMeberIdIsNotNull() {
            addCriterion("MEBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMeberIdEqualTo(Integer value) {
            addCriterion("MEBER_ID =", value, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdNotEqualTo(Integer value) {
            addCriterion("MEBER_ID <>", value, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdGreaterThan(Integer value) {
            addCriterion("MEBER_ID >", value, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MEBER_ID >=", value, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdLessThan(Integer value) {
            addCriterion("MEBER_ID <", value, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdLessThanOrEqualTo(Integer value) {
            addCriterion("MEBER_ID <=", value, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdIn(List<Integer> values) {
            addCriterion("MEBER_ID in", values, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdNotIn(List<Integer> values) {
            addCriterion("MEBER_ID not in", values, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdBetween(Integer value1, Integer value2) {
            addCriterion("MEBER_ID between", value1, value2, "meberId");
            return (Criteria) this;
        }

        public Criteria andMeberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MEBER_ID not between", value1, value2, "meberId");
            return (Criteria) this;
        }

        public Criteria andActIdIsNull() {
            addCriterion("ACT_ID is null");
            return (Criteria) this;
        }

        public Criteria andActIdIsNotNull() {
            addCriterion("ACT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActIdEqualTo(Integer value) {
            addCriterion("ACT_ID =", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotEqualTo(Integer value) {
            addCriterion("ACT_ID <>", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThan(Integer value) {
            addCriterion("ACT_ID >", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACT_ID >=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThan(Integer value) {
            addCriterion("ACT_ID <", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACT_ID <=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdIn(List<Integer> values) {
            addCriterion("ACT_ID in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotIn(List<Integer> values) {
            addCriterion("ACT_ID not in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdBetween(Integer value1, Integer value2) {
            addCriterion("ACT_ID between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACT_ID not between", value1, value2, "actId");
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

        public Criteria andDateIsNull() {
            addCriterion("DATE is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("DATE =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("DATE <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("DATE >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("DATE >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("DATE <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("DATE <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("DATE like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("DATE not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("DATE in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("DATE not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("DATE between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("DATE not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andPsIsNull() {
            addCriterion("PS is null");
            return (Criteria) this;
        }

        public Criteria andPsIsNotNull() {
            addCriterion("PS is not null");
            return (Criteria) this;
        }

        public Criteria andPsEqualTo(String value) {
            addCriterion("PS =", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotEqualTo(String value) {
            addCriterion("PS <>", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThan(String value) {
            addCriterion("PS >", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThanOrEqualTo(String value) {
            addCriterion("PS >=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThan(String value) {
            addCriterion("PS <", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThanOrEqualTo(String value) {
            addCriterion("PS <=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLike(String value) {
            addCriterion("PS like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotLike(String value) {
            addCriterion("PS not like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsIn(List<String> values) {
            addCriterion("PS in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotIn(List<String> values) {
            addCriterion("PS not in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsBetween(String value1, String value2) {
            addCriterion("PS between", value1, value2, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotBetween(String value1, String value2) {
            addCriterion("PS not between", value1, value2, "ps");
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