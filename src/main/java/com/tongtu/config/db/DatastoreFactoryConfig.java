package com.tongtu.config.db;

import com.vividsolutions.jts.geom.GeometryFactory;
import org.geotools.data.DataStore;
import org.geotools.data.postgis.PostGISDialect;
import org.geotools.data.postgis.PostgisNGDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.feature.type.FeatureTypeFactoryImpl;
import org.geotools.jdbc.JDBCDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;

@Configuration
@PropertySources({
        @PropertySource("classpath:static/persistence-multiple-db.properties")
})
public class DatastoreFactoryConfig {
    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "postgisNGDataStoreFactory")
    public PostgisNGDataStoreFactory  postgisNGDataStoreFactory() {
        PostgisNGDataStoreFactory factory=new PostgisNGDataStoreFactory();
        return  factory;
    }
    @Primary
    @Bean(name = "postgisDataStore")
    @ConfigurationProperties(prefix = "postgresql.datasource")
    public DataStore dataStore(  @Qualifier("postgresDataSource") DataSource dataSource,@Qualifier("postgisNGDataStoreFactory") PostgisNGDataStoreFactory postgisNGDataStoreFactory) throws IOException {
//    public DataStore dataStore(  @Qualifier("postgisNGDataStoreFactory") PostgisNGDataStoreFactory postgisNGDataStoreFactory) throws IOException {
        JDBCDataStore dataStore =new JDBCDataStore();
        dataStore.setDataSource(dataSource);
        dataStore.setExposePrimaryKeyColumns(Boolean.parseBoolean(env.getProperty("postgresql.datasource.exposePrimaryKeyColumns")));
        dataStore.setSQLDialect(new PostGISDialect(dataStore));
        dataStore.setFilterFactory(CommonFactoryFinder.getFilterFactory(null));
        dataStore.setGeometryFactory(new GeometryFactory());
        dataStore.setFeatureTypeFactory(new FeatureTypeFactoryImpl());
        dataStore.setFeatureFactory(CommonFactoryFinder.getFeatureFactory(null));
//        dataStore.setDataStoreFactory(this);
        return dataStore;
    }


}
