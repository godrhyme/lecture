package vip.markxu.lectures.status;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResponseBody<T> implements Serializable {
    int code;
    String message;
    T payload;
    long timestamp=new Date().getTime();

    private ResponseBody(StatusEnum statusEnum, T payload) {
        this.message=statusEnum.getMsg();
        this.code=statusEnum.getCode();
        this.payload = payload;
    }

    public static <T>ResponseBody<T> TokenMissing(){
        return new ResponseBody<>(StatusEnum.TokenMissing,null);
    }

    public static <T>ResponseBody<T> TokenExpired(){
        return new ResponseBody<>(StatusEnum.TokenExpired,null);
    }

    public static <T>ResponseBody<T> PermissionDenied(){
        return new ResponseBody<>(StatusEnum.PermissionDenied,null);
    }

    public static <T>ResponseBody<T> FileUploadFail(){
        return new ResponseBody<>(StatusEnum.FileUploadFail,null);
    }

    public static <T>ResponseBody<T> UserNotOnLine(){
        return new ResponseBody<>(StatusEnum.UserNotOnLine,null);
    }

    public static <T>ResponseBody<T> UserNotExist(){
        return new ResponseBody<>(StatusEnum.UserNotExist,null);
    }

    public static <T>ResponseBody<T> PasswordError(){
        return new ResponseBody<>(StatusEnum.PasswordError,null);
    }

    public static <T>ResponseBody<T> UserHasBeenExist(){
        return new ResponseBody<>(StatusEnum.UserHasBeenExist,null);
    }

    public static <T>ResponseBody<T> BadRequest(){
        return new ResponseBody<>(StatusEnum.BadRequest,null);
    }

    public static <T>ResponseBody<T> Success(){
        return new ResponseBody<>(StatusEnum.Success,null);
    }

    public static <T>ResponseBody<T> Success(T t){
        return new ResponseBody<>(StatusEnum.Success,t);
    }

    public static <T>ResponseBody<T> BadParam(){
        return new ResponseBody<>(StatusEnum.BadParam,null);
    }

    public static <T>ResponseBody<T> ServerInnerError(){
        return new ResponseBody<>(StatusEnum.ServerInnerError,null);
    }

}
