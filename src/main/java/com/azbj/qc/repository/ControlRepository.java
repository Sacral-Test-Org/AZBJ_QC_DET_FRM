package com.azbj.qc.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class ControlRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void updateAZBJ_QC_KCLICK_DATA(String policyRef) {
        String sql = "UPDATE AZBJ_QC_KCLICK_DATA SET flg = 'N' WHERE POLICY_REF = :policyRef";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public void updateAzbjKclickQcDetails(String policyRef) {
        String sql = "UPDATE azbj_kclick_qc_details SET qc_status = 'N' WHERE policy_ref = :policyRef AND qc_status = 'P'";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public void updateAzbjMergingTatDetail(String policyRef) {
        String sql = "UPDATE azbj_merging_tat_detail SET qc_status = 'N' WHERE policy_ref = :policyRef AND qc_status = 'P'";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public void commitChanges() {
        entityManager.flush();
    }

    @Transactional
    public void updateQCStatusInKClick(String policyRef) {
        String sql = "UPDATE azbj_kclick_qc_details SET qc_status = 'N' WHERE policy_ref = :policyRef AND qc_status = 'P'";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public void updateQCStatusInMergingTat(String policyRef) {
        String sql = "UPDATE azbj_merging_tat_detail SET qc_status = 'N' WHERE policy_ref = :policyRef AND qc_status = 'P'";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public Optional<Nominee> findNomineeDetails(String policyRef) {
        String sql = "SELECT * FROM azbj_beneficiary_rep WHERE contract_id = (SELECT contract_id FROM azbj_policy WHERE policy_ref = :policyRef) AND top_indicator = 'Y' AND action_code <> 'D' AND BEN_RELATION <> 'SPOUSE' AND rownum < 2";
        try {
            return Optional.of((Nominee) entityManager.createNativeQuery(sql, Nominee.class)
                    .setParameter("policyRef", policyRef)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public int updateNomineeName(String newNomineeName, String contractId) {
        String sql = "UPDATE azbj_beneficiary_rep SET ben_NAME = :newNomineeName WHERE contract_id = :contractId AND top_indicator = 'Y' AND action_code <> 'D' AND BEN_RELATION <> 'SPOUSE' AND rownum < 2";
        return entityManager.createNativeQuery(sql)
                .setParameter("newNomineeName", newNomineeName)
                .setParameter("contractId", contractId)
                .executeUpdate();
    }

    @Transactional
    public void logPolicyActivity(PolicyActivityLog policyActivityLog) {
        String sql = "INSERT INTO azbj_pol_activity_log (id, log_date, opus_date, user, contract_id, field1, field2, policy_ref, action, description, comments, field3, field4) VALUES (azbj_policy_log_seq.NEXTVAL, sysdate, :opusDate, :user, :contractId, '', '', :policyRef, 'NOM_UPD', :description, :comments, NULL, :opusDate)";
        entityManager.createNativeQuery(sql)
                .setParameter("opusDate", policyActivityLog.getOpusDate())
                .setParameter("user", policyActivityLog.getUser())
                .setParameter("contractId", policyActivityLog.getContractId())
                .setParameter("policyRef", policyActivityLog.getPolicyRef())
                .setParameter("description", policyActivityLog.getDescription())
                .setParameter("comments", policyActivityLog.getComments())
                .executeUpdate();
    }

    @Transactional
    public Optional<String> findScrutinyNumber(String proposalNumber) {
        String sql = "SELECT a.scrutiny_no FROM azbj_phub_scrutiny_prop a, azbj_phub_tracker b WHERE a.application_no = b.application_no AND b.proposal_no = :proposalNumber";
        try {
            return Optional.of((String) entityManager.createNativeQuery(sql)
                    .setParameter("proposalNumber", proposalNumber)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public int countEnrichmentRequests(String scrutinyNumber) {
        String sql = "SELECT COUNT(*) FROM azbj_phub_scrutiny_req WHERE scrutiny_no = :scrutinyNumber AND req_code = 'ENRICH'";
        return ((Number) entityManager.createNativeQuery(sql)
                .setParameter("scrutinyNumber", scrutinyNumber)
                .getSingleResult()).intValue();
    }

    @Transactional
    public int countEnrichmentDetails(String applicationNumber) {
        String sql = "SELECT COUNT(ROWNUM) FROM azbj_data_entrich_details WHERE application_no = :applicationNumber";
        return ((Number) entityManager.createNativeQuery(sql)
                .setParameter("applicationNumber", applicationNumber)
                .getSingleResult()).intValue();
    }

    @Transactional
    public Optional<String> findCustomerNamePrimary(String contractId) {
        String sql = "SELECT customer_name_text FROM ocp_interested_parties WHERE contract_id = :contractId AND ip_no = 1";
        try {
            return Optional.of((String) entityManager.createNativeQuery(sql)
                    .setParameter("contractId", contractId)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<String> findCustomerNameSecondary(String contractId) {
        String sql = "SELECT customer_name_text FROM wip_interested_parties WHERE contract_id = :contractId AND ip_no = 1";
        try {
            return Optional.of((String) entityManager.createNativeQuery(sql)
                    .setParameter("contractId", contractId)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<ViewImagesDTO> findSolutionId(String applicationNo, String contractId) {
        String sql = "SELECT solution_id FROM azbj_solution_appln_bases WHERE application_no = :applicationNo OR contract_id = :contractId AND solution_id IS NOT NULL AND ROWNUM = 1";
        try {
            String solutionId = (String) entityManager.createNativeQuery(sql)
                    .setParameter("applicationNo", applicationNo)
                    .setParameter("contractId", contractId)
                    .getSingleResult();

            String parentContractIdSql = "SELECT contract_id FROM azbj_solution_appln_bases a WHERE solution_id = :solutionId AND PARENT_FLAG = 'Y' AND EXISTS (SELECT 1 FROM azbj_solution_appln_bases b WHERE a.solution_id = b.solution_id AND PARENT_FLAG IS NULL)";
            String parentContractId = (String) entityManager.createNativeQuery(parentContractIdSql)
                    .setParameter("solutionId", solutionId)
                    .getSingleResult();

            String policyRefSql = "SELECT policy_ref FROM azbj_policy WHERE contract_id = :parentContractId";
            String policyRef = (String) entityManager.createNativeQuery(policyRefSql)
                    .setParameter("parentContractId", parentContractId)
                    .getSingleResult();

            ViewImagesDTO viewImagesDTO = new ViewImagesDTO(solutionId, parentContractId, policyRef);
            return Optional.of(viewImagesDTO);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public Dispatch findDispatchDetails(String contractId) {
        String sql = "SELECT address_line1, address_line2, address_line3, postcode, address_line4, address_line5 FROM cp_addresses A, OCP_INTERESTED_PARTIES B WHERE A.add_id = B.MAILING_ADDRESS_ID AND ACTION_CODE <> 'D' AND TOP_INDICATOR = 'Y' AND IP_NO = 2 AND CONTRACT_ID = :contractId";
        return (Dispatch) entityManager.createNativeQuery(sql, Dispatch.class)
                .setParameter("contractId", contractId)
                .getSingleResult();
    }

    @Transactional
    public void clearDispatchDetails() {
        String sql = "UPDATE dispatch SET address_line1 = NULL, address_line2 = NULL, address_line3 = NULL, postcode = NULL, address_line4 = NULL, address_line5 = NULL";
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public List<Control> findAll() {
        String sql = "SELECT * FROM control";
        return entityManager.createNativeQuery(sql, Control.class).getResultList();
    }

    @Transactional
    public Control save(Control control) {
        entityManager.persist(control);
        return control;
    }

    @Transactional
    public void updateQCRecords(ControlUpdateDTO controlUpdateDTO) {
        String sql = "UPDATE control SET field1 = :field1, field2 = :field2 WHERE id = :id";
        entityManager.createNativeQuery(sql)
                .setParameter("field1", controlUpdateDTO.getField1())
                .setParameter("field2", controlUpdateDTO.getField2())
                .setParameter("id", controlUpdateDTO.getId())
                .executeUpdate();
    }

    @Transactional
    public PolicyReferenceDTO findPolicyReference(String policyRef) {
        String sql = "SELECT * FROM policy_reference WHERE policy_ref = :policyRef";
        return (PolicyReferenceDTO) entityManager.createNativeQuery(sql, PolicyReferenceDTO.class)
                .setParameter("policyRef", policyRef)
                .getSingleResult();
    }

    @Transactional
    public void updatePolicyReference(String policyRef, String status, Date timestamp) {
        String sql = "UPDATE policy_reference SET status = :status, timestamp = :timestamp WHERE policy_ref = :policyRef";
        entityManager.createNativeQuery(sql)
                .setParameter("status", status)
                .setParameter("timestamp", timestamp)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public BeneficiaryDetailsDTO findBeneficiaryDetails(String policyRef) {
        String sql = "SELECT * FROM beneficiary_details WHERE policy_ref = :policyRef";
        return (BeneficiaryDetailsDTO) entityManager.createNativeQuery(sql, BeneficiaryDetailsDTO.class)
                .setParameter("policyRef", policyRef)
                .getSingleResult();
    }

    @Transactional
    public UserProfile findUserProfile(String userName) {
        String sql = "SELECT * FROM user_profile WHERE user_name = :userName";
        return (UserProfile) entityManager.createNativeQuery(sql, UserProfile.class)
                .setParameter("userName", userName)
                .getSingleResult();
    }

    @Transactional
    public List<Comment> findComments(String policyNumber) {
        String sql = "SELECT * FROM comments WHERE policy_no = :policyNumber";
        return entityManager.createNativeQuery(sql, Comment.class)
                .setParameter("policyNumber", policyNumber)
                .getResultList();
    }

    @Transactional
    public void updateBlockFlag(String policyRef) {
        String sql = "UPDATE AZBJ_PRINT_QC_DISCARD SET BLOCK_FLAG = 'N' WHERE POLICY_REF = :policyRef AND BLOCK_FLAG = 'Y'";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .executeUpdate();
    }

    @Transactional
    public void insertNewRecord(ControlUpdateDTO controlUpdateDTO) {
        String sql = "INSERT INTO AZBJ_PRINT_QC_DISCARD (POLICY_REF, BLOCK_FLAG, BLOCK_REASON, DELINK_DATE, DELINK_USER, BLOCK_COMMENTS) VALUES (:policyRef, 'Y', :reason, sysdate, USER, :comments)";
        entityManager.createNativeQuery(sql)
                .setParameter("policyRef", controlUpdateDTO.getPolicyRef())
                .setParameter("reason", controlUpdateDTO.getReason())
                .setParameter("comments", controlUpdateDTO.getComments())
                .executeUpdate();
    }

    @Transactional
    public String findDocumentPath(String policyRef) {
        String sql = "SELECT file_path FROM azbj_kclick_qc_details WHERE policy_ref = :policyRef AND QC_STATUS = 'P' AND file_path IS NOT NULL";
        return (String) entityManager.createNativeQuery(sql)
                .setParameter("policyRef", policyRef)
                .getSingleResult();
    }

    @Transactional
    public List<QCRecord> findQCRecordsByPolicyNumber(String policyNumber) {
        String sql = "SELECT * FROM qc_records WHERE policy_no = :policyNumber";
        return entityManager.createNativeQuery(sql, QCRecord.class)
                .setParameter("policyNumber", policyNumber)
                .getResultList();
    }

    @Transactional
    public void updateQCStatus(QCStatusDTO qcStatusDTO) {
        String sql = "UPDATE qc_status SET status = :status, substatus = :substatus, ins_date = SYSDATE WHERE policy_no = :policyNumber";
        entityManager.createNativeQuery(sql)
                .setParameter("status", qcStatusDTO.getStatus())
                .setParameter("substatus", qcStatusDTO.getSubstatus())
                .setParameter("policyNumber", qcStatusDTO.getPolicyNumber())
                .executeUpdate();
    }
}