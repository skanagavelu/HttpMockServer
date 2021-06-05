package com.mock.common.response.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public abstract class Response {

    public int code = 0; //Successful
    public HttpStatus status = HttpStatus.OK; //Successful
    public Map<String, String> headers = new HashMap<>();

    public Object body;

    public Response() {}

    public Response(Object body) {

        this.body = body;
    }

    public Response(Object body, HttpStatus status) {

        this.body = body;
        this.status = status;
    }

    public ErrorResponse getFailureResponse() {

        throw new UnsupportedOperationException();
    }

    public Object getSuccessfulResponse() {

        throw new UnsupportedOperationException();
    }

    public HttpStatus getStatus() {

        return this.status;
    }

    public static class SuccessfulResponse extends Response {

        public SuccessfulResponse(Object body) {

            this.body = body;
        }

        public SuccessfulResponse(HttpStatus status, Object body) {

            this.status = status;
            this.body = body;
        }

        public Object getSuccessfulResponse() {

            return body;
        }
    }

    public static class FailureResponse extends Response {

        private ErrorResponse errorResponse;

        public FailureResponse(ResponseCode responseCode) {

            this.code = responseCode.getCode();
            this.status = responseCode.getStatus();
            this.errorResponse = new ErrorResponse(responseCode.getCode(), responseCode.getCause());
        }

        public ErrorResponse getFailureResponse() {

            return errorResponse;
        }
    }
}

class ErrorResponse {

    public int code;
    public String cause;

    public ErrorResponse(int code, String cause) {

        this.code = code;
        this.cause = cause;
    }
}