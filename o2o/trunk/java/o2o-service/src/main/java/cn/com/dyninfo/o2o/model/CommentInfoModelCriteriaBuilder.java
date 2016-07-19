package cn.com.dyninfo.o2o.model;

import java.util.ArrayList;
import java.util.List;

public class CommentInfoModelCriteriaBuilder {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentInfoModelCriteriaBuilder() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Integer value) {
            addCriterion("INFO_ID =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Integer value) {
            addCriterion("INFO_ID <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Integer value) {
            addCriterion("INFO_ID >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("INFO_ID >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Integer value) {
            addCriterion("INFO_ID <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("INFO_ID <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Integer> values) {
            addCriterion("INFO_ID in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Integer> values) {
            addCriterion("INFO_ID not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("INFO_ID between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("INFO_ID not between", value1, value2, "infoId");
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

        public Criteria andGinfoIdIsNull() {
            addCriterion("GINFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andGinfoIdIsNotNull() {
            addCriterion("GINFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGinfoIdEqualTo(Integer value) {
            addCriterion("GINFO_ID =", value, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdNotEqualTo(Integer value) {
            addCriterion("GINFO_ID <>", value, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdGreaterThan(Integer value) {
            addCriterion("GINFO_ID >", value, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GINFO_ID >=", value, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdLessThan(Integer value) {
            addCriterion("GINFO_ID <", value, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("GINFO_ID <=", value, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdIn(List<Integer> values) {
            addCriterion("GINFO_ID in", values, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdNotIn(List<Integer> values) {
            addCriterion("GINFO_ID not in", values, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("GINFO_ID between", value1, value2, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andGinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GINFO_ID not between", value1, value2, "ginfoId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNull() {
            addCriterion("REPLY_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("REPLY_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("REPLY_CONTENT =", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("REPLY_CONTENT <>", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("REPLY_CONTENT >", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("REPLY_CONTENT >=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("REPLY_CONTENT <", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("REPLY_CONTENT <=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLike(String value) {
            addCriterion("REPLY_CONTENT like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("REPLY_CONTENT not like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(List<String> values) {
            addCriterion("REPLY_CONTENT in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(List<String> values) {
            addCriterion("REPLY_CONTENT not in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("REPLY_CONTENT between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("REPLY_CONTENT not between", value1, value2, "replyContent");
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

        public Criteria andUinfoIdIsNull() {
            addCriterion("UINFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andUinfoIdIsNotNull() {
            addCriterion("UINFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUinfoIdEqualTo(String value) {
            addCriterion("UINFO_ID =", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdNotEqualTo(String value) {
            addCriterion("UINFO_ID <>", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdGreaterThan(String value) {
            addCriterion("UINFO_ID >", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("UINFO_ID >=", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdLessThan(String value) {
            addCriterion("UINFO_ID <", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdLessThanOrEqualTo(String value) {
            addCriterion("UINFO_ID <=", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdLike(String value) {
            addCriterion("UINFO_ID like", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdNotLike(String value) {
            addCriterion("UINFO_ID not like", value, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdIn(List<String> values) {
            addCriterion("UINFO_ID in", values, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdNotIn(List<String> values) {
            addCriterion("UINFO_ID not in", values, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdBetween(String value1, String value2) {
            addCriterion("UINFO_ID between", value1, value2, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andUinfoIdNotBetween(String value1, String value2) {
            addCriterion("UINFO_ID not between", value1, value2, "uinfoId");
            return (Criteria) this;
        }

        public Criteria andImageSrcIsNull() {
            addCriterion("IMAGE_SRC is null");
            return (Criteria) this;
        }

        public Criteria andImageSrcIsNotNull() {
            addCriterion("IMAGE_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andImageSrcEqualTo(String value) {
            addCriterion("IMAGE_SRC =", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcNotEqualTo(String value) {
            addCriterion("IMAGE_SRC <>", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcGreaterThan(String value) {
            addCriterion("IMAGE_SRC >", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_SRC >=", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcLessThan(String value) {
            addCriterion("IMAGE_SRC <", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcLessThanOrEqualTo(String value) {
            addCriterion("IMAGE_SRC <=", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcLike(String value) {
            addCriterion("IMAGE_SRC like", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcNotLike(String value) {
            addCriterion("IMAGE_SRC not like", value, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcIn(List<String> values) {
            addCriterion("IMAGE_SRC in", values, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcNotIn(List<String> values) {
            addCriterion("IMAGE_SRC not in", values, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcBetween(String value1, String value2) {
            addCriterion("IMAGE_SRC between", value1, value2, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andImageSrcNotBetween(String value1, String value2) {
            addCriterion("IMAGE_SRC not between", value1, value2, "imageSrc");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("IS_SHOW is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("IS_SHOW is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("IS_SHOW =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("IS_SHOW <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("IS_SHOW >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SHOW >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("IS_SHOW <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("IS_SHOW <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("IS_SHOW like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("IS_SHOW not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("IS_SHOW in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("IS_SHOW not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("IS_SHOW between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("IS_SHOW not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andLeveIsNull() {
            addCriterion("LEVE is null");
            return (Criteria) this;
        }

        public Criteria andLeveIsNotNull() {
            addCriterion("LEVE is not null");
            return (Criteria) this;
        }

        public Criteria andLeveEqualTo(Double value) {
            addCriterion("LEVE =", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveNotEqualTo(Double value) {
            addCriterion("LEVE <>", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveGreaterThan(Double value) {
            addCriterion("LEVE >", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveGreaterThanOrEqualTo(Double value) {
            addCriterion("LEVE >=", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveLessThan(Double value) {
            addCriterion("LEVE <", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveLessThanOrEqualTo(Double value) {
            addCriterion("LEVE <=", value, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveIn(List<Double> values) {
            addCriterion("LEVE in", values, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveNotIn(List<Double> values) {
            addCriterion("LEVE not in", values, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveBetween(Double value1, Double value2) {
            addCriterion("LEVE between", value1, value2, "leve");
            return (Criteria) this;
        }

        public Criteria andLeveNotBetween(Double value1, Double value2) {
            addCriterion("LEVE not between", value1, value2, "leve");
            return (Criteria) this;
        }

        public Criteria andPhototitleIsNull() {
            addCriterion("PHOTOTITLE is null");
            return (Criteria) this;
        }

        public Criteria andPhototitleIsNotNull() {
            addCriterion("PHOTOTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPhototitleEqualTo(String value) {
            addCriterion("PHOTOTITLE =", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleNotEqualTo(String value) {
            addCriterion("PHOTOTITLE <>", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleGreaterThan(String value) {
            addCriterion("PHOTOTITLE >", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTOTITLE >=", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleLessThan(String value) {
            addCriterion("PHOTOTITLE <", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleLessThanOrEqualTo(String value) {
            addCriterion("PHOTOTITLE <=", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleLike(String value) {
            addCriterion("PHOTOTITLE like", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleNotLike(String value) {
            addCriterion("PHOTOTITLE not like", value, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleIn(List<String> values) {
            addCriterion("PHOTOTITLE in", values, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleNotIn(List<String> values) {
            addCriterion("PHOTOTITLE not in", values, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleBetween(String value1, String value2) {
            addCriterion("PHOTOTITLE between", value1, value2, "phototitle");
            return (Criteria) this;
        }

        public Criteria andPhototitleNotBetween(String value1, String value2) {
            addCriterion("PHOTOTITLE not between", value1, value2, "phototitle");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdIsNull() {
            addCriterion("ORDERPRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdIsNotNull() {
            addCriterion("ORDERPRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdEqualTo(Integer value) {
            addCriterion("ORDERPRODUCT_ID =", value, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdNotEqualTo(Integer value) {
            addCriterion("ORDERPRODUCT_ID <>", value, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdGreaterThan(Integer value) {
            addCriterion("ORDERPRODUCT_ID >", value, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERPRODUCT_ID >=", value, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdLessThan(Integer value) {
            addCriterion("ORDERPRODUCT_ID <", value, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERPRODUCT_ID <=", value, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdIn(List<Integer> values) {
            addCriterion("ORDERPRODUCT_ID in", values, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdNotIn(List<Integer> values) {
            addCriterion("ORDERPRODUCT_ID not in", values, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdBetween(Integer value1, Integer value2) {
            addCriterion("ORDERPRODUCT_ID between", value1, value2, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andOrderproductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERPRODUCT_ID not between", value1, value2, "orderproductId");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("TIME like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("TIME not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("TIME not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andSaycontentIsNull() {
            addCriterion("SAYCONTENT is null");
            return (Criteria) this;
        }

        public Criteria andSaycontentIsNotNull() {
            addCriterion("SAYCONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andSaycontentEqualTo(String value) {
            addCriterion("SAYCONTENT =", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentNotEqualTo(String value) {
            addCriterion("SAYCONTENT <>", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentGreaterThan(String value) {
            addCriterion("SAYCONTENT >", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentGreaterThanOrEqualTo(String value) {
            addCriterion("SAYCONTENT >=", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentLessThan(String value) {
            addCriterion("SAYCONTENT <", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentLessThanOrEqualTo(String value) {
            addCriterion("SAYCONTENT <=", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentLike(String value) {
            addCriterion("SAYCONTENT like", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentNotLike(String value) {
            addCriterion("SAYCONTENT not like", value, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentIn(List<String> values) {
            addCriterion("SAYCONTENT in", values, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentNotIn(List<String> values) {
            addCriterion("SAYCONTENT not in", values, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentBetween(String value1, String value2) {
            addCriterion("SAYCONTENT between", value1, value2, "saycontent");
            return (Criteria) this;
        }

        public Criteria andSaycontentNotBetween(String value1, String value2) {
            addCriterion("SAYCONTENT not between", value1, value2, "saycontent");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNull() {
            addCriterion("INDEXS is null");
            return (Criteria) this;
        }

        public Criteria andIndexsIsNotNull() {
            addCriterion("INDEXS is not null");
            return (Criteria) this;
        }

        public Criteria andIndexsEqualTo(String value) {
            addCriterion("INDEXS =", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotEqualTo(String value) {
            addCriterion("INDEXS <>", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThan(String value) {
            addCriterion("INDEXS >", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXS >=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThan(String value) {
            addCriterion("INDEXS <", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLessThanOrEqualTo(String value) {
            addCriterion("INDEXS <=", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsLike(String value) {
            addCriterion("INDEXS like", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotLike(String value) {
            addCriterion("INDEXS not like", value, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsIn(List<String> values) {
            addCriterion("INDEXS in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotIn(List<String> values) {
            addCriterion("INDEXS not in", values, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsBetween(String value1, String value2) {
            addCriterion("INDEXS between", value1, value2, "indexs");
            return (Criteria) this;
        }

        public Criteria andIndexsNotBetween(String value1, String value2) {
            addCriterion("INDEXS not between", value1, value2, "indexs");
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