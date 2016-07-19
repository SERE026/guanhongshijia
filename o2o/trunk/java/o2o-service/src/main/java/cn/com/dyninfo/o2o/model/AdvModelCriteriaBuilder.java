package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class AdvModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvModelCriteriaBuilder() {
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

        public Criteria andAdvwzIdIsNull() {
            addCriterion("ADVWZ_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdIsNotNull() {
            addCriterion("ADVWZ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdEqualTo(String value) {
            addCriterion("ADVWZ_ID =", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdNotEqualTo(String value) {
            addCriterion("ADVWZ_ID <>", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdGreaterThan(String value) {
            addCriterion("ADVWZ_ID >", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADVWZ_ID >=", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdLessThan(String value) {
            addCriterion("ADVWZ_ID <", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdLessThanOrEqualTo(String value) {
            addCriterion("ADVWZ_ID <=", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdLike(String value) {
            addCriterion("ADVWZ_ID like", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdNotLike(String value) {
            addCriterion("ADVWZ_ID not like", value, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdIn(List<String> values) {
            addCriterion("ADVWZ_ID in", values, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdNotIn(List<String> values) {
            addCriterion("ADVWZ_ID not in", values, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdBetween(String value1, String value2) {
            addCriterion("ADVWZ_ID between", value1, value2, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvwzIdNotBetween(String value1, String value2) {
            addCriterion("ADVWZ_ID not between", value1, value2, "advwzId");
            return (Criteria) this;
        }

        public Criteria andAdvUseIsNull() {
            addCriterion("ADV_USE is null");
            return (Criteria) this;
        }

        public Criteria andAdvUseIsNotNull() {
            addCriterion("ADV_USE is not null");
            return (Criteria) this;
        }

        public Criteria andAdvUseEqualTo(String value) {
            addCriterion("ADV_USE =", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseNotEqualTo(String value) {
            addCriterion("ADV_USE <>", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseGreaterThan(String value) {
            addCriterion("ADV_USE >", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseGreaterThanOrEqualTo(String value) {
            addCriterion("ADV_USE >=", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseLessThan(String value) {
            addCriterion("ADV_USE <", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseLessThanOrEqualTo(String value) {
            addCriterion("ADV_USE <=", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseLike(String value) {
            addCriterion("ADV_USE like", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseNotLike(String value) {
            addCriterion("ADV_USE not like", value, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseIn(List<String> values) {
            addCriterion("ADV_USE in", values, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseNotIn(List<String> values) {
            addCriterion("ADV_USE not in", values, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseBetween(String value1, String value2) {
            addCriterion("ADV_USE between", value1, value2, "advUse");
            return (Criteria) this;
        }

        public Criteria andAdvUseNotBetween(String value1, String value2) {
            addCriterion("ADV_USE not between", value1, value2, "advUse");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("STARTTIME like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("STARTTIME not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("STARTTIME not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("ENDTIME like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("ENDTIME not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("LINK is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("LINK is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("LINK =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("LINK <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("LINK >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("LINK >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("LINK <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("LINK <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("LINK like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("LINK not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("LINK in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("LINK not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("LINK between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("LINK not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andFileIsNull() {
            addCriterion("FILE is null");
            return (Criteria) this;
        }

        public Criteria andFileIsNotNull() {
            addCriterion("FILE is not null");
            return (Criteria) this;
        }

        public Criteria andFileEqualTo(String value) {
            addCriterion("FILE =", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotEqualTo(String value) {
            addCriterion("FILE <>", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThan(String value) {
            addCriterion("FILE >", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThanOrEqualTo(String value) {
            addCriterion("FILE >=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThan(String value) {
            addCriterion("FILE <", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThanOrEqualTo(String value) {
            addCriterion("FILE <=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLike(String value) {
            addCriterion("FILE like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotLike(String value) {
            addCriterion("FILE not like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileIn(List<String> values) {
            addCriterion("FILE in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotIn(List<String> values) {
            addCriterion("FILE not in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileBetween(String value1, String value2) {
            addCriterion("FILE between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotBetween(String value1, String value2) {
            addCriterion("FILE not between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("LINKMAN =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("LINKMAN <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("LINKMAN >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("LINKMAN >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("LINKMAN <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("LINKMAN <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("LINKMAN like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("LINKMAN not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("LINKMAN in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("LINKMAN not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("LINKMAN between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("LINKMAN not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinktypeIsNull() {
            addCriterion("LINKTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLinktypeIsNotNull() {
            addCriterion("LINKTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLinktypeEqualTo(String value) {
            addCriterion("LINKTYPE =", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeNotEqualTo(String value) {
            addCriterion("LINKTYPE <>", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeGreaterThan(String value) {
            addCriterion("LINKTYPE >", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeGreaterThanOrEqualTo(String value) {
            addCriterion("LINKTYPE >=", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeLessThan(String value) {
            addCriterion("LINKTYPE <", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeLessThanOrEqualTo(String value) {
            addCriterion("LINKTYPE <=", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeLike(String value) {
            addCriterion("LINKTYPE like", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeNotLike(String value) {
            addCriterion("LINKTYPE not like", value, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeIn(List<String> values) {
            addCriterion("LINKTYPE in", values, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeNotIn(List<String> values) {
            addCriterion("LINKTYPE not in", values, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeBetween(String value1, String value2) {
            addCriterion("LINKTYPE between", value1, value2, "linktype");
            return (Criteria) this;
        }

        public Criteria andLinktypeNotBetween(String value1, String value2) {
            addCriterion("LINKTYPE not between", value1, value2, "linktype");
            return (Criteria) this;
        }

        public Criteria andHitsIsNull() {
            addCriterion("HITS is null");
            return (Criteria) this;
        }

        public Criteria andHitsIsNotNull() {
            addCriterion("HITS is not null");
            return (Criteria) this;
        }

        public Criteria andHitsEqualTo(Integer value) {
            addCriterion("HITS =", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotEqualTo(Integer value) {
            addCriterion("HITS <>", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThan(Integer value) {
            addCriterion("HITS >", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("HITS >=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThan(Integer value) {
            addCriterion("HITS <", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThanOrEqualTo(Integer value) {
            addCriterion("HITS <=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsIn(List<Integer> values) {
            addCriterion("HITS in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotIn(List<Integer> values) {
            addCriterion("HITS not in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsBetween(Integer value1, Integer value2) {
            addCriterion("HITS between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("HITS not between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("AREA_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("AREA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(String value) {
            addCriterion("AREA_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(String value) {
            addCriterion("AREA_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(String value) {
            addCriterion("AREA_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(String value) {
            addCriterion("AREA_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(String value) {
            addCriterion("AREA_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLike(String value) {
            addCriterion("AREA_ID like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotLike(String value) {
            addCriterion("AREA_ID not like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<String> values) {
            addCriterion("AREA_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<String> values) {
            addCriterion("AREA_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(String value1, String value2) {
            addCriterion("AREA_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(String value1, String value2) {
            addCriterion("AREA_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorIsNull() {
            addCriterion("ADV_BGCOLOR is null");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorIsNotNull() {
            addCriterion("ADV_BGCOLOR is not null");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorEqualTo(String value) {
            addCriterion("ADV_BGCOLOR =", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorNotEqualTo(String value) {
            addCriterion("ADV_BGCOLOR <>", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorGreaterThan(String value) {
            addCriterion("ADV_BGCOLOR >", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorGreaterThanOrEqualTo(String value) {
            addCriterion("ADV_BGCOLOR >=", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorLessThan(String value) {
            addCriterion("ADV_BGCOLOR <", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorLessThanOrEqualTo(String value) {
            addCriterion("ADV_BGCOLOR <=", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorLike(String value) {
            addCriterion("ADV_BGCOLOR like", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorNotLike(String value) {
            addCriterion("ADV_BGCOLOR not like", value, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorIn(List<String> values) {
            addCriterion("ADV_BGCOLOR in", values, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorNotIn(List<String> values) {
            addCriterion("ADV_BGCOLOR not in", values, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorBetween(String value1, String value2) {
            addCriterion("ADV_BGCOLOR between", value1, value2, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andAdvBgcolorNotBetween(String value1, String value2) {
            addCriterion("ADV_BGCOLOR not between", value1, value2, "advBgcolor");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNull() {
            addCriterion("ORDER_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNotNull() {
            addCriterion("ORDER_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexEqualTo(Integer value) {
            addCriterion("ORDER_INDEX =", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotEqualTo(Integer value) {
            addCriterion("ORDER_INDEX <>", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThan(Integer value) {
            addCriterion("ORDER_INDEX >", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_INDEX >=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThan(Integer value) {
            addCriterion("ORDER_INDEX <", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_INDEX <=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIn(List<Integer> values) {
            addCriterion("ORDER_INDEX in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotIn(List<Integer> values) {
            addCriterion("ORDER_INDEX not in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_INDEX between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_INDEX not between", value1, value2, "orderIndex");
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