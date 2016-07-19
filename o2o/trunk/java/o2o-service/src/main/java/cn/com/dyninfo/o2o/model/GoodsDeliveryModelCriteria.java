package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsDeliveryModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public GoodsDeliveryModelCriteria() {
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

        public Criteria andDeliveryIsNull() {
            addCriterion("DELIVERY is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNotNull() {
            addCriterion("DELIVERY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEqualTo(String value) {
            addCriterion("DELIVERY =", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotEqualTo(String value) {
            addCriterion("DELIVERY <>", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThan(String value) {
            addCriterion("DELIVERY >", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY >=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThan(String value) {
            addCriterion("DELIVERY <", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY <=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLike(String value) {
            addCriterion("DELIVERY like", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotLike(String value) {
            addCriterion("DELIVERY not like", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryIn(List<String> values) {
            addCriterion("DELIVERY in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotIn(List<String> values) {
            addCriterion("DELIVERY not in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryBetween(String value1, String value2) {
            addCriterion("DELIVERY between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotBetween(String value1, String value2) {
            addCriterion("DELIVERY not between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagIsNull() {
            addCriterion("DELIVERY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagIsNotNull() {
            addCriterion("DELIVERY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagEqualTo(String value) {
            addCriterion("DELIVERY_FLAG =", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagNotEqualTo(String value) {
            addCriterion("DELIVERY_FLAG <>", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagGreaterThan(String value) {
            addCriterion("DELIVERY_FLAG >", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_FLAG >=", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagLessThan(String value) {
            addCriterion("DELIVERY_FLAG <", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_FLAG <=", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagLike(String value) {
            addCriterion("DELIVERY_FLAG like", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagNotLike(String value) {
            addCriterion("DELIVERY_FLAG not like", value, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagIn(List<String> values) {
            addCriterion("DELIVERY_FLAG in", values, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagNotIn(List<String> values) {
            addCriterion("DELIVERY_FLAG not in", values, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagBetween(String value1, String value2) {
            addCriterion("DELIVERY_FLAG between", value1, value2, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryFlagNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_FLAG not between", value1, value2, "deliveryFlag");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyIsNull() {
            addCriterion("DELIVERY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyIsNotNull() {
            addCriterion("DELIVERY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyEqualTo(Double value) {
            addCriterion("DELIVERY_MONEY =", value, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyNotEqualTo(Double value) {
            addCriterion("DELIVERY_MONEY <>", value, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyGreaterThan(Double value) {
            addCriterion("DELIVERY_MONEY >", value, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("DELIVERY_MONEY >=", value, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyLessThan(Double value) {
            addCriterion("DELIVERY_MONEY <", value, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyLessThanOrEqualTo(Double value) {
            addCriterion("DELIVERY_MONEY <=", value, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyIn(List<Double> values) {
            addCriterion("DELIVERY_MONEY in", values, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyNotIn(List<Double> values) {
            addCriterion("DELIVERY_MONEY not in", values, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyBetween(Double value1, Double value2) {
            addCriterion("DELIVERY_MONEY between", value1, value2, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andDeliveryMoneyNotBetween(Double value1, Double value2) {
            addCriterion("DELIVERY_MONEY not between", value1, value2, "deliveryMoney");
            return (Criteria) this;
        }

        public Criteria andTGoodsIsNull() {
            addCriterion("T_GOODS is null");
            return (Criteria) this;
        }

        public Criteria andTGoodsIsNotNull() {
            addCriterion("T_GOODS is not null");
            return (Criteria) this;
        }

        public Criteria andTGoodsEqualTo(Integer value) {
            addCriterion("T_GOODS =", value, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsNotEqualTo(Integer value) {
            addCriterion("T_GOODS <>", value, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsGreaterThan(Integer value) {
            addCriterion("T_GOODS >", value, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("T_GOODS >=", value, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsLessThan(Integer value) {
            addCriterion("T_GOODS <", value, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("T_GOODS <=", value, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsIn(List<Integer> values) {
            addCriterion("T_GOODS in", values, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsNotIn(List<Integer> values) {
            addCriterion("T_GOODS not in", values, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsBetween(Integer value1, Integer value2) {
            addCriterion("T_GOODS between", value1, value2, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("T_GOODS not between", value1, value2, "tGoods");
            return (Criteria) this;
        }

        public Criteria andTProductIsNull() {
            addCriterion("T_PRODUCT is null");
            return (Criteria) this;
        }

        public Criteria andTProductIsNotNull() {
            addCriterion("T_PRODUCT is not null");
            return (Criteria) this;
        }

        public Criteria andTProductEqualTo(Integer value) {
            addCriterion("T_PRODUCT =", value, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductNotEqualTo(Integer value) {
            addCriterion("T_PRODUCT <>", value, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductGreaterThan(Integer value) {
            addCriterion("T_PRODUCT >", value, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductGreaterThanOrEqualTo(Integer value) {
            addCriterion("T_PRODUCT >=", value, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductLessThan(Integer value) {
            addCriterion("T_PRODUCT <", value, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductLessThanOrEqualTo(Integer value) {
            addCriterion("T_PRODUCT <=", value, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductIn(List<Integer> values) {
            addCriterion("T_PRODUCT in", values, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductNotIn(List<Integer> values) {
            addCriterion("T_PRODUCT not in", values, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductBetween(Integer value1, Integer value2) {
            addCriterion("T_PRODUCT between", value1, value2, "tProduct");
            return (Criteria) this;
        }

        public Criteria andTProductNotBetween(Integer value1, Integer value2) {
            addCriterion("T_PRODUCT not between", value1, value2, "tProduct");
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