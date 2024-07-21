package com.azbj.qc.service;

import com.azbj.qc.repository.ControlRepository;
import com.azbj.qc.dto.ControlDTO;
import com.azbj.qc.dto.ResetRequestDTO;
import com.azbj.qc.dto.NomineeUpdateDTO;
import com.azbj.qc.dto.ViewImagesDTO;
import com.azbj.qc.dto.ControlUpdateDTO;
import com.azbj.qc.dto.PolicyReferenceDTO;
import com.azbj.qc.dto.BeneficiaryDetailsDTO;
import com.azbj.qc.dto.QCUpdateDTO;
import com.azbj.qc.dto.QCVerificationDTO;
import com.azbj.qc.dto.QCStatusDTO;
import com.azbj.qc.model.Control;
import com.azbj.qc.model.QC;
import com.azbj.qc.model.Dispatch;
import com.azbj.qc.model.UserProfile;
import com.azbj.qc.model.Comment;
import com.azbj.qc.model.PolicyActivityLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ControlService {

    @Autowired
    private ControlRepository controlRepository;

    public void updateRecordsAndExit(String policyRef) {
        controlRepository.updateAZBJ_QC_KCLICK_DATA(policyRef);
        controlRepository.updateAzbjKclickQcDetails(policyRef);
        controlRepository.updateAzbjMergingTatDetail(policyRef);
        controlRepository.commitChanges();
    }

    public void updateQCStatus(String policyRef) {
        controlRepository.updateQCStatusInKClick(policyRef);
        controlRepository.updateQCStatusInMergingTat(policyRef);
    }

    public void resetControlData(ResetRequestDTO resetRequest) {
        controlRepository.updateAZBJ_QC_KCLICK_DATA(resetRequest.getPolicyRef());
        controlRepository.updateAzbjKclickQcDetails(resetRequest.getPolicyRef());
        controlRepository.updateAzbjMergingTatDetail(resetRequest.getPolicyRef());
        controlRepository.commitChanges();
    }

    public String updateNomineeDetails(NomineeUpdateDTO nomineeUpdateDTO) {
        Optional<Nominee> nominee = controlRepository.findNomineeDetails(nomineeUpdateDTO.getPolicyRef());
        if (!nominee.isPresent()) {
            return "Nominee Detail Not Found";
        }
        String contractId = nominee.get().getContractId();
        if (!nomineeUpdateDTO.getNewNomineeName().equals(nominee.get().getNomineeName())) {
            controlRepository.updateNomineeName(nomineeUpdateDTO.getNewNomineeName(), contractId);
            PolicyActivityLog log = new PolicyActivityLog();
            log.setPolicyRef(nomineeUpdateDTO.getPolicyRef());
            log.setActivity("Nominee Name Updation in QC");
            log.setDescription("Nominee Name updated to " + nomineeUpdateDTO.getNewNomineeName());
            controlRepository.logPolicyActivity(log);
            return "Nominee Name updated successfully";
        }
        return "No changes made to Nominee Name";
    }

    public boolean checkScrutinyNumber(String proposalNumber) {
        return controlRepository.findScrutinyNumber(proposalNumber).isPresent();
    }

    public boolean checkEnrichmentRequests(String scrutinyNumber) {
        return controlRepository.countEnrichmentRequests(scrutinyNumber) > 0;
    }

    public boolean getEnrichmentDetails(String applicationNumber) {
        return controlRepository.countEnrichmentDetails(applicationNumber) > 0;
    }

    public String getCustomerName(String contractId) {
        Optional<String> customerName = controlRepository.findCustomerNamePrimary(contractId);
        if (!customerName.isPresent()) {
            customerName = controlRepository.findCustomerNameSecondary(contractId);
        }
        return customerName.orElse("");
    }

    public void updateQCRecords(ControlUpdateDTO controlUpdateDTO) {
        List<QC> qcRecords = controlRepository.findAll();
        for (QC qc : qcRecords) {
            if ("Y".equals(qc.getCi()) && 11 == qc.getFlg()) {
                qc.setCi("N");
                controlRepository.save(qc);
            }
        }
    }

    public ViewImagesDTO getSolutionId(String applicationNo, String contractId) {
        Optional<ViewImagesDTO> viewImagesDTO = controlRepository.findSolutionId(applicationNo, contractId);
        if (!viewImagesDTO.isPresent()) {
            throw new RuntimeException("Solution ID not found");
        }
        return viewImagesDTO.get();
    }

    public Dispatch getDispatchDetails(String contractId) {
        return controlRepository.findDispatchDetails(contractId);
    }

    public void clearDispatchDetails() {
        controlRepository.clearDispatchDetails();
    }

    public void iterateAndUpdateRecords() {
        List<Control> controls = controlRepository.findAll();
        for (Control control : controls) {
            if ("Y".equals(control.getCi()) && 11 == control.getFlg()) {
                control.setCi("N");
                controlRepository.save(control);
            }
        }
    }

    public PolicyReferenceDTO validatePolicyReference(String policyRef) {
        // Business logic for validating policy reference
        return new PolicyReferenceDTO();
    }

    public BeneficiaryDetailsDTO processPolicyReference(String policyRef) {
        // Business logic for processing policy reference
        return new BeneficiaryDetailsDTO();
    }

    public void fetchUserProfile() {
        String userName = controlRepository.findUserProfile();
        // Further processing with userName
    }

    public List<Comment> fetchComments(String policyNumber) {
        return controlRepository.findComments(policyNumber);
    }

    public void skipApplication(ControlUpdateDTO controlUpdateDTO) {
        if (controlUpdateDTO.getQcSkipReason() == null) {
            throw new RuntimeException("Please Select Reason For Skipping Application");
        }
        if ("OTHERS".equals(controlUpdateDTO.getQcSkipReason()) && controlUpdateDTO.getDelinkComments() == null) {
            throw new RuntimeException("Please Enter comments");
        }
        controlRepository.updateBlockFlag(controlUpdateDTO.getPolicyRef());
        controlRepository.insertNewRecord(controlUpdateDTO);
        controlRepository.commitChanges();
    }

    public String getDocumentPath(String policyRef) {
        return controlRepository.findDocumentPath(policyRef);
    }

    public QCStatusDTO verifyPolicyNumber(QCVerificationDTO qcVerificationDTO) {
        // Business logic for QC verification
        return new QCStatusDTO();
    }
}