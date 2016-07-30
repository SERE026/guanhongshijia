package cn.com.dyninfo.o2o.communication.common;

/**
 * Created by Administrator on 2016/7/25.
 */
public class PageRequest extends BaseRequest {

    private int pageSize = 10;

    private int pageNo = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                '}';
    }
}
