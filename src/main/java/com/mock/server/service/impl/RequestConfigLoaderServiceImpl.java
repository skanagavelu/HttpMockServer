package com.mock.server.service.impl;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mock.common.model.RequestConfig;
import com.mock.server.service.RequestConfigLoaderService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import static com.mock.common.json.JsonUtils.getInstance;

@Service
public class RequestConfigLoaderServiceImpl implements RequestConfigLoaderService {

    Map<String, RequestConfig> cache = new ConcurrentHashMap<>();

    @Nullable
    public RequestConfig loadRequestConfig(String configFilePath) {

        return cache.computeIfAbsent(configFilePath, path -> getInstance(new File(path), RequestConfig.class));
    }
}
