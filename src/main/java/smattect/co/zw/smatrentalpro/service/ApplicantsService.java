package smattect.co.zw.smatrentalpro.service;

import smattect.co.zw.smatrentalpro.utils.dao.Applicants;
import smattect.co.zw.smatrentalpro.utils.dto.request.ApplicantsRequest;

import java.util.List;

public interface ApplicantsService {
    void addApplicant(ApplicantsRequest applicantsRequest);

    List<Applicants> applicantsDetails();

    Applicants findApplicantById(long id);
}
