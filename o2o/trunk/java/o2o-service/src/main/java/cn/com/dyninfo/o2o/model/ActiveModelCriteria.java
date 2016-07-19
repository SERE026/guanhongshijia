package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class ActiveModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ActiveModelCriteria() {
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

        public Criteria andBdateIsNull() {
            addCriterion("BDATE is null");
            return (Criteria) this;
        }

        public Criteria andBdateIsNotNull() {
            addCriterion("BDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBdateEqualTo(String value) {
            addCriterion("BDATE =", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotEqualTo(String value) {
            addCriterion("BDATE <>", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateGreaterThan(String value) {
            addCriterion("BDATE >", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateGreaterThanOrEqualTo(String value) {
            addCriterion("BDATE >=", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLessThan(String value) {
            addCriterion("BDATE <", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLessThanOrEqualTo(String value) {
            addCriterion("BDATE <=", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLike(String value) {
            addCriterion("BDATE like", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotLike(String value) {
            addCriterion("BDATE not like", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateIn(List<String> values) {
            addCriterion("BDATE in", values, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotIn(List<String> values) {
            addCriterion("BDATE not in", values, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateBetween(String value1, String value2) {
            addCriterion("BDATE between", value1, value2, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotBetween(String value1, String value2) {
            addCriterion("BDATE not between", value1, value2, "bdate");
            return (Criteria) this;
        }

        public Criteria andEdateIsNull() {
            addCriterion("EDATE is null");
            return (Criteria) this;
        }

        public Criteria andEdateIsNotNull() {
            addCriterion("EDATE is not null");
            return (Criteria) this;
        }

        public Criteria andEdateEqualTo(String value) {
            addCriterion("EDATE =", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotEqualTo(String value) {
            addCriterion("EDATE <>", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThan(String value) {
            addCriterion("EDATE >", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThanOrEqualTo(String value) {
            addCriterion("EDATE >=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThan(String value) {
            addCriterion("EDATE <", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThanOrEqualTo(String value) {
            addCriterion("EDATE <=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLike(String value) {
            addCriterion("EDATE like", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotLike(String value) {
            addCriterion("EDATE not like", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateIn(List<String> values) {
            addCriterion("EDATE in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotIn(List<String> values) {
            addCriterion("EDATE not in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateBetween(String value1, String value2) {
            addCriterion("EDATE between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotBetween(String value1, String value2) {
            addCriterion("EDATE not between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andBtimeIsNull() {
            addCriterion("BTIME is null");
            return (Criteria) this;
        }

        public Criteria andBtimeIsNotNull() {
            addCriterion("BTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBtimeEqualTo(String value) {
            addCriterion("BTIME =", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotEqualTo(String value) {
            addCriterion("BTIME <>", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeGreaterThan(String value) {
            addCriterion("BTIME >", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeGreaterThanOrEqualTo(String value) {
            addCriterion("BTIME >=", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeLessThan(String value) {
            addCriterion("BTIME <", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeLessThanOrEqualTo(String value) {
            addCriterion("BTIME <=", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeLike(String value) {
            addCriterion("BTIME like", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotLike(String value) {
            addCriterion("BTIME not like", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeIn(List<String> values) {
            addCriterion("BTIME in", values, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotIn(List<String> values) {
            addCriterion("BTIME not in", values, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeBetween(String value1, String value2) {
            addCriterion("BTIME between", value1, value2, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotBetween(String value1, String value2) {
            addCriterion("BTIME not between", value1, value2, "btime");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNull() {
            addCriterion("ETIME is null");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNotNull() {
            addCriterion("ETIME is not null");
            return (Criteria) this;
        }

        public Criteria andEtimeEqualTo(String value) {
            addCriterion("ETIME =", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotEqualTo(String value) {
            addCriterion("ETIME <>", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThan(String value) {
            addCriterion("ETIME >", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ETIME >=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThan(String value) {
            addCriterion("ETIME <", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThanOrEqualTo(String value) {
            addCriterion("ETIME <=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLike(String value) {
            addCriterion("ETIME like", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotLike(String value) {
            addCriterion("ETIME not like", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeIn(List<String> values) {
            addCriterion("ETIME in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotIn(List<String> values) {
            addCriterion("ETIME not in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeBetween(String value1, String value2) {
            addCriterion("ETIME between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotBetween(String value1, String value2) {
            addCriterion("ETIME not between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andBtimelIsNull() {
            addCriterion("BTIMEL is null");
            return (Criteria) this;
        }

        public Criteria andBtimelIsNotNull() {
            addCriterion("BTIMEL is not null");
            return (Criteria) this;
        }

        public Criteria andBtimelEqualTo(Integer value) {
            addCriterion("BTIMEL =", value, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelNotEqualTo(Integer value) {
            addCriterion("BTIMEL <>", value, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelGreaterThan(Integer value) {
            addCriterion("BTIMEL >", value, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelGreaterThanOrEqualTo(Integer value) {
            addCriterion("BTIMEL >=", value, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelLessThan(Integer value) {
            addCriterion("BTIMEL <", value, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelLessThanOrEqualTo(Integer value) {
            addCriterion("BTIMEL <=", value, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelIn(List<Integer> values) {
            addCriterion("BTIMEL in", values, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelNotIn(List<Integer> values) {
            addCriterion("BTIMEL not in", values, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelBetween(Integer value1, Integer value2) {
            addCriterion("BTIMEL between", value1, value2, "btimel");
            return (Criteria) this;
        }

        public Criteria andBtimelNotBetween(Integer value1, Integer value2) {
            addCriterion("BTIMEL not between", value1, value2, "btimel");
            return (Criteria) this;
        }

        public Criteria andEtimelIsNull() {
            addCriterion("ETIMEL is null");
            return (Criteria) this;
        }

        public Criteria andEtimelIsNotNull() {
            addCriterion("ETIMEL is not null");
            return (Criteria) this;
        }

        public Criteria andEtimelEqualTo(Integer value) {
            addCriterion("ETIMEL =", value, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelNotEqualTo(Integer value) {
            addCriterion("ETIMEL <>", value, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelGreaterThan(Integer value) {
            addCriterion("ETIMEL >", value, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ETIMEL >=", value, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelLessThan(Integer value) {
            addCriterion("ETIMEL <", value, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelLessThanOrEqualTo(Integer value) {
            addCriterion("ETIMEL <=", value, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelIn(List<Integer> values) {
            addCriterion("ETIMEL in", values, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelNotIn(List<Integer> values) {
            addCriterion("ETIMEL not in", values, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelBetween(Integer value1, Integer value2) {
            addCriterion("ETIMEL between", value1, value2, "etimel");
            return (Criteria) this;
        }

        public Criteria andEtimelNotBetween(Integer value1, Integer value2) {
            addCriterion("ETIMEL not between", value1, value2, "etimel");
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

        public Criteria andValIsNull() {
            addCriterion("VAL is null");
            return (Criteria) this;
        }

        public Criteria andValIsNotNull() {
            addCriterion("VAL is not null");
            return (Criteria) this;
        }

        public Criteria andValEqualTo(Double value) {
            addCriterion("VAL =", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotEqualTo(Double value) {
            addCriterion("VAL <>", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThan(Double value) {
            addCriterion("VAL >", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThanOrEqualTo(Double value) {
            addCriterion("VAL >=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThan(Double value) {
            addCriterion("VAL <", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThanOrEqualTo(Double value) {
            addCriterion("VAL <=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValIn(List<Double> values) {
            addCriterion("VAL in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValNotIn(List<Double> values) {
            addCriterion("VAL not in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValBetween(Double value1, Double value2) {
            addCriterion("VAL between", value1, value2, "val");
            return (Criteria) this;
        }

        public Criteria andValNotBetween(Double value1, Double value2) {
            addCriterion("VAL not between", value1, value2, "val");
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

        public Criteria andGameIdIsNull() {
            addCriterion("GAME_ID is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("GAME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Integer value) {
            addCriterion("GAME_ID =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Integer value) {
            addCriterion("GAME_ID <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Integer value) {
            addCriterion("GAME_ID >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GAME_ID >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Integer value) {
            addCriterion("GAME_ID <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Integer value) {
            addCriterion("GAME_ID <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Integer> values) {
            addCriterion("GAME_ID in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Integer> values) {
            addCriterion("GAME_ID not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Integer value1, Integer value2) {
            addCriterion("GAME_ID between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GAME_ID not between", value1, value2, "gameId");
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

        public Criteria andGoodsCountIsNull() {
            addCriterion("GOODS_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("GOODS_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("GOODS_COUNT =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("GOODS_COUNT <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("GOODS_COUNT >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODS_COUNT >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("GOODS_COUNT <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("GOODS_COUNT <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("GOODS_COUNT in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("GOODS_COUNT not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_COUNT between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_COUNT not between", value1, value2, "goodsCount");
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

        public Criteria andRoleIsNull() {
            addCriterion("ROLE is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("ROLE =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("ROLE <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("ROLE >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("ROLE <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("ROLE <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("ROLE like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("ROLE not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("ROLE in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("ROLE not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("ROLE between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("ROLE not between", value1, value2, "role");
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