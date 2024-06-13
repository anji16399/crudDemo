package com.springboot.crudDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crudDemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{

}
