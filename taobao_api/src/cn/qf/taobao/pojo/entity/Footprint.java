package cn.qf.taobao.pojo.entity;

/**
 * 足迹
 */
public class Footprint {
    private Long userId;
    private  Long  commodityId;
    private String  creationTime;

    @Override
    public String toString() {
        return "Footprint{" +
                "userId=" + userId +
                ", commodityId=" + commodityId +
                ", creationTime='" + creationTime + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
