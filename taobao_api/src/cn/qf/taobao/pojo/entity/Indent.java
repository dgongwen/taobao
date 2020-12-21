package cn.qf.taobao.pojo.entity;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单实体
 */

public class Indent implements Serializable {
    /**
     * 订单id
     */
    private Long indentId;

    /**
     * 订单编号
     */
    private String indentSn;


    /**
     * 订单提交时间
     */
    private String createTime;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

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
     * 订单状态(0,未提交,1,已经提交)
     */
    private Integer status;

    //商品名
    private String commodityName;

    //商品数量
    private long commodityNumber;

    //商品图片
    private String commodityImgUrl;

    private static final long serialVersionUID = 1L;

    public String getCommodityImgUrl() {
        return commodityImgUrl;
    }

    public void setCommodityImgUrl(String commodityImgUrl) {
        this.commodityImgUrl = commodityImgUrl;
    }

    public Long getIndentId() {
        return indentId;
    }

    public void setIndentId(Long indentId) {
        this.indentId = indentId;
    }

    public String getIndentSn() {
        return indentSn;
    }

    public void setIndentSn(String indentSn) {
        this.indentSn = indentSn;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public long getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(long commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Indent(String indentSn, String createTime, BigDecimal totalAmount, String receiverName, String receiverPhone, String receiverAddress, long commodityNumber, String commodityName) {
        this.indentSn = indentSn;
        this.createTime = createTime;
        this.totalAmount = totalAmount;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddress = receiverAddress;
        this.commodityNumber=commodityNumber;
        this.commodityName=commodityName;
    }

    public Indent() {

    }

    @Override
    public String toString() {
        return "Indent{" +
                "indentId=" + indentId +
                ", indentSn='" + indentSn + '\'' +
                ", createTime='" + createTime + '\'' +
                ", totalAmount=" + totalAmount +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", status=" + status +
                ", commodityName='" + commodityName + '\'' +
                ", commodityNumber=" + commodityNumber +
                ", commodityImgUrl='" + commodityImgUrl + '\'' +
                '}';
    }
}

