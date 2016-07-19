package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class DlyTypeModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DlyTypeModelCriteriaBuilder() {
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

        public Criteria andDlynmaeIsNull() {
            addCriterion("DLYNMAE is null");
            return (Criteria) this;
        }

        public Criteria andDlynmaeIsNotNull() {
            addCriterion("DLYNMAE is not null");
            return (Criteria) this;
        }

        public Criteria andDlynmaeEqualTo(String value) {
            addCriterion("DLYNMAE =", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeNotEqualTo(String value) {
            addCriterion("DLYNMAE <>", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeGreaterThan(String value) {
            addCriterion("DLYNMAE >", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeGreaterThanOrEqualTo(String value) {
            addCriterion("DLYNMAE >=", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeLessThan(String value) {
            addCriterion("DLYNMAE <", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeLessThanOrEqualTo(String value) {
            addCriterion("DLYNMAE <=", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeLike(String value) {
            addCriterion("DLYNMAE like", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeNotLike(String value) {
            addCriterion("DLYNMAE not like", value, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeIn(List<String> values) {
            addCriterion("DLYNMAE in", values, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeNotIn(List<String> values) {
            addCriterion("DLYNMAE not in", values, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeBetween(String value1, String value2) {
            addCriterion("DLYNMAE between", value1, value2, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andDlynmaeNotBetween(String value1, String value2) {
            addCriterion("DLYNMAE not between", value1, value2, "dlynmae");
            return (Criteria) this;
        }

        public Criteria andFirstwtIsNull() {
            addCriterion("FIRSTWT is null");
            return (Criteria) this;
        }

        public Criteria andFirstwtIsNotNull() {
            addCriterion("FIRSTWT is not null");
            return (Criteria) this;
        }

        public Criteria andFirstwtEqualTo(Double value) {
            addCriterion("FIRSTWT =", value, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtNotEqualTo(Double value) {
            addCriterion("FIRSTWT <>", value, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtGreaterThan(Double value) {
            addCriterion("FIRSTWT >", value, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtGreaterThanOrEqualTo(Double value) {
            addCriterion("FIRSTWT >=", value, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtLessThan(Double value) {
            addCriterion("FIRSTWT <", value, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtLessThanOrEqualTo(Double value) {
            addCriterion("FIRSTWT <=", value, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtIn(List<Double> values) {
            addCriterion("FIRSTWT in", values, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtNotIn(List<Double> values) {
            addCriterion("FIRSTWT not in", values, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtBetween(Double value1, Double value2) {
            addCriterion("FIRSTWT between", value1, value2, "firstwt");
            return (Criteria) this;
        }

        public Criteria andFirstwtNotBetween(Double value1, Double value2) {
            addCriterion("FIRSTWT not between", value1, value2, "firstwt");
            return (Criteria) this;
        }

        public Criteria andAddwtIsNull() {
            addCriterion("ADDWT is null");
            return (Criteria) this;
        }

        public Criteria andAddwtIsNotNull() {
            addCriterion("ADDWT is not null");
            return (Criteria) this;
        }

        public Criteria andAddwtEqualTo(Double value) {
            addCriterion("ADDWT =", value, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtNotEqualTo(Double value) {
            addCriterion("ADDWT <>", value, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtGreaterThan(Double value) {
            addCriterion("ADDWT >", value, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtGreaterThanOrEqualTo(Double value) {
            addCriterion("ADDWT >=", value, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtLessThan(Double value) {
            addCriterion("ADDWT <", value, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtLessThanOrEqualTo(Double value) {
            addCriterion("ADDWT <=", value, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtIn(List<Double> values) {
            addCriterion("ADDWT in", values, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtNotIn(List<Double> values) {
            addCriterion("ADDWT not in", values, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtBetween(Double value1, Double value2) {
            addCriterion("ADDWT between", value1, value2, "addwt");
            return (Criteria) this;
        }

        public Criteria andAddwtNotBetween(Double value1, Double value2) {
            addCriterion("ADDWT not between", value1, value2, "addwt");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyIsNull() {
            addCriterion("FIRSTMONEY is null");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyIsNotNull() {
            addCriterion("FIRSTMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyEqualTo(Double value) {
            addCriterion("FIRSTMONEY =", value, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyNotEqualTo(Double value) {
            addCriterion("FIRSTMONEY <>", value, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyGreaterThan(Double value) {
            addCriterion("FIRSTMONEY >", value, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("FIRSTMONEY >=", value, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyLessThan(Double value) {
            addCriterion("FIRSTMONEY <", value, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyLessThanOrEqualTo(Double value) {
            addCriterion("FIRSTMONEY <=", value, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyIn(List<Double> values) {
            addCriterion("FIRSTMONEY in", values, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyNotIn(List<Double> values) {
            addCriterion("FIRSTMONEY not in", values, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyBetween(Double value1, Double value2) {
            addCriterion("FIRSTMONEY between", value1, value2, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andFirstmoneyNotBetween(Double value1, Double value2) {
            addCriterion("FIRSTMONEY not between", value1, value2, "firstmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyIsNull() {
            addCriterion("ADDWTMONEY is null");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyIsNotNull() {
            addCriterion("ADDWTMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyEqualTo(Double value) {
            addCriterion("ADDWTMONEY =", value, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyNotEqualTo(Double value) {
            addCriterion("ADDWTMONEY <>", value, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyGreaterThan(Double value) {
            addCriterion("ADDWTMONEY >", value, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("ADDWTMONEY >=", value, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyLessThan(Double value) {
            addCriterion("ADDWTMONEY <", value, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyLessThanOrEqualTo(Double value) {
            addCriterion("ADDWTMONEY <=", value, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyIn(List<Double> values) {
            addCriterion("ADDWTMONEY in", values, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyNotIn(List<Double> values) {
            addCriterion("ADDWTMONEY not in", values, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyBetween(Double value1, Double value2) {
            addCriterion("ADDWTMONEY between", value1, value2, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andAddwtmoneyNotBetween(Double value1, Double value2) {
            addCriterion("ADDWTMONEY not between", value1, value2, "addwtmoney");
            return (Criteria) this;
        }

        public Criteria andBjflIsNull() {
            addCriterion("BJFL is null");
            return (Criteria) this;
        }

        public Criteria andBjflIsNotNull() {
            addCriterion("BJFL is not null");
            return (Criteria) this;
        }

        public Criteria andBjflEqualTo(Double value) {
            addCriterion("BJFL =", value, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflNotEqualTo(Double value) {
            addCriterion("BJFL <>", value, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflGreaterThan(Double value) {
            addCriterion("BJFL >", value, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflGreaterThanOrEqualTo(Double value) {
            addCriterion("BJFL >=", value, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflLessThan(Double value) {
            addCriterion("BJFL <", value, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflLessThanOrEqualTo(Double value) {
            addCriterion("BJFL <=", value, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflIn(List<Double> values) {
            addCriterion("BJFL in", values, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflNotIn(List<Double> values) {
            addCriterion("BJFL not in", values, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflBetween(Double value1, Double value2) {
            addCriterion("BJFL between", value1, value2, "bjfl");
            return (Criteria) this;
        }

        public Criteria andBjflNotBetween(Double value1, Double value2) {
            addCriterion("BJFL not between", value1, value2, "bjfl");
            return (Criteria) this;
        }

        public Criteria andLowestIsNull() {
            addCriterion("LOWEST is null");
            return (Criteria) this;
        }

        public Criteria andLowestIsNotNull() {
            addCriterion("LOWEST is not null");
            return (Criteria) this;
        }

        public Criteria andLowestEqualTo(Double value) {
            addCriterion("LOWEST =", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestNotEqualTo(Double value) {
            addCriterion("LOWEST <>", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestGreaterThan(Double value) {
            addCriterion("LOWEST >", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestGreaterThanOrEqualTo(Double value) {
            addCriterion("LOWEST >=", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestLessThan(Double value) {
            addCriterion("LOWEST <", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestLessThanOrEqualTo(Double value) {
            addCriterion("LOWEST <=", value, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestIn(List<Double> values) {
            addCriterion("LOWEST in", values, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestNotIn(List<Double> values) {
            addCriterion("LOWEST not in", values, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestBetween(Double value1, Double value2) {
            addCriterion("LOWEST between", value1, value2, "lowest");
            return (Criteria) this;
        }

        public Criteria andLowestNotBetween(Double value1, Double value2) {
            addCriterion("LOWEST not between", value1, value2, "lowest");
            return (Criteria) this;
        }

        public Criteria andValuationIsNull() {
            addCriterion("VALUATION is null");
            return (Criteria) this;
        }

        public Criteria andValuationIsNotNull() {
            addCriterion("VALUATION is not null");
            return (Criteria) this;
        }

        public Criteria andValuationEqualTo(String value) {
            addCriterion("VALUATION =", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotEqualTo(String value) {
            addCriterion("VALUATION <>", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationGreaterThan(String value) {
            addCriterion("VALUATION >", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationGreaterThanOrEqualTo(String value) {
            addCriterion("VALUATION >=", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationLessThan(String value) {
            addCriterion("VALUATION <", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationLessThanOrEqualTo(String value) {
            addCriterion("VALUATION <=", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationLike(String value) {
            addCriterion("VALUATION like", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotLike(String value) {
            addCriterion("VALUATION not like", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationIn(List<String> values) {
            addCriterion("VALUATION in", values, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotIn(List<String> values) {
            addCriterion("VALUATION not in", values, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationBetween(String value1, String value2) {
            addCriterion("VALUATION between", value1, value2, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotBetween(String value1, String value2) {
            addCriterion("VALUATION not between", value1, value2, "valuation");
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

        public Criteria andValuetypeIsNull() {
            addCriterion("VALUETYPE is null");
            return (Criteria) this;
        }

        public Criteria andValuetypeIsNotNull() {
            addCriterion("VALUETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andValuetypeEqualTo(String value) {
            addCriterion("VALUETYPE =", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotEqualTo(String value) {
            addCriterion("VALUETYPE <>", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeGreaterThan(String value) {
            addCriterion("VALUETYPE >", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeGreaterThanOrEqualTo(String value) {
            addCriterion("VALUETYPE >=", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeLessThan(String value) {
            addCriterion("VALUETYPE <", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeLessThanOrEqualTo(String value) {
            addCriterion("VALUETYPE <=", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeLike(String value) {
            addCriterion("VALUETYPE like", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotLike(String value) {
            addCriterion("VALUETYPE not like", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeIn(List<String> values) {
            addCriterion("VALUETYPE in", values, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotIn(List<String> values) {
            addCriterion("VALUETYPE not in", values, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeBetween(String value1, String value2) {
            addCriterion("VALUETYPE between", value1, value2, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotBetween(String value1, String value2) {
            addCriterion("VALUETYPE not between", value1, value2, "valuetype");
            return (Criteria) this;
        }

        public Criteria andStatsIsNull() {
            addCriterion("STATS is null");
            return (Criteria) this;
        }

        public Criteria andStatsIsNotNull() {
            addCriterion("STATS is not null");
            return (Criteria) this;
        }

        public Criteria andStatsEqualTo(String value) {
            addCriterion("STATS =", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotEqualTo(String value) {
            addCriterion("STATS <>", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsGreaterThan(String value) {
            addCriterion("STATS >", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsGreaterThanOrEqualTo(String value) {
            addCriterion("STATS >=", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLessThan(String value) {
            addCriterion("STATS <", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLessThanOrEqualTo(String value) {
            addCriterion("STATS <=", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsLike(String value) {
            addCriterion("STATS like", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotLike(String value) {
            addCriterion("STATS not like", value, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsIn(List<String> values) {
            addCriterion("STATS in", values, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotIn(List<String> values) {
            addCriterion("STATS not in", values, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsBetween(String value1, String value2) {
            addCriterion("STATS between", value1, value2, "stats");
            return (Criteria) this;
        }

        public Criteria andStatsNotBetween(String value1, String value2) {
            addCriterion("STATS not between", value1, value2, "stats");
            return (Criteria) this;
        }

        public Criteria andDetailedIsNull() {
            addCriterion("DETAILED is null");
            return (Criteria) this;
        }

        public Criteria andDetailedIsNotNull() {
            addCriterion("DETAILED is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedEqualTo(String value) {
            addCriterion("DETAILED =", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedNotEqualTo(String value) {
            addCriterion("DETAILED <>", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedGreaterThan(String value) {
            addCriterion("DETAILED >", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedGreaterThanOrEqualTo(String value) {
            addCriterion("DETAILED >=", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedLessThan(String value) {
            addCriterion("DETAILED <", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedLessThanOrEqualTo(String value) {
            addCriterion("DETAILED <=", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedLike(String value) {
            addCriterion("DETAILED like", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedNotLike(String value) {
            addCriterion("DETAILED not like", value, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedIn(List<String> values) {
            addCriterion("DETAILED in", values, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedNotIn(List<String> values) {
            addCriterion("DETAILED not in", values, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedBetween(String value1, String value2) {
            addCriterion("DETAILED between", value1, value2, "detailed");
            return (Criteria) this;
        }

        public Criteria andDetailedNotBetween(String value1, String value2) {
            addCriterion("DETAILED not between", value1, value2, "detailed");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("COUNT =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("COUNT <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("COUNT >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("COUNT >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("COUNT <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("COUNT <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("COUNT in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("COUNT not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("COUNT between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("COUNT not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdIsNull() {
            addCriterion("WLCOMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdIsNotNull() {
            addCriterion("WLCOMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID =", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdNotEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID <>", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdGreaterThan(Integer value) {
            addCriterion("WLCOMPANY_ID >", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID >=", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdLessThan(Integer value) {
            addCriterion("WLCOMPANY_ID <", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("WLCOMPANY_ID <=", value, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdIn(List<Integer> values) {
            addCriterion("WLCOMPANY_ID in", values, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdNotIn(List<Integer> values) {
            addCriterion("WLCOMPANY_ID not in", values, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("WLCOMPANY_ID between", value1, value2, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andWlcompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WLCOMPANY_ID not between", value1, value2, "wlcompanyId");
            return (Criteria) this;
        }

        public Criteria andMrfrIsNull() {
            addCriterion("MRFR is null");
            return (Criteria) this;
        }

        public Criteria andMrfrIsNotNull() {
            addCriterion("MRFR is not null");
            return (Criteria) this;
        }

        public Criteria andMrfrEqualTo(String value) {
            addCriterion("MRFR =", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrNotEqualTo(String value) {
            addCriterion("MRFR <>", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrGreaterThan(String value) {
            addCriterion("MRFR >", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrGreaterThanOrEqualTo(String value) {
            addCriterion("MRFR >=", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrLessThan(String value) {
            addCriterion("MRFR <", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrLessThanOrEqualTo(String value) {
            addCriterion("MRFR <=", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrLike(String value) {
            addCriterion("MRFR like", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrNotLike(String value) {
            addCriterion("MRFR not like", value, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrIn(List<String> values) {
            addCriterion("MRFR in", values, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrNotIn(List<String> values) {
            addCriterion("MRFR not in", values, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrBetween(String value1, String value2) {
            addCriterion("MRFR between", value1, value2, "mrfr");
            return (Criteria) this;
        }

        public Criteria andMrfrNotBetween(String value1, String value2) {
            addCriterion("MRFR not between", value1, value2, "mrfr");
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

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIsNull() {
            addCriterion("MARCHANTS_ID is null");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIsNotNull() {
            addCriterion("MARCHANTS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID =", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID <>", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdGreaterThan(Integer value) {
            addCriterion("MARCHANTS_ID >", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID >=", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLessThan(Integer value) {
            addCriterion("MARCHANTS_ID <", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLessThanOrEqualTo(Integer value) {
            addCriterion("MARCHANTS_ID <=", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIn(List<Integer> values) {
            addCriterion("MARCHANTS_ID in", values, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotIn(List<Integer> values) {
            addCriterion("MARCHANTS_ID not in", values, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdBetween(Integer value1, Integer value2) {
            addCriterion("MARCHANTS_ID between", value1, value2, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MARCHANTS_ID not between", value1, value2, "marchantsId");
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