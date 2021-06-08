package com.counter.service;

import com.counter.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService implements ICountService{

    @Autowired
    private CountRepository repository;

    @Override
    public synchronized Long getCount() {

        Long count = repository.count();
        return count;
    }
}
