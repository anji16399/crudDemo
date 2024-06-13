package com.springboot.crudDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.crudDemo.exception.CloudVendorNotFoundException;
import com.springboot.crudDemo.model.CloudVendor;
import com.springboot.crudDemo.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

	CloudVendorRepository repo;
	
	public CloudVendorServiceImpl(CloudVendorRepository repo) {
		this.repo = repo;
	}

	@Override
	public String createVendor(CloudVendor cloudVendor) {
		repo.save(cloudVendor);
		return "Success";
	}

	@Override
	public String updateVendor(CloudVendor cloudVendor) {
		repo.save(cloudVendor);
		return "Success";
	}

	@Override
	public String deleteVendor(String cloudVendorId) {
		repo.deleteById(cloudVendorId);
		return "Success";
	}

	@Override
	public CloudVendor getVendor(String cloudVendorId) {
		if(repo.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Vendor Doesn't exist!!!");
		return repo.findById(cloudVendorId).get();
	}

	@Override
	public List<CloudVendor> getAllVendor() {
		return repo.findAll();
	}

}
