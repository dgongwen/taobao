package cn.qf.taobao.pojo.entity;

/**
 * 商品实体
 */
public class Commodity {

    private Long id;//id
    private String commodityName;//商品名
    private String commodityPrice;//商品价格
    private String commodityImgUrl;//商品图片
    private Long classificationId;//分类id
    private Long commoditySales;//商品销量
    private Long commodityState;//商品上下架 1 上架 0 下架

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

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
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

    public Long getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(Long commodityState) {
        this.commodityState = commodityState;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice='" + commodityPrice + '\'' +
                ", commodityImgUrl='" + commodityImgUrl + '\'' +
                ", classificationId=" + classificationId +
                ", commoditySales=" + commoditySales +
                ", commodityState=" + commodityState +
                '}';
    }
}
