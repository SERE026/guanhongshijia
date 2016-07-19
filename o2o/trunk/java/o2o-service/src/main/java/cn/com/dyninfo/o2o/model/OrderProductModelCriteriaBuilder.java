package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class OrderProductModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderProductModelCriteriaBuilder() {
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

        public Criteria andActMoneyIsNull() {
            addCriterion("ACT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andActMoneyIsNotNull() {
            addCriterion("ACT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andActMoneyEqualTo(Double value) {
            addCriterion("ACT_MONEY =", value, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyNotEqualTo(Double value) {
            addCriterion("ACT_MONEY <>", value, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyGreaterThan(Double value) {
            addCriterion("ACT_MONEY >", value, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("ACT_MONEY >=", value, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyLessThan(Double value) {
            addCriterion("ACT_MONEY <", value, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyLessThanOrEqualTo(Double value) {
            addCriterion("ACT_MONEY <=", value, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyIn(List<Double> values) {
            addCriterion("ACT_MONEY in", values, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyNotIn(List<Double> values) {
            addCriterion("ACT_MONEY not in", values, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyBetween(Double value1, Double value2) {
            addCriterion("ACT_MONEY between", value1, value2, "actMoney");
            return (Criteria) this;
        }

        public Criteria andActMoneyNotBetween(Double value1, Double value2) {
            addCriterion("ACT_MONEY not between", value1, value2, "actMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyIsNull() {
            addCriterion("GOOD_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyIsNotNull() {
            addCriterion("GOOD_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyEqualTo(Double value) {
            addCriterion("GOOD_MONEY =", value, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyNotEqualTo(Double value) {
            addCriterion("GOOD_MONEY <>", value, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyGreaterThan(Double value) {
            addCriterion("GOOD_MONEY >", value, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("GOOD_MONEY >=", value, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyLessThan(Double value) {
            addCriterion("GOOD_MONEY <", value, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyLessThanOrEqualTo(Double value) {
            addCriterion("GOOD_MONEY <=", value, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyIn(List<Double> values) {
            addCriterion("GOOD_MONEY in", values, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyNotIn(List<Double> values) {
            addCriterion("GOOD_MONEY not in", values, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyBetween(Double value1, Double value2) {
            addCriterion("GOOD_MONEY between", value1, value2, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodMoneyNotBetween(Double value1, Double value2) {
            addCriterion("GOOD_MONEY not between", value1, value2, "goodMoney");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIsNull() {
            addCriterion("GOODS_SPEC is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIsNotNull() {
            addCriterion("GOODS_SPEC is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecEqualTo(String value) {
            addCriterion("GOODS_SPEC =", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotEqualTo(String value) {
            addCriterion("GOODS_SPEC <>", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecGreaterThan(String value) {
            addCriterion("GOODS_SPEC >", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_SPEC >=", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecLessThan(String value) {
            addCriterion("GOODS_SPEC <", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecLessThanOrEqualTo(String value) {
            addCriterion("GOODS_SPEC <=", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecLike(String value) {
            addCriterion("GOODS_SPEC like", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotLike(String value) {
            addCriterion("GOODS_SPEC not like", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIn(List<String> values) {
            addCriterion("GOODS_SPEC in", values, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotIn(List<String> values) {
            addCriterion("GOODS_SPEC not in", values, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecBetween(String value1, String value2) {
            addCriterion("GOODS_SPEC between", value1, value2, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotBetween(String value1, String value2) {
            addCriterion("GOODS_SPEC not between", value1, value2, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodNumIsNull() {
            addCriterion("GOOD_NUM is null");
            return (Criteria) this;
        }

        public Criteria andGoodNumIsNotNull() {
            addCriterion("GOOD_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNumEqualTo(Integer value) {
            addCriterion("GOOD_NUM =", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumNotEqualTo(Integer value) {
            addCriterion("GOOD_NUM <>", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumGreaterThan(Integer value) {
            addCriterion("GOOD_NUM >", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOOD_NUM >=", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumLessThan(Integer value) {
            addCriterion("GOOD_NUM <", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumLessThanOrEqualTo(Integer value) {
            addCriterion("GOOD_NUM <=", value, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumIn(List<Integer> values) {
            addCriterion("GOOD_NUM in", values, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumNotIn(List<Integer> values) {
            addCriterion("GOOD_NUM not in", values, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumBetween(Integer value1, Integer value2) {
            addCriterion("GOOD_NUM between", value1, value2, "goodNum");
            return (Criteria) this;
        }

        public Criteria andGoodNumNotBetween(Integer value1, Integer value2) {
            addCriterion("GOOD_NUM not between", value1, value2, "goodNum");
            return (Criteria) this;
        }

        public Criteria andWidgetIsNull() {
            addCriterion("WIDGET is null");
            return (Criteria) this;
        }

        public Criteria andWidgetIsNotNull() {
            addCriterion("WIDGET is not null");
            return (Criteria) this;
        }

        public Criteria andWidgetEqualTo(Double value) {
            addCriterion("WIDGET =", value, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetNotEqualTo(Double value) {
            addCriterion("WIDGET <>", value, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetGreaterThan(Double value) {
            addCriterion("WIDGET >", value, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetGreaterThanOrEqualTo(Double value) {
            addCriterion("WIDGET >=", value, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetLessThan(Double value) {
            addCriterion("WIDGET <", value, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetLessThanOrEqualTo(Double value) {
            addCriterion("WIDGET <=", value, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetIn(List<Double> values) {
            addCriterion("WIDGET in", values, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetNotIn(List<Double> values) {
            addCriterion("WIDGET not in", values, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetBetween(Double value1, Double value2) {
            addCriterion("WIDGET between", value1, value2, "widget");
            return (Criteria) this;
        }

        public Criteria andWidgetNotBetween(Double value1, Double value2) {
            addCriterion("WIDGET not between", value1, value2, "widget");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
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

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andShowStatsIsNull() {
            addCriterion("SHOW_STATS is null");
            return (Criteria) this;
        }

        public Criteria andShowStatsIsNotNull() {
            addCriterion("SHOW_STATS is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatsEqualTo(String value) {
            addCriterion("SHOW_STATS =", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsNotEqualTo(String value) {
            addCriterion("SHOW_STATS <>", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsGreaterThan(String value) {
            addCriterion("SHOW_STATS >", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsGreaterThanOrEqualTo(String value) {
            addCriterion("SHOW_STATS >=", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsLessThan(String value) {
            addCriterion("SHOW_STATS <", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsLessThanOrEqualTo(String value) {
            addCriterion("SHOW_STATS <=", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsLike(String value) {
            addCriterion("SHOW_STATS like", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsNotLike(String value) {
            addCriterion("SHOW_STATS not like", value, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsIn(List<String> values) {
            addCriterion("SHOW_STATS in", values, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsNotIn(List<String> values) {
            addCriterion("SHOW_STATS not in", values, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsBetween(String value1, String value2) {
            addCriterion("SHOW_STATS between", value1, value2, "showStats");
            return (Criteria) this;
        }

        public Criteria andShowStatsNotBetween(String value1, String value2) {
            addCriterion("SHOW_STATS not between", value1, value2, "showStats");
            return (Criteria) this;
        }

        public Criteria andActGameIdIsNull() {
            addCriterion("ACT_Game_ID is null");
            return (Criteria) this;
        }

        public Criteria andActGameIdIsNotNull() {
            addCriterion("ACT_Game_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActGameIdEqualTo(Integer value) {
            addCriterion("ACT_Game_ID =", value, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdNotEqualTo(Integer value) {
            addCriterion("ACT_Game_ID <>", value, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdGreaterThan(Integer value) {
            addCriterion("ACT_Game_ID >", value, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACT_Game_ID >=", value, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdLessThan(Integer value) {
            addCriterion("ACT_Game_ID <", value, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACT_Game_ID <=", value, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdIn(List<Integer> values) {
            addCriterion("ACT_Game_ID in", values, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdNotIn(List<Integer> values) {
            addCriterion("ACT_Game_ID not in", values, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdBetween(Integer value1, Integer value2) {
            addCriterion("ACT_Game_ID between", value1, value2, "actGameId");
            return (Criteria) this;
        }

        public Criteria andActGameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACT_Game_ID not between", value1, value2, "actGameId");
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