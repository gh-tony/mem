package cn.com.sabs.mem.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName
 * @Description TODO
 * @Author Tony
 * @Date 2020/12/16 19:32
 * Version 1.0
 */
@Slf4j
public class AppException extends Exception{
    public AppException(String message){
        super(message);
        log.info(message);
    }
}
