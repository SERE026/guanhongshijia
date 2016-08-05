/*
package cn.com.dyninfo.o2o.furniture.android.controller;

import cn.com.dyninfo.o2o.communication.*;
import cn.com.dyninfo.o2o.entity.Category;
import cn.com.dyninfo.o2o.entity.CategoryTwo;
import cn.com.dyninfo.o2o.furniture.common.BaseAppController;
import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Administrator on 2016/7/29.
 *//*

@Controller
@RequestMapping("/category")
public class AppCategoryController extends BaseAppController {

    @Resource
    private HuiyuanService huiyuanService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsSortService goodsSortService;

    */
/**
     * 获取主分类
     * @param mainCategoryRequest
     * @param request
     * @param response
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/main")
    public MainCategoryResult main(@RequestBody MainCategoryRequest mainCategoryRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(mainCategoryRequest);
        MainCategoryResult result = new MainCategoryResult();
//        PageInfo page=new PageInfo();
//        page.setPageNo(1);
//        page.setPageSize(11);
        List<Category>  lists=new ArrayList<Category>();
        List<GoodsSort> list =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(""));
//        List<GoodsSort> list =(List<GoodsSort>)goodsSortService.getListByPageWhere(new StringBuffer(""),page);
        if(!ValidationUtil.isEmpty(list)) {
            for (int i = 0; i < 11; i++) {
                Category category = new Category();
                category.setId(String.valueOf(list.get(i).getGoodsSort_id()));
                category.setTitle(list.get(i).getName());
                category.setImageUrl(list.get(i).getImagesrc());
                category.setSortOrder(list.get(i).getIndex());
                lists.add(category);
            }
            result.setPageNo(1);
            result.setTotalPage(2);
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        result.setCategoryList(lists);
//        else{
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("获取主分类数据失败");
//        }
        log.debug(result);
        return result;
    }

    */
/**
     * 获取二级类别
     * @param subCategoryRequest
     * @param request
     * @param response
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/sub")
    public SubCategoryResult sub(@RequestBody SubCategoryRequest subCategoryRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(subCategoryRequest);
        SubCategoryResult result = new SubCategoryResult();
        List<CategoryTwo>  lists=new ArrayList<CategoryTwo>();
        List<GoodsSort> list1 =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(" and n.goodsSort_id="+subCategoryRequest.getId()));
        if(!ValidationUtil.isEmpty(list1)) {
            List<GoodsSort> list=list1.get(0).getChildren();
            if(!ValidationUtil.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    CategoryTwo category = new CategoryTwo();
                    category.setId(String.valueOf(list.get(i).getGoodsSort_id()));
                    category.setTitle(list.get(i).getName());
                    category.setImageUrl(list.get(i).getImagesrc());
                    category.setSortOrder(list.get(i).getIndex());
                    lists.add(category);
                }
            }
            //            result.setTotalPage(2);
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        result.setCategoryList(lists);
        result.setPageNo(1);

//        else{
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("获取二级类别数据失败");
//        }
        log.debug(result);
        return result;
    }


    */
/**
     * 获取更多分类
     * @param moreCategoryRequest
     * @param request
     * @param response
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/more")
    public MoreCategoryResult more(@RequestBody MoreCategoryRequest moreCategoryRequest, HttpServletRequest request, HttpServletResponse response) {
        log.debug(moreCategoryRequest);
        MoreCategoryResult result = new MoreCategoryResult();
        List<Category>  lists=new ArrayList<Category>();
        List<GoodsSort> list =(List<GoodsSort>)goodsSortService.getListByWhere(new StringBuffer(""));
        if(!ValidationUtil.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                Category category = new Category();
                category.setId(String.valueOf(list.get(i).getGoodsSort_id()));
                category.setTitle(list.get(i).getName());
                category.setImageUrl(list.get(i).getImagesrc());
                category.setSortOrder(list.get(i).getIndex());
                lists.add(category);
            }

          //  result.setTotalPage(2);
        }
        result.setResultCode(SUCCESS);
        result.setMessage("OK");
        result.setCategoryList(lists);
        result.setPageNo(1);
//        else{
//            result.setResultCode(NO_LOGIN);
//            result.setMessage("获取更多分类数据失败");
//        }
        log.debug(result);
        return result;
    }

}
*/
