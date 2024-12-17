package com.rentalappapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalappapi.api.model.OwnerIdRequest;
import com.rentalappapi.api.model.OwnerRequestBody;
import com.rentalappapi.api.service.OwnerService;
 
  
@RestController
@CrossOrigin
public class OwnerController {
	
	@Autowired
	private OwnerService OwnerService;	
	
	@RequestMapping(value = "/createOwner", method = RequestMethod.POST)
	public ResponseEntity<?> createOwner(@RequestBody OwnerRequestBody OwnerReqBody) throws Exception {
		return ResponseEntity.ok(OwnerService.createOwner(OwnerReqBody));
	}
	
	@RequestMapping(value = "/updateOwner", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOwner(@RequestBody OwnerRequestBody OwnerReqBody) throws Exception {
		return ResponseEntity.ok(OwnerService.updateOwner(OwnerReqBody));
	}		
	
	@RequestMapping(value = "/listAllOwners", method = RequestMethod.GET)
	public ResponseEntity<?> listAllOwners(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(OwnerService.listallusersfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteOwner", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteOwner(@RequestBody OwnerIdRequest user) throws Exception {
		return ResponseEntity.ok(OwnerService.deleteOwner(user));
	}		
	
	@RequestMapping(value = "/Ownerscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfOwners() throws Exception {
		return ResponseEntity.ok((OwnerService.countNumberOfOwners()));
	}
	
}
