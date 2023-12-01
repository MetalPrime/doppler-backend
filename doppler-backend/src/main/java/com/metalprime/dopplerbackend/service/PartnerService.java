package com.metalprime.dopplerbackend.service;

import com.metalprime.dopplerbackend.model.Partner;
import com.metalprime.dopplerbackend.model.Project;

import java.util.List;

public interface PartnerService {
    public Partner addPartner(Partner project);

    public Partner editPartner(Partner project, int id);

    public void deletePartner(int id);

    public Partner getPartnerById(int id);
    
    public List<Partner> getAllPartners();
}
