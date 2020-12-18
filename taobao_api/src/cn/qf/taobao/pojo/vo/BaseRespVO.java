package cn.qf.taobao.pojo.vo;

/**
 * 标准内容返回对象类型
 */
public class BaseRespVO<T> {
    //    状态：成功，失败
    private int code = CodeType.SUCCESS.getValue();
    //    失败提示信息
    private String msg;
    //    业务信息
    private T data;

    public enum CodeType {
        SUCCESS(100), FAILED(101),UN_LOGIN(200);
        private int value;

        CodeType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    @Override
    public String toString() {
        return "BaseRespVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
