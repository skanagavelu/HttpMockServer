package com.mock.server.dao.impl;

import java.io.File;

import com.mock.common.json.FileUtils;
import com.mock.common.json.JsonUtils;
import com.mock.common.model.RequestConfig.ResponseConfig;
import com.mock.server.dao.ResponseLoaderDao;
import org.springframework.stereotype.Repository;

/**
 * File based Dao response implementation
 */
@Repository
public class ResponseLoaderDaoImpl implements ResponseLoaderDao {

    @Override
    public String loadResponse(ResponseConfig responseConfig) {

        return FileUtils.getFileContent(responseConfig.responseFilePath);
    }
}
