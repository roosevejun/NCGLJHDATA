package com.tongtu;

import com.alibaba.fastjson.JSON;
import com.tongtu.bean.Line;
import com.tongtu.bean.postgres.Reservation;
import com.tongtu.bean.Fjdlkc2018View;
import com.tongtu.config.db.PostgresConfig;
import com.tongtu.config.db.SqlserverConfig;
import com.tongtu.repository.postgres.ReservationRepository;
import com.tongtu.repository.Fjdlkc2018ViewRepository;
import com.tongtu.repository.sqlserver.ProductRepository;
import com.vividsolutions.jts.geom.LineString;
import org.assertj.core.api.Assertions;
import org.geotools.data.DataStore;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.FileDataStoreFactorySpi;
import org.geotools.data.Transaction;
import org.geotools.data.memory.MemoryFeatureCollection;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PostgresConfig.class, SqlserverConfig.class})
@RunWith(SpringRunner.class)
public class JPAMultipleDBTest {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Fjdlkc2018ViewRepository fjdlkc2018ViewRepository;

    @Test
    @Rollback(true)
    @Transactional
    public void whenCreatingReservation() {
        Reservation reservation = new Reservation();
        reservation.setReservationName("John");
        reservation = reservationRepository.save(reservation);
        reservation = reservationRepository.findAll().iterator().next();
        Assertions.assertThat(reservationRepository.findByReservationName("John")).isNotNull();
    }
    @Test
    @Rollback(true)
    @Transactional
    public void allFjdlkc2018View() throws IOException {
        FileDataStoreFactorySpi factory = new ShapefileDataStoreFactory();
        File file = new File("target/xianjictgc.shp");
        Map<String, Serializable> params = new HashMap<String, Serializable>();
        params.put("url", file.toURI().toURL());
        params.put("create spatial index", Boolean.TRUE);
        params.put("charset", "GBK");
        DataStore myData = factory.createNewDataStore( params );
        List<Fjdlkc2018View> fjdlkc2018ViewList= fjdlkc2018ViewRepository.getxianjictgcViewResult();
        SimpleFeatureType simpleFeatureType=null;
        MemoryFeatureCollection simpleFeatureCollection=null;
        int index=1;
        for(Fjdlkc2018View view:fjdlkc2018ViewList){
            if(simpleFeatureType==null){
                simpleFeatureType=view.convertToSimpleFeatureType();
                myData.createSchema(simpleFeatureType);
                simpleFeatureCollection =new MemoryFeatureCollection(simpleFeatureType);
            }
            Line line = JSON.parseObject(view.getCoordinates(), Line.class);
            LineString lineString= line.convertToJTSGeometry();
            SimpleFeature simpleFeature= view.buildFeature(index,simpleFeatureType,lineString);
            simpleFeatureCollection.add(simpleFeature);
            index++;
        }
        String typeName = myData.getTypeNames()[0];
        SimpleFeatureSource featureSource = myData.getFeatureSource(typeName);
        SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;
        Transaction t = new DefaultTransaction("addTransaction");
        featureStore.setTransaction(t);
        featureStore.addFeatures(simpleFeatureCollection);
        t.commit();
        t.close();
    }
}
