package com.mock.server.service;

import com.mock.common.model.RequestConfig;

public interface RequestConfigLoaderService {

    /**
     * Load and return the config information
     *
     * @param configFilePath RequestConfig object with minimum information to load this object
     * @return RequestConfig instance when the information is enough to load else null.
     */
    public RequestConfig loadRequestConfig(String configFilePath);
}
