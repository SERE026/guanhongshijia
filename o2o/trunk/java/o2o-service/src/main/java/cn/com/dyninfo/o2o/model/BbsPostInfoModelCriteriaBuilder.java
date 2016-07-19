package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class BbsPostInfoModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BbsPostInfoModelCriteriaBuilder() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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

        public Criteria andHtimeIsNull() {
            addCriterion("HTIME is null");
            return (Criteria) this;
        }

        public Criteria andHtimeIsNotNull() {
            addCriterion("HTIME is not null");
            return (Criteria) this;
        }

        public Criteria andHtimeEqualTo(String value) {
            addCriterion("HTIME =", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotEqualTo(String value) {
            addCriterion("HTIME <>", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeGreaterThan(String value) {
            addCriterion("HTIME >", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeGreaterThanOrEqualTo(String value) {
            addCriterion("HTIME >=", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeLessThan(String value) {
            addCriterion("HTIME <", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeLessThanOrEqualTo(String value) {
            addCriterion("HTIME <=", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeLike(String value) {
            addCriterion("HTIME like", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotLike(String value) {
            addCriterion("HTIME not like", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeIn(List<String> values) {
            addCriterion("HTIME in", values, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotIn(List<String> values) {
            addCriterion("HTIME not in", values, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeBetween(String value1, String value2) {
            addCriterion("HTIME between", value1, value2, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotBetween(String value1, String value2) {
            addCriterion("HTIME not between", value1, value2, "htime");
            return (Criteria) this;
        }

        public Criteria andHuserIdIsNull() {
            addCriterion("HUSER_ID is null");
            return (Criteria) this;
        }

        public Criteria andHuserIdIsNotNull() {
            addCriterion("HUSER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHuserIdEqualTo(String value) {
            addCriterion("HUSER_ID =", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdNotEqualTo(String value) {
            addCriterion("HUSER_ID <>", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdGreaterThan(String value) {
            addCriterion("HUSER_ID >", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdGreaterThanOrEqualTo(String value) {
            addCriterion("HUSER_ID >=", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdLessThan(String value) {
            addCriterion("HUSER_ID <", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdLessThanOrEqualTo(String value) {
            addCriterion("HUSER_ID <=", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdLike(String value) {
            addCriterion("HUSER_ID like", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdNotLike(String value) {
            addCriterion("HUSER_ID not like", value, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdIn(List<String> values) {
            addCriterion("HUSER_ID in", values, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdNotIn(List<String> values) {
            addCriterion("HUSER_ID not in", values, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdBetween(String value1, String value2) {
            addCriterion("HUSER_ID between", value1, value2, "huserId");
            return (Criteria) this;
        }

        public Criteria andHuserIdNotBetween(String value1, String value2) {
            addCriterion("HUSER_ID not between", value1, value2, "huserId");
            return (Criteria) this;
        }

        public Criteria andHnumIsNull() {
            addCriterion("HNUM is null");
            return (Criteria) this;
        }

        public Criteria andHnumIsNotNull() {
            addCriterion("HNUM is not null");
            return (Criteria) this;
        }

        public Criteria andHnumEqualTo(Integer value) {
            addCriterion("HNUM =", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotEqualTo(Integer value) {
            addCriterion("HNUM <>", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumGreaterThan(Integer value) {
            addCriterion("HNUM >", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("HNUM >=", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumLessThan(Integer value) {
            addCriterion("HNUM <", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumLessThanOrEqualTo(Integer value) {
            addCriterion("HNUM <=", value, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumIn(List<Integer> values) {
            addCriterion("HNUM in", values, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotIn(List<Integer> values) {
            addCriterion("HNUM not in", values, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumBetween(Integer value1, Integer value2) {
            addCriterion("HNUM between", value1, value2, "hnum");
            return (Criteria) this;
        }

        public Criteria andHnumNotBetween(Integer value1, Integer value2) {
            addCriterion("HNUM not between", value1, value2, "hnum");
            return (Criteria) this;
        }

        public Criteria andSnumIsNull() {
            addCriterion("SNUM is null");
            return (Criteria) this;
        }

        public Criteria andSnumIsNotNull() {
            addCriterion("SNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSnumEqualTo(Integer value) {
            addCriterion("SNUM =", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotEqualTo(Integer value) {
            addCriterion("SNUM <>", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThan(Integer value) {
            addCriterion("SNUM >", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNUM >=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThan(Integer value) {
            addCriterion("SNUM <", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThanOrEqualTo(Integer value) {
            addCriterion("SNUM <=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumIn(List<Integer> values) {
            addCriterion("SNUM in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotIn(List<Integer> values) {
            addCriterion("SNUM not in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumBetween(Integer value1, Integer value2) {
            addCriterion("SNUM between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotBetween(Integer value1, Integer value2) {
            addCriterion("SNUM not between", value1, value2, "snum");
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

        public Criteria andTopIsNull() {
            addCriterion("TOP is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("TOP is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(Integer value) {
            addCriterion("TOP =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(Integer value) {
            addCriterion("TOP <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(Integer value) {
            addCriterion("TOP >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOP >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(Integer value) {
            addCriterion("TOP <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(Integer value) {
            addCriterion("TOP <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<Integer> values) {
            addCriterion("TOP in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<Integer> values) {
            addCriterion("TOP not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(Integer value1, Integer value2) {
            addCriterion("TOP between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(Integer value1, Integer value2) {
            addCriterion("TOP not between", value1, value2, "top");
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