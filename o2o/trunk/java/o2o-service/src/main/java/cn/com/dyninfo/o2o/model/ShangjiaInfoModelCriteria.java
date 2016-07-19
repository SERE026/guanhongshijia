package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class ShangjiaInfoModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ShangjiaInfoModelCriteria() {
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

        public Criteria andContactnameIsNull() {
            addCriterion("CONTACTNAME is null");
            return (Criteria) this;
        }

        public Criteria andContactnameIsNotNull() {
            addCriterion("CONTACTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactnameEqualTo(String value) {
            addCriterion("CONTACTNAME =", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotEqualTo(String value) {
            addCriterion("CONTACTNAME <>", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameGreaterThan(String value) {
            addCriterion("CONTACTNAME >", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTNAME >=", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameLessThan(String value) {
            addCriterion("CONTACTNAME <", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameLessThanOrEqualTo(String value) {
            addCriterion("CONTACTNAME <=", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameLike(String value) {
            addCriterion("CONTACTNAME like", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotLike(String value) {
            addCriterion("CONTACTNAME not like", value, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameIn(List<String> values) {
            addCriterion("CONTACTNAME in", values, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotIn(List<String> values) {
            addCriterion("CONTACTNAME not in", values, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameBetween(String value1, String value2) {
            addCriterion("CONTACTNAME between", value1, value2, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactnameNotBetween(String value1, String value2) {
            addCriterion("CONTACTNAME not between", value1, value2, "contactname");
            return (Criteria) this;
        }

        public Criteria andContactphoneIsNull() {
            addCriterion("CONTACTPHONE is null");
            return (Criteria) this;
        }

        public Criteria andContactphoneIsNotNull() {
            addCriterion("CONTACTPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContactphoneEqualTo(String value) {
            addCriterion("CONTACTPHONE =", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneNotEqualTo(String value) {
            addCriterion("CONTACTPHONE <>", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneGreaterThan(String value) {
            addCriterion("CONTACTPHONE >", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTPHONE >=", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneLessThan(String value) {
            addCriterion("CONTACTPHONE <", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneLessThanOrEqualTo(String value) {
            addCriterion("CONTACTPHONE <=", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneLike(String value) {
            addCriterion("CONTACTPHONE like", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneNotLike(String value) {
            addCriterion("CONTACTPHONE not like", value, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneIn(List<String> values) {
            addCriterion("CONTACTPHONE in", values, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneNotIn(List<String> values) {
            addCriterion("CONTACTPHONE not in", values, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneBetween(String value1, String value2) {
            addCriterion("CONTACTPHONE between", value1, value2, "contactphone");
            return (Criteria) this;
        }

        public Criteria andContactphoneNotBetween(String value1, String value2) {
            addCriterion("CONTACTPHONE not between", value1, value2, "contactphone");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Float value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Float value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Float value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Float value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Float value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Float> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Float> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Float value1, Float value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Float value1, Float value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Float value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Float value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Float value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Float value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Float value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Float> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Float> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Float value1, Float value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Float value1, Float value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
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

        public Criteria andOrderIndexIsNull() {
            addCriterion("ORDER_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNotNull() {
            addCriterion("ORDER_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexEqualTo(String value) {
            addCriterion("ORDER_INDEX =", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotEqualTo(String value) {
            addCriterion("ORDER_INDEX <>", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThan(String value) {
            addCriterion("ORDER_INDEX >", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_INDEX >=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThan(String value) {
            addCriterion("ORDER_INDEX <", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThanOrEqualTo(String value) {
            addCriterion("ORDER_INDEX <=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLike(String value) {
            addCriterion("ORDER_INDEX like", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotLike(String value) {
            addCriterion("ORDER_INDEX not like", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIn(List<String> values) {
            addCriterion("ORDER_INDEX in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotIn(List<String> values) {
            addCriterion("ORDER_INDEX not in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexBetween(String value1, String value2) {
            addCriterion("ORDER_INDEX between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotBetween(String value1, String value2) {
            addCriterion("ORDER_INDEX not between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("INTRO is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("INTRO =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("INTRO <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("INTRO >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("INTRO >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("INTRO <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("INTRO <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("INTRO like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("INTRO not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("INTRO in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("INTRO not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("INTRO between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("INTRO not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexIsNull() {
            addCriterion("RECOMMENDED_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexIsNotNull() {
            addCriterion("RECOMMENDED_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexEqualTo(String value) {
            addCriterion("RECOMMENDED_INDEX =", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexNotEqualTo(String value) {
            addCriterion("RECOMMENDED_INDEX <>", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexGreaterThan(String value) {
            addCriterion("RECOMMENDED_INDEX >", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexGreaterThanOrEqualTo(String value) {
            addCriterion("RECOMMENDED_INDEX >=", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexLessThan(String value) {
            addCriterion("RECOMMENDED_INDEX <", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexLessThanOrEqualTo(String value) {
            addCriterion("RECOMMENDED_INDEX <=", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexLike(String value) {
            addCriterion("RECOMMENDED_INDEX like", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexNotLike(String value) {
            addCriterion("RECOMMENDED_INDEX not like", value, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexIn(List<String> values) {
            addCriterion("RECOMMENDED_INDEX in", values, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexNotIn(List<String> values) {
            addCriterion("RECOMMENDED_INDEX not in", values, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexBetween(String value1, String value2) {
            addCriterion("RECOMMENDED_INDEX between", value1, value2, "recommendedIndex");
            return (Criteria) this;
        }

        public Criteria andRecommendedIndexNotBetween(String value1, String value2) {
            addCriterion("RECOMMENDED_INDEX not between", value1, value2, "recommendedIndex");
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

        public Criteria andImageIsNull() {
            addCriterion("IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("IMAGE =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("IMAGE <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("IMAGE >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("IMAGE <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("IMAGE <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("IMAGE like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("IMAGE not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("IMAGE in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("IMAGE not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("IMAGE between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("IMAGE not between", value1, value2, "image");
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAffiliationIsNull() {
            addCriterion("AFFILIATION is null");
            return (Criteria) this;
        }

        public Criteria andAffiliationIsNotNull() {
            addCriterion("AFFILIATION is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliationEqualTo(String value) {
            addCriterion("AFFILIATION =", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotEqualTo(String value) {
            addCriterion("AFFILIATION <>", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationGreaterThan(String value) {
            addCriterion("AFFILIATION >", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationGreaterThanOrEqualTo(String value) {
            addCriterion("AFFILIATION >=", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationLessThan(String value) {
            addCriterion("AFFILIATION <", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationLessThanOrEqualTo(String value) {
            addCriterion("AFFILIATION <=", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationLike(String value) {
            addCriterion("AFFILIATION like", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotLike(String value) {
            addCriterion("AFFILIATION not like", value, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationIn(List<String> values) {
            addCriterion("AFFILIATION in", values, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotIn(List<String> values) {
            addCriterion("AFFILIATION not in", values, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationBetween(String value1, String value2) {
            addCriterion("AFFILIATION between", value1, value2, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAffiliationNotBetween(String value1, String value2) {
            addCriterion("AFFILIATION not between", value1, value2, "affiliation");
            return (Criteria) this;
        }

        public Criteria andAppkeyIsNull() {
            addCriterion("APPKEY is null");
            return (Criteria) this;
        }

        public Criteria andAppkeyIsNotNull() {
            addCriterion("APPKEY is not null");
            return (Criteria) this;
        }

        public Criteria andAppkeyEqualTo(String value) {
            addCriterion("APPKEY =", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotEqualTo(String value) {
            addCriterion("APPKEY <>", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyGreaterThan(String value) {
            addCriterion("APPKEY >", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("APPKEY >=", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLessThan(String value) {
            addCriterion("APPKEY <", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLessThanOrEqualTo(String value) {
            addCriterion("APPKEY <=", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLike(String value) {
            addCriterion("APPKEY like", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotLike(String value) {
            addCriterion("APPKEY not like", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyIn(List<String> values) {
            addCriterion("APPKEY in", values, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotIn(List<String> values) {
            addCriterion("APPKEY not in", values, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyBetween(String value1, String value2) {
            addCriterion("APPKEY between", value1, value2, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotBetween(String value1, String value2) {
            addCriterion("APPKEY not between", value1, value2, "appkey");
            return (Criteria) this;
        }

        public Criteria andNrjIdIsNull() {
            addCriterion("NRJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andNrjIdIsNotNull() {
            addCriterion("NRJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNrjIdEqualTo(Integer value) {
            addCriterion("NRJ_ID =", value, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdNotEqualTo(Integer value) {
            addCriterion("NRJ_ID <>", value, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdGreaterThan(Integer value) {
            addCriterion("NRJ_ID >", value, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NRJ_ID >=", value, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdLessThan(Integer value) {
            addCriterion("NRJ_ID <", value, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdLessThanOrEqualTo(Integer value) {
            addCriterion("NRJ_ID <=", value, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdIn(List<Integer> values) {
            addCriterion("NRJ_ID in", values, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdNotIn(List<Integer> values) {
            addCriterion("NRJ_ID not in", values, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdBetween(Integer value1, Integer value2) {
            addCriterion("NRJ_ID between", value1, value2, "nrjId");
            return (Criteria) this;
        }

        public Criteria andNrjIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NRJ_ID not between", value1, value2, "nrjId");
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

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andDzIamgeIsNull() {
            addCriterion("DZ_IAMGE is null");
            return (Criteria) this;
        }

        public Criteria andDzIamgeIsNotNull() {
            addCriterion("DZ_IAMGE is not null");
            return (Criteria) this;
        }

        public Criteria andDzIamgeEqualTo(String value) {
            addCriterion("DZ_IAMGE =", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeNotEqualTo(String value) {
            addCriterion("DZ_IAMGE <>", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeGreaterThan(String value) {
            addCriterion("DZ_IAMGE >", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeGreaterThanOrEqualTo(String value) {
            addCriterion("DZ_IAMGE >=", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeLessThan(String value) {
            addCriterion("DZ_IAMGE <", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeLessThanOrEqualTo(String value) {
            addCriterion("DZ_IAMGE <=", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeLike(String value) {
            addCriterion("DZ_IAMGE like", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeNotLike(String value) {
            addCriterion("DZ_IAMGE not like", value, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeIn(List<String> values) {
            addCriterion("DZ_IAMGE in", values, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeNotIn(List<String> values) {
            addCriterion("DZ_IAMGE not in", values, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeBetween(String value1, String value2) {
            addCriterion("DZ_IAMGE between", value1, value2, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andDzIamgeNotBetween(String value1, String value2) {
            addCriterion("DZ_IAMGE not between", value1, value2, "dzIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeIsNull() {
            addCriterion("NRJ_IAMGE is null");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeIsNotNull() {
            addCriterion("NRJ_IAMGE is not null");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeEqualTo(String value) {
            addCriterion("NRJ_IAMGE =", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeNotEqualTo(String value) {
            addCriterion("NRJ_IAMGE <>", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeGreaterThan(String value) {
            addCriterion("NRJ_IAMGE >", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeGreaterThanOrEqualTo(String value) {
            addCriterion("NRJ_IAMGE >=", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeLessThan(String value) {
            addCriterion("NRJ_IAMGE <", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeLessThanOrEqualTo(String value) {
            addCriterion("NRJ_IAMGE <=", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeLike(String value) {
            addCriterion("NRJ_IAMGE like", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeNotLike(String value) {
            addCriterion("NRJ_IAMGE not like", value, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeIn(List<String> values) {
            addCriterion("NRJ_IAMGE in", values, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeNotIn(List<String> values) {
            addCriterion("NRJ_IAMGE not in", values, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeBetween(String value1, String value2) {
            addCriterion("NRJ_IAMGE between", value1, value2, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andNrjIamgeNotBetween(String value1, String value2) {
            addCriterion("NRJ_IAMGE not between", value1, value2, "nrjIamge");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
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

        public Criteria andDzUrlIsNull() {
            addCriterion("DZ_URL is null");
            return (Criteria) this;
        }

        public Criteria andDzUrlIsNotNull() {
            addCriterion("DZ_URL is not null");
            return (Criteria) this;
        }

        public Criteria andDzUrlEqualTo(String value) {
            addCriterion("DZ_URL =", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlNotEqualTo(String value) {
            addCriterion("DZ_URL <>", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlGreaterThan(String value) {
            addCriterion("DZ_URL >", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlGreaterThanOrEqualTo(String value) {
            addCriterion("DZ_URL >=", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlLessThan(String value) {
            addCriterion("DZ_URL <", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlLessThanOrEqualTo(String value) {
            addCriterion("DZ_URL <=", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlLike(String value) {
            addCriterion("DZ_URL like", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlNotLike(String value) {
            addCriterion("DZ_URL not like", value, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlIn(List<String> values) {
            addCriterion("DZ_URL in", values, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlNotIn(List<String> values) {
            addCriterion("DZ_URL not in", values, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlBetween(String value1, String value2) {
            addCriterion("DZ_URL between", value1, value2, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andDzUrlNotBetween(String value1, String value2) {
            addCriterion("DZ_URL not between", value1, value2, "dzUrl");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
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