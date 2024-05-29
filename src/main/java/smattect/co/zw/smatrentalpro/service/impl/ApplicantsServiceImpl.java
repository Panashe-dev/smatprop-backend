package smattect.co.zw.smatrentalpro.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.repository.ApplicantsRepository;
import smattect.co.zw.smatrentalpro.repository.PropertyRepository;
import smattect.co.zw.smatrentalpro.service.ApplicantsService;
import smattect.co.zw.smatrentalpro.utils.dao.Applicants;
import smattect.co.zw.smatrentalpro.utils.dao.Property;
import smattect.co.zw.smatrentalpro.utils.dto.request.ApplicantsRequest;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantsServiceImpl implements ApplicantsService {

    private  final PropertyRepository propertyRepository;
    private  final ApplicantsRepository applicantsRepository;
    @Override
    public void addApplicant(ApplicantsRequest applicantsRequest) {

        Property property = propertyRepository.findById(applicantsRequest.getPropertyId())
                .orElseThrow(() -> new BusinessValidationException(""));
        Applicants applicants = Applicants.builder()
                .property(property)
                .firstname(applicantsRequest.getFirstname())
                .lastname(applicantsRequest.getLastname())
                .dob(applicantsRequest.getDob())
                .ssn(applicantsRequest.getSsn())
                .idNumber(applicantsRequest.getIdNumber())
                .phone(applicantsRequest.getPhone())
                .occupation(applicantsRequest.getOccupation())
                .build();
        applicantsRepository.save(applicants);
    }

    @Override
    public List<Applicants> applicantsDetails() {
        return applicantsRepository.findAll();
    }

    @Override
    public Applicants findApplicantById(long id) {
        return null;
    }

}
