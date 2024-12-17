
package com.healthhubapi.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.healthhubapi.api.entity.AppointmentsEntity;
import com.healthhubapi.api.model.AppointmentsRequestBody;
 
@Repository
public interface  AppointmentsRepository extends CrudRepository<AppointmentsEntity,Integer> {

	@Query(value = "select * from  antra_appointments ", nativeQuery = true)
	Page<AppointmentsEntity> listallusersfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from antra_appointments", nativeQuery = true)
	String countNumberOfAppointmentss();



}
