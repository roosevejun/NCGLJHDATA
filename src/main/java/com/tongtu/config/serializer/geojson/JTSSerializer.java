package com.tongtu.config.serializer.geojson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.vividsolutions.jts.geom.Geometry;
import org.geotools.geojson.geom.GeometryJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
public class JTSSerializer implements ObjectSerializer {
    @Autowired
    @Qualifier("geometryJSON")
    private GeometryJSON geometryJSON;

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter writer = serializer.getWriter();
        geometryJSON.write((Geometry) object, writer);
    }
}
