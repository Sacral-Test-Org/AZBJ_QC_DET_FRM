package com.azbj.qc.repository;

import com.azbj.qc.model.QC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QCRepository extends JpaRepository<QC, Long> {

    @Query("SELECT q FROM QC q WHERE q.policyId = :policyId")
    List<QC> findByPolicyId(@Param("policyId") String policyId);

    @Query("SELECT q FROM QC q WHERE q.ci = 'Y' AND q.flg = 10")
    List<QC> fetchRecords();

    @Query("SELECT CASE WHEN COUNT(q) > 0 THEN true ELSE false END FROM QC q WHERE q.selection = :selection AND q.flags = :flags")
    boolean checkDatabaseCondition(@Param("selection") String selection, @Param("flags") Object flags);

    List<QC> findAll();

    QC save(QC entity);
}
