package com.mock.server.service;

import javax.servlet.http.HttpServletRequest;

import com.mock.common.response.utils.Response;

public interface RequestHandlerService {

    Response handleRequest(HttpServletRequest request, String configFilePath);
}
