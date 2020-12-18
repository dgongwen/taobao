package cn.qf.taobao.pojo.entity;

/**
 * 分类实体
 */
public class Classify {

    private Long classificationId; //分类id
    private String classificationName; //分类名

    @Override
    public String toString() {
        return "Classify{" +
                "classificationId=" + classificationId +
                ", classificationName='" + classificationName + '\'' +
                '}';
    }

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }
}
