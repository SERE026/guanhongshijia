package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class UserInfoModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoModelCriteriaBuilder() {
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

        public Criteria andLoginIdIsNull() {
            addCriterion("LOGIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("LOGIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(String value) {
            addCriterion("LOGIN_ID =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(String value) {
            addCriterion("LOGIN_ID <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(String value) {
            addCriterion("LOGIN_ID >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(String value) {
            addCriterion("LOGIN_ID <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLike(String value) {
            addCriterion("LOGIN_ID like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotLike(String value) {
            addCriterion("LOGIN_ID not like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<String> values) {
            addCriterion("LOGIN_ID in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<String> values) {
            addCriterion("LOGIN_ID not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(String value1, String value2) {
            addCriterion("LOGIN_ID between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_ID not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
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

        public Criteria andIsDefaultIsNull() {
            addCriterion("IS_DEFAULT is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("IS_DEFAULT is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(String value) {
            addCriterion("IS_DEFAULT =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(String value) {
            addCriterion("IS_DEFAULT <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(String value) {
            addCriterion("IS_DEFAULT >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEFAULT >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(String value) {
            addCriterion("IS_DEFAULT <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(String value) {
            addCriterion("IS_DEFAULT <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLike(String value) {
            addCriterion("IS_DEFAULT like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotLike(String value) {
            addCriterion("IS_DEFAULT not like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<String> values) {
            addCriterion("IS_DEFAULT in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<String> values) {
            addCriterion("IS_DEFAULT not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(String value1, String value2) {
            addCriterion("IS_DEFAULT between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(String value1, String value2) {
            addCriterion("IS_DEFAULT not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsusedIsNull() {
            addCriterion("ISUSED is null");
            return (Criteria) this;
        }

        public Criteria andIsusedIsNotNull() {
            addCriterion("ISUSED is not null");
            return (Criteria) this;
        }

        public Criteria andIsusedEqualTo(String value) {
            addCriterion("ISUSED =", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotEqualTo(String value) {
            addCriterion("ISUSED <>", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedGreaterThan(String value) {
            addCriterion("ISUSED >", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedGreaterThanOrEqualTo(String value) {
            addCriterion("ISUSED >=", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLessThan(String value) {
            addCriterion("ISUSED <", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLessThanOrEqualTo(String value) {
            addCriterion("ISUSED <=", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLike(String value) {
            addCriterion("ISUSED like", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotLike(String value) {
            addCriterion("ISUSED not like", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedIn(List<String> values) {
            addCriterion("ISUSED in", values, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotIn(List<String> values) {
            addCriterion("ISUSED not in", values, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedBetween(String value1, String value2) {
            addCriterion("ISUSED between", value1, value2, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotBetween(String value1, String value2) {
            addCriterion("ISUSED not between", value1, value2, "isused");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andOffTelIsNull() {
            addCriterion("OFF_TEL is null");
            return (Criteria) this;
        }

        public Criteria andOffTelIsNotNull() {
            addCriterion("OFF_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andOffTelEqualTo(String value) {
            addCriterion("OFF_TEL =", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelNotEqualTo(String value) {
            addCriterion("OFF_TEL <>", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelGreaterThan(String value) {
            addCriterion("OFF_TEL >", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelGreaterThanOrEqualTo(String value) {
            addCriterion("OFF_TEL >=", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelLessThan(String value) {
            addCriterion("OFF_TEL <", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelLessThanOrEqualTo(String value) {
            addCriterion("OFF_TEL <=", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelLike(String value) {
            addCriterion("OFF_TEL like", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelNotLike(String value) {
            addCriterion("OFF_TEL not like", value, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelIn(List<String> values) {
            addCriterion("OFF_TEL in", values, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelNotIn(List<String> values) {
            addCriterion("OFF_TEL not in", values, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelBetween(String value1, String value2) {
            addCriterion("OFF_TEL between", value1, value2, "offTel");
            return (Criteria) this;
        }

        public Criteria andOffTelNotBetween(String value1, String value2) {
            addCriterion("OFF_TEL not between", value1, value2, "offTel");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("PASSWD is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("PASSWD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("PASSWD =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("PASSWD <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("PASSWD >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWD >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("PASSWD <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("PASSWD <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("PASSWD like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("PASSWD not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("PASSWD in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("PASSWD not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("PASSWD between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("PASSWD not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSinfoIdIsNull() {
            addCriterion("SINFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andSinfoIdIsNotNull() {
            addCriterion("SINFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSinfoIdEqualTo(Integer value) {
            addCriterion("SINFO_ID =", value, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdNotEqualTo(Integer value) {
            addCriterion("SINFO_ID <>", value, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdGreaterThan(Integer value) {
            addCriterion("SINFO_ID >", value, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SINFO_ID >=", value, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdLessThan(Integer value) {
            addCriterion("SINFO_ID <", value, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("SINFO_ID <=", value, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdIn(List<Integer> values) {
            addCriterion("SINFO_ID in", values, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdNotIn(List<Integer> values) {
            addCriterion("SINFO_ID not in", values, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("SINFO_ID between", value1, value2, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andSinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SINFO_ID not between", value1, value2, "sinfoId");
            return (Criteria) this;
        }

        public Criteria andIsUserIsNull() {
            addCriterion("IS_USER is null");
            return (Criteria) this;
        }

        public Criteria andIsUserIsNotNull() {
            addCriterion("IS_USER is not null");
            return (Criteria) this;
        }

        public Criteria andIsUserEqualTo(String value) {
            addCriterion("IS_USER =", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserNotEqualTo(String value) {
            addCriterion("IS_USER <>", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserGreaterThan(String value) {
            addCriterion("IS_USER >", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserGreaterThanOrEqualTo(String value) {
            addCriterion("IS_USER >=", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserLessThan(String value) {
            addCriterion("IS_USER <", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserLessThanOrEqualTo(String value) {
            addCriterion("IS_USER <=", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserLike(String value) {
            addCriterion("IS_USER like", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserNotLike(String value) {
            addCriterion("IS_USER not like", value, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserIn(List<String> values) {
            addCriterion("IS_USER in", values, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserNotIn(List<String> values) {
            addCriterion("IS_USER not in", values, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserBetween(String value1, String value2) {
            addCriterion("IS_USER between", value1, value2, "isUser");
            return (Criteria) this;
        }

        public Criteria andIsUserNotBetween(String value1, String value2) {
            addCriterion("IS_USER not between", value1, value2, "isUser");
            return (Criteria) this;
        }

        public Criteria andDailiIdIsNull() {
            addCriterion("DAILI_ID is null");
            return (Criteria) this;
        }

        public Criteria andDailiIdIsNotNull() {
            addCriterion("DAILI_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDailiIdEqualTo(String value) {
            addCriterion("DAILI_ID =", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdNotEqualTo(String value) {
            addCriterion("DAILI_ID <>", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdGreaterThan(String value) {
            addCriterion("DAILI_ID >", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdGreaterThanOrEqualTo(String value) {
            addCriterion("DAILI_ID >=", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdLessThan(String value) {
            addCriterion("DAILI_ID <", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdLessThanOrEqualTo(String value) {
            addCriterion("DAILI_ID <=", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdLike(String value) {
            addCriterion("DAILI_ID like", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdNotLike(String value) {
            addCriterion("DAILI_ID not like", value, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdIn(List<String> values) {
            addCriterion("DAILI_ID in", values, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdNotIn(List<String> values) {
            addCriterion("DAILI_ID not in", values, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdBetween(String value1, String value2) {
            addCriterion("DAILI_ID between", value1, value2, "dailiId");
            return (Criteria) this;
        }

        public Criteria andDailiIdNotBetween(String value1, String value2) {
            addCriterion("DAILI_ID not between", value1, value2, "dailiId");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNull() {
            addCriterion("areaname is null");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNotNull() {
            addCriterion("areaname is not null");
            return (Criteria) this;
        }

        public Criteria andAreanameEqualTo(String value) {
            addCriterion("areaname =", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotEqualTo(String value) {
            addCriterion("areaname <>", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThan(String value) {
            addCriterion("areaname >", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThanOrEqualTo(String value) {
            addCriterion("areaname >=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThan(String value) {
            addCriterion("areaname <", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThanOrEqualTo(String value) {
            addCriterion("areaname <=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLike(String value) {
            addCriterion("areaname like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotLike(String value) {
            addCriterion("areaname not like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameIn(List<String> values) {
            addCriterion("areaname in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotIn(List<String> values) {
            addCriterion("areaname not in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameBetween(String value1, String value2) {
            addCriterion("areaname between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotBetween(String value1, String value2) {
            addCriterion("areaname not between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNull() {
            addCriterion("areaid is null");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNotNull() {
            addCriterion("areaid is not null");
            return (Criteria) this;
        }

        public Criteria andAreaidEqualTo(String value) {
            addCriterion("areaid =", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotEqualTo(String value) {
            addCriterion("areaid <>", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThan(String value) {
            addCriterion("areaid >", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThanOrEqualTo(String value) {
            addCriterion("areaid >=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThan(String value) {
            addCriterion("areaid <", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThanOrEqualTo(String value) {
            addCriterion("areaid <=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLike(String value) {
            addCriterion("areaid like", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotLike(String value) {
            addCriterion("areaid not like", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidIn(List<String> values) {
            addCriterion("areaid in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotIn(List<String> values) {
            addCriterion("areaid not in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidBetween(String value1, String value2) {
            addCriterion("areaid between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotBetween(String value1, String value2) {
            addCriterion("areaid not between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreanmaeIsNull() {
            addCriterion("AREANMAE is null");
            return (Criteria) this;
        }

        public Criteria andAreanmaeIsNotNull() {
            addCriterion("AREANMAE is not null");
            return (Criteria) this;
        }

        public Criteria andAreanmaeEqualTo(String value) {
            addCriterion("AREANMAE =", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotEqualTo(String value) {
            addCriterion("AREANMAE <>", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeGreaterThan(String value) {
            addCriterion("AREANMAE >", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeGreaterThanOrEqualTo(String value) {
            addCriterion("AREANMAE >=", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeLessThan(String value) {
            addCriterion("AREANMAE <", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeLessThanOrEqualTo(String value) {
            addCriterion("AREANMAE <=", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeLike(String value) {
            addCriterion("AREANMAE like", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotLike(String value) {
            addCriterion("AREANMAE not like", value, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeIn(List<String> values) {
            addCriterion("AREANMAE in", values, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotIn(List<String> values) {
            addCriterion("AREANMAE not in", values, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeBetween(String value1, String value2) {
            addCriterion("AREANMAE between", value1, value2, "areanmae");
            return (Criteria) this;
        }

        public Criteria andAreanmaeNotBetween(String value1, String value2) {
            addCriterion("AREANMAE not between", value1, value2, "areanmae");
            return (Criteria) this;
        }

        public Criteria andIsxpsjIsNull() {
            addCriterion("ISXPSJ is null");
            return (Criteria) this;
        }

        public Criteria andIsxpsjIsNotNull() {
            addCriterion("ISXPSJ is not null");
            return (Criteria) this;
        }

        public Criteria andIsxpsjEqualTo(String value) {
            addCriterion("ISXPSJ =", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjNotEqualTo(String value) {
            addCriterion("ISXPSJ <>", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjGreaterThan(String value) {
            addCriterion("ISXPSJ >", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjGreaterThanOrEqualTo(String value) {
            addCriterion("ISXPSJ >=", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjLessThan(String value) {
            addCriterion("ISXPSJ <", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjLessThanOrEqualTo(String value) {
            addCriterion("ISXPSJ <=", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjLike(String value) {
            addCriterion("ISXPSJ like", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjNotLike(String value) {
            addCriterion("ISXPSJ not like", value, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjIn(List<String> values) {
            addCriterion("ISXPSJ in", values, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjNotIn(List<String> values) {
            addCriterion("ISXPSJ not in", values, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjBetween(String value1, String value2) {
            addCriterion("ISXPSJ between", value1, value2, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andIsxpsjNotBetween(String value1, String value2) {
            addCriterion("ISXPSJ not between", value1, value2, "isxpsj");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdIsNull() {
            addCriterion("AGENT_GRADE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdIsNotNull() {
            addCriterion("AGENT_GRADE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdEqualTo(Integer value) {
            addCriterion("AGENT_GRADE_ID =", value, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdNotEqualTo(Integer value) {
            addCriterion("AGENT_GRADE_ID <>", value, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdGreaterThan(Integer value) {
            addCriterion("AGENT_GRADE_ID >", value, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGENT_GRADE_ID >=", value, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdLessThan(Integer value) {
            addCriterion("AGENT_GRADE_ID <", value, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("AGENT_GRADE_ID <=", value, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdIn(List<Integer> values) {
            addCriterion("AGENT_GRADE_ID in", values, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdNotIn(List<Integer> values) {
            addCriterion("AGENT_GRADE_ID not in", values, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("AGENT_GRADE_ID between", value1, value2, "agentGradeId");
            return (Criteria) this;
        }

        public Criteria andAgentGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AGENT_GRADE_ID not between", value1, value2, "agentGradeId");
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