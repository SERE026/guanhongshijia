package cn.com.dyninfo.o2o.communication;

import cn.com.dyninfo.o2o.communication.common.PageResult;
import cn.com.dyninfo.o2o.entity.Brand;
import cn.com.dyninfo.o2o.entity.GoodsSummary;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CategoryBrandListResult extends PageResult {

    private List<Brand> brandList;


    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
    @Override
    public String toString() {
        return "CategoryBrandListResult{" +
                "brandList=" + brandList +
                '}';
    }
}
