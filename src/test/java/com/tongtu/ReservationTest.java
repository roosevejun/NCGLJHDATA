package com.tongtu;

import com.tongtu.bean.postgres.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import org.hamcrest.Matchers;


public class ReservationTest {
    @Test
    public void cration(){
        Reservation r= new Reservation(1L,"Jane");
        Assert.assertEquals(r.getId(),(Long)1L);
        Assert.assertThat(r.getId(), Matchers.equalTo(1L));
        Assertions.assertThat((r.getId()).equals(1L));
        Assertions.assertThat((r.getReservationName())).isNotBlank();
        Assertions.assertThat((r.getReservationName())).isEqualTo("Jane");
    }
}
