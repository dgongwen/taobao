package cn.qf.taobao.pojo.entity;

import java.math.BigInteger;
import java.util.List;

/**
 * 分类商品总数，分页数
 */
public class Pages {

    private Long num;
    private List pagesNum;

    @Override
    public String toString() {
        return "Pages{" +
                "num=" + num +
                ", pagesNum=" + pagesNum +
                '}';
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public List getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(List pagesNum) {
        this.pagesNum = pagesNum;
    }
}
