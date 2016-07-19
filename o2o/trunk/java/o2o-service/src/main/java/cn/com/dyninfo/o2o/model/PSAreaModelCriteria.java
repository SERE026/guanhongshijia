package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class PSAreaModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public PSAreaModelCriteria() {
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

        public Criteria andAreanmaeIsNull() {
            addCriterion("AREANMAE is null");
            return (Criteria) this;
        }

        public Criteria andAreanmaeIsNotNull() {
            addCriterion("AREANMAE is not null");
            return (Criteria) this;
        }

        public Criteria andAreanmaeEqualTo(String value) {
            addCriterion("AREANMAE =", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotEqualTo(String value) {
            addCriterion("AREANMAE <>", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeGreaterThan(String value) {
            addCriterion("AREANMAE >", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeGreaterThanOrEqualTo(String value) {
            addCriterion("AREANMAE >=", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeLessThan(String value) {
            addCriterion("AREANMAE <", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeLessThanOrEqualTo(String value) {
            addCriterion("AREANMAE <=", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeLike(String value) {
            addCriterion("AREANMAE like", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotLike(String value) {
            addCriterion("AREANMAE not like", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeIn(List<String> values) {
            addCriterion("AREANMAE in", values, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotIn(List<String> values) {
            addCriterion("AREANMAE not in", values, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeBetween(String value1, String value2) {
            addCriterion("AREANMAE between", value1, value2, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotBetween(String value1, String value2) {
            addCriterion("AREANMAE not between", value1, value2, "areanmae");
            return (Criteria) this;
        }

        public Criteria andMrscfrIsNull() {
            addCriterion("MRSCFR is null");
            return (Criteria) this;
        }

        public Criteria andMrscfrIsNotNull() {
            addCriterion("MRSCFR is not null");
            return (Criteria) this;
        }

        public Criteria andMrscfrEqualTo(Double value) {
            addCriterion("MRSCFR =", value, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrNotEqualTo(Double value) {
            addCriterion("MRSCFR <>", value, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrGreaterThan(Double value) {
            addCriterion("MRSCFR >", value, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrGreaterThanOrEqualTo(Double value) {
            addCriterion("MRSCFR >=", value, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrLessThan(Double value) {
            addCriterion("MRSCFR <", value, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrLessThanOrEqualTo(Double value) {
            addCriterion("MRSCFR <=", value, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrIn(List<Double> values) {
            addCriterion("MRSCFR in", values, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrNotIn(List<Double> values) {
            addCriterion("MRSCFR not in", values, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrBetween(Double value1, Double value2) {
            addCriterion("MRSCFR between", value1, value2, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrscfrNotBetween(Double value1, Double value2) {
            addCriterion("MRSCFR not between", value1, value2, "mrscfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrIsNull() {
            addCriterion("MRXZFR is null");
            return (Criteria) this;
        }

        public Criteria andMrxzfrIsNotNull() {
            addCriterion("MRXZFR is not null");
            return (Criteria) this;
        }

        public Criteria andMrxzfrEqualTo(Double value) {
            addCriterion("MRXZFR =", value, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrNotEqualTo(Double value) {
            addCriterion("MRXZFR <>", value, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrGreaterThan(Double value) {
            addCriterion("MRXZFR >", value, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrGreaterThanOrEqualTo(Double value) {
            addCriterion("MRXZFR >=", value, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrLessThan(Double value) {
            addCriterion("MRXZFR <", value, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrLessThanOrEqualTo(Double value) {
            addCriterion("MRXZFR <=", value, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrIn(List<Double> values) {
            addCriterion("MRXZFR in", values, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrNotIn(List<Double> values) {
            addCriterion("MRXZFR not in", values, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrBetween(Double value1, Double value2) {
            addCriterion("MRXZFR between", value1, value2, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andMrxzfrNotBetween(Double value1, Double value2) {
            addCriterion("MRXZFR not between", value1, value2, "mrxzfr");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("PAYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("PAYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(String value) {
            addCriterion("PAYTYPE =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(String value) {
            addCriterion("PAYTYPE <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(String value) {
            addCriterion("PAYTYPE >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYTYPE >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(String value) {
            addCriterion("PAYTYPE <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(String value) {
            addCriterion("PAYTYPE <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLike(String value) {
            addCriterion("PAYTYPE like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotLike(String value) {
            addCriterion("PAYTYPE not like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<String> values) {
            addCriterion("PAYTYPE in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<String> values) {
            addCriterion("PAYTYPE not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(String value1, String value2) {
            addCriterion("PAYTYPE between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(String value1, String value2) {
            addCriterion("PAYTYPE not between", value1, value2, "paytype");
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