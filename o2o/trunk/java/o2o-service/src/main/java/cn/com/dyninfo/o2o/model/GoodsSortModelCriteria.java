package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsSortModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public GoodsSortModelCriteria() {
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andImagesrcIsNull() {
            addCriterion("IMAGESRC is null");
            return (Criteria) this;
        }

        public Criteria andImagesrcIsNotNull() {
            addCriterion("IMAGESRC is not null");
            return (Criteria) this;
        }

        public Criteria andImagesrcEqualTo(String value) {
            addCriterion("IMAGESRC =", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotEqualTo(String value) {
            addCriterion("IMAGESRC <>", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcGreaterThan(String value) {
            addCriterion("IMAGESRC >", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGESRC >=", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcLessThan(String value) {
            addCriterion("IMAGESRC <", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcLessThanOrEqualTo(String value) {
            addCriterion("IMAGESRC <=", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcLike(String value) {
            addCriterion("IMAGESRC like", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotLike(String value) {
            addCriterion("IMAGESRC not like", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcIn(List<String> values) {
            addCriterion("IMAGESRC in", values, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotIn(List<String> values) {
            addCriterion("IMAGESRC not in", values, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcBetween(String value1, String value2) {
            addCriterion("IMAGESRC between", value1, value2, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotBetween(String value1, String value2) {
            addCriterion("IMAGESRC not between", value1, value2, "imagesrc");
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

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("TYPE_ID =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("TYPE_ID <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("TYPE_ID >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ID >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("TYPE_ID <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ID <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("TYPE_ID in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("TYPE_ID not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ID between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ID not between", value1, value2, "typeId");
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

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
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

        public Criteria andTIndexIsNull() {
            addCriterion("T_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andTIndexIsNotNull() {
            addCriterion("T_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andTIndexEqualTo(Integer value) {
            addCriterion("T_INDEX =", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotEqualTo(Integer value) {
            addCriterion("T_INDEX <>", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexGreaterThan(Integer value) {
            addCriterion("T_INDEX >", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("T_INDEX >=", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexLessThan(Integer value) {
            addCriterion("T_INDEX <", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexLessThanOrEqualTo(Integer value) {
            addCriterion("T_INDEX <=", value, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexIn(List<Integer> values) {
            addCriterion("T_INDEX in", values, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotIn(List<Integer> values) {
            addCriterion("T_INDEX not in", values, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexBetween(Integer value1, Integer value2) {
            addCriterion("T_INDEX between", value1, value2, "tIndex");
            return (Criteria) this;
        }

        public Criteria andTIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("T_INDEX not between", value1, value2, "tIndex");
            return (Criteria) this;
        }

        public Criteria andRevealIsNull() {
            addCriterion("REVEAL is null");
            return (Criteria) this;
        }

        public Criteria andRevealIsNotNull() {
            addCriterion("REVEAL is not null");
            return (Criteria) this;
        }

        public Criteria andRevealEqualTo(String value) {
            addCriterion("REVEAL =", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealNotEqualTo(String value) {
            addCriterion("REVEAL <>", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealGreaterThan(String value) {
            addCriterion("REVEAL >", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealGreaterThanOrEqualTo(String value) {
            addCriterion("REVEAL >=", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealLessThan(String value) {
            addCriterion("REVEAL <", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealLessThanOrEqualTo(String value) {
            addCriterion("REVEAL <=", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealLike(String value) {
            addCriterion("REVEAL like", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealNotLike(String value) {
            addCriterion("REVEAL not like", value, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealIn(List<String> values) {
            addCriterion("REVEAL in", values, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealNotIn(List<String> values) {
            addCriterion("REVEAL not in", values, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealBetween(String value1, String value2) {
            addCriterion("REVEAL between", value1, value2, "reveal");
            return (Criteria) this;
        }

        public Criteria andRevealNotBetween(String value1, String value2) {
            addCriterion("REVEAL not between", value1, value2, "reveal");
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