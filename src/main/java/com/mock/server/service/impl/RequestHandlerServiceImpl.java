package com.mock.server.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.mock.common.model.RequestConfig;
import com.mock.common.response.utils.Response;
import com.mock.common.response.utils.Response.SuccessfulResponse;
import com.mock.server.dao.ResponseLoaderDao;
import com.mock.server.service.RequestConfigLoaderService;
import com.mock.server.service.RequestHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestHandlerServiceImpl implements RequestHandlerService {

    @Autowired
    public RequestConfigLoaderService configLoaderService;

    @Autowired
    public ResponseLoaderDao responseDao;

    @Override
    public Response handleRequest(HttpServletRequest request, String configFilePath) {

        RequestConfig config = configLoaderService.loadRequestConfig(configFilePath);
        String responseContent = responseDao.loadResponse(config.responseConfig);
        Response response = new SuccessfulResponse(responseContent);
        response.headers.putAll(config.responseConfig.headers);
        response.body = responseContent;
        return response;
    }
}
