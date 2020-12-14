package cn.qf.taobao.pojo.entity;

/**
 * 分类实体
 */
public class Classify {

    private Long id; //分类id
    private String classificationName; //分类名

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", classificationName='" + classificationName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }
}
