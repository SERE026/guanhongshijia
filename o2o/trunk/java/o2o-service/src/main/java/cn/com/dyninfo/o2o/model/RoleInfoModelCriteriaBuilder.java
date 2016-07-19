package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class RoleInfoModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleInfoModelCriteriaBuilder() {
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

        public Criteria andIndexOrderIsNull() {
            addCriterion("INDEX_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIsNotNull() {
            addCriterion("INDEX_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andIndexOrderEqualTo(Integer value) {
            addCriterion("INDEX_ORDER =", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotEqualTo(Integer value) {
            addCriterion("INDEX_ORDER <>", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderGreaterThan(Integer value) {
            addCriterion("INDEX_ORDER >", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("INDEX_ORDER >=", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLessThan(Integer value) {
            addCriterion("INDEX_ORDER <", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLessThanOrEqualTo(Integer value) {
            addCriterion("INDEX_ORDER <=", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIn(List<Integer> values) {
            addCriterion("INDEX_ORDER in", values, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotIn(List<Integer> values) {
            addCriterion("INDEX_ORDER not in", values, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_ORDER between", value1, value2, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("INDEX_ORDER not between", value1, value2, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIsSysIsNull() {
            addCriterion("IS_SYS is null");
            return (Criteria) this;
        }

        public Criteria andIsSysIsNotNull() {
            addCriterion("IS_SYS is not null");
            return (Criteria) this;
        }

        public Criteria andIsSysEqualTo(String value) {
            addCriterion("IS_SYS =", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysNotEqualTo(String value) {
            addCriterion("IS_SYS <>", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysGreaterThan(String value) {
            addCriterion("IS_SYS >", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYS >=", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysLessThan(String value) {
            addCriterion("IS_SYS <", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysLessThanOrEqualTo(String value) {
            addCriterion("IS_SYS <=", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysLike(String value) {
            addCriterion("IS_SYS like", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysNotLike(String value) {
            addCriterion("IS_SYS not like", value, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysIn(List<String> values) {
            addCriterion("IS_SYS in", values, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysNotIn(List<String> values) {
            addCriterion("IS_SYS not in", values, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysBetween(String value1, String value2) {
            addCriterion("IS_SYS between", value1, value2, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsSysNotBetween(String value1, String value2) {
            addCriterion("IS_SYS not between", value1, value2, "isSys");
            return (Criteria) this;
        }

        public Criteria andIsJobIsNull() {
            addCriterion("IS_JOB is null");
            return (Criteria) this;
        }

        public Criteria andIsJobIsNotNull() {
            addCriterion("IS_JOB is not null");
            return (Criteria) this;
        }

        public Criteria andIsJobEqualTo(String value) {
            addCriterion("IS_JOB =", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobNotEqualTo(String value) {
            addCriterion("IS_JOB <>", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobGreaterThan(String value) {
            addCriterion("IS_JOB >", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobGreaterThanOrEqualTo(String value) {
            addCriterion("IS_JOB >=", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobLessThan(String value) {
            addCriterion("IS_JOB <", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobLessThanOrEqualTo(String value) {
            addCriterion("IS_JOB <=", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobLike(String value) {
            addCriterion("IS_JOB like", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobNotLike(String value) {
            addCriterion("IS_JOB not like", value, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobIn(List<String> values) {
            addCriterion("IS_JOB in", values, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobNotIn(List<String> values) {
            addCriterion("IS_JOB not in", values, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobBetween(String value1, String value2) {
            addCriterion("IS_JOB between", value1, value2, "isJob");
            return (Criteria) this;
        }

        public Criteria andIsJobNotBetween(String value1, String value2) {
            addCriterion("IS_JOB not between", value1, value2, "isJob");
            return (Criteria) this;
        }

        public Criteria andRoleCNameIsNull() {
            addCriterion("ROLE_C_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleCNameIsNotNull() {
            addCriterion("ROLE_C_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCNameEqualTo(String value) {
            addCriterion("ROLE_C_NAME =", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameNotEqualTo(String value) {
            addCriterion("ROLE_C_NAME <>", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameGreaterThan(String value) {
            addCriterion("ROLE_C_NAME >", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_C_NAME >=", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameLessThan(String value) {
            addCriterion("ROLE_C_NAME <", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_C_NAME <=", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameLike(String value) {
            addCriterion("ROLE_C_NAME like", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameNotLike(String value) {
            addCriterion("ROLE_C_NAME not like", value, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameIn(List<String> values) {
            addCriterion("ROLE_C_NAME in", values, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameNotIn(List<String> values) {
            addCriterion("ROLE_C_NAME not in", values, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameBetween(String value1, String value2) {
            addCriterion("ROLE_C_NAME between", value1, value2, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleCNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_C_NAME not between", value1, value2, "roleCName");
            return (Criteria) this;
        }

        public Criteria andRoleENameIsNull() {
            addCriterion("ROLE_E_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleENameIsNotNull() {
            addCriterion("ROLE_E_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleENameEqualTo(String value) {
            addCriterion("ROLE_E_NAME =", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameNotEqualTo(String value) {
            addCriterion("ROLE_E_NAME <>", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameGreaterThan(String value) {
            addCriterion("ROLE_E_NAME >", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_E_NAME >=", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameLessThan(String value) {
            addCriterion("ROLE_E_NAME <", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_E_NAME <=", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameLike(String value) {
            addCriterion("ROLE_E_NAME like", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameNotLike(String value) {
            addCriterion("ROLE_E_NAME not like", value, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameIn(List<String> values) {
            addCriterion("ROLE_E_NAME in", values, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameNotIn(List<String> values) {
            addCriterion("ROLE_E_NAME not in", values, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameBetween(String value1, String value2) {
            addCriterion("ROLE_E_NAME between", value1, value2, "roleEName");
            return (Criteria) this;
        }

        public Criteria andRoleENameNotBetween(String value1, String value2) {
            addCriterion("ROLE_E_NAME not between", value1, value2, "roleEName");
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