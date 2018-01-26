package com.tongtu.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.tongtu.config.serializer.SimpleFeatureSerializer;
import com.tongtu.config.serializer.geojson.JTSSerializer;
import com.vividsolutions.jts.geom.*;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JsonConfig {
    @Autowired
    private JTSSerializer jtsSerializer;
    @Autowired
    private SimpleFeatureSerializer simpleFeatureSerializer;

    @Primary
    @Bean(name = "geometryJSON")
    public GeometryJSON geometryJSON() {
        return new GeometryJSON(8);
    }

    @Primary
    @Bean(name = "featureJSON")
    public FeatureJSON featureJSON(@Qualifier("geometryJSON") GeometryJSON geometryJSON) {
        return new FeatureJSON(geometryJSON);
    }

    @Primary
    @Bean(name = "serializeConfig")
    public SerializeConfig serializeConfig() {
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        serializeConfig.put(SimpleFeature.class, simpleFeatureSerializer);
        serializeConfig.put(Geometry.class, jtsSerializer);
        serializeConfig.put(Envelope.class, jtsSerializer);
        serializeConfig.put(GeometryCollection.class, jtsSerializer);
        serializeConfig.put(Coordinate.class, jtsSerializer);
        serializeConfig.put(CoordinateArrays.class, jtsSerializer);
        serializeConfig.put(Point.class, jtsSerializer);
        serializeConfig.put(Polygon.class, jtsSerializer);
        serializeConfig.put(MultiPoint.class, jtsSerializer);
        serializeConfig.put(MultiLineString.class, jtsSerializer);
        serializeConfig.put(Location.class, jtsSerializer);
        serializeConfig.put(LineString.class, jtsSerializer);
        serializeConfig.put(LineSegment.class, jtsSerializer);
        serializeConfig.put(LinearRing.class, jtsSerializer);
        return serializeConfig;
    }

    @Primary
    @Bean(name = "fastJsonConfig")
    public FastJsonConfig fastJsonConfig(@Qualifier("serializeConfig") SerializeConfig serializeConfig) {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializeConfig(serializeConfig);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        return fastJsonConfig;
    }

}
