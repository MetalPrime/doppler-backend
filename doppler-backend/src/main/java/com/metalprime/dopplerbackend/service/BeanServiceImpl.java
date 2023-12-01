package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Bean;
import com.metalprime.dopplerbackend.repository.BeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BeanServiceImpl implements BeanService {

    @Autowired
    private BeanRepository beanRepository;


    @Override
    public Bean addBean(Bean bean) {
        return beanRepository.save(bean);
    }

    @Override
    public Bean editBean(Bean updateBean, int id) {
        Optional<Bean> optionalBean = beanRepository.findById(id);

        if (optionalBean.isPresent()) {
            Bean existingBean = optionalBean.get();

            return beanRepository.save(existingBean);
        } else {
            throw new EntityNotFoundException("Not found Bean with ID: " + id);
        }

    }

    @Override
    public void deleteBean(int id) {
        Optional<Bean> optionalBean = beanRepository.findById(id);

        if(optionalBean.isPresent()) {
            beanRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not eliminate Bean, not found with ID: " + id);
        }
    }

    @Override
    public Bean getBeanById(int id) {
        Optional<Bean> optionalBean = beanRepository.findById(id);

        return optionalBean.orElse(null);
    }

    @Override
    public List<Bean> getAllBeans() {
        return beanRepository.findAll();
    }
}
