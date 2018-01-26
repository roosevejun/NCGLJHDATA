package com.tongtu;

import com.tongtu.bean.postgres.Reservation;
import com.tongtu.config.db.PostgresConfig;
import com.tongtu.config.db.SqlserverConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = { PostgresConfig.class})
@RunWith(SpringRunner.class)
public class ReservationJpaTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    public void mapping() {
         Reservation jane=   this.testEntityManager.persistFlushFind(new Reservation(null,"Jane"));
        Assertions.assertThat(jane.getReservationName()).isEqualTo("Jane");
        Assertions.assertThat(jane.getId()).isNotNull();
        Assertions.assertThat(jane.getId()).isGreaterThan(0);

    }
}
