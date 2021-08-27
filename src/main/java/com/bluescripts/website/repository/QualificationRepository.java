package com.bluescripts.website.repository;

import com.bluescripts.website.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Integer> {

	Qualification findByqId(Integer qId);
}
