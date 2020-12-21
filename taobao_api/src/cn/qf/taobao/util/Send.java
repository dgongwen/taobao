package cn.qf.taobao.util;

public class Send<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer status) {
        this.code = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Send<T> sendJsonSucess(T data) {
      Send<T> send = new Send<>();
        send.setCode(100);
        send.setMessage("成功");
        send.setData(data);
        return send;
    }
    public static <T> Send<T> sendJsonError(T data) {
     Send<T> send = new Send<>();
        send.setCode(101);
        send.setMessage("失败");
        return send;
    }

    @Override
    public String toString() {
        return "Send{" +
                "status=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
