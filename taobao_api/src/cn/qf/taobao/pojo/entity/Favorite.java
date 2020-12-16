package cn.qf.taobao.pojo.entity;

/**
 * 收藏夹
 */
public class Favorite {
    private Long userId;
    private Long commodityId;

    @Override
    public String toString() {
        return "Favorite{" +
                "userId=" + userId +
                ", commodityId=" + commodityId +
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
}
