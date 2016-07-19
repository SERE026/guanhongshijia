package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class WebModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebModelCriteriaBuilder() {
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

        public Criteria andSltWIsNull() {
            addCriterion("SLT_W is null");
            return (Criteria) this;
        }

        public Criteria andSltWIsNotNull() {
            addCriterion("SLT_W is not null");
            return (Criteria) this;
        }

        public Criteria andSltWEqualTo(String value) {
            addCriterion("SLT_W =", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWNotEqualTo(String value) {
            addCriterion("SLT_W <>", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWGreaterThan(String value) {
            addCriterion("SLT_W >", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWGreaterThanOrEqualTo(String value) {
            addCriterion("SLT_W >=", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWLessThan(String value) {
            addCriterion("SLT_W <", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWLessThanOrEqualTo(String value) {
            addCriterion("SLT_W <=", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWLike(String value) {
            addCriterion("SLT_W like", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWNotLike(String value) {
            addCriterion("SLT_W not like", value, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWIn(List<String> values) {
            addCriterion("SLT_W in", values, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWNotIn(List<String> values) {
            addCriterion("SLT_W not in", values, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWBetween(String value1, String value2) {
            addCriterion("SLT_W between", value1, value2, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltWNotBetween(String value1, String value2) {
            addCriterion("SLT_W not between", value1, value2, "sltW");
            return (Criteria) this;
        }

        public Criteria andSltHIsNull() {
            addCriterion("SLT_H is null");
            return (Criteria) this;
        }

        public Criteria andSltHIsNotNull() {
            addCriterion("SLT_H is not null");
            return (Criteria) this;
        }

        public Criteria andSltHEqualTo(String value) {
            addCriterion("SLT_H =", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHNotEqualTo(String value) {
            addCriterion("SLT_H <>", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHGreaterThan(String value) {
            addCriterion("SLT_H >", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHGreaterThanOrEqualTo(String value) {
            addCriterion("SLT_H >=", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHLessThan(String value) {
            addCriterion("SLT_H <", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHLessThanOrEqualTo(String value) {
            addCriterion("SLT_H <=", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHLike(String value) {
            addCriterion("SLT_H like", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHNotLike(String value) {
            addCriterion("SLT_H not like", value, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHIn(List<String> values) {
            addCriterion("SLT_H in", values, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHNotIn(List<String> values) {
            addCriterion("SLT_H not in", values, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHBetween(String value1, String value2) {
            addCriterion("SLT_H between", value1, value2, "sltH");
            return (Criteria) this;
        }

        public Criteria andSltHNotBetween(String value1, String value2) {
            addCriterion("SLT_H not between", value1, value2, "sltH");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWIsNull() {
            addCriterion("GOODSXX_W is null");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWIsNotNull() {
            addCriterion("GOODSXX_W is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWEqualTo(String value) {
            addCriterion("GOODSXX_W =", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWNotEqualTo(String value) {
            addCriterion("GOODSXX_W <>", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWGreaterThan(String value) {
            addCriterion("GOODSXX_W >", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSXX_W >=", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWLessThan(String value) {
            addCriterion("GOODSXX_W <", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWLessThanOrEqualTo(String value) {
            addCriterion("GOODSXX_W <=", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWLike(String value) {
            addCriterion("GOODSXX_W like", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWNotLike(String value) {
            addCriterion("GOODSXX_W not like", value, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWIn(List<String> values) {
            addCriterion("GOODSXX_W in", values, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWNotIn(List<String> values) {
            addCriterion("GOODSXX_W not in", values, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWBetween(String value1, String value2) {
            addCriterion("GOODSXX_W between", value1, value2, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodsxxWNotBetween(String value1, String value2) {
            addCriterion("GOODSXX_W not between", value1, value2, "goodsxxW");
            return (Criteria) this;
        }

        public Criteria andGoodxxHIsNull() {
            addCriterion("GOODXX_H is null");
            return (Criteria) this;
        }

        public Criteria andGoodxxHIsNotNull() {
            addCriterion("GOODXX_H is not null");
            return (Criteria) this;
        }

        public Criteria andGoodxxHEqualTo(String value) {
            addCriterion("GOODXX_H =", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHNotEqualTo(String value) {
            addCriterion("GOODXX_H <>", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHGreaterThan(String value) {
            addCriterion("GOODXX_H >", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHGreaterThanOrEqualTo(String value) {
            addCriterion("GOODXX_H >=", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHLessThan(String value) {
            addCriterion("GOODXX_H <", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHLessThanOrEqualTo(String value) {
            addCriterion("GOODXX_H <=", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHLike(String value) {
            addCriterion("GOODXX_H like", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHNotLike(String value) {
            addCriterion("GOODXX_H not like", value, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHIn(List<String> values) {
            addCriterion("GOODXX_H in", values, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHNotIn(List<String> values) {
            addCriterion("GOODXX_H not in", values, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHBetween(String value1, String value2) {
            addCriterion("GOODXX_H between", value1, value2, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodxxHNotBetween(String value1, String value2) {
            addCriterion("GOODXX_H not between", value1, value2, "goodxxH");
            return (Criteria) this;
        }

        public Criteria andGoodWIsNull() {
            addCriterion("GOOD_W is null");
            return (Criteria) this;
        }

        public Criteria andGoodWIsNotNull() {
            addCriterion("GOOD_W is not null");
            return (Criteria) this;
        }

        public Criteria andGoodWEqualTo(String value) {
            addCriterion("GOOD_W =", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWNotEqualTo(String value) {
            addCriterion("GOOD_W <>", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWGreaterThan(String value) {
            addCriterion("GOOD_W >", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWGreaterThanOrEqualTo(String value) {
            addCriterion("GOOD_W >=", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWLessThan(String value) {
            addCriterion("GOOD_W <", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWLessThanOrEqualTo(String value) {
            addCriterion("GOOD_W <=", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWLike(String value) {
            addCriterion("GOOD_W like", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWNotLike(String value) {
            addCriterion("GOOD_W not like", value, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWIn(List<String> values) {
            addCriterion("GOOD_W in", values, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWNotIn(List<String> values) {
            addCriterion("GOOD_W not in", values, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWBetween(String value1, String value2) {
            addCriterion("GOOD_W between", value1, value2, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodWNotBetween(String value1, String value2) {
            addCriterion("GOOD_W not between", value1, value2, "goodW");
            return (Criteria) this;
        }

        public Criteria andGoodHIsNull() {
            addCriterion("GOOD_H is null");
            return (Criteria) this;
        }

        public Criteria andGoodHIsNotNull() {
            addCriterion("GOOD_H is not null");
            return (Criteria) this;
        }

        public Criteria andGoodHEqualTo(String value) {
            addCriterion("GOOD_H =", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHNotEqualTo(String value) {
            addCriterion("GOOD_H <>", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHGreaterThan(String value) {
            addCriterion("GOOD_H >", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHGreaterThanOrEqualTo(String value) {
            addCriterion("GOOD_H >=", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHLessThan(String value) {
            addCriterion("GOOD_H <", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHLessThanOrEqualTo(String value) {
            addCriterion("GOOD_H <=", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHLike(String value) {
            addCriterion("GOOD_H like", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHNotLike(String value) {
            addCriterion("GOOD_H not like", value, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHIn(List<String> values) {
            addCriterion("GOOD_H in", values, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHNotIn(List<String> values) {
            addCriterion("GOOD_H not in", values, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHBetween(String value1, String value2) {
            addCriterion("GOOD_H between", value1, value2, "goodH");
            return (Criteria) this;
        }

        public Criteria andGoodHNotBetween(String value1, String value2) {
            addCriterion("GOOD_H not between", value1, value2, "goodH");
            return (Criteria) this;
        }

        public Criteria andIsSyIsNull() {
            addCriterion("IS_SY is null");
            return (Criteria) this;
        }

        public Criteria andIsSyIsNotNull() {
            addCriterion("IS_SY is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyEqualTo(String value) {
            addCriterion("IS_SY =", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyNotEqualTo(String value) {
            addCriterion("IS_SY <>", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyGreaterThan(String value) {
            addCriterion("IS_SY >", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SY >=", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyLessThan(String value) {
            addCriterion("IS_SY <", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyLessThanOrEqualTo(String value) {
            addCriterion("IS_SY <=", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyLike(String value) {
            addCriterion("IS_SY like", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyNotLike(String value) {
            addCriterion("IS_SY not like", value, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyIn(List<String> values) {
            addCriterion("IS_SY in", values, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyNotIn(List<String> values) {
            addCriterion("IS_SY not in", values, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyBetween(String value1, String value2) {
            addCriterion("IS_SY between", value1, value2, "isSy");
            return (Criteria) this;
        }

        public Criteria andIsSyNotBetween(String value1, String value2) {
            addCriterion("IS_SY not between", value1, value2, "isSy");
            return (Criteria) this;
        }

        public Criteria andSyNameIsNull() {
            addCriterion("SY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSyNameIsNotNull() {
            addCriterion("SY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSyNameEqualTo(String value) {
            addCriterion("SY_NAME =", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameNotEqualTo(String value) {
            addCriterion("SY_NAME <>", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameGreaterThan(String value) {
            addCriterion("SY_NAME >", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameGreaterThanOrEqualTo(String value) {
            addCriterion("SY_NAME >=", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameLessThan(String value) {
            addCriterion("SY_NAME <", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameLessThanOrEqualTo(String value) {
            addCriterion("SY_NAME <=", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameLike(String value) {
            addCriterion("SY_NAME like", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameNotLike(String value) {
            addCriterion("SY_NAME not like", value, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameIn(List<String> values) {
            addCriterion("SY_NAME in", values, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameNotIn(List<String> values) {
            addCriterion("SY_NAME not in", values, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameBetween(String value1, String value2) {
            addCriterion("SY_NAME between", value1, value2, "syName");
            return (Criteria) this;
        }

        public Criteria andSyNameNotBetween(String value1, String value2) {
            addCriterion("SY_NAME not between", value1, value2, "syName");
            return (Criteria) this;
        }

        public Criteria andSyLocationIsNull() {
            addCriterion("SY_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andSyLocationIsNotNull() {
            addCriterion("SY_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andSyLocationEqualTo(String value) {
            addCriterion("SY_LOCATION =", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationNotEqualTo(String value) {
            addCriterion("SY_LOCATION <>", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationGreaterThan(String value) {
            addCriterion("SY_LOCATION >", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationGreaterThanOrEqualTo(String value) {
            addCriterion("SY_LOCATION >=", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationLessThan(String value) {
            addCriterion("SY_LOCATION <", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationLessThanOrEqualTo(String value) {
            addCriterion("SY_LOCATION <=", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationLike(String value) {
            addCriterion("SY_LOCATION like", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationNotLike(String value) {
            addCriterion("SY_LOCATION not like", value, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationIn(List<String> values) {
            addCriterion("SY_LOCATION in", values, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationNotIn(List<String> values) {
            addCriterion("SY_LOCATION not in", values, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationBetween(String value1, String value2) {
            addCriterion("SY_LOCATION between", value1, value2, "syLocation");
            return (Criteria) this;
        }

        public Criteria andSyLocationNotBetween(String value1, String value2) {
            addCriterion("SY_LOCATION not between", value1, value2, "syLocation");
            return (Criteria) this;
        }

        public Criteria andFontColorIsNull() {
            addCriterion("FONT_COLOR is null");
            return (Criteria) this;
        }

        public Criteria andFontColorIsNotNull() {
            addCriterion("FONT_COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andFontColorEqualTo(String value) {
            addCriterion("FONT_COLOR =", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotEqualTo(String value) {
            addCriterion("FONT_COLOR <>", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorGreaterThan(String value) {
            addCriterion("FONT_COLOR >", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorGreaterThanOrEqualTo(String value) {
            addCriterion("FONT_COLOR >=", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLessThan(String value) {
            addCriterion("FONT_COLOR <", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLessThanOrEqualTo(String value) {
            addCriterion("FONT_COLOR <=", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLike(String value) {
            addCriterion("FONT_COLOR like", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotLike(String value) {
            addCriterion("FONT_COLOR not like", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorIn(List<String> values) {
            addCriterion("FONT_COLOR in", values, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotIn(List<String> values) {
            addCriterion("FONT_COLOR not in", values, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorBetween(String value1, String value2) {
            addCriterion("FONT_COLOR between", value1, value2, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotBetween(String value1, String value2) {
            addCriterion("FONT_COLOR not between", value1, value2, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNull() {
            addCriterion("FONT_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNotNull() {
            addCriterion("FONT_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andFontSizeEqualTo(String value) {
            addCriterion("FONT_SIZE =", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotEqualTo(String value) {
            addCriterion("FONT_SIZE <>", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThan(String value) {
            addCriterion("FONT_SIZE >", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThanOrEqualTo(String value) {
            addCriterion("FONT_SIZE >=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThan(String value) {
            addCriterion("FONT_SIZE <", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThanOrEqualTo(String value) {
            addCriterion("FONT_SIZE <=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLike(String value) {
            addCriterion("FONT_SIZE like", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotLike(String value) {
            addCriterion("FONT_SIZE not like", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeIn(List<String> values) {
            addCriterion("FONT_SIZE in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotIn(List<String> values) {
            addCriterion("FONT_SIZE not in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeBetween(String value1, String value2) {
            addCriterion("FONT_SIZE between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotBetween(String value1, String value2) {
            addCriterion("FONT_SIZE not between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andIsCodeIsNull() {
            addCriterion("IS_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIsCodeIsNotNull() {
            addCriterion("IS_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIsCodeEqualTo(String value) {
            addCriterion("IS_CODE =", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeNotEqualTo(String value) {
            addCriterion("IS_CODE <>", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeGreaterThan(String value) {
            addCriterion("IS_CODE >", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CODE >=", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeLessThan(String value) {
            addCriterion("IS_CODE <", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeLessThanOrEqualTo(String value) {
            addCriterion("IS_CODE <=", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeLike(String value) {
            addCriterion("IS_CODE like", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeNotLike(String value) {
            addCriterion("IS_CODE not like", value, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeIn(List<String> values) {
            addCriterion("IS_CODE in", values, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeNotIn(List<String> values) {
            addCriterion("IS_CODE not in", values, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeBetween(String value1, String value2) {
            addCriterion("IS_CODE between", value1, value2, "isCode");
            return (Criteria) this;
        }

        public Criteria andIsCodeNotBetween(String value1, String value2) {
            addCriterion("IS_CODE not between", value1, value2, "isCode");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNull() {
            addCriterion("PAGE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNotNull() {
            addCriterion("PAGE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andPageSizeEqualTo(String value) {
            addCriterion("PAGE_SIZE =", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotEqualTo(String value) {
            addCriterion("PAGE_SIZE <>", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThan(String value) {
            addCriterion("PAGE_SIZE >", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThanOrEqualTo(String value) {
            addCriterion("PAGE_SIZE >=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThan(String value) {
            addCriterion("PAGE_SIZE <", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThanOrEqualTo(String value) {
            addCriterion("PAGE_SIZE <=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLike(String value) {
            addCriterion("PAGE_SIZE like", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotLike(String value) {
            addCriterion("PAGE_SIZE not like", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeIn(List<String> values) {
            addCriterion("PAGE_SIZE in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotIn(List<String> values) {
            addCriterion("PAGE_SIZE not in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeBetween(String value1, String value2) {
            addCriterion("PAGE_SIZE between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotBetween(String value1, String value2) {
            addCriterion("PAGE_SIZE not between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andIsLmplIsNull() {
            addCriterion("IS_LMPL is null");
            return (Criteria) this;
        }

        public Criteria andIsLmplIsNotNull() {
            addCriterion("IS_LMPL is not null");
            return (Criteria) this;
        }

        public Criteria andIsLmplEqualTo(String value) {
            addCriterion("IS_LMPL =", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplNotEqualTo(String value) {
            addCriterion("IS_LMPL <>", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplGreaterThan(String value) {
            addCriterion("IS_LMPL >", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplGreaterThanOrEqualTo(String value) {
            addCriterion("IS_LMPL >=", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplLessThan(String value) {
            addCriterion("IS_LMPL <", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplLessThanOrEqualTo(String value) {
            addCriterion("IS_LMPL <=", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplLike(String value) {
            addCriterion("IS_LMPL like", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplNotLike(String value) {
            addCriterion("IS_LMPL not like", value, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplIn(List<String> values) {
            addCriterion("IS_LMPL in", values, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplNotIn(List<String> values) {
            addCriterion("IS_LMPL not in", values, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplBetween(String value1, String value2) {
            addCriterion("IS_LMPL between", value1, value2, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsLmplNotBetween(String value1, String value2) {
            addCriterion("IS_LMPL not between", value1, value2, "isLmpl");
            return (Criteria) this;
        }

        public Criteria andIsDispalyIsNull() {
            addCriterion("IS_DISPALY is null");
            return (Criteria) this;
        }

        public Criteria andIsDispalyIsNotNull() {
            addCriterion("IS_DISPALY is not null");
            return (Criteria) this;
        }

        public Criteria andIsDispalyEqualTo(String value) {
            addCriterion("IS_DISPALY =", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyNotEqualTo(String value) {
            addCriterion("IS_DISPALY <>", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyGreaterThan(String value) {
            addCriterion("IS_DISPALY >", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DISPALY >=", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyLessThan(String value) {
            addCriterion("IS_DISPALY <", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyLessThanOrEqualTo(String value) {
            addCriterion("IS_DISPALY <=", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyLike(String value) {
            addCriterion("IS_DISPALY like", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyNotLike(String value) {
            addCriterion("IS_DISPALY not like", value, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyIn(List<String> values) {
            addCriterion("IS_DISPALY in", values, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyNotIn(List<String> values) {
            addCriterion("IS_DISPALY not in", values, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyBetween(String value1, String value2) {
            addCriterion("IS_DISPALY between", value1, value2, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andIsDispalyNotBetween(String value1, String value2) {
            addCriterion("IS_DISPALY not between", value1, value2, "isDispaly");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("KEYWORD is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("KEYWORD is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("KEYWORD =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("KEYWORD <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("KEYWORD >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("KEYWORD >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("KEYWORD <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("KEYWORD <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("KEYWORD like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("KEYWORD not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("KEYWORD in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("KEYWORD not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("KEYWORD between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("KEYWORD not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBgColorIsNull() {
            addCriterion("BG_COLOR is null");
            return (Criteria) this;
        }

        public Criteria andBgColorIsNotNull() {
            addCriterion("BG_COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andBgColorEqualTo(String value) {
            addCriterion("BG_COLOR =", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorNotEqualTo(String value) {
            addCriterion("BG_COLOR <>", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorGreaterThan(String value) {
            addCriterion("BG_COLOR >", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorGreaterThanOrEqualTo(String value) {
            addCriterion("BG_COLOR >=", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorLessThan(String value) {
            addCriterion("BG_COLOR <", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorLessThanOrEqualTo(String value) {
            addCriterion("BG_COLOR <=", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorLike(String value) {
            addCriterion("BG_COLOR like", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorNotLike(String value) {
            addCriterion("BG_COLOR not like", value, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorIn(List<String> values) {
            addCriterion("BG_COLOR in", values, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorNotIn(List<String> values) {
            addCriterion("BG_COLOR not in", values, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorBetween(String value1, String value2) {
            addCriterion("BG_COLOR between", value1, value2, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgColorNotBetween(String value1, String value2) {
            addCriterion("BG_COLOR not between", value1, value2, "bgColor");
            return (Criteria) this;
        }

        public Criteria andBgImgIsNull() {
            addCriterion("BG_IMG is null");
            return (Criteria) this;
        }

        public Criteria andBgImgIsNotNull() {
            addCriterion("BG_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andBgImgEqualTo(String value) {
            addCriterion("BG_IMG =", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgNotEqualTo(String value) {
            addCriterion("BG_IMG <>", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgGreaterThan(String value) {
            addCriterion("BG_IMG >", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgGreaterThanOrEqualTo(String value) {
            addCriterion("BG_IMG >=", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgLessThan(String value) {
            addCriterion("BG_IMG <", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgLessThanOrEqualTo(String value) {
            addCriterion("BG_IMG <=", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgLike(String value) {
            addCriterion("BG_IMG like", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgNotLike(String value) {
            addCriterion("BG_IMG not like", value, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgIn(List<String> values) {
            addCriterion("BG_IMG in", values, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgNotIn(List<String> values) {
            addCriterion("BG_IMG not in", values, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgBetween(String value1, String value2) {
            addCriterion("BG_IMG between", value1, value2, "bgImg");
            return (Criteria) this;
        }

        public Criteria andBgImgNotBetween(String value1, String value2) {
            addCriterion("BG_IMG not between", value1, value2, "bgImg");
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