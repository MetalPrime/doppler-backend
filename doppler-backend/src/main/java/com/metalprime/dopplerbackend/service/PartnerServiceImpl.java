package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Partner;
import com.metalprime.dopplerbackend.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

            existingPartner.setDescription(updatePartner.getDescription());
            existingPartner.setName(updatePartner.getName());
            existingPartner.setType(updatePartner.getType());

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

    @Override
    public List<Partner> getFilterPartners(int currentPage, String query) {
        final int ITEMS_PER_PAGE = 10;
        Pageable pageable = PageRequest.of(currentPage - 1, ITEMS_PER_PAGE);
        return partnerRepository.findFilteredPartners( pageable, query);
    }

    @Override
    public Integer getPartnersPages(String query) {
        final int ITEMS_PER_PAGE = 10;
        Integer count = partnerRepository.getPartnersPages(query);
        System.out.print((int) Math.ceil((double) count / ITEMS_PER_PAGE));
        return (int) Math.ceil((double) count / ITEMS_PER_PAGE);
    }
}
