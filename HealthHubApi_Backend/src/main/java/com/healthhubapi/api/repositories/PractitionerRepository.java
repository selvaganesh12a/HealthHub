package com.healthhubapi.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.healthhubapi.api.entity.PractitionerEntity;
import com.healthhubapi.api.model.PractitionerRequestBody;
 
@Repository
public interface  PractitionerRepository extends CrudRepository<PractitionerEntity,Integer> {

	@Query(value = "select * from  practitioner ", nativeQuery = true)
	Page<PractitionerEntity> listallusersfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from practitioner", nativeQuery = true)
	String countNumberOfPractitioners();

	//@Query(value = "select * from  practitioner where practitioner_id =:id", nativeQuery = true)
 	  List<PractitionerEntity> findPractitionerEntityBydoctorId(int  practitioner_id);

 	 @Query(value = "select * from  practitioner ", nativeQuery = true)
	List <PractitionerEntity> getAllPractitioners();



}
