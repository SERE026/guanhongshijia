package cn.com.dyninfo.o2o.common.service;

import cn.com.dyninfo.o2o.common.Page;
import cn.com.dyninfo.o2o.common.mapper.BaseMapper;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
public abstract class BaseService <T, C> {

    public Logger log = LoggerFactory.getLogger(getClass());

    public abstract BaseMapper<T, C> getDomainMapper();

    /** PageMapper Start **/
    public Page<T> findPage(Page<T> page, Map<String, Object> parameter) {
        Integer totalCount = getDomainMapper().findPageCount(parameter);

        page.setResult(getDomainMapper().findPage(toParameterMap(parameter, page)));

        page.setTotalItems(totalCount);

        return page;
    }

    public Integer findPageCount(Map<String, Object> parameter) {

        return getDomainMapper().findPageCount(parameter);
    }
    /** PageMapper End **/

    /** SelectMapper Start **/
    public T selectByPrimaryKey(@Param("id") Integer id) {
        return getDomainMapper().selectByPrimaryKey(id);
    }
    /** SelectMapper End **/

    /** InsertMapper Start **/
    public abstract int insert(T domain);

    public abstract int insertSelective(T domain);
    /** InsertMapper End **/

    /** UpdateMapper Start **/
    public abstract int updateByPrimaryKey(T domain);

    public abstract int updateByPrimaryKeySelective(T domain);

    /** BY MAP **/
    public int updateByMapCriteriaSelective(Map<String, Object> criteria) {
        return getDomainMapper().updateByMapCriteriaSelective(criteria);
    }

    public int updateByMapCriteria(Map<String, Object> criteria) {
        return getDomainMapper().updateByMapCriteria(criteria);
    }

    /** BY ModelCriteria **/
    public abstract int updateByModelCriteriaSelective(T domain, C criteria);

    public abstract int updateByModelCriteria(T domain, C criteria);
    /** UpdateMapper End **/

    /** DeleteMapper Start **/
    public abstract int deleteByPrimaryKey(Integer id);

    /** BY MAP **/
    public abstract int deleteByMapCriteria(Map<String, Object> criteria);

    /** BY ModelCriteria **/
    public abstract int deleteByModelCriteria(C criteria);
    /** DeleteMapper End **/


    public static Map toParameterMap(Object parameter, Page p) {
        Map map = toParameterMap(parameter);
        map.put("startRow", p.getStartRow());
        map.put("endRow", p.getEndRow());
        map.put("offset", p.getOffset());
        map.put("limit", p.getPageSize());
        return map;
    }

    public static Map toParameterMap(Object parameter) {
        if (parameter instanceof Map) {
            return (Map) parameter;
        } else {
            try {
                return PropertyUtils.describe(parameter);
            } catch (Exception e) {
                return null;
            }
        }
    }

}
