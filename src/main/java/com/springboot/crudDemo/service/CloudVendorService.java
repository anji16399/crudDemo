package com.springboot.crudDemo.service;

import java.util.List;

import com.springboot.crudDemo.model.CloudVendor;

public interface CloudVendorService {
	public String createVendor(CloudVendor cloudVendor);
	public String updateVendor(CloudVendor cloudVendor);
	public String deleteVendor(String cloudVendorId);
	public CloudVendor getVendor(String cloudVendorId);
	public List<CloudVendor> getAllVendor();
}
