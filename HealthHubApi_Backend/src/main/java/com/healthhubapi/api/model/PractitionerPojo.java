package com.healthhubapi.api.model;
import java.util.List;

import javax.persistence.Entity;

import com.healthhubapi.api.entity.PractitionerEntity;

 
public class PractitionerPojo {

	private long totalRecords;
    private List<PractitionerEntity> Practitioner;
      
    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
    
    public List<PractitionerEntity> getPractitionerList() {
        return Practitioner;
    }
    
    public void setPractitionerList(List<PractitionerEntity> Practitioner) {
        this.Practitioner = Practitioner;
   }
}
