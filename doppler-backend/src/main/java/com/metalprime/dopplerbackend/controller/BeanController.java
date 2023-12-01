package com.metalprime.dopplerbackend.controller;

import com.metalprime.dopplerbackend.model.Bean;
import com.metalprime.dopplerbackend.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bean")
@CrossOrigin
public class BeanController {
    @Autowired
    private BeanService beanService;

    @PostMapping("/add")
    public String add(@RequestBody Bean bean){
        beanService.addBean(bean);
        return "New Bean is added";
    }

    @PostMapping("/addMultiple")
    public String addMultiple(@RequestBody List<Bean> beans){
        beans.forEach(bean -> {
            beanService.addBean(bean);

        });
        return "New Beans added";
    }

    @GetMapping("/getAll")
    public List<Bean> list(){
        return beanService.getAllBeans();
    }
}
