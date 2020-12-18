package cn.com.sabs.mem.model;

/**
 * @ClassName
 * @Description TODO
 * @Author Tony
 * @Date 2020/8/19 14:18
 * Version 1.0
 */
public class ReturnResult<T>{
    public int code;

    private String msg;

    private T data;

    public ReturnResult<T> setCode(ReturnCode returnCode) {
        this.code = returnCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ReturnResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ReturnResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
