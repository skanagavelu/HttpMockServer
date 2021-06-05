package com.mock.server.dao;

import com.mock.common.model.RequestConfig.ResponseConfig;

public interface ResponseLoaderDao {

    String loadResponse(ResponseConfig responseConfig);
}
