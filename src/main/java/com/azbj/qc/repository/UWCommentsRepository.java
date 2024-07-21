package com.azbj.qc.repository;

import com.azbj.qc.model.UWComment;
import com.azbj.qc.model.RICODetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UWCommentsRepository extends JpaRepository<UWComment, Long> {

    @Query("SELECT u FROM UWComment u WHERE u.policyRef = :policyRef")
    List<UWComment> findByPolicyRef(@Param("policyRef") String policyRef);

    @Query("SELECT r FROM RICODetail r WHERE r.policyRef = :policyRef ORDER BY r.coDate")
    List<RICODetail> findRICODetailsByPolicyRef(@Param("policyRef") String policyRef);

    @Query("SELECT u FROM UWComment u WHERE u.policyId = :policyId")
    List<UWComment> findByPolicyId(@Param("policyId") String policyId);

    @Query("SELECT u FROM UWComment u WHERE u.policyNumber = :policyNumber")
    List<UWComment> findByPolicyNumber(@Param("policyNumber") String policyNumber);

    @Query("SELECT r FROM RICODetail r WHERE r.policyNumber = :policyNumber ORDER BY r.coDate")
    List<RICODetail> findAdditionalComments(@Param("policyNumber") String policyNumber);

    <S extends UWComment> List<S> saveAll(Iterable<S> comments);

    <S extends UWComment> S save(S comment);
}
