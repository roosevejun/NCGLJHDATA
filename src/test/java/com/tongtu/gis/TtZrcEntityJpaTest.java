package com.tongtu.gis;

import com.tongtu.bean.postgres.TtZrcEntity;
import com.tongtu.config.db.PostgresConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PostgresConfig.class})
@RunWith(SpringRunner.class)
public class TtZrcEntityJpaTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Rollback(true)
    @Transactional
    @Test
    public void mappingTtZrcEntity() {
        TtZrcEntity entity= new TtZrcEntity();
        entity.setJzcbm("341502003016");
        entity.setZrcbm("341502003016003");
        entity.setZrcmc("新街村");
        entity.setRksl(BigInteger.valueOf(201L));
        entity.setZrchs(BigInteger.valueOf(51L));
        entity.setLongitude(116.699908);
        entity.setLatitude(31.852052);
        entity.setAltitude(25.5);
        TtZrcEntity jane=   this.testEntityManager.persistFlushFind(entity);
        Assertions.assertThat(jane.getZrcmc()).isEqualTo("新街村");
        Assertions.assertThat(jane.getZrcbm()).isNotNull();
        Assertions.assertThat(jane.getRksl()).isGreaterThan(BigInteger.valueOf(20L));
    }
}
