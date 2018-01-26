package com.tongtu.gis;

import com.tongtu.bean.postgres.TtZrcEntity;
import com.tongtu.config.db.PostgresConfig;
import com.tongtu.repository.postgres.TtZrcEntityRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Collection;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PostgresConfig.class})
@RunWith(SpringRunner.class)
public class TtZrcEntityRepositoryTest {

    @Autowired
    private TtZrcEntityRepository ttZrcEntityRepository;

    @Rollback(false)
    @Transactional
    @Test
    public void findByZrcmc() {
//        TtZrcEntity entity = new TtZrcEntity();
//        entity.setJzcbm("341502003016");
//        entity.setZrcbm("341502003016001");
//        entity.setZrcmc("新街村");
//        entity.setRksl(BigInteger.valueOf(200L));
//        entity.setZrchs(BigInteger.valueOf(50L));
//        entity.setLongitude(116.699908);
//        entity.setLatitude(31.852052);
//        entity.setAltitude(25.5);
//        this.ttZrcEntityRepository.save(entity);

        Collection<TtZrcEntity> entities = this.ttZrcEntityRepository.findByZrcmc("新街村");
        for(TtZrcEntity zrc:entities){
            System.out.println(zrc.getLocation().getX()+"====="+zrc.getLocation().getY()+"====="+zrc.getLocation().getCoordinate().z);
        }
        Assertions.assertThat((entities.size())).isEqualTo(1);
        Assertions.assertThat((entities.iterator().next().getRksl())).isGreaterThan(BigInteger.valueOf(100L));
        Assertions.assertThat((entities.iterator().next().getZrcmc())).isEqualTo("新街村");
    }
}
