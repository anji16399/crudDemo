package com.springboot.crudDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudDemo.model.CloudVendor;
import com.springboot.crudDemo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

	CloudVendorService cloudvendorservice ;

	public CloudVendorController(CloudVendorService cloudvendorservice) {
		this.cloudvendorservice = cloudvendorservice;
	}
	
	@GetMapping("/{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return cloudvendorservice.getVendor(vendorId);
	}
	
	@GetMapping("/")
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudvendorservice.getAllVendor();
	}
	
	@PostMapping("/")
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudvendor) {
		cloudvendorservice.createVendor(cloudvendor);
		return "Successfully created vendor!!!";
	}
	
	@PutMapping("/")
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudvendor) {
		cloudvendorservice.updateVendor(cloudvendor);
		return "Successfully updated vendor!!!";
	}
	
	@DeleteMapping("/{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudvendorservice.deleteVendor(vendorId);
		return "Successfully deleted vendor!!!";
	}
}
