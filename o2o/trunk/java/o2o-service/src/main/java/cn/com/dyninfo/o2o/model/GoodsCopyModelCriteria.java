package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsCopyModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public GoodsCopyModelCriteria() {
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

        public Criteria andIndexIsNull() {
            addCriterion("INDEX is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(String value) {
            addCriterion("INDEX =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(String value) {
            addCriterion("INDEX <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(String value) {
            addCriterion("INDEX >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(String value) {
            addCriterion("INDEX <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(String value) {
            addCriterion("INDEX <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLike(String value) {
            addCriterion("INDEX like", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotLike(String value) {
            addCriterion("INDEX not like", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<String> values) {
            addCriterion("INDEX in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<String> values) {
            addCriterion("INDEX not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(String value1, String value2) {
            addCriterion("INDEX between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(String value1, String value2) {
            addCriterion("INDEX not between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdIsNull() {
            addCriterion("GOODSSORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdIsNotNull() {
            addCriterion("GOODSSORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdEqualTo(Integer value) {
            addCriterion("GOODSSORT_ID =", value, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdNotEqualTo(Integer value) {
            addCriterion("GOODSSORT_ID <>", value, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdGreaterThan(Integer value) {
            addCriterion("GOODSSORT_ID >", value, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODSSORT_ID >=", value, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdLessThan(Integer value) {
            addCriterion("GOODSSORT_ID <", value, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOODSSORT_ID <=", value, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdIn(List<Integer> values) {
            addCriterion("GOODSSORT_ID in", values, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdNotIn(List<Integer> values) {
            addCriterion("GOODSSORT_ID not in", values, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdBetween(Integer value1, Integer value2) {
            addCriterion("GOODSSORT_ID between", value1, value2, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodssortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODSSORT_ID not between", value1, value2, "goodssortId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdIsNull() {
            addCriterion("GOODSTYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdIsNotNull() {
            addCriterion("GOODSTYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdEqualTo(Integer value) {
            addCriterion("GOODSTYPE_ID =", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdNotEqualTo(Integer value) {
            addCriterion("GOODSTYPE_ID <>", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdGreaterThan(Integer value) {
            addCriterion("GOODSTYPE_ID >", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODSTYPE_ID >=", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdLessThan(Integer value) {
            addCriterion("GOODSTYPE_ID <", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOODSTYPE_ID <=", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdIn(List<Integer> values) {
            addCriterion("GOODSTYPE_ID in", values, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdNotIn(List<Integer> values) {
            addCriterion("GOODSTYPE_ID not in", values, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdBetween(Integer value1, Integer value2) {
            addCriterion("GOODSTYPE_ID between", value1, value2, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODSTYPE_ID not between", value1, value2, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyIsNull() {
            addCriterion("BAZAARMONEY is null");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyIsNotNull() {
            addCriterion("BAZAARMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyEqualTo(Double value) {
            addCriterion("BAZAARMONEY =", value, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyNotEqualTo(Double value) {
            addCriterion("BAZAARMONEY <>", value, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyGreaterThan(Double value) {
            addCriterion("BAZAARMONEY >", value, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("BAZAARMONEY >=", value, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyLessThan(Double value) {
            addCriterion("BAZAARMONEY <", value, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyLessThanOrEqualTo(Double value) {
            addCriterion("BAZAARMONEY <=", value, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyIn(List<Double> values) {
            addCriterion("BAZAARMONEY in", values, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyNotIn(List<Double> values) {
            addCriterion("BAZAARMONEY not in", values, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyBetween(Double value1, Double value2) {
            addCriterion("BAZAARMONEY between", value1, value2, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andBazaarmoneyNotBetween(Double value1, Double value2) {
            addCriterion("BAZAARMONEY not between", value1, value2, "bazaarmoney");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyIsNull() {
            addCriterion("COSTSMONEY is null");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyIsNotNull() {
            addCriterion("COSTSMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyEqualTo(Double value) {
            addCriterion("COSTSMONEY =", value, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyNotEqualTo(Double value) {
            addCriterion("COSTSMONEY <>", value, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyGreaterThan(Double value) {
            addCriterion("COSTSMONEY >", value, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("COSTSMONEY >=", value, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyLessThan(Double value) {
            addCriterion("COSTSMONEY <", value, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyLessThanOrEqualTo(Double value) {
            addCriterion("COSTSMONEY <=", value, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyIn(List<Double> values) {
            addCriterion("COSTSMONEY in", values, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyNotIn(List<Double> values) {
            addCriterion("COSTSMONEY not in", values, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyBetween(Double value1, Double value2) {
            addCriterion("COSTSMONEY between", value1, value2, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andCostsmoneyNotBetween(Double value1, Double value2) {
            addCriterion("COSTSMONEY not between", value1, value2, "costsmoney");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationIsNull() {
            addCriterion("GOODSAUTHORIZATION is null");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationIsNotNull() {
            addCriterion("GOODSAUTHORIZATION is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationEqualTo(String value) {
            addCriterion("GOODSAUTHORIZATION =", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationNotEqualTo(String value) {
            addCriterion("GOODSAUTHORIZATION <>", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationGreaterThan(String value) {
            addCriterion("GOODSAUTHORIZATION >", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSAUTHORIZATION >=", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationLessThan(String value) {
            addCriterion("GOODSAUTHORIZATION <", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationLessThanOrEqualTo(String value) {
            addCriterion("GOODSAUTHORIZATION <=", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationLike(String value) {
            addCriterion("GOODSAUTHORIZATION like", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationNotLike(String value) {
            addCriterion("GOODSAUTHORIZATION not like", value, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationIn(List<String> values) {
            addCriterion("GOODSAUTHORIZATION in", values, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationNotIn(List<String> values) {
            addCriterion("GOODSAUTHORIZATION not in", values, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationBetween(String value1, String value2) {
            addCriterion("GOODSAUTHORIZATION between", value1, value2, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsauthorizationNotBetween(String value1, String value2) {
            addCriterion("GOODSAUTHORIZATION not between", value1, value2, "goodsauthorization");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterIsNull() {
            addCriterion("GOODSPARAMETER is null");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterIsNotNull() {
            addCriterion("GOODSPARAMETER is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterEqualTo(String value) {
            addCriterion("GOODSPARAMETER =", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterNotEqualTo(String value) {
            addCriterion("GOODSPARAMETER <>", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterGreaterThan(String value) {
            addCriterion("GOODSPARAMETER >", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSPARAMETER >=", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterLessThan(String value) {
            addCriterion("GOODSPARAMETER <", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterLessThanOrEqualTo(String value) {
            addCriterion("GOODSPARAMETER <=", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterLike(String value) {
            addCriterion("GOODSPARAMETER like", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterNotLike(String value) {
            addCriterion("GOODSPARAMETER not like", value, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterIn(List<String> values) {
            addCriterion("GOODSPARAMETER in", values, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterNotIn(List<String> values) {
            addCriterion("GOODSPARAMETER not in", values, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterBetween(String value1, String value2) {
            addCriterion("GOODSPARAMETER between", value1, value2, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsparameterNotBetween(String value1, String value2) {
            addCriterion("GOODSPARAMETER not between", value1, value2, "goodsparameter");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryIsNull() {
            addCriterion("GOODSSTORY is null");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryIsNotNull() {
            addCriterion("GOODSSTORY is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryEqualTo(String value) {
            addCriterion("GOODSSTORY =", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryNotEqualTo(String value) {
            addCriterion("GOODSSTORY <>", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryGreaterThan(String value) {
            addCriterion("GOODSSTORY >", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSSTORY >=", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryLessThan(String value) {
            addCriterion("GOODSSTORY <", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryLessThanOrEqualTo(String value) {
            addCriterion("GOODSSTORY <=", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryLike(String value) {
            addCriterion("GOODSSTORY like", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryNotLike(String value) {
            addCriterion("GOODSSTORY not like", value, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryIn(List<String> values) {
            addCriterion("GOODSSTORY in", values, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryNotIn(List<String> values) {
            addCriterion("GOODSSTORY not in", values, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryBetween(String value1, String value2) {
            addCriterion("GOODSSTORY between", value1, value2, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andGoodsstoryNotBetween(String value1, String value2) {
            addCriterion("GOODSSTORY not between", value1, value2, "goodsstory");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyIsNull() {
            addCriterion("HUIYUANMONEY is null");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyIsNotNull() {
            addCriterion("HUIYUANMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyEqualTo(Double value) {
            addCriterion("HUIYUANMONEY =", value, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyNotEqualTo(Double value) {
            addCriterion("HUIYUANMONEY <>", value, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyGreaterThan(Double value) {
            addCriterion("HUIYUANMONEY >", value, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("HUIYUANMONEY >=", value, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyLessThan(Double value) {
            addCriterion("HUIYUANMONEY <", value, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyLessThanOrEqualTo(Double value) {
            addCriterion("HUIYUANMONEY <=", value, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyIn(List<Double> values) {
            addCriterion("HUIYUANMONEY in", values, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyNotIn(List<Double> values) {
            addCriterion("HUIYUANMONEY not in", values, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyBetween(Double value1, Double value2) {
            addCriterion("HUIYUANMONEY between", value1, value2, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andHuiyuanmoneyNotBetween(Double value1, Double value2) {
            addCriterion("HUIYUANMONEY not between", value1, value2, "huiyuanmoney");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("IMG is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("IMG is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("IMG =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("IMG <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("IMG >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("IMG >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("IMG <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("IMG <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("IMG like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("IMG not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("IMG in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("IMG not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("IMG between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("IMG not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("INVENTORY is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("INVENTORY is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Double value) {
            addCriterion("INVENTORY =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Double value) {
            addCriterion("INVENTORY <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Double value) {
            addCriterion("INVENTORY >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Double value) {
            addCriterion("INVENTORY >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Double value) {
            addCriterion("INVENTORY <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Double value) {
            addCriterion("INVENTORY <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Double> values) {
            addCriterion("INVENTORY in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Double> values) {
            addCriterion("INVENTORY not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Double value1, Double value2) {
            addCriterion("INVENTORY between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Double value1, Double value2) {
            addCriterion("INVENTORY not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andIsCxIsNull() {
            addCriterion("IS_CX is null");
            return (Criteria) this;
        }

        public Criteria andIsCxIsNotNull() {
            addCriterion("IS_CX is not null");
            return (Criteria) this;
        }

        public Criteria andIsCxEqualTo(String value) {
            addCriterion("IS_CX =", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxNotEqualTo(String value) {
            addCriterion("IS_CX <>", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxGreaterThan(String value) {
            addCriterion("IS_CX >", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CX >=", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxLessThan(String value) {
            addCriterion("IS_CX <", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxLessThanOrEqualTo(String value) {
            addCriterion("IS_CX <=", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxLike(String value) {
            addCriterion("IS_CX like", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxNotLike(String value) {
            addCriterion("IS_CX not like", value, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxIn(List<String> values) {
            addCriterion("IS_CX in", values, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxNotIn(List<String> values) {
            addCriterion("IS_CX not in", values, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxBetween(String value1, String value2) {
            addCriterion("IS_CX between", value1, value2, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsCxNotBetween(String value1, String value2) {
            addCriterion("IS_CX not between", value1, value2, "isCx");
            return (Criteria) this;
        }

        public Criteria andIsJptjIsNull() {
            addCriterion("IS_JPTJ is null");
            return (Criteria) this;
        }

        public Criteria andIsJptjIsNotNull() {
            addCriterion("IS_JPTJ is not null");
            return (Criteria) this;
        }

        public Criteria andIsJptjEqualTo(String value) {
            addCriterion("IS_JPTJ =", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjNotEqualTo(String value) {
            addCriterion("IS_JPTJ <>", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjGreaterThan(String value) {
            addCriterion("IS_JPTJ >", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjGreaterThanOrEqualTo(String value) {
            addCriterion("IS_JPTJ >=", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjLessThan(String value) {
            addCriterion("IS_JPTJ <", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjLessThanOrEqualTo(String value) {
            addCriterion("IS_JPTJ <=", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjLike(String value) {
            addCriterion("IS_JPTJ like", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjNotLike(String value) {
            addCriterion("IS_JPTJ not like", value, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjIn(List<String> values) {
            addCriterion("IS_JPTJ in", values, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjNotIn(List<String> values) {
            addCriterion("IS_JPTJ not in", values, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjBetween(String value1, String value2) {
            addCriterion("IS_JPTJ between", value1, value2, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsJptjNotBetween(String value1, String value2) {
            addCriterion("IS_JPTJ not between", value1, value2, "isJptj");
            return (Criteria) this;
        }

        public Criteria andIsRxcpIsNull() {
            addCriterion("IS_RXCP is null");
            return (Criteria) this;
        }

        public Criteria andIsRxcpIsNotNull() {
            addCriterion("IS_RXCP is not null");
            return (Criteria) this;
        }

        public Criteria andIsRxcpEqualTo(String value) {
            addCriterion("IS_RXCP =", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpNotEqualTo(String value) {
            addCriterion("IS_RXCP <>", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpGreaterThan(String value) {
            addCriterion("IS_RXCP >", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpGreaterThanOrEqualTo(String value) {
            addCriterion("IS_RXCP >=", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpLessThan(String value) {
            addCriterion("IS_RXCP <", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpLessThanOrEqualTo(String value) {
            addCriterion("IS_RXCP <=", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpLike(String value) {
            addCriterion("IS_RXCP like", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpNotLike(String value) {
            addCriterion("IS_RXCP not like", value, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpIn(List<String> values) {
            addCriterion("IS_RXCP in", values, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpNotIn(List<String> values) {
            addCriterion("IS_RXCP not in", values, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpBetween(String value1, String value2) {
            addCriterion("IS_RXCP between", value1, value2, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andIsRxcpNotBetween(String value1, String value2) {
            addCriterion("IS_RXCP not between", value1, value2, "isRxcp");
            return (Criteria) this;
        }

        public Criteria andShelvesIsNull() {
            addCriterion("SHELVES is null");
            return (Criteria) this;
        }

        public Criteria andShelvesIsNotNull() {
            addCriterion("SHELVES is not null");
            return (Criteria) this;
        }

        public Criteria andShelvesEqualTo(String value) {
            addCriterion("SHELVES =", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesNotEqualTo(String value) {
            addCriterion("SHELVES <>", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesGreaterThan(String value) {
            addCriterion("SHELVES >", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesGreaterThanOrEqualTo(String value) {
            addCriterion("SHELVES >=", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesLessThan(String value) {
            addCriterion("SHELVES <", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesLessThanOrEqualTo(String value) {
            addCriterion("SHELVES <=", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesLike(String value) {
            addCriterion("SHELVES like", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesNotLike(String value) {
            addCriterion("SHELVES not like", value, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesIn(List<String> values) {
            addCriterion("SHELVES in", values, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesNotIn(List<String> values) {
            addCriterion("SHELVES not in", values, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesBetween(String value1, String value2) {
            addCriterion("SHELVES between", value1, value2, "shelves");
            return (Criteria) this;
        }

        public Criteria andShelvesNotBetween(String value1, String value2) {
            addCriterion("SHELVES not between", value1, value2, "shelves");
            return (Criteria) this;
        }

        public Criteria andIsZxIsNull() {
            addCriterion("IS_ZX is null");
            return (Criteria) this;
        }

        public Criteria andIsZxIsNotNull() {
            addCriterion("IS_ZX is not null");
            return (Criteria) this;
        }

        public Criteria andIsZxEqualTo(String value) {
            addCriterion("IS_ZX =", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxNotEqualTo(String value) {
            addCriterion("IS_ZX <>", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxGreaterThan(String value) {
            addCriterion("IS_ZX >", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxGreaterThanOrEqualTo(String value) {
            addCriterion("IS_ZX >=", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxLessThan(String value) {
            addCriterion("IS_ZX <", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxLessThanOrEqualTo(String value) {
            addCriterion("IS_ZX <=", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxLike(String value) {
            addCriterion("IS_ZX like", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxNotLike(String value) {
            addCriterion("IS_ZX not like", value, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxIn(List<String> values) {
            addCriterion("IS_ZX in", values, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxNotIn(List<String> values) {
            addCriterion("IS_ZX not in", values, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxBetween(String value1, String value2) {
            addCriterion("IS_ZX between", value1, value2, "isZx");
            return (Criteria) this;
        }

        public Criteria andIsZxNotBetween(String value1, String value2) {
            addCriterion("IS_ZX not between", value1, value2, "isZx");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyIsNull() {
            addCriterion("SALESMONEY is null");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyIsNotNull() {
            addCriterion("SALESMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyEqualTo(Double value) {
            addCriterion("SALESMONEY =", value, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyNotEqualTo(Double value) {
            addCriterion("SALESMONEY <>", value, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyGreaterThan(Double value) {
            addCriterion("SALESMONEY >", value, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("SALESMONEY >=", value, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyLessThan(Double value) {
            addCriterion("SALESMONEY <", value, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyLessThanOrEqualTo(Double value) {
            addCriterion("SALESMONEY <=", value, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyIn(List<Double> values) {
            addCriterion("SALESMONEY in", values, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyNotIn(List<Double> values) {
            addCriterion("SALESMONEY not in", values, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyBetween(Double value1, Double value2) {
            addCriterion("SALESMONEY between", value1, value2, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andSalesmoneyNotBetween(Double value1, Double value2) {
            addCriterion("SALESMONEY not between", value1, value2, "salesmoney");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andSjTimeIsNull() {
            addCriterion("SJ_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSjTimeIsNotNull() {
            addCriterion("SJ_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSjTimeEqualTo(String value) {
            addCriterion("SJ_TIME =", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeNotEqualTo(String value) {
            addCriterion("SJ_TIME <>", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeGreaterThan(String value) {
            addCriterion("SJ_TIME >", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SJ_TIME >=", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeLessThan(String value) {
            addCriterion("SJ_TIME <", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeLessThanOrEqualTo(String value) {
            addCriterion("SJ_TIME <=", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeLike(String value) {
            addCriterion("SJ_TIME like", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeNotLike(String value) {
            addCriterion("SJ_TIME not like", value, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeIn(List<String> values) {
            addCriterion("SJ_TIME in", values, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeNotIn(List<String> values) {
            addCriterion("SJ_TIME not in", values, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeBetween(String value1, String value2) {
            addCriterion("SJ_TIME between", value1, value2, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSjTimeNotBetween(String value1, String value2) {
            addCriterion("SJ_TIME not between", value1, value2, "sjTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeIsNull() {
            addCriterion("SYS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSysTimeIsNotNull() {
            addCriterion("SYS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSysTimeEqualTo(String value) {
            addCriterion("SYS_TIME =", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotEqualTo(String value) {
            addCriterion("SYS_TIME <>", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeGreaterThan(String value) {
            addCriterion("SYS_TIME >", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_TIME >=", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeLessThan(String value) {
            addCriterion("SYS_TIME <", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeLessThanOrEqualTo(String value) {
            addCriterion("SYS_TIME <=", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeLike(String value) {
            addCriterion("SYS_TIME like", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotLike(String value) {
            addCriterion("SYS_TIME not like", value, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeIn(List<String> values) {
            addCriterion("SYS_TIME in", values, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotIn(List<String> values) {
            addCriterion("SYS_TIME not in", values, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeBetween(String value1, String value2) {
            addCriterion("SYS_TIME between", value1, value2, "sysTime");
            return (Criteria) this;
        }

        public Criteria andSysTimeNotBetween(String value1, String value2) {
            addCriterion("SYS_TIME not between", value1, value2, "sysTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("BRAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("BRAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("BRAND_ID =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("BRAND_ID <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("BRAND_ID >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ID >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("BRAND_ID <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ID <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("BRAND_ID in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("BRAND_ID not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ID between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ID not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNull() {
            addCriterion("INDEXS is null");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNotNull() {
            addCriterion("INDEXS is not null");
            return (Criteria) this;
        }

        public Criteria andIndexsEqualTo(String value) {
            addCriterion("INDEXS =", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotEqualTo(String value) {
            addCriterion("INDEXS <>", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThan(String value) {
            addCriterion("INDEXS >", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXS >=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThan(String value) {
            addCriterion("INDEXS <", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThanOrEqualTo(String value) {
            addCriterion("INDEXS <=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLike(String value) {
            addCriterion("INDEXS like", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotLike(String value) {
            addCriterion("INDEXS not like", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsIn(List<String> values) {
            addCriterion("INDEXS in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotIn(List<String> values) {
            addCriterion("INDEXS not in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsBetween(String value1, String value2) {
            addCriterion("INDEXS between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotBetween(String value1, String value2) {
            addCriterion("INDEXS not between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andTypespecIsNull() {
            addCriterion("TYPESPEC is null");
            return (Criteria) this;
        }

        public Criteria andTypespecIsNotNull() {
            addCriterion("TYPESPEC is not null");
            return (Criteria) this;
        }

        public Criteria andTypespecEqualTo(String value) {
            addCriterion("TYPESPEC =", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecNotEqualTo(String value) {
            addCriterion("TYPESPEC <>", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecGreaterThan(String value) {
            addCriterion("TYPESPEC >", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecGreaterThanOrEqualTo(String value) {
            addCriterion("TYPESPEC >=", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecLessThan(String value) {
            addCriterion("TYPESPEC <", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecLessThanOrEqualTo(String value) {
            addCriterion("TYPESPEC <=", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecLike(String value) {
            addCriterion("TYPESPEC like", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecNotLike(String value) {
            addCriterion("TYPESPEC not like", value, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecIn(List<String> values) {
            addCriterion("TYPESPEC in", values, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecNotIn(List<String> values) {
            addCriterion("TYPESPEC not in", values, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecBetween(String value1, String value2) {
            addCriterion("TYPESPEC between", value1, value2, "typespec");
            return (Criteria) this;
        }

        public Criteria andTypespecNotBetween(String value1, String value2) {
            addCriterion("TYPESPEC not between", value1, value2, "typespec");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageIsNull() {
            addCriterion("DEFAULT_IAMAGE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageIsNotNull() {
            addCriterion("DEFAULT_IAMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageEqualTo(String value) {
            addCriterion("DEFAULT_IAMAGE =", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageNotEqualTo(String value) {
            addCriterion("DEFAULT_IAMAGE <>", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageGreaterThan(String value) {
            addCriterion("DEFAULT_IAMAGE >", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_IAMAGE >=", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageLessThan(String value) {
            addCriterion("DEFAULT_IAMAGE <", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_IAMAGE <=", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageLike(String value) {
            addCriterion("DEFAULT_IAMAGE like", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageNotLike(String value) {
            addCriterion("DEFAULT_IAMAGE not like", value, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageIn(List<String> values) {
            addCriterion("DEFAULT_IAMAGE in", values, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageNotIn(List<String> values) {
            addCriterion("DEFAULT_IAMAGE not in", values, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageBetween(String value1, String value2) {
            addCriterion("DEFAULT_IAMAGE between", value1, value2, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andDefaultIamageNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_IAMAGE not between", value1, value2, "defaultIamage");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("IMAGES is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("IMAGES is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String value) {
            addCriterion("IMAGES =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String value) {
            addCriterion("IMAGES <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String value) {
            addCriterion("IMAGES >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGES >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String value) {
            addCriterion("IMAGES <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            addCriterion("IMAGES <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLike(String value) {
            addCriterion("IMAGES like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String value) {
            addCriterion("IMAGES not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String> values) {
            addCriterion("IMAGES in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String> values) {
            addCriterion("IMAGES not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String value1, String value2) {
            addCriterion("IMAGES between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            addCriterion("IMAGES not between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andSpecValue0IsNull() {
            addCriterion("SPEC_VALUE_0 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue0IsNotNull() {
            addCriterion("SPEC_VALUE_0 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue0EqualTo(String value) {
            addCriterion("SPEC_VALUE_0 =", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_0 <>", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0GreaterThan(String value) {
            addCriterion("SPEC_VALUE_0 >", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_0 >=", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0LessThan(String value) {
            addCriterion("SPEC_VALUE_0 <", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_0 <=", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0Like(String value) {
            addCriterion("SPEC_VALUE_0 like", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0NotLike(String value) {
            addCriterion("SPEC_VALUE_0 not like", value, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0In(List<String> values) {
            addCriterion("SPEC_VALUE_0 in", values, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_0 not in", values, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_0 between", value1, value2, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue0NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_0 not between", value1, value2, "specValue0");
            return (Criteria) this;
        }

        public Criteria andSpecValue1IsNull() {
            addCriterion("SPEC_VALUE_1 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue1IsNotNull() {
            addCriterion("SPEC_VALUE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue1EqualTo(String value) {
            addCriterion("SPEC_VALUE_1 =", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_1 <>", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1GreaterThan(String value) {
            addCriterion("SPEC_VALUE_1 >", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_1 >=", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1LessThan(String value) {
            addCriterion("SPEC_VALUE_1 <", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_1 <=", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1Like(String value) {
            addCriterion("SPEC_VALUE_1 like", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1NotLike(String value) {
            addCriterion("SPEC_VALUE_1 not like", value, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1In(List<String> values) {
            addCriterion("SPEC_VALUE_1 in", values, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_1 not in", values, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_1 between", value1, value2, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue1NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_1 not between", value1, value2, "specValue1");
            return (Criteria) this;
        }

        public Criteria andSpecValue2IsNull() {
            addCriterion("SPEC_VALUE_2 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue2IsNotNull() {
            addCriterion("SPEC_VALUE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue2EqualTo(String value) {
            addCriterion("SPEC_VALUE_2 =", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_2 <>", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2GreaterThan(String value) {
            addCriterion("SPEC_VALUE_2 >", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_2 >=", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2LessThan(String value) {
            addCriterion("SPEC_VALUE_2 <", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_2 <=", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2Like(String value) {
            addCriterion("SPEC_VALUE_2 like", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2NotLike(String value) {
            addCriterion("SPEC_VALUE_2 not like", value, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2In(List<String> values) {
            addCriterion("SPEC_VALUE_2 in", values, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_2 not in", values, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_2 between", value1, value2, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue2NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_2 not between", value1, value2, "specValue2");
            return (Criteria) this;
        }

        public Criteria andSpecValue3IsNull() {
            addCriterion("SPEC_VALUE_3 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue3IsNotNull() {
            addCriterion("SPEC_VALUE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue3EqualTo(String value) {
            addCriterion("SPEC_VALUE_3 =", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_3 <>", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3GreaterThan(String value) {
            addCriterion("SPEC_VALUE_3 >", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_3 >=", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3LessThan(String value) {
            addCriterion("SPEC_VALUE_3 <", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_3 <=", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3Like(String value) {
            addCriterion("SPEC_VALUE_3 like", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3NotLike(String value) {
            addCriterion("SPEC_VALUE_3 not like", value, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3In(List<String> values) {
            addCriterion("SPEC_VALUE_3 in", values, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_3 not in", values, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_3 between", value1, value2, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue3NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_3 not between", value1, value2, "specValue3");
            return (Criteria) this;
        }

        public Criteria andSpecValue4IsNull() {
            addCriterion("SPEC_VALUE_4 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue4IsNotNull() {
            addCriterion("SPEC_VALUE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue4EqualTo(String value) {
            addCriterion("SPEC_VALUE_4 =", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_4 <>", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4GreaterThan(String value) {
            addCriterion("SPEC_VALUE_4 >", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_4 >=", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4LessThan(String value) {
            addCriterion("SPEC_VALUE_4 <", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_4 <=", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4Like(String value) {
            addCriterion("SPEC_VALUE_4 like", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4NotLike(String value) {
            addCriterion("SPEC_VALUE_4 not like", value, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4In(List<String> values) {
            addCriterion("SPEC_VALUE_4 in", values, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_4 not in", values, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_4 between", value1, value2, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue4NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_4 not between", value1, value2, "specValue4");
            return (Criteria) this;
        }

        public Criteria andSpecValue5IsNull() {
            addCriterion("SPEC_VALUE_5 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue5IsNotNull() {
            addCriterion("SPEC_VALUE_5 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue5EqualTo(String value) {
            addCriterion("SPEC_VALUE_5 =", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_5 <>", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5GreaterThan(String value) {
            addCriterion("SPEC_VALUE_5 >", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_5 >=", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5LessThan(String value) {
            addCriterion("SPEC_VALUE_5 <", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_5 <=", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5Like(String value) {
            addCriterion("SPEC_VALUE_5 like", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5NotLike(String value) {
            addCriterion("SPEC_VALUE_5 not like", value, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5In(List<String> values) {
            addCriterion("SPEC_VALUE_5 in", values, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_5 not in", values, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_5 between", value1, value2, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue5NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_5 not between", value1, value2, "specValue5");
            return (Criteria) this;
        }

        public Criteria andSpecValue6IsNull() {
            addCriterion("SPEC_VALUE_6 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue6IsNotNull() {
            addCriterion("SPEC_VALUE_6 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue6EqualTo(String value) {
            addCriterion("SPEC_VALUE_6 =", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_6 <>", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6GreaterThan(String value) {
            addCriterion("SPEC_VALUE_6 >", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_6 >=", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6LessThan(String value) {
            addCriterion("SPEC_VALUE_6 <", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_6 <=", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6Like(String value) {
            addCriterion("SPEC_VALUE_6 like", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6NotLike(String value) {
            addCriterion("SPEC_VALUE_6 not like", value, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6In(List<String> values) {
            addCriterion("SPEC_VALUE_6 in", values, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_6 not in", values, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_6 between", value1, value2, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue6NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_6 not between", value1, value2, "specValue6");
            return (Criteria) this;
        }

        public Criteria andSpecValue7IsNull() {
            addCriterion("SPEC_VALUE_7 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue7IsNotNull() {
            addCriterion("SPEC_VALUE_7 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue7EqualTo(String value) {
            addCriterion("SPEC_VALUE_7 =", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_7 <>", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7GreaterThan(String value) {
            addCriterion("SPEC_VALUE_7 >", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_7 >=", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7LessThan(String value) {
            addCriterion("SPEC_VALUE_7 <", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_7 <=", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7Like(String value) {
            addCriterion("SPEC_VALUE_7 like", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7NotLike(String value) {
            addCriterion("SPEC_VALUE_7 not like", value, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7In(List<String> values) {
            addCriterion("SPEC_VALUE_7 in", values, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_7 not in", values, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_7 between", value1, value2, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue7NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_7 not between", value1, value2, "specValue7");
            return (Criteria) this;
        }

        public Criteria andSpecValue8IsNull() {
            addCriterion("SPEC_VALUE_8 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue8IsNotNull() {
            addCriterion("SPEC_VALUE_8 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue8EqualTo(String value) {
            addCriterion("SPEC_VALUE_8 =", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_8 <>", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8GreaterThan(String value) {
            addCriterion("SPEC_VALUE_8 >", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_8 >=", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8LessThan(String value) {
            addCriterion("SPEC_VALUE_8 <", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_8 <=", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8Like(String value) {
            addCriterion("SPEC_VALUE_8 like", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8NotLike(String value) {
            addCriterion("SPEC_VALUE_8 not like", value, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8In(List<String> values) {
            addCriterion("SPEC_VALUE_8 in", values, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_8 not in", values, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_8 between", value1, value2, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue8NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_8 not between", value1, value2, "specValue8");
            return (Criteria) this;
        }

        public Criteria andSpecValue9IsNull() {
            addCriterion("SPEC_VALUE_9 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue9IsNotNull() {
            addCriterion("SPEC_VALUE_9 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue9EqualTo(String value) {
            addCriterion("SPEC_VALUE_9 =", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_9 <>", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9GreaterThan(String value) {
            addCriterion("SPEC_VALUE_9 >", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_9 >=", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9LessThan(String value) {
            addCriterion("SPEC_VALUE_9 <", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_9 <=", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9Like(String value) {
            addCriterion("SPEC_VALUE_9 like", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9NotLike(String value) {
            addCriterion("SPEC_VALUE_9 not like", value, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9In(List<String> values) {
            addCriterion("SPEC_VALUE_9 in", values, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_9 not in", values, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_9 between", value1, value2, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue9NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_9 not between", value1, value2, "specValue9");
            return (Criteria) this;
        }

        public Criteria andSpecValue10IsNull() {
            addCriterion("SPEC_VALUE_10 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue10IsNotNull() {
            addCriterion("SPEC_VALUE_10 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue10EqualTo(String value) {
            addCriterion("SPEC_VALUE_10 =", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_10 <>", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10GreaterThan(String value) {
            addCriterion("SPEC_VALUE_10 >", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_10 >=", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10LessThan(String value) {
            addCriterion("SPEC_VALUE_10 <", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_10 <=", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10Like(String value) {
            addCriterion("SPEC_VALUE_10 like", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10NotLike(String value) {
            addCriterion("SPEC_VALUE_10 not like", value, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10In(List<String> values) {
            addCriterion("SPEC_VALUE_10 in", values, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_10 not in", values, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_10 between", value1, value2, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue10NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_10 not between", value1, value2, "specValue10");
            return (Criteria) this;
        }

        public Criteria andSpecValue11IsNull() {
            addCriterion("SPEC_VALUE_11 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue11IsNotNull() {
            addCriterion("SPEC_VALUE_11 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue11EqualTo(String value) {
            addCriterion("SPEC_VALUE_11 =", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_11 <>", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11GreaterThan(String value) {
            addCriterion("SPEC_VALUE_11 >", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_11 >=", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11LessThan(String value) {
            addCriterion("SPEC_VALUE_11 <", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_11 <=", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11Like(String value) {
            addCriterion("SPEC_VALUE_11 like", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11NotLike(String value) {
            addCriterion("SPEC_VALUE_11 not like", value, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11In(List<String> values) {
            addCriterion("SPEC_VALUE_11 in", values, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_11 not in", values, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_11 between", value1, value2, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue11NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_11 not between", value1, value2, "specValue11");
            return (Criteria) this;
        }

        public Criteria andSpecValue12IsNull() {
            addCriterion("SPEC_VALUE_12 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue12IsNotNull() {
            addCriterion("SPEC_VALUE_12 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue12EqualTo(String value) {
            addCriterion("SPEC_VALUE_12 =", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_12 <>", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12GreaterThan(String value) {
            addCriterion("SPEC_VALUE_12 >", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_12 >=", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12LessThan(String value) {
            addCriterion("SPEC_VALUE_12 <", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_12 <=", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12Like(String value) {
            addCriterion("SPEC_VALUE_12 like", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12NotLike(String value) {
            addCriterion("SPEC_VALUE_12 not like", value, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12In(List<String> values) {
            addCriterion("SPEC_VALUE_12 in", values, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_12 not in", values, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_12 between", value1, value2, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue12NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_12 not between", value1, value2, "specValue12");
            return (Criteria) this;
        }

        public Criteria andSpecValue13IsNull() {
            addCriterion("SPEC_VALUE_13 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue13IsNotNull() {
            addCriterion("SPEC_VALUE_13 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue13EqualTo(String value) {
            addCriterion("SPEC_VALUE_13 =", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_13 <>", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13GreaterThan(String value) {
            addCriterion("SPEC_VALUE_13 >", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_13 >=", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13LessThan(String value) {
            addCriterion("SPEC_VALUE_13 <", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_13 <=", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13Like(String value) {
            addCriterion("SPEC_VALUE_13 like", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13NotLike(String value) {
            addCriterion("SPEC_VALUE_13 not like", value, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13In(List<String> values) {
            addCriterion("SPEC_VALUE_13 in", values, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_13 not in", values, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_13 between", value1, value2, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue13NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_13 not between", value1, value2, "specValue13");
            return (Criteria) this;
        }

        public Criteria andSpecValue14IsNull() {
            addCriterion("SPEC_VALUE_14 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue14IsNotNull() {
            addCriterion("SPEC_VALUE_14 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue14EqualTo(String value) {
            addCriterion("SPEC_VALUE_14 =", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_14 <>", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14GreaterThan(String value) {
            addCriterion("SPEC_VALUE_14 >", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_14 >=", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14LessThan(String value) {
            addCriterion("SPEC_VALUE_14 <", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_14 <=", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14Like(String value) {
            addCriterion("SPEC_VALUE_14 like", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14NotLike(String value) {
            addCriterion("SPEC_VALUE_14 not like", value, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14In(List<String> values) {
            addCriterion("SPEC_VALUE_14 in", values, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_14 not in", values, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_14 between", value1, value2, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue14NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_14 not between", value1, value2, "specValue14");
            return (Criteria) this;
        }

        public Criteria andSpecValue15IsNull() {
            addCriterion("SPEC_VALUE_15 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue15IsNotNull() {
            addCriterion("SPEC_VALUE_15 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue15EqualTo(String value) {
            addCriterion("SPEC_VALUE_15 =", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_15 <>", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15GreaterThan(String value) {
            addCriterion("SPEC_VALUE_15 >", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_15 >=", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15LessThan(String value) {
            addCriterion("SPEC_VALUE_15 <", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_15 <=", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15Like(String value) {
            addCriterion("SPEC_VALUE_15 like", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15NotLike(String value) {
            addCriterion("SPEC_VALUE_15 not like", value, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15In(List<String> values) {
            addCriterion("SPEC_VALUE_15 in", values, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_15 not in", values, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_15 between", value1, value2, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue15NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_15 not between", value1, value2, "specValue15");
            return (Criteria) this;
        }

        public Criteria andSpecValue16IsNull() {
            addCriterion("SPEC_VALUE_16 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue16IsNotNull() {
            addCriterion("SPEC_VALUE_16 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue16EqualTo(String value) {
            addCriterion("SPEC_VALUE_16 =", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_16 <>", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16GreaterThan(String value) {
            addCriterion("SPEC_VALUE_16 >", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_16 >=", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16LessThan(String value) {
            addCriterion("SPEC_VALUE_16 <", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_16 <=", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16Like(String value) {
            addCriterion("SPEC_VALUE_16 like", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16NotLike(String value) {
            addCriterion("SPEC_VALUE_16 not like", value, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16In(List<String> values) {
            addCriterion("SPEC_VALUE_16 in", values, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_16 not in", values, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_16 between", value1, value2, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue16NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_16 not between", value1, value2, "specValue16");
            return (Criteria) this;
        }

        public Criteria andSpecValue17IsNull() {
            addCriterion("SPEC_VALUE_17 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue17IsNotNull() {
            addCriterion("SPEC_VALUE_17 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue17EqualTo(String value) {
            addCriterion("SPEC_VALUE_17 =", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_17 <>", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17GreaterThan(String value) {
            addCriterion("SPEC_VALUE_17 >", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_17 >=", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17LessThan(String value) {
            addCriterion("SPEC_VALUE_17 <", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_17 <=", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17Like(String value) {
            addCriterion("SPEC_VALUE_17 like", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17NotLike(String value) {
            addCriterion("SPEC_VALUE_17 not like", value, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17In(List<String> values) {
            addCriterion("SPEC_VALUE_17 in", values, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_17 not in", values, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_17 between", value1, value2, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue17NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_17 not between", value1, value2, "specValue17");
            return (Criteria) this;
        }

        public Criteria andSpecValue18IsNull() {
            addCriterion("SPEC_VALUE_18 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue18IsNotNull() {
            addCriterion("SPEC_VALUE_18 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue18EqualTo(String value) {
            addCriterion("SPEC_VALUE_18 =", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_18 <>", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18GreaterThan(String value) {
            addCriterion("SPEC_VALUE_18 >", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_18 >=", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18LessThan(String value) {
            addCriterion("SPEC_VALUE_18 <", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_18 <=", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18Like(String value) {
            addCriterion("SPEC_VALUE_18 like", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18NotLike(String value) {
            addCriterion("SPEC_VALUE_18 not like", value, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18In(List<String> values) {
            addCriterion("SPEC_VALUE_18 in", values, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_18 not in", values, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_18 between", value1, value2, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue18NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_18 not between", value1, value2, "specValue18");
            return (Criteria) this;
        }

        public Criteria andSpecValue19IsNull() {
            addCriterion("SPEC_VALUE_19 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue19IsNotNull() {
            addCriterion("SPEC_VALUE_19 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue19EqualTo(String value) {
            addCriterion("SPEC_VALUE_19 =", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_19 <>", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19GreaterThan(String value) {
            addCriterion("SPEC_VALUE_19 >", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_19 >=", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19LessThan(String value) {
            addCriterion("SPEC_VALUE_19 <", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_19 <=", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19Like(String value) {
            addCriterion("SPEC_VALUE_19 like", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19NotLike(String value) {
            addCriterion("SPEC_VALUE_19 not like", value, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19In(List<String> values) {
            addCriterion("SPEC_VALUE_19 in", values, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_19 not in", values, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_19 between", value1, value2, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue19NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_19 not between", value1, value2, "specValue19");
            return (Criteria) this;
        }

        public Criteria andSpecValue20IsNull() {
            addCriterion("SPEC_VALUE_20 is null");
            return (Criteria) this;
        }

        public Criteria andSpecValue20IsNotNull() {
            addCriterion("SPEC_VALUE_20 is not null");
            return (Criteria) this;
        }

        public Criteria andSpecValue20EqualTo(String value) {
            addCriterion("SPEC_VALUE_20 =", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20NotEqualTo(String value) {
            addCriterion("SPEC_VALUE_20 <>", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20GreaterThan(String value) {
            addCriterion("SPEC_VALUE_20 >", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20GreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_20 >=", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20LessThan(String value) {
            addCriterion("SPEC_VALUE_20 <", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20LessThanOrEqualTo(String value) {
            addCriterion("SPEC_VALUE_20 <=", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20Like(String value) {
            addCriterion("SPEC_VALUE_20 like", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20NotLike(String value) {
            addCriterion("SPEC_VALUE_20 not like", value, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20In(List<String> values) {
            addCriterion("SPEC_VALUE_20 in", values, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20NotIn(List<String> values) {
            addCriterion("SPEC_VALUE_20 not in", values, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20Between(String value1, String value2) {
            addCriterion("SPEC_VALUE_20 between", value1, value2, "specValue20");
            return (Criteria) this;
        }

        public Criteria andSpecValue20NotBetween(String value1, String value2) {
            addCriterion("SPEC_VALUE_20 not between", value1, value2, "specValue20");
            return (Criteria) this;
        }

        public Criteria andIsSjIsNull() {
            addCriterion("IS_SJ is null");
            return (Criteria) this;
        }

        public Criteria andIsSjIsNotNull() {
            addCriterion("IS_SJ is not null");
            return (Criteria) this;
        }

        public Criteria andIsSjEqualTo(String value) {
            addCriterion("IS_SJ =", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjNotEqualTo(String value) {
            addCriterion("IS_SJ <>", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjGreaterThan(String value) {
            addCriterion("IS_SJ >", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SJ >=", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjLessThan(String value) {
            addCriterion("IS_SJ <", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjLessThanOrEqualTo(String value) {
            addCriterion("IS_SJ <=", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjLike(String value) {
            addCriterion("IS_SJ like", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjNotLike(String value) {
            addCriterion("IS_SJ not like", value, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjIn(List<String> values) {
            addCriterion("IS_SJ in", values, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjNotIn(List<String> values) {
            addCriterion("IS_SJ not in", values, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjBetween(String value1, String value2) {
            addCriterion("IS_SJ between", value1, value2, "isSj");
            return (Criteria) this;
        }

        public Criteria andIsSjNotBetween(String value1, String value2) {
            addCriterion("IS_SJ not between", value1, value2, "isSj");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
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

        public Criteria andDeliveryIdIsNull() {
            addCriterion("DELIVERY_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIsNotNull() {
            addCriterion("DELIVERY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdEqualTo(Integer value) {
            addCriterion("DELIVERY_ID =", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotEqualTo(Integer value) {
            addCriterion("DELIVERY_ID <>", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThan(Integer value) {
            addCriterion("DELIVERY_ID >", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELIVERY_ID >=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThan(Integer value) {
            addCriterion("DELIVERY_ID <", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThanOrEqualTo(Integer value) {
            addCriterion("DELIVERY_ID <=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIn(List<Integer> values) {
            addCriterion("DELIVERY_ID in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotIn(List<Integer> values) {
            addCriterion("DELIVERY_ID not in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdBetween(Integer value1, Integer value2) {
            addCriterion("DELIVERY_ID between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DELIVERY_ID not between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdIsNull() {
            addCriterion("SHANGJIAINFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdIsNotNull() {
            addCriterion("SHANGJIAINFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID =", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdNotEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID <>", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdGreaterThan(Integer value) {
            addCriterion("SHANGJIAINFO_ID >", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID >=", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdLessThan(Integer value) {
            addCriterion("SHANGJIAINFO_ID <", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("SHANGJIAINFO_ID <=", value, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdIn(List<Integer> values) {
            addCriterion("SHANGJIAINFO_ID in", values, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdNotIn(List<Integer> values) {
            addCriterion("SHANGJIAINFO_ID not in", values, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdBetween(Integer value1, Integer value2) {
            addCriterion("SHANGJIAINFO_ID between", value1, value2, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andShangjiainfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SHANGJIAINFO_ID not between", value1, value2, "shangjiainfoId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdIsNull() {
            addCriterion("CUSTOM_SORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdIsNotNull() {
            addCriterion("CUSTOM_SORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdEqualTo(Integer value) {
            addCriterion("CUSTOM_SORT_ID =", value, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdNotEqualTo(Integer value) {
            addCriterion("CUSTOM_SORT_ID <>", value, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdGreaterThan(Integer value) {
            addCriterion("CUSTOM_SORT_ID >", value, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUSTOM_SORT_ID >=", value, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdLessThan(Integer value) {
            addCriterion("CUSTOM_SORT_ID <", value, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("CUSTOM_SORT_ID <=", value, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdIn(List<Integer> values) {
            addCriterion("CUSTOM_SORT_ID in", values, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdNotIn(List<Integer> values) {
            addCriterion("CUSTOM_SORT_ID not in", values, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOM_SORT_ID between", value1, value2, "customSortId");
            return (Criteria) this;
        }

        public Criteria andCustomSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOM_SORT_ID not between", value1, value2, "customSortId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andPriceRangeIsNull() {
            addCriterion("PRICE_RANGE is null");
            return (Criteria) this;
        }

        public Criteria andPriceRangeIsNotNull() {
            addCriterion("PRICE_RANGE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceRangeEqualTo(String value) {
            addCriterion("PRICE_RANGE =", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotEqualTo(String value) {
            addCriterion("PRICE_RANGE <>", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeGreaterThan(String value) {
            addCriterion("PRICE_RANGE >", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_RANGE >=", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLessThan(String value) {
            addCriterion("PRICE_RANGE <", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLessThanOrEqualTo(String value) {
            addCriterion("PRICE_RANGE <=", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLike(String value) {
            addCriterion("PRICE_RANGE like", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotLike(String value) {
            addCriterion("PRICE_RANGE not like", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeIn(List<String> values) {
            addCriterion("PRICE_RANGE in", values, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotIn(List<String> values) {
            addCriterion("PRICE_RANGE not in", values, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeBetween(String value1, String value2) {
            addCriterion("PRICE_RANGE between", value1, value2, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotBetween(String value1, String value2) {
            addCriterion("PRICE_RANGE not between", value1, value2, "priceRange");
            return (Criteria) this;
        }

        public Criteria andIshgIsNull() {
            addCriterion("ISHG is null");
            return (Criteria) this;
        }

        public Criteria andIshgIsNotNull() {
            addCriterion("ISHG is not null");
            return (Criteria) this;
        }

        public Criteria andIshgEqualTo(Integer value) {
            addCriterion("ISHG =", value, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgNotEqualTo(Integer value) {
            addCriterion("ISHG <>", value, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgGreaterThan(Integer value) {
            addCriterion("ISHG >", value, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISHG >=", value, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgLessThan(Integer value) {
            addCriterion("ISHG <", value, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgLessThanOrEqualTo(Integer value) {
            addCriterion("ISHG <=", value, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgIn(List<Integer> values) {
            addCriterion("ISHG in", values, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgNotIn(List<Integer> values) {
            addCriterion("ISHG not in", values, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgBetween(Integer value1, Integer value2) {
            addCriterion("ISHG between", value1, value2, "ishg");
            return (Criteria) this;
        }

        public Criteria andIshgNotBetween(Integer value1, Integer value2) {
            addCriterion("ISHG not between", value1, value2, "ishg");
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