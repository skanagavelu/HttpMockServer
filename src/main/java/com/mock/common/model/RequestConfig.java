package com.mock.common.model;

import java.util.Map;

public class RequestConfig {

    public String configFilePath;
    public ServerConfig serverConfig;
    public ResponseConfig responseConfig;
    public CallbackConfig callbackConfig;

    public static class ServerConfig {

    }

    public static class ResponseConfig {

        public String responseFilePath;
        public Map<String, String> headers;
    }

    public static class CallbackConfig {

        public String callbackFilePath;
    }
}
