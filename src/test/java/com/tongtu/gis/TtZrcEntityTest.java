package com.tongtu.gis;

import com.tongtu.bean.postgres.TtZrcEntity;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TtZrcEntityTest {

    @Test
    public void crationTtZrcEntity(){
        TtZrcEntity entity= new TtZrcEntity();
        entity.setJzcbm("341502003016");
        entity.setZrcbm("341502003016001");
        entity.setZrcmc("新街村");
        entity.setRksl(BigInteger.valueOf(200L));
        entity.setZrchs(BigInteger.valueOf(50L));
        entity.setLongitude(116.699908);
        entity.setLatitude(31.852052);
        entity.setAltitude(25.5);
        Assert.assertEquals(entity.getJzcbm(),"341502003016");
        Assert.assertThat(entity.getJzcbm(), Matchers.equalTo("341502003016"));
        Assertions.assertThat((entity.getJzcbm()).equals("341502003017"));
        Assertions.assertThat((entity.getZrcbm())).isNotBlank();
        Assertions.assertThat((entity.getZrcmc())).isEqualTo("新街村");
    }
}
