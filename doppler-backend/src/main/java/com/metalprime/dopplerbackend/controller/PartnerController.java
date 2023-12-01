package com.metalprime.dopplerbackend.controller;

import com.metalprime.dopplerbackend.model.Bean;
import com.metalprime.dopplerbackend.model.Partner;
import com.metalprime.dopplerbackend.model.Project;
import com.metalprime.dopplerbackend.service.PartnerService;
import com.metalprime.dopplerbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.List;

@RestController
@RequestMapping("/partner")
@CrossOrigin
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @PostMapping("/add")
    public String add(@RequestBody Partner Partner){
        partnerService.addPartner(Partner);
        return "New Partner is added";
    }

    @PostMapping("/addMultiple")
    public String addMultiple(@RequestBody List<Partner> partners){
        partners.forEach(partner -> {
            partnerService.addPartner(partner);

        });
        return "New Partners added";
    }

    @GetMapping("/getAll")
    public List<Partner> list(){
        return partnerService.getAllPartners();
    }
}
