
package com.healthhubapi.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.healthhubapi.api.entity.PatientEntity;
import com.healthhubapi.api.model.PatientRequestBody;
 
@Repository
public interface  PatientRepository extends CrudRepository<PatientEntity,Integer> {

	@Query(value = "select * from  antra_patients ", nativeQuery = true)
	Page<PatientEntity> listallusersfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from antra_patients", nativeQuery = true)
	String countNumberOfPatients();

	List findPatientEntityBypatientId(int id);

	@Query(value = "select * from  antra_patients ", nativeQuery = true)
	List <PatientEntity> getAllPractitioners();



}
