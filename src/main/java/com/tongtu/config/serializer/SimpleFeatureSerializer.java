package com.tongtu.config.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
public class SimpleFeatureSerializer implements ObjectSerializer {
    @Autowired
    @Qualifier("featureJSON")
    private FeatureJSON featureJSON;

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter writer = serializer.getWriter();
        featureJSON.writeFeature((SimpleFeature) object, writer);
    }
}