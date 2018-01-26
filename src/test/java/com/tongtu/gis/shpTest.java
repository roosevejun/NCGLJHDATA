package com.tongtu.gis;


import com.alibaba.fastjson.JSON;
import com.tongtu.config.JsonConfig;
import com.tongtu.config.db.DatastoreFactoryConfig;
import com.tongtu.config.db.PostgresConfig;
import com.tongtu.repository.postgres.TtZrcEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.geotools.data.DataStore;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.FileDataStoreFactorySpi;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.factory.Hints;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PostgresConfig.class, DatastoreFactoryConfig.class, JsonConfig.class})
@ComponentScan("com.tongtu.config.serializer")
@RunWith(SpringRunner.class)
public class shpTest {
    public static Logger loggerInfo = LogManager.getLogger("info");
    public static Logger loggerError = LogManager.getLogger("error");
    @Autowired
    private TtZrcEntityRepository ttZrcEntityRepository;
    @Autowired
    @Qualifier("postgisDataStore")
    private DataStore dataStore;

    @Test
    @Rollback(true)
    @Transactional
    public void testShp() throws IOException {
        FileDataStoreFactorySpi factory = new ShapefileDataStoreFactory();
        String tableName = "tt_ld_copy1";
        File file = new File("target/" + tableName + ".shp");
        Map<String, Serializable> params = new HashMap<String, Serializable>();
        params.put("url", file.toURI().toURL());
        params.put("create spatial index", Boolean.TRUE);
        params.put("charset", "GBK");
        DataStore myData = factory.createNewDataStore(params);
        SimpleFeatureSource simpleFeatureSource = dataStore.getFeatureSource(tableName);
        SimpleFeatureType simpleFeatureType = simpleFeatureSource.getSchema();
        loggerInfo.info(simpleFeatureType.toString());
        myData.createSchema(simpleFeatureType);
        SimpleFeatureCollection featureCollection = simpleFeatureSource.getFeatures();
        Hints hints = new Hints(Hints.CRS, DefaultGeographicCRS.WGS84);
        String typeName = myData.getTypeNames()[0];
        SimpleFeatureSource featureSource = myData.getFeatureSource(typeName);
        SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;

        Transaction t = new DefaultTransaction("addTransaction");
        featureStore.setTransaction(t);
        featureStore.addFeatures(featureCollection);
        t.commit();
        t.close();
    }

    @Test
    @Rollback(true)
    @Transactional
    public void testgeojson4j() throws IOException {
        String tableName = "tt_ld_copy1";
//        String tableName = "zrc";
        SimpleFeatureSource simpleFeatureSource = dataStore.getFeatureSource(tableName);
        SimpleFeatureCollection featureCollection = simpleFeatureSource.getFeatures();
        SimpleFeatureIterator simpleFeatureIterator = featureCollection.features();
        try {
            while (simpleFeatureIterator.hasNext()) {
                SimpleFeature subFeature = simpleFeatureIterator.next();
//                loggerInfo.info("JSON{}", JSON.toJSONString(subFeature));
                loggerInfo.info("JSON{}", JSON.toJSONString(subFeature.getDefaultGeometry()));
            }
        } finally {
            simpleFeatureIterator.close();
        }

    }
}
