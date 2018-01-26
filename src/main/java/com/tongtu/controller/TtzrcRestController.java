package com.tongtu.controller;

import com.tongtu.bean.postgres.TtZrcEntity;
import com.tongtu.repository.postgres.TtZrcEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TtzrcRestController {

    @Autowired
    private TtZrcEntityRepository reservationRepository;

    @GetMapping(value = "/ttzrcs")
    Collection<TtZrcEntity> ttzrcs() {
        return this.reservationRepository.findAll();
    }
}
