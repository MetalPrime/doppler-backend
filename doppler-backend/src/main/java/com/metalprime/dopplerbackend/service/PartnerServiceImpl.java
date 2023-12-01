package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Partner;
import com.metalprime.dopplerbackend.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;


    @Override
    public Partner addPartner(Partner Partner) {
        return partnerRepository.save(Partner);
    }

    @Override
    public Partner editPartner(Partner updatePartner, int id) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);

        if (optionalPartner.isPresent()) {
            Partner existingPartner = optionalPartner.get();

            return partnerRepository.save(existingPartner);
        } else {
            throw new EntityNotFoundException("Not found Partner with ID: " + id);
        }

    }

    @Override
    public void deletePartner(int id) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);

        if(optionalPartner.isPresent()) {
            partnerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not eliminate Partner, not found with ID: " + id);
        }
    }

    @Override
    public Partner getPartnerById(int id) {
        Optional<Partner> optionalPartner = partnerRepository.findById(id);

        return optionalPartner.orElse(null);
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }
}
