package cn.qf.taobao.pojo.entity;

import java.util.List;

/**
 * @author dian
 * @date 2020/12/16
 */
public class Page<T> {
    //数据展示
    private List<T> list;
    //当前页数
    private int currentPage;
    //页容量
    private int pageSize;
    //总条数
    private long totalCount;
    //总页数
    private int totalPage;

    public Page() {
    }

    public Page(List<T> list, int currentPage, int pageSize, long totalCount, int totalPage) {
        this.list = list;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return (int) Math.ceil(totalCount*1.0/pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "list=" + list +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}
