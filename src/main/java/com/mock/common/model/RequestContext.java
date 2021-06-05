package com.mock.common.model;

import javax.servlet.http.HttpServletRequest;

/**
 * Every request has this new object
 */
public class RequestContext {

    public RequestConfig config;
    public HttpServletRequest request;
}
