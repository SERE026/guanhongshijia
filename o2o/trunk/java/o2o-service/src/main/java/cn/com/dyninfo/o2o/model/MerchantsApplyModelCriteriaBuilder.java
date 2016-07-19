package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantsApplyModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantsApplyModelCriteriaBuilder() {
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

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andContatctEmailIsNull() {
            addCriterion("CONTATCT_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andContatctEmailIsNotNull() {
            addCriterion("CONTATCT_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andContatctEmailEqualTo(String value) {
            addCriterion("CONTATCT_EMAIL =", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailNotEqualTo(String value) {
            addCriterion("CONTATCT_EMAIL <>", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailGreaterThan(String value) {
            addCriterion("CONTATCT_EMAIL >", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailGreaterThanOrEqualTo(String value) {
            addCriterion("CONTATCT_EMAIL >=", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailLessThan(String value) {
            addCriterion("CONTATCT_EMAIL <", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailLessThanOrEqualTo(String value) {
            addCriterion("CONTATCT_EMAIL <=", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailLike(String value) {
            addCriterion("CONTATCT_EMAIL like", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailNotLike(String value) {
            addCriterion("CONTATCT_EMAIL not like", value, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailIn(List<String> values) {
            addCriterion("CONTATCT_EMAIL in", values, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailNotIn(List<String> values) {
            addCriterion("CONTATCT_EMAIL not in", values, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailBetween(String value1, String value2) {
            addCriterion("CONTATCT_EMAIL between", value1, value2, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctEmailNotBetween(String value1, String value2) {
            addCriterion("CONTATCT_EMAIL not between", value1, value2, "contatctEmail");
            return (Criteria) this;
        }

        public Criteria andContatctManIsNull() {
            addCriterion("CONTATCT_MAN is null");
            return (Criteria) this;
        }

        public Criteria andContatctManIsNotNull() {
            addCriterion("CONTATCT_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andContatctManEqualTo(String value) {
            addCriterion("CONTATCT_MAN =", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManNotEqualTo(String value) {
            addCriterion("CONTATCT_MAN <>", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManGreaterThan(String value) {
            addCriterion("CONTATCT_MAN >", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManGreaterThanOrEqualTo(String value) {
            addCriterion("CONTATCT_MAN >=", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManLessThan(String value) {
            addCriterion("CONTATCT_MAN <", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManLessThanOrEqualTo(String value) {
            addCriterion("CONTATCT_MAN <=", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManLike(String value) {
            addCriterion("CONTATCT_MAN like", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManNotLike(String value) {
            addCriterion("CONTATCT_MAN not like", value, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManIn(List<String> values) {
            addCriterion("CONTATCT_MAN in", values, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManNotIn(List<String> values) {
            addCriterion("CONTATCT_MAN not in", values, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManBetween(String value1, String value2) {
            addCriterion("CONTATCT_MAN between", value1, value2, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctManNotBetween(String value1, String value2) {
            addCriterion("CONTATCT_MAN not between", value1, value2, "contatctMan");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneIsNull() {
            addCriterion("CONTATCT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneIsNotNull() {
            addCriterion("CONTATCT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneEqualTo(String value) {
            addCriterion("CONTATCT_PHONE =", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneNotEqualTo(String value) {
            addCriterion("CONTATCT_PHONE <>", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneGreaterThan(String value) {
            addCriterion("CONTATCT_PHONE >", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONTATCT_PHONE >=", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneLessThan(String value) {
            addCriterion("CONTATCT_PHONE <", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONTATCT_PHONE <=", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneLike(String value) {
            addCriterion("CONTATCT_PHONE like", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneNotLike(String value) {
            addCriterion("CONTATCT_PHONE not like", value, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneIn(List<String> values) {
            addCriterion("CONTATCT_PHONE in", values, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneNotIn(List<String> values) {
            addCriterion("CONTATCT_PHONE not in", values, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneBetween(String value1, String value2) {
            addCriterion("CONTATCT_PHONE between", value1, value2, "contatctPhone");
            return (Criteria) this;
        }

        public Criteria andContatctPhoneNotBetween(String value1, String value2) {
            addCriterion("CONTATCT_PHONE not between", value1, value2, "contatctPhone");
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

        public Criteria andStoreNameIsNull() {
            addCriterion("STORE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("STORE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("STORE_NAME =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("STORE_NAME <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("STORE_NAME >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_NAME >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("STORE_NAME <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("STORE_NAME <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("STORE_NAME like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("STORE_NAME not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("STORE_NAME in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("STORE_NAME not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("STORE_NAME between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("STORE_NAME not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNull() {
            addCriterion("STORE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("STORE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(Integer value) {
            addCriterion("STORE_TYPE =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(Integer value) {
            addCriterion("STORE_TYPE <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(Integer value) {
            addCriterion("STORE_TYPE >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("STORE_TYPE >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(Integer value) {
            addCriterion("STORE_TYPE <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(Integer value) {
            addCriterion("STORE_TYPE <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<Integer> values) {
            addCriterion("STORE_TYPE in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<Integer> values) {
            addCriterion("STORE_TYPE not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(Integer value1, Integer value2) {
            addCriterion("STORE_TYPE between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("STORE_TYPE not between", value1, value2, "storeType");
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

        public Criteria andCountIdIsNull() {
            addCriterion("COUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNotNull() {
            addCriterion("COUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCountIdEqualTo(String value) {
            addCriterion("COUNT_ID =", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotEqualTo(String value) {
            addCriterion("COUNT_ID <>", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThan(String value) {
            addCriterion("COUNT_ID >", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThanOrEqualTo(String value) {
            addCriterion("COUNT_ID >=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThan(String value) {
            addCriterion("COUNT_ID <", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThanOrEqualTo(String value) {
            addCriterion("COUNT_ID <=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLike(String value) {
            addCriterion("COUNT_ID like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotLike(String value) {
            addCriterion("COUNT_ID not like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdIn(List<String> values) {
            addCriterion("COUNT_ID in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotIn(List<String> values) {
            addCriterion("COUNT_ID not in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdBetween(String value1, String value2) {
            addCriterion("COUNT_ID between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotBetween(String value1, String value2) {
            addCriterion("COUNT_ID not between", value1, value2, "countId");
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

        public Criteria andBusTypeIsNull() {
            addCriterion("BUS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNotNull() {
            addCriterion("BUS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusTypeEqualTo(Integer value) {
            addCriterion("BUS_TYPE =", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotEqualTo(Integer value) {
            addCriterion("BUS_TYPE <>", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThan(Integer value) {
            addCriterion("BUS_TYPE >", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUS_TYPE >=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThan(Integer value) {
            addCriterion("BUS_TYPE <", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BUS_TYPE <=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeIn(List<Integer> values) {
            addCriterion("BUS_TYPE in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotIn(List<Integer> values) {
            addCriterion("BUS_TYPE not in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeBetween(Integer value1, Integer value2) {
            addCriterion("BUS_TYPE between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BUS_TYPE not between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andContatctTelIsNull() {
            addCriterion("CONTATCT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andContatctTelIsNotNull() {
            addCriterion("CONTATCT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andContatctTelEqualTo(String value) {
            addCriterion("CONTATCT_TEL =", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelNotEqualTo(String value) {
            addCriterion("CONTATCT_TEL <>", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelGreaterThan(String value) {
            addCriterion("CONTATCT_TEL >", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelGreaterThanOrEqualTo(String value) {
            addCriterion("CONTATCT_TEL >=", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelLessThan(String value) {
            addCriterion("CONTATCT_TEL <", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelLessThanOrEqualTo(String value) {
            addCriterion("CONTATCT_TEL <=", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelLike(String value) {
            addCriterion("CONTATCT_TEL like", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelNotLike(String value) {
            addCriterion("CONTATCT_TEL not like", value, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelIn(List<String> values) {
            addCriterion("CONTATCT_TEL in", values, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelNotIn(List<String> values) {
            addCriterion("CONTATCT_TEL not in", values, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelBetween(String value1, String value2) {
            addCriterion("CONTATCT_TEL between", value1, value2, "contatctTel");
            return (Criteria) this;
        }

        public Criteria andContatctTelNotBetween(String value1, String value2) {
            addCriterion("CONTATCT_TEL not between", value1, value2, "contatctTel");
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