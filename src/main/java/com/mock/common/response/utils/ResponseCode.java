package com.mock.common.response.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public enum ResponseCode {


    //Input Validation
    UNKNOWN_ERROR(-1, "Unknown Error", HttpStatus.BAD_REQUEST), //TODO when ever we face this needs to correct it by adding OP-DMI correlation
    SUCCESS(0, "SUCCESS", HttpStatus.OK),
    INVALID_PDU(1, "Invalid PDU", HttpStatus.BAD_REQUEST), //Invalid Request Content
    INVALID_REQUEST(2, "Invalid Request", HttpStatus.BAD_REQUEST),
    INVALID_DATA(3, "Invalid Data", HttpStatus.BAD_REQUEST),
    NOT_FOUND(4, "Not Found", HttpStatus.NOT_FOUND),
    ACCESS_DENIED(103,"Access denied", HttpStatus.FORBIDDEN),
    INTERNAL_SERVER_ERROR(500,"Internal Error while processing the request", HttpStatus.INTERNAL_SERVER_ERROR),

    //Application errors
    PARKING_STATION_NOT_FOUND(1001, "Parking station not found", HttpStatus.NOT_FOUND),

    ;

//    ACCESS_DENIED(1001,"", HttpStatus.FORBIDDEN);


    private int code;
    private String cause;
    private HttpStatus status;

    private ResponseCode(int code, String msg) {
        this.setCode(code);
        this.setCause(msg);
    }

    private ResponseCode(int code, String msg, HttpStatus hStatus) {
        this.setCode(code);
        this.setCause(msg);
        this.setStatus(hStatus);
    }


    private static final Map<Integer, ResponseCode> HTTPDMIcorrelation = new HashMap<>();

    static {
        for (ResponseCode error : ResponseCode.values()) {
            if(error.code >= 400 && error.code < 600) {
                HTTPDMIcorrelation.put(error.code, error);
            }
        }
    }

    public HttpStatus getStatus() {

        return status;
    }

    public void setStatus(HttpStatus status) {

        this.status = status;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getCause() {
        return cause;
    }

    private void setCause(String msg) {
        this.cause = msg;
    }
}
