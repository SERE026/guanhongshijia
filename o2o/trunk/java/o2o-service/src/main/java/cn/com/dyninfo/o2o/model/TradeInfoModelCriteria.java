package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class TradeInfoModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public TradeInfoModelCriteria() {
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

        public Criteria andTradeIdIsNull() {
            addCriterion("TRADE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTradeIdIsNotNull() {
            addCriterion("TRADE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTradeIdEqualTo(String value) {
            addCriterion("TRADE_ID =", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotEqualTo(String value) {
            addCriterion("TRADE_ID <>", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdGreaterThan(String value) {
            addCriterion("TRADE_ID >", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_ID >=", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLessThan(String value) {
            addCriterion("TRADE_ID <", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLessThanOrEqualTo(String value) {
            addCriterion("TRADE_ID <=", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdLike(String value) {
            addCriterion("TRADE_ID like", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotLike(String value) {
            addCriterion("TRADE_ID not like", value, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdIn(List<String> values) {
            addCriterion("TRADE_ID in", values, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotIn(List<String> values) {
            addCriterion("TRADE_ID not in", values, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdBetween(String value1, String value2) {
            addCriterion("TRADE_ID between", value1, value2, "tradeId");
            return (Criteria) this;
        }

        public Criteria andTradeIdNotBetween(String value1, String value2) {
            addCriterion("TRADE_ID not between", value1, value2, "tradeId");
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

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("MONEY not between", value1, value2, "money");
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

        public Criteria andZffsIdIsNull() {
            addCriterion("ZFFS_ID is null");
            return (Criteria) this;
        }

        public Criteria andZffsIdIsNotNull() {
            addCriterion("ZFFS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andZffsIdEqualTo(Integer value) {
            addCriterion("ZFFS_ID =", value, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdNotEqualTo(Integer value) {
            addCriterion("ZFFS_ID <>", value, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdGreaterThan(Integer value) {
            addCriterion("ZFFS_ID >", value, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZFFS_ID >=", value, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdLessThan(Integer value) {
            addCriterion("ZFFS_ID <", value, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdLessThanOrEqualTo(Integer value) {
            addCriterion("ZFFS_ID <=", value, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdIn(List<Integer> values) {
            addCriterion("ZFFS_ID in", values, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdNotIn(List<Integer> values) {
            addCriterion("ZFFS_ID not in", values, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdBetween(Integer value1, Integer value2) {
            addCriterion("ZFFS_ID between", value1, value2, "zffsId");
            return (Criteria) this;
        }

        public Criteria andZffsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ZFFS_ID not between", value1, value2, "zffsId");
            return (Criteria) this;
        }

        public Criteria andTradeIsNull() {
            addCriterion("TRADE is null");
            return (Criteria) this;
        }

        public Criteria andTradeIsNotNull() {
            addCriterion("TRADE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeEqualTo(String value) {
            addCriterion("TRADE =", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotEqualTo(String value) {
            addCriterion("TRADE <>", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeGreaterThan(String value) {
            addCriterion("TRADE >", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE >=", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeLessThan(String value) {
            addCriterion("TRADE <", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeLessThanOrEqualTo(String value) {
            addCriterion("TRADE <=", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeLike(String value) {
            addCriterion("TRADE like", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotLike(String value) {
            addCriterion("TRADE not like", value, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeIn(List<String> values) {
            addCriterion("TRADE in", values, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotIn(List<String> values) {
            addCriterion("TRADE not in", values, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeBetween(String value1, String value2) {
            addCriterion("TRADE between", value1, value2, "trade");
            return (Criteria) this;
        }

        public Criteria andTradeNotBetween(String value1, String value2) {
            addCriterion("TRADE not between", value1, value2, "trade");
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

        public Criteria andHuiyuanIdIsNull() {
            addCriterion("HUIYUAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdIsNotNull() {
            addCriterion("HUIYUAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID =", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID <>", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdGreaterThan(Integer value) {
            addCriterion("HUIYUAN_ID >", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID >=", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLessThan(Integer value) {
            addCriterion("HUIYUAN_ID <", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdLessThanOrEqualTo(Integer value) {
            addCriterion("HUIYUAN_ID <=", value, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdIn(List<Integer> values) {
            addCriterion("HUIYUAN_ID in", values, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotIn(List<Integer> values) {
            addCriterion("HUIYUAN_ID not in", values, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdBetween(Integer value1, Integer value2) {
            addCriterion("HUIYUAN_ID between", value1, value2, "huiyuanId");
            return (Criteria) this;
        }

        public Criteria andHuiyuanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HUIYUAN_ID not between", value1, value2, "huiyuanId");
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