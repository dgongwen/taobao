package cn.qf.taobao.pojo.entity;

import java.math.BigDecimal;

/**
 * 商品实体
 */
public class Commodity {

    private Long id;//id
    private String commodityName;//商品名
    private Double commodityPrice;//商品价格
    private String commodityImgUrl;//商品图片
    private Long classificationId;//分类id
    private Long commoditySales;//商品销量
    private Long cartNum;//商品数量
    private String commodityState;//商品上下架 1 上架 0 下架
    private String creationTime;//时间
    private String commodityTotalPrice;//单个商品价格X数量

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", commodityImgUrl='" + commodityImgUrl + '\'' +
                ", classificationId=" + classificationId +
                ", commoditySales=" + commoditySales +
                ", cartNum=" + cartNum +
                ", commodityState='" + commodityState + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", commodityTotalPrice='" + commodityTotalPrice + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityImgUrl() {
        return commodityImgUrl;
    }

    public void setCommodityImgUrl(String commodityImgUrl) {
        this.commodityImgUrl = commodityImgUrl;
    }

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public Long getCommoditySales() {
        return commoditySales;
    }

    public void setCommoditySales(Long commoditySales) {
        this.commoditySales = commoditySales;
    }

    public Long getCartNum() {
        return cartNum;
    }

    public void setCartNum(Long cartNum) {
        this.cartNum = cartNum;
    }

    public String getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(String commodityState) {
        this.commodityState = commodityState;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getCommodityTotalPrice() {
        return commodityTotalPrice;
    }

    public void setCommodityTotalPrice(String commodityTotalPrice) {
        this.commodityTotalPrice = commodityTotalPrice;
    }
}
