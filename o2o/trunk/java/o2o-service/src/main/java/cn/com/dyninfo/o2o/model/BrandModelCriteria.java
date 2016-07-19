package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class BrandModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public BrandModelCriteria() {
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

        public Criteria andLogoIsNull() {
            addCriterion("LOGO is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("LOGO is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("LOGO =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("LOGO <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("LOGO >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("LOGO >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("LOGO <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("LOGO <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("LOGO like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("LOGO not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("LOGO in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("LOGO not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("LOGO between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("LOGO not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("PROVIDER is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("PROVIDER is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("PROVIDER =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("PROVIDER <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("PROVIDER >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("PROVIDER <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("PROVIDER like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("PROVIDER not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("PROVIDER in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("PROVIDER not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("PROVIDER between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("PROVIDER not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneIsNull() {
            addCriterion("PROVIDER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneIsNotNull() {
            addCriterion("PROVIDER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneEqualTo(String value) {
            addCriterion("PROVIDER_PHONE =", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneNotEqualTo(String value) {
            addCriterion("PROVIDER_PHONE <>", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneGreaterThan(String value) {
            addCriterion("PROVIDER_PHONE >", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER_PHONE >=", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneLessThan(String value) {
            addCriterion("PROVIDER_PHONE <", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER_PHONE <=", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneLike(String value) {
            addCriterion("PROVIDER_PHONE like", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneNotLike(String value) {
            addCriterion("PROVIDER_PHONE not like", value, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneIn(List<String> values) {
            addCriterion("PROVIDER_PHONE in", values, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneNotIn(List<String> values) {
            addCriterion("PROVIDER_PHONE not in", values, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneBetween(String value1, String value2) {
            addCriterion("PROVIDER_PHONE between", value1, value2, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderPhoneNotBetween(String value1, String value2) {
            addCriterion("PROVIDER_PHONE not between", value1, value2, "providerPhone");
            return (Criteria) this;
        }

        public Criteria andProviderMovableIsNull() {
            addCriterion("PROVIDER_MOVABLE is null");
            return (Criteria) this;
        }

        public Criteria andProviderMovableIsNotNull() {
            addCriterion("PROVIDER_MOVABLE is not null");
            return (Criteria) this;
        }

        public Criteria andProviderMovableEqualTo(String value) {
            addCriterion("PROVIDER_MOVABLE =", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableNotEqualTo(String value) {
            addCriterion("PROVIDER_MOVABLE <>", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableGreaterThan(String value) {
            addCriterion("PROVIDER_MOVABLE >", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER_MOVABLE >=", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableLessThan(String value) {
            addCriterion("PROVIDER_MOVABLE <", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER_MOVABLE <=", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableLike(String value) {
            addCriterion("PROVIDER_MOVABLE like", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableNotLike(String value) {
            addCriterion("PROVIDER_MOVABLE not like", value, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableIn(List<String> values) {
            addCriterion("PROVIDER_MOVABLE in", values, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableNotIn(List<String> values) {
            addCriterion("PROVIDER_MOVABLE not in", values, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableBetween(String value1, String value2) {
            addCriterion("PROVIDER_MOVABLE between", value1, value2, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderMovableNotBetween(String value1, String value2) {
            addCriterion("PROVIDER_MOVABLE not between", value1, value2, "providerMovable");
            return (Criteria) this;
        }

        public Criteria andProviderAddressIsNull() {
            addCriterion("PROVIDER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andProviderAddressIsNotNull() {
            addCriterion("PROVIDER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andProviderAddressEqualTo(String value) {
            addCriterion("PROVIDER_ADDRESS =", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressNotEqualTo(String value) {
            addCriterion("PROVIDER_ADDRESS <>", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressGreaterThan(String value) {
            addCriterion("PROVIDER_ADDRESS >", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("PROVIDER_ADDRESS >=", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressLessThan(String value) {
            addCriterion("PROVIDER_ADDRESS <", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressLessThanOrEqualTo(String value) {
            addCriterion("PROVIDER_ADDRESS <=", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressLike(String value) {
            addCriterion("PROVIDER_ADDRESS like", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressNotLike(String value) {
            addCriterion("PROVIDER_ADDRESS not like", value, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressIn(List<String> values) {
            addCriterion("PROVIDER_ADDRESS in", values, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressNotIn(List<String> values) {
            addCriterion("PROVIDER_ADDRESS not in", values, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressBetween(String value1, String value2) {
            addCriterion("PROVIDER_ADDRESS between", value1, value2, "providerAddress");
            return (Criteria) this;
        }

        public Criteria andProviderAddressNotBetween(String value1, String value2) {
            addCriterion("PROVIDER_ADDRESS not between", value1, value2, "providerAddress");
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

        public Criteria andIsRIsNull() {
            addCriterion("IS_R is null");
            return (Criteria) this;
        }

        public Criteria andIsRIsNotNull() {
            addCriterion("IS_R is not null");
            return (Criteria) this;
        }

        public Criteria andIsREqualTo(String value) {
            addCriterion("IS_R =", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRNotEqualTo(String value) {
            addCriterion("IS_R <>", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRGreaterThan(String value) {
            addCriterion("IS_R >", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRGreaterThanOrEqualTo(String value) {
            addCriterion("IS_R >=", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRLessThan(String value) {
            addCriterion("IS_R <", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRLessThanOrEqualTo(String value) {
            addCriterion("IS_R <=", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRLike(String value) {
            addCriterion("IS_R like", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRNotLike(String value) {
            addCriterion("IS_R not like", value, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRIn(List<String> values) {
            addCriterion("IS_R in", values, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRNotIn(List<String> values) {
            addCriterion("IS_R not in", values, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRBetween(String value1, String value2) {
            addCriterion("IS_R between", value1, value2, "isR");
            return (Criteria) this;
        }

        public Criteria andIsRNotBetween(String value1, String value2) {
            addCriterion("IS_R not between", value1, value2, "isR");
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

        public Criteria andMarchantsIdEqualTo(String value) {
            addCriterion("MARCHANTS_ID =", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotEqualTo(String value) {
            addCriterion("MARCHANTS_ID <>", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdGreaterThan(String value) {
            addCriterion("MARCHANTS_ID >", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdGreaterThanOrEqualTo(String value) {
            addCriterion("MARCHANTS_ID >=", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLessThan(String value) {
            addCriterion("MARCHANTS_ID <", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLessThanOrEqualTo(String value) {
            addCriterion("MARCHANTS_ID <=", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdLike(String value) {
            addCriterion("MARCHANTS_ID like", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotLike(String value) {
            addCriterion("MARCHANTS_ID not like", value, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdIn(List<String> values) {
            addCriterion("MARCHANTS_ID in", values, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotIn(List<String> values) {
            addCriterion("MARCHANTS_ID not in", values, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdBetween(String value1, String value2) {
            addCriterion("MARCHANTS_ID between", value1, value2, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andMarchantsIdNotBetween(String value1, String value2) {
            addCriterion("MARCHANTS_ID not between", value1, value2, "marchantsId");
            return (Criteria) this;
        }

        public Criteria andPaixuIsNull() {
            addCriterion("PAIXU is null");
            return (Criteria) this;
        }

        public Criteria andPaixuIsNotNull() {
            addCriterion("PAIXU is not null");
            return (Criteria) this;
        }

        public Criteria andPaixuEqualTo(String value) {
            addCriterion("PAIXU =", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotEqualTo(String value) {
            addCriterion("PAIXU <>", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuGreaterThan(String value) {
            addCriterion("PAIXU >", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuGreaterThanOrEqualTo(String value) {
            addCriterion("PAIXU >=", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuLessThan(String value) {
            addCriterion("PAIXU <", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuLessThanOrEqualTo(String value) {
            addCriterion("PAIXU <=", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuLike(String value) {
            addCriterion("PAIXU like", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotLike(String value) {
            addCriterion("PAIXU not like", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuIn(List<String> values) {
            addCriterion("PAIXU in", values, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotIn(List<String> values) {
            addCriterion("PAIXU not in", values, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuBetween(String value1, String value2) {
            addCriterion("PAIXU between", value1, value2, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotBetween(String value1, String value2) {
            addCriterion("PAIXU not between", value1, value2, "paixu");
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