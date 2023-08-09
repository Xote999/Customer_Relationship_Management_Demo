package com.xxxx.entity.vo;

public class MessageModel {
    private Integer code = 1;   //状態コード(1:成功　0:失敗)
    private String msg = "成功！";     //メッセージの提示
    private Object object;  //入力されたデータの返す

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
