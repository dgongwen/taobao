package cn.qf.taobao.pojo.qo;

public class AdminCommodityQO {
    private int id;
    private String commodityName;
    private Double commodityPrice;
    private String commodityImgUrl;
    private int classificationId;
    private int commoditySales;
    private String commodityState;
    private int commodityStatus;
    private String classificationName;
    private String commodityNum;

    public String getClassificationName() {
        return classificationName;
    }

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public int getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(int commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public AdminCommodityQO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int commodityQoId) {
        this.id = commodityQoId;
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

    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    public int getCommoditySales() {
        return commoditySales;
    }

    public void setCommoditySales(int commoditySales) {
        this.commoditySales = commoditySales;
    }

    public String getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(String commodityState) {
        this.commodityState = commodityState;
    }

    @Override
    public String toString() {
        return "AdminCommodityQO{" +
                "id=" + id +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", commodityImgUrl='" + commodityImgUrl + '\'' +
                ", classificationId=" + classificationId +
                ", commoditySales=" + commoditySales +
                ", commodityState=" + commodityState +
                ", commodityStatus=" + commodityStatus +
                ", classificationName='" + classificationName + '\'' +
                ", commodityNum='" + commodityNum + '\'' +
                '}';
    }
}
