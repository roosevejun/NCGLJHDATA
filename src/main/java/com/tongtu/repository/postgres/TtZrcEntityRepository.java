package com.tongtu.repository.postgres;

import com.tongtu.bean.postgres.TtZrcEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TtZrcEntityRepository extends JpaRepository<TtZrcEntity,String> {

  Collection<TtZrcEntity> findByZrcmc(String name);
}
