package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class ZffsModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ZffsModelCriteria() {
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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

        public Criteria andZfbIdIsNull() {
            addCriterion("ZFB_ID is null");
            return (Criteria) this;
        }

        public Criteria andZfbIdIsNotNull() {
            addCriterion("ZFB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andZfbIdEqualTo(String value) {
            addCriterion("ZFB_ID =", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdNotEqualTo(String value) {
            addCriterion("ZFB_ID <>", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdGreaterThan(String value) {
            addCriterion("ZFB_ID >", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdGreaterThanOrEqualTo(String value) {
            addCriterion("ZFB_ID >=", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdLessThan(String value) {
            addCriterion("ZFB_ID <", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdLessThanOrEqualTo(String value) {
            addCriterion("ZFB_ID <=", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdLike(String value) {
            addCriterion("ZFB_ID like", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdNotLike(String value) {
            addCriterion("ZFB_ID not like", value, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdIn(List<String> values) {
            addCriterion("ZFB_ID in", values, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdNotIn(List<String> values) {
            addCriterion("ZFB_ID not in", values, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdBetween(String value1, String value2) {
            addCriterion("ZFB_ID between", value1, value2, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbIdNotBetween(String value1, String value2) {
            addCriterion("ZFB_ID not between", value1, value2, "zfbId");
            return (Criteria) this;
        }

        public Criteria andZfbCodeIsNull() {
            addCriterion("ZFB_CODE is null");
            return (Criteria) this;
        }

        public Criteria andZfbCodeIsNotNull() {
            addCriterion("ZFB_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andZfbCodeEqualTo(String value) {
            addCriterion("ZFB_CODE =", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeNotEqualTo(String value) {
            addCriterion("ZFB_CODE <>", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeGreaterThan(String value) {
            addCriterion("ZFB_CODE >", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ZFB_CODE >=", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeLessThan(String value) {
            addCriterion("ZFB_CODE <", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeLessThanOrEqualTo(String value) {
            addCriterion("ZFB_CODE <=", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeLike(String value) {
            addCriterion("ZFB_CODE like", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeNotLike(String value) {
            addCriterion("ZFB_CODE not like", value, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeIn(List<String> values) {
            addCriterion("ZFB_CODE in", values, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeNotIn(List<String> values) {
            addCriterion("ZFB_CODE not in", values, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeBetween(String value1, String value2) {
            addCriterion("ZFB_CODE between", value1, value2, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbCodeNotBetween(String value1, String value2) {
            addCriterion("ZFB_CODE not between", value1, value2, "zfbCode");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoIsNull() {
            addCriterion("ZFB_ZHANGHAO is null");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoIsNotNull() {
            addCriterion("ZFB_ZHANGHAO is not null");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoEqualTo(String value) {
            addCriterion("ZFB_ZHANGHAO =", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoNotEqualTo(String value) {
            addCriterion("ZFB_ZHANGHAO <>", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoGreaterThan(String value) {
            addCriterion("ZFB_ZHANGHAO >", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoGreaterThanOrEqualTo(String value) {
            addCriterion("ZFB_ZHANGHAO >=", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoLessThan(String value) {
            addCriterion("ZFB_ZHANGHAO <", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoLessThanOrEqualTo(String value) {
            addCriterion("ZFB_ZHANGHAO <=", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoLike(String value) {
            addCriterion("ZFB_ZHANGHAO like", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoNotLike(String value) {
            addCriterion("ZFB_ZHANGHAO not like", value, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoIn(List<String> values) {
            addCriterion("ZFB_ZHANGHAO in", values, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoNotIn(List<String> values) {
            addCriterion("ZFB_ZHANGHAO not in", values, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoBetween(String value1, String value2) {
            addCriterion("ZFB_ZHANGHAO between", value1, value2, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andZfbZhanghaoNotBetween(String value1, String value2) {
            addCriterion("ZFB_ZHANGHAO not between", value1, value2, "zfbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoIsNull() {
            addCriterion("CFTJS_ZHANGHAO is null");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoIsNotNull() {
            addCriterion("CFTJS_ZHANGHAO is not null");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoEqualTo(String value) {
            addCriterion("CFTJS_ZHANGHAO =", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoNotEqualTo(String value) {
            addCriterion("CFTJS_ZHANGHAO <>", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoGreaterThan(String value) {
            addCriterion("CFTJS_ZHANGHAO >", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoGreaterThanOrEqualTo(String value) {
            addCriterion("CFTJS_ZHANGHAO >=", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoLessThan(String value) {
            addCriterion("CFTJS_ZHANGHAO <", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoLessThanOrEqualTo(String value) {
            addCriterion("CFTJS_ZHANGHAO <=", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoLike(String value) {
            addCriterion("CFTJS_ZHANGHAO like", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoNotLike(String value) {
            addCriterion("CFTJS_ZHANGHAO not like", value, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoIn(List<String> values) {
            addCriterion("CFTJS_ZHANGHAO in", values, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoNotIn(List<String> values) {
            addCriterion("CFTJS_ZHANGHAO not in", values, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoBetween(String value1, String value2) {
            addCriterion("CFTJS_ZHANGHAO between", value1, value2, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsZhanghaoNotBetween(String value1, String value2) {
            addCriterion("CFTJS_ZHANGHAO not between", value1, value2, "cftjsZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyIsNull() {
            addCriterion("CFTJS_KEY is null");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyIsNotNull() {
            addCriterion("CFTJS_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyEqualTo(String value) {
            addCriterion("CFTJS_KEY =", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyNotEqualTo(String value) {
            addCriterion("CFTJS_KEY <>", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyGreaterThan(String value) {
            addCriterion("CFTJS_KEY >", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyGreaterThanOrEqualTo(String value) {
            addCriterion("CFTJS_KEY >=", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyLessThan(String value) {
            addCriterion("CFTJS_KEY <", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyLessThanOrEqualTo(String value) {
            addCriterion("CFTJS_KEY <=", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyLike(String value) {
            addCriterion("CFTJS_KEY like", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyNotLike(String value) {
            addCriterion("CFTJS_KEY not like", value, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyIn(List<String> values) {
            addCriterion("CFTJS_KEY in", values, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyNotIn(List<String> values) {
            addCriterion("CFTJS_KEY not in", values, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyBetween(String value1, String value2) {
            addCriterion("CFTJS_KEY between", value1, value2, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftjsKeyNotBetween(String value1, String value2) {
            addCriterion("CFTJS_KEY not between", value1, value2, "cftjsKey");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoIsNull() {
            addCriterion("CFTDB_ZHANGHAO is null");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoIsNotNull() {
            addCriterion("CFTDB_ZHANGHAO is not null");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoEqualTo(String value) {
            addCriterion("CFTDB_ZHANGHAO =", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoNotEqualTo(String value) {
            addCriterion("CFTDB_ZHANGHAO <>", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoGreaterThan(String value) {
            addCriterion("CFTDB_ZHANGHAO >", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoGreaterThanOrEqualTo(String value) {
            addCriterion("CFTDB_ZHANGHAO >=", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoLessThan(String value) {
            addCriterion("CFTDB_ZHANGHAO <", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoLessThanOrEqualTo(String value) {
            addCriterion("CFTDB_ZHANGHAO <=", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoLike(String value) {
            addCriterion("CFTDB_ZHANGHAO like", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoNotLike(String value) {
            addCriterion("CFTDB_ZHANGHAO not like", value, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoIn(List<String> values) {
            addCriterion("CFTDB_ZHANGHAO in", values, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoNotIn(List<String> values) {
            addCriterion("CFTDB_ZHANGHAO not in", values, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoBetween(String value1, String value2) {
            addCriterion("CFTDB_ZHANGHAO between", value1, value2, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbZhanghaoNotBetween(String value1, String value2) {
            addCriterion("CFTDB_ZHANGHAO not between", value1, value2, "cftdbZhanghao");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyIsNull() {
            addCriterion("CFTDB_KEY is null");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyIsNotNull() {
            addCriterion("CFTDB_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyEqualTo(String value) {
            addCriterion("CFTDB_KEY =", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyNotEqualTo(String value) {
            addCriterion("CFTDB_KEY <>", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyGreaterThan(String value) {
            addCriterion("CFTDB_KEY >", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyGreaterThanOrEqualTo(String value) {
            addCriterion("CFTDB_KEY >=", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyLessThan(String value) {
            addCriterion("CFTDB_KEY <", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyLessThanOrEqualTo(String value) {
            addCriterion("CFTDB_KEY <=", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyLike(String value) {
            addCriterion("CFTDB_KEY like", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyNotLike(String value) {
            addCriterion("CFTDB_KEY not like", value, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyIn(List<String> values) {
            addCriterion("CFTDB_KEY in", values, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyNotIn(List<String> values) {
            addCriterion("CFTDB_KEY not in", values, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyBetween(String value1, String value2) {
            addCriterion("CFTDB_KEY between", value1, value2, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andCftdbKeyNotBetween(String value1, String value2) {
            addCriterion("CFTDB_KEY not between", value1, value2, "cftdbKey");
            return (Criteria) this;
        }

        public Criteria andValue1IsNull() {
            addCriterion("VALUE1 is null");
            return (Criteria) this;
        }

        public Criteria andValue1IsNotNull() {
            addCriterion("VALUE1 is not null");
            return (Criteria) this;
        }

        public Criteria andValue1EqualTo(String value) {
            addCriterion("VALUE1 =", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotEqualTo(String value) {
            addCriterion("VALUE1 <>", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThan(String value) {
            addCriterion("VALUE1 >", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThanOrEqualTo(String value) {
            addCriterion("VALUE1 >=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThan(String value) {
            addCriterion("VALUE1 <", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThanOrEqualTo(String value) {
            addCriterion("VALUE1 <=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Like(String value) {
            addCriterion("VALUE1 like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotLike(String value) {
            addCriterion("VALUE1 not like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1In(List<String> values) {
            addCriterion("VALUE1 in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotIn(List<String> values) {
            addCriterion("VALUE1 not in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Between(String value1, String value2) {
            addCriterion("VALUE1 between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotBetween(String value1, String value2) {
            addCriterion("VALUE1 not between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue2IsNull() {
            addCriterion("VALUE2 is null");
            return (Criteria) this;
        }

        public Criteria andValue2IsNotNull() {
            addCriterion("VALUE2 is not null");
            return (Criteria) this;
        }

        public Criteria andValue2EqualTo(String value) {
            addCriterion("VALUE2 =", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotEqualTo(String value) {
            addCriterion("VALUE2 <>", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThan(String value) {
            addCriterion("VALUE2 >", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThanOrEqualTo(String value) {
            addCriterion("VALUE2 >=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThan(String value) {
            addCriterion("VALUE2 <", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThanOrEqualTo(String value) {
            addCriterion("VALUE2 <=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Like(String value) {
            addCriterion("VALUE2 like", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotLike(String value) {
            addCriterion("VALUE2 not like", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2In(List<String> values) {
            addCriterion("VALUE2 in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotIn(List<String> values) {
            addCriterion("VALUE2 not in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Between(String value1, String value2) {
            addCriterion("VALUE2 between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotBetween(String value1, String value2) {
            addCriterion("VALUE2 not between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue3IsNull() {
            addCriterion("VALUE3 is null");
            return (Criteria) this;
        }

        public Criteria andValue3IsNotNull() {
            addCriterion("VALUE3 is not null");
            return (Criteria) this;
        }

        public Criteria andValue3EqualTo(String value) {
            addCriterion("VALUE3 =", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotEqualTo(String value) {
            addCriterion("VALUE3 <>", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3GreaterThan(String value) {
            addCriterion("VALUE3 >", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3GreaterThanOrEqualTo(String value) {
            addCriterion("VALUE3 >=", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3LessThan(String value) {
            addCriterion("VALUE3 <", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3LessThanOrEqualTo(String value) {
            addCriterion("VALUE3 <=", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3Like(String value) {
            addCriterion("VALUE3 like", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotLike(String value) {
            addCriterion("VALUE3 not like", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3In(List<String> values) {
            addCriterion("VALUE3 in", values, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotIn(List<String> values) {
            addCriterion("VALUE3 not in", values, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3Between(String value1, String value2) {
            addCriterion("VALUE3 between", value1, value2, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotBetween(String value1, String value2) {
            addCriterion("VALUE3 not between", value1, value2, "value3");
            return (Criteria) this;
        }

        public Criteria andValue4IsNull() {
            addCriterion("VALUE4 is null");
            return (Criteria) this;
        }

        public Criteria andValue4IsNotNull() {
            addCriterion("VALUE4 is not null");
            return (Criteria) this;
        }

        public Criteria andValue4EqualTo(String value) {
            addCriterion("VALUE4 =", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotEqualTo(String value) {
            addCriterion("VALUE4 <>", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4GreaterThan(String value) {
            addCriterion("VALUE4 >", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4GreaterThanOrEqualTo(String value) {
            addCriterion("VALUE4 >=", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4LessThan(String value) {
            addCriterion("VALUE4 <", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4LessThanOrEqualTo(String value) {
            addCriterion("VALUE4 <=", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4Like(String value) {
            addCriterion("VALUE4 like", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotLike(String value) {
            addCriterion("VALUE4 not like", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4In(List<String> values) {
            addCriterion("VALUE4 in", values, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotIn(List<String> values) {
            addCriterion("VALUE4 not in", values, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4Between(String value1, String value2) {
            addCriterion("VALUE4 between", value1, value2, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotBetween(String value1, String value2) {
            addCriterion("VALUE4 not between", value1, value2, "value4");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andZfbKeyIsNull() {
            addCriterion("ZFB_KEY is null");
            return (Criteria) this;
        }

        public Criteria andZfbKeyIsNotNull() {
            addCriterion("ZFB_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andZfbKeyEqualTo(String value) {
            addCriterion("ZFB_KEY =", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyNotEqualTo(String value) {
            addCriterion("ZFB_KEY <>", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyGreaterThan(String value) {
            addCriterion("ZFB_KEY >", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ZFB_KEY >=", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyLessThan(String value) {
            addCriterion("ZFB_KEY <", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyLessThanOrEqualTo(String value) {
            addCriterion("ZFB_KEY <=", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyLike(String value) {
            addCriterion("ZFB_KEY like", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyNotLike(String value) {
            addCriterion("ZFB_KEY not like", value, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyIn(List<String> values) {
            addCriterion("ZFB_KEY in", values, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyNotIn(List<String> values) {
            addCriterion("ZFB_KEY not in", values, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyBetween(String value1, String value2) {
            addCriterion("ZFB_KEY between", value1, value2, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andZfbKeyNotBetween(String value1, String value2) {
            addCriterion("ZFB_KEY not between", value1, value2, "zfbKey");
            return (Criteria) this;
        }

        public Criteria andWidgetNameIsNull() {
            addCriterion("WIDGET_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWidgetNameIsNotNull() {
            addCriterion("WIDGET_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWidgetNameEqualTo(String value) {
            addCriterion("WIDGET_NAME =", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameNotEqualTo(String value) {
            addCriterion("WIDGET_NAME <>", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameGreaterThan(String value) {
            addCriterion("WIDGET_NAME >", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameGreaterThanOrEqualTo(String value) {
            addCriterion("WIDGET_NAME >=", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameLessThan(String value) {
            addCriterion("WIDGET_NAME <", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameLessThanOrEqualTo(String value) {
            addCriterion("WIDGET_NAME <=", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameLike(String value) {
            addCriterion("WIDGET_NAME like", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameNotLike(String value) {
            addCriterion("WIDGET_NAME not like", value, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameIn(List<String> values) {
            addCriterion("WIDGET_NAME in", values, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameNotIn(List<String> values) {
            addCriterion("WIDGET_NAME not in", values, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameBetween(String value1, String value2) {
            addCriterion("WIDGET_NAME between", value1, value2, "widgetName");
            return (Criteria) this;
        }

        public Criteria andWidgetNameNotBetween(String value1, String value2) {
            addCriterion("WIDGET_NAME not between", value1, value2, "widgetName");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("BODY is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("BODY is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("BODY =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("BODY <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("BODY >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("BODY >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("BODY <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("BODY <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("BODY like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("BODY not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("BODY in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("BODY not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("BODY between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("BODY not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("NOTIFY_URL is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("NOTIFY_URL is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("NOTIFY_URL =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("NOTIFY_URL <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("NOTIFY_URL >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("NOTIFY_URL <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("NOTIFY_URL like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("NOTIFY_URL not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("NOTIFY_URL in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("NOTIFY_URL not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("RETURN_URL is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("RETURN_URL is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("RETURN_URL =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("RETURN_URL <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("RETURN_URL >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_URL >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("RETURN_URL <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("RETURN_URL <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("RETURN_URL like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("RETURN_URL not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("RETURN_URL in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("RETURN_URL not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("RETURN_URL between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("RETURN_URL not between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlIsNull() {
            addCriterion("SHOW_URL is null");
            return (Criteria) this;
        }

        public Criteria andShowUrlIsNotNull() {
            addCriterion("SHOW_URL is not null");
            return (Criteria) this;
        }

        public Criteria andShowUrlEqualTo(String value) {
            addCriterion("SHOW_URL =", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotEqualTo(String value) {
            addCriterion("SHOW_URL <>", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlGreaterThan(String value) {
            addCriterion("SHOW_URL >", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlGreaterThanOrEqualTo(String value) {
            addCriterion("SHOW_URL >=", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLessThan(String value) {
            addCriterion("SHOW_URL <", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLessThanOrEqualTo(String value) {
            addCriterion("SHOW_URL <=", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLike(String value) {
            addCriterion("SHOW_URL like", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotLike(String value) {
            addCriterion("SHOW_URL not like", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlIn(List<String> values) {
            addCriterion("SHOW_URL in", values, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotIn(List<String> values) {
            addCriterion("SHOW_URL not in", values, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlBetween(String value1, String value2) {
            addCriterion("SHOW_URL between", value1, value2, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotBetween(String value1, String value2) {
            addCriterion("SHOW_URL not between", value1, value2, "showUrl");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("SUBJECT =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("SUBJECT <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("SUBJECT >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("SUBJECT <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("SUBJECT like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("SUBJECT not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("SUBJECT in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("SUBJECT not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("SUBJECT between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("SUBJECT not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andJianchenIsNull() {
            addCriterion("JIANCHEN is null");
            return (Criteria) this;
        }

        public Criteria andJianchenIsNotNull() {
            addCriterion("JIANCHEN is not null");
            return (Criteria) this;
        }

        public Criteria andJianchenEqualTo(String value) {
            addCriterion("JIANCHEN =", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenNotEqualTo(String value) {
            addCriterion("JIANCHEN <>", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenGreaterThan(String value) {
            addCriterion("JIANCHEN >", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenGreaterThanOrEqualTo(String value) {
            addCriterion("JIANCHEN >=", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenLessThan(String value) {
            addCriterion("JIANCHEN <", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenLessThanOrEqualTo(String value) {
            addCriterion("JIANCHEN <=", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenLike(String value) {
            addCriterion("JIANCHEN like", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenNotLike(String value) {
            addCriterion("JIANCHEN not like", value, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenIn(List<String> values) {
            addCriterion("JIANCHEN in", values, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenNotIn(List<String> values) {
            addCriterion("JIANCHEN not in", values, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenBetween(String value1, String value2) {
            addCriterion("JIANCHEN between", value1, value2, "jianchen");
            return (Criteria) this;
        }

        public Criteria andJianchenNotBetween(String value1, String value2) {
            addCriterion("JIANCHEN not between", value1, value2, "jianchen");
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