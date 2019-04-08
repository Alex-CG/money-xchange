package com.moneyxchange.app.resources.model;

import com.moneyxchange.app.consts.Constants;
import lombok.Data;

@Data
public class ResponseModel<T> {

    private String code;
    private String message;
    private T data;

    public ResponseModel() {
        this(Constants.RESP_CODE_SUCCESS, Constants.RESP_MSSG_SUCCESS);
    }

    public ResponseModel(T data) {
        this();
        this.data = data;
    }

    public ResponseModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
