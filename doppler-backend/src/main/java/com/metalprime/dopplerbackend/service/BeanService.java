package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Bean;

import java.util.List;

public interface BeanService {
    public Bean addBean(Bean bean);

    public Bean editBean(Bean bean, int id);

    public void deleteBean(int id);

    public Bean getBeanById(int id);
    
    public List<Bean> getAllBeans();
}
