package com.azbj.qc.repository;

import com.azbj.qc.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RidersRepository extends JpaRepository<Rider, Long> {
    Rider save(Rider rider);
}