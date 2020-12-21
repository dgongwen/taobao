package cn.qf.taobao.pojo.qo;
import java.math.BigDecimal;

/**
 * 接受参数封装
 */


public class IndentRequest {

    /**
     * 收货人
     */
    private String receiverName;

    /**
     * 手机号码
     */
    private String receiverPhone;

    /**
     * 收货地址
     */
    private String receiverAddress;

    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品单价
     */
    private Double commodityPrice;

    /**
     * 商品数量
     */
    private Long commodityNum;

    //商品名
    private String commodityName;


    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Long getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(Long commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public IndentRequest(String commodityName, String receiverName, String receiverPhone, String receiverAddress, Long id, Long commodityNum) {
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddress = receiverAddress;
        this.id = id;
        this.commodityNum = commodityNum;
        this.commodityName = commodityName;

    }

    public IndentRequest() {

    }
}
