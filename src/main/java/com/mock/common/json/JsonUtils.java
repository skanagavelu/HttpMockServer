package com.mock.common.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.lang.Nullable;

public class JsonUtils {
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectWriter OBJECT_WRITER_DEFAULT = OBJECT_MAPPER.writer();
    
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    }

    public static final <T> T fromJson(final String s, final Class<T> type) throws Exception {

        final ObjectReader reader = OBJECT_MAPPER.readerFor(type);
        return reader.readValue(s);
    }

    public static final String toJsonString(final Object o) throws Exception {

        return OBJECT_WRITER_DEFAULT.writeValueAsString(o);
    }
    
    public static final <T> T convertValue(final Object obj, final Class<T> type) {

        return OBJECT_MAPPER.convertValue(obj, type);
    }

    @Nullable
    public static final <T> T getInstance(final File file, final Class<T> type) {

        try {

            return OBJECT_MAPPER.readValue(file, type);
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }
}