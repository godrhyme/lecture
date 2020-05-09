package vip.markxu.lectures.status;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum StatusEnum implements Serializable {
    TokenMissing(900,"token丢失 ,请检查"),
    TokenExpired(910,"授权过期,请重新获取授权"),
    PermissionDenied(920,"权限不足"),

    FileUploadFail(800,"文件上传失败"),
    FileTooMax(810,"文件过大"),
    FileTypeError(820,"文件类型不支持"),

    UserNotOnLine(700,"用户不在线"),

    UserNotExist(600,"账户不存在"),
    PasswordError(610,"密码错误"),
    UserHasBeenExist(620,"账户已存在,请直接登录"),

    ServerInnerError(500,"服务器内部错误"),

    BadParam(998,"请求参数错误"),
    BadRequest(999,"操作错误"),
    Success(1000,"操作成功");


    private String msg;
    private int code;

    StatusEnum(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }
}
