package com.counter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountServiceTest {

    @Autowired
    private ICountService countService;


    @Test
    public void getCountTest() {

        Long count = countService.getCount();
        Assertions.assertNotNull(count);
        Assertions.assertTrue(count >= 0);

    }
}