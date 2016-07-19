package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class TryUseApplyModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TryUseApplyModelCriteriaBuilder() {
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

        public Criteria andReceiveAddressIsNull() {
            addCriterion("RECEIVE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("RECEIVE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("RECEIVE_ADDRESS >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("RECEIVE_ADDRESS <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_ADDRESS <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("RECEIVE_ADDRESS like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("RECEIVE_ADDRESS not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("RECEIVE_ADDRESS in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("RECEIVE_ADDRESS not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("RECEIVE_ADDRESS between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_ADDRESS not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("APPLYDATE is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("APPLYDATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(String value) {
            addCriterion("APPLYDATE =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(String value) {
            addCriterion("APPLYDATE <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(String value) {
            addCriterion("APPLYDATE >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(String value) {
            addCriterion("APPLYDATE >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(String value) {
            addCriterion("APPLYDATE <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(String value) {
            addCriterion("APPLYDATE <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLike(String value) {
            addCriterion("APPLYDATE like", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotLike(String value) {
            addCriterion("APPLYDATE not like", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<String> values) {
            addCriterion("APPLYDATE in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<String> values) {
            addCriterion("APPLYDATE not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(String value1, String value2) {
            addCriterion("APPLYDATE between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(String value1, String value2) {
            addCriterion("APPLYDATE not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("APPLYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("APPLYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(String value) {
            addCriterion("APPLYTYPE =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(String value) {
            addCriterion("APPLYTYPE <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(String value) {
            addCriterion("APPLYTYPE >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLYTYPE >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(String value) {
            addCriterion("APPLYTYPE <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(String value) {
            addCriterion("APPLYTYPE <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLike(String value) {
            addCriterion("APPLYTYPE like", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotLike(String value) {
            addCriterion("APPLYTYPE not like", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<String> values) {
            addCriterion("APPLYTYPE in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<String> values) {
            addCriterion("APPLYTYPE not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(String value1, String value2) {
            addCriterion("APPLYTYPE between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(String value1, String value2) {
            addCriterion("APPLYTYPE not between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeIsNull() {
            addCriterion("RECEIVE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeIsNotNull() {
            addCriterion("RECEIVE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeEqualTo(String value) {
            addCriterion("RECEIVE_CODE =", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotEqualTo(String value) {
            addCriterion("RECEIVE_CODE <>", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeGreaterThan(String value) {
            addCriterion("RECEIVE_CODE >", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_CODE >=", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeLessThan(String value) {
            addCriterion("RECEIVE_CODE <", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_CODE <=", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeLike(String value) {
            addCriterion("RECEIVE_CODE like", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotLike(String value) {
            addCriterion("RECEIVE_CODE not like", value, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeIn(List<String> values) {
            addCriterion("RECEIVE_CODE in", values, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotIn(List<String> values) {
            addCriterion("RECEIVE_CODE not in", values, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeBetween(String value1, String value2) {
            addCriterion("RECEIVE_CODE between", value1, value2, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveCodeNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_CODE not between", value1, value2, "receiveCode");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNull() {
            addCriterion("RECEIVE_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIsNotNull() {
            addCriterion("RECEIVE_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL =", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL <>", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThan(String value) {
            addCriterion("RECEIVE_EMAIL >", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL >=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThan(String value) {
            addCriterion("RECEIVE_EMAIL <", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_EMAIL <=", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailLike(String value) {
            addCriterion("RECEIVE_EMAIL like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotLike(String value) {
            addCriterion("RECEIVE_EMAIL not like", value, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailIn(List<String> values) {
            addCriterion("RECEIVE_EMAIL in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotIn(List<String> values) {
            addCriterion("RECEIVE_EMAIL not in", values, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailBetween(String value1, String value2) {
            addCriterion("RECEIVE_EMAIL between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReceiveEmailNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_EMAIL not between", value1, value2, "receiveEmail");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNull() {
            addCriterion("RECEIVE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNotNull() {
            addCriterion("RECEIVE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameEqualTo(String value) {
            addCriterion("RECEIVE_NAME =", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotEqualTo(String value) {
            addCriterion("RECEIVE_NAME <>", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThan(String value) {
            addCriterion("RECEIVE_NAME >", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NAME >=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThan(String value) {
            addCriterion("RECEIVE_NAME <", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_NAME <=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLike(String value) {
            addCriterion("RECEIVE_NAME like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotLike(String value) {
            addCriterion("RECEIVE_NAME not like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIn(List<String> values) {
            addCriterion("RECEIVE_NAME in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotIn(List<String> values) {
            addCriterion("RECEIVE_NAME not in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameBetween(String value1, String value2) {
            addCriterion("RECEIVE_NAME between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_NAME not between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNull() {
            addCriterion("RECEIVE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNotNull() {
            addCriterion("RECEIVE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneEqualTo(String value) {
            addCriterion("RECEIVE_PHONE =", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotEqualTo(String value) {
            addCriterion("RECEIVE_PHONE <>", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThan(String value) {
            addCriterion("RECEIVE_PHONE >", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_PHONE >=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThan(String value) {
            addCriterion("RECEIVE_PHONE <", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_PHONE <=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLike(String value) {
            addCriterion("RECEIVE_PHONE like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotLike(String value) {
            addCriterion("RECEIVE_PHONE not like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIn(List<String> values) {
            addCriterion("RECEIVE_PHONE in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotIn(List<String> values) {
            addCriterion("RECEIVE_PHONE not in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneBetween(String value1, String value2) {
            addCriterion("RECEIVE_PHONE between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_PHONE not between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceiveTelIsNull() {
            addCriterion("RECEIVE_TEL is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTelIsNotNull() {
            addCriterion("RECEIVE_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTelEqualTo(String value) {
            addCriterion("RECEIVE_TEL =", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotEqualTo(String value) {
            addCriterion("RECEIVE_TEL <>", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelGreaterThan(String value) {
            addCriterion("RECEIVE_TEL >", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TEL >=", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelLessThan(String value) {
            addCriterion("RECEIVE_TEL <", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TEL <=", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelLike(String value) {
            addCriterion("RECEIVE_TEL like", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotLike(String value) {
            addCriterion("RECEIVE_TEL not like", value, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelIn(List<String> values) {
            addCriterion("RECEIVE_TEL in", values, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotIn(List<String> values) {
            addCriterion("RECEIVE_TEL not in", values, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelBetween(String value1, String value2) {
            addCriterion("RECEIVE_TEL between", value1, value2, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andReceiveTelNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_TEL not between", value1, value2, "receiveTel");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("CITY_ID like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("CITY_ID not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCountyIdIsNull() {
            addCriterion("COUNTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCountyIdIsNotNull() {
            addCriterion("COUNTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCountyIdEqualTo(String value) {
            addCriterion("COUNTY_ID =", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotEqualTo(String value) {
            addCriterion("COUNTY_ID <>", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdGreaterThan(String value) {
            addCriterion("COUNTY_ID >", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY_ID >=", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLessThan(String value) {
            addCriterion("COUNTY_ID <", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLessThanOrEqualTo(String value) {
            addCriterion("COUNTY_ID <=", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdLike(String value) {
            addCriterion("COUNTY_ID like", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotLike(String value) {
            addCriterion("COUNTY_ID not like", value, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdIn(List<String> values) {
            addCriterion("COUNTY_ID in", values, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotIn(List<String> values) {
            addCriterion("COUNTY_ID not in", values, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdBetween(String value1, String value2) {
            addCriterion("COUNTY_ID between", value1, value2, "countyId");
            return (Criteria) this;
        }

        public Criteria andCountyIdNotBetween(String value1, String value2) {
            addCriterion("COUNTY_ID not between", value1, value2, "countyId");
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

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(String value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(String value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(String value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(String value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLike(String value) {
            addCriterion("PROVINCE_ID like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotLike(String value) {
            addCriterion("PROVINCE_ID not like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<String> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<String> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(String value1, String value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
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