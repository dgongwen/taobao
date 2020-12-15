package cn.qf.taobao.pojo.entity;

/**
 * @author dian
 * @date 2020/12/15
 */
public class SearchContent {
    private Long searchId;
    private Long commodityId;
    private Long userId;
    private String searchContent;

    public SearchContent() {
    }

    public SearchContent(Long searchId, Long commodityId, Long userId, String searchContent) {
        this.searchId = searchId;
        this.commodityId = commodityId;
        this.userId = userId;
        this.searchContent = searchContent;
    }

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    @Override
    public String toString() {
        return "SearchContent{" +
                "searchId=" + searchId +
                ", commodityId=" + commodityId +
                ", userId=" + userId +
                ", searchContent='" + searchContent + '\'' +
                '}';
    }
}
