package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Category extends BaseEntity {

    private String imageUrl;

    private String title;

    private List<Category> childrenList;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Category> childrenList) {
        this.childrenList = childrenList;
    }
}
