
package com.healthhubapi.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.healthhubapi.api.entity.AppointmentAvailabilityEntity;
import com.healthhubapi.api.model.AppointmentAvailabilityRequestBody;
 
@Repository
public interface  AppointmentAvailabilityRepository extends CrudRepository<AppointmentAvailabilityEntity,Integer> {

	@Query(value = "select * from  main_AppointmentAvailability ", nativeQuery = true)
	Page<AppointmentAvailabilityEntity> listallusersfromdb(Pageable pageable);

	@Query(value = "SELECT count(*) from main_AppointmentAvailability", nativeQuery = true)
	String countNumberOfAppointmentAvailabilitys();



}
