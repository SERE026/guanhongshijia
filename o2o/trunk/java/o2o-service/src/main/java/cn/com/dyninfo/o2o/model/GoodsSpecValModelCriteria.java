package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsSpecValModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public GoodsSpecValModelCriteria() {
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

        public Criteria andGoodsSpecIdIsNull() {
            addCriterion("GOODS_SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdIsNotNull() {
            addCriterion("GOODS_SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdEqualTo(Integer value) {
            addCriterion("GOODS_SPEC_ID =", value, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdNotEqualTo(Integer value) {
            addCriterion("GOODS_SPEC_ID <>", value, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdGreaterThan(Integer value) {
            addCriterion("GOODS_SPEC_ID >", value, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODS_SPEC_ID >=", value, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdLessThan(Integer value) {
            addCriterion("GOODS_SPEC_ID <", value, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOODS_SPEC_ID <=", value, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdIn(List<Integer> values) {
            addCriterion("GOODS_SPEC_ID in", values, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdNotIn(List<Integer> values) {
            addCriterion("GOODS_SPEC_ID not in", values, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_SPEC_ID between", value1, value2, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_SPEC_ID not between", value1, value2, "goodsSpecId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
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

        public Criteria andValEqualTo(String value) {
            addCriterion("VAL =", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotEqualTo(String value) {
            addCriterion("VAL <>", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThan(String value) {
            addCriterion("VAL >", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThanOrEqualTo(String value) {
            addCriterion("VAL >=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThan(String value) {
            addCriterion("VAL <", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThanOrEqualTo(String value) {
            addCriterion("VAL <=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLike(String value) {
            addCriterion("VAL like", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotLike(String value) {
            addCriterion("VAL not like", value, "val");
            return (Criteria) this;
        }

        public Criteria andValIn(List<String> values) {
            addCriterion("VAL in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValNotIn(List<String> values) {
            addCriterion("VAL not in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValBetween(String value1, String value2) {
            addCriterion("VAL between", value1, value2, "val");
            return (Criteria) this;
        }

        public Criteria andValNotBetween(String value1, String value2) {
            addCriterion("VAL not between", value1, value2, "val");
            return (Criteria) this;
        }

        public Criteria andSpecSalesIsNull() {
            addCriterion("SPEC_SALES is null");
            return (Criteria) this;
        }

        public Criteria andSpecSalesIsNotNull() {
            addCriterion("SPEC_SALES is not null");
            return (Criteria) this;
        }

        public Criteria andSpecSalesEqualTo(Float value) {
            addCriterion("SPEC_SALES =", value, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesNotEqualTo(Float value) {
            addCriterion("SPEC_SALES <>", value, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesGreaterThan(Float value) {
            addCriterion("SPEC_SALES >", value, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesGreaterThanOrEqualTo(Float value) {
            addCriterion("SPEC_SALES >=", value, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesLessThan(Float value) {
            addCriterion("SPEC_SALES <", value, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesLessThanOrEqualTo(Float value) {
            addCriterion("SPEC_SALES <=", value, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesIn(List<Float> values) {
            addCriterion("SPEC_SALES in", values, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesNotIn(List<Float> values) {
            addCriterion("SPEC_SALES not in", values, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesBetween(Float value1, Float value2) {
            addCriterion("SPEC_SALES between", value1, value2, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecSalesNotBetween(Float value1, Float value2) {
            addCriterion("SPEC_SALES not between", value1, value2, "specSales");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarIsNull() {
            addCriterion("SPEC_BAZAAR is null");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarIsNotNull() {
            addCriterion("SPEC_BAZAAR is not null");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarEqualTo(Float value) {
            addCriterion("SPEC_BAZAAR =", value, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarNotEqualTo(Float value) {
            addCriterion("SPEC_BAZAAR <>", value, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarGreaterThan(Float value) {
            addCriterion("SPEC_BAZAAR >", value, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarGreaterThanOrEqualTo(Float value) {
            addCriterion("SPEC_BAZAAR >=", value, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarLessThan(Float value) {
            addCriterion("SPEC_BAZAAR <", value, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarLessThanOrEqualTo(Float value) {
            addCriterion("SPEC_BAZAAR <=", value, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarIn(List<Float> values) {
            addCriterion("SPEC_BAZAAR in", values, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarNotIn(List<Float> values) {
            addCriterion("SPEC_BAZAAR not in", values, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarBetween(Float value1, Float value2) {
            addCriterion("SPEC_BAZAAR between", value1, value2, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecBazaarNotBetween(Float value1, Float value2) {
            addCriterion("SPEC_BAZAAR not between", value1, value2, "specBazaar");
            return (Criteria) this;
        }

        public Criteria andSpecCostIsNull() {
            addCriterion("SPEC_COST is null");
            return (Criteria) this;
        }

        public Criteria andSpecCostIsNotNull() {
            addCriterion("SPEC_COST is not null");
            return (Criteria) this;
        }

        public Criteria andSpecCostEqualTo(Float value) {
            addCriterion("SPEC_COST =", value, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostNotEqualTo(Float value) {
            addCriterion("SPEC_COST <>", value, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostGreaterThan(Float value) {
            addCriterion("SPEC_COST >", value, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostGreaterThanOrEqualTo(Float value) {
            addCriterion("SPEC_COST >=", value, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostLessThan(Float value) {
            addCriterion("SPEC_COST <", value, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostLessThanOrEqualTo(Float value) {
            addCriterion("SPEC_COST <=", value, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostIn(List<Float> values) {
            addCriterion("SPEC_COST in", values, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostNotIn(List<Float> values) {
            addCriterion("SPEC_COST not in", values, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostBetween(Float value1, Float value2) {
            addCriterion("SPEC_COST between", value1, value2, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecCostNotBetween(Float value1, Float value2) {
            addCriterion("SPEC_COST not between", value1, value2, "specCost");
            return (Criteria) this;
        }

        public Criteria andSpecWeightIsNull() {
            addCriterion("SPEC_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andSpecWeightIsNotNull() {
            addCriterion("SPEC_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andSpecWeightEqualTo(Float value) {
            addCriterion("SPEC_WEIGHT =", value, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightNotEqualTo(Float value) {
            addCriterion("SPEC_WEIGHT <>", value, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightGreaterThan(Float value) {
            addCriterion("SPEC_WEIGHT >", value, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightGreaterThanOrEqualTo(Float value) {
            addCriterion("SPEC_WEIGHT >=", value, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightLessThan(Float value) {
            addCriterion("SPEC_WEIGHT <", value, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightLessThanOrEqualTo(Float value) {
            addCriterion("SPEC_WEIGHT <=", value, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightIn(List<Float> values) {
            addCriterion("SPEC_WEIGHT in", values, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightNotIn(List<Float> values) {
            addCriterion("SPEC_WEIGHT not in", values, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightBetween(Float value1, Float value2) {
            addCriterion("SPEC_WEIGHT between", value1, value2, "specWeight");
            return (Criteria) this;
        }

        public Criteria andSpecWeightNotBetween(Float value1, Float value2) {
            addCriterion("SPEC_WEIGHT not between", value1, value2, "specWeight");
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

        public Criteria andInventoryEqualTo(Float value) {
            addCriterion("INVENTORY =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Float value) {
            addCriterion("INVENTORY <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Float value) {
            addCriterion("INVENTORY >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Float value) {
            addCriterion("INVENTORY >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Float value) {
            addCriterion("INVENTORY <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Float value) {
            addCriterion("INVENTORY <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Float> values) {
            addCriterion("INVENTORY in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Float> values) {
            addCriterion("INVENTORY not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Float value1, Float value2) {
            addCriterion("INVENTORY between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Float value1, Float value2) {
            addCriterion("INVENTORY not between", value1, value2, "inventory");
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