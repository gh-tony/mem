package cn.com.sabs.mem.model;

/**
 * @ClassName
 * @Description TODO
 * @Author Tony
 * @Date 2020/8/19 14:20
 * Version 1.0
 */
public class RtnResponse {
    private final static String SUCCESS = "success";

    public static <T> ReturnResult<T> makeOKRsp() {
        return new ReturnResult<T>().setCode(ReturnCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ReturnResult<T> makeOKRsp(T data) {
        return new ReturnResult<T>().setCode(ReturnCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ReturnResult<T> makeErrRsp(String message) {
        return new ReturnResult<T>().setCode(ReturnCode.FAIL).setMsg(message);
    }

    public static <T> ReturnResult<T> makeRsp(int code, String msg) {
        return new ReturnResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ReturnResult<T> makeRsp(int code, String msg, T data) {
        return new ReturnResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
