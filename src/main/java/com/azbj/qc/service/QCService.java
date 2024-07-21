package com.azbj.qc.service;

import com.azbj.qc.repository.QCRepository;
import com.azbj.qc.model.QC;
import com.azbj.qc.dto.QCDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QCService {

    @Autowired
    private QCRepository qcRepository;

    public boolean validateRadioButtonSelection(String selection, Object flags) {
        if ("N".equals(selection)) {
            if (flags != null && flags.equals("specificFlag1")) {
                // Display alert to select error category
                System.out.println("Please select an error category first.");
                return false;
            } else if (flags != null && flags.equals("specificFlag2")) {
                boolean conditionMet = qcRepository.checkDatabaseCondition(selection, flags);
                if (conditionMet) {
                    // Display alert based on database condition
                    System.out.println("Condition met in the database.");
                    return false;
                }
            }
        } else if ("Y".equals(selection) && flags != null && flags.equals("specificFlag3")) {
            // Reset certain fields to 'N'
            // Assuming we have a method to reset fields
            resetFieldsToN();
        }
        return true;
    }

    public QC saveQCDetails(QCDTO qcDetails) {
        QC qc = new QC();
        // Assuming QCDTO has similar fields to QC
        qc.setPolicyId(qcDetails.getPolicyId());
        qc.setStatus(qcDetails.getStatus());
        qc.setSubStatus(qcDetails.getSubStatus());
        return qcRepository.save(qc);
    }

    public List<QC> fetchQCDetails(String policyId) {
        return qcRepository.findByPolicyId(policyId);
    }

    public void iterateAndUpdateRecords() {
        List<QC> records = qcRepository.fetchRecords();
        for (QC record : records) {
            if ("Y".equals(record.getCi()) && record.getFlg() == 10) {
                record.setCi("N");
                qcRepository.save(record);
            }
        }
    }

    public void updateRecords() {
        List<QC> records = qcRepository.findAll();
        for (QC record : records) {
            if ("Y".equals(record.getCi()) && record.getFlg() == 10) {
                record.setCi("N");
                qcRepository.save(record);
            }
        }
    }

    public void iterateAndUpdateQCRecords() {
        List<QC> records = qcRepository.findAll();
        for (QC record : records) {
            if ("Y".equals(record.getCi()) && record.getFlg() == 11) {
                record.setCi("N");
                qcRepository.save(record);
            }
        }
    }

    private void resetFieldsToN() {
        // Logic to reset fields to 'N'
        // This is a placeholder method and should be implemented based on actual requirements
    }
}
