package com.springboot.crudDemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.springboot.crudDemo.model.CloudVendor;
import com.springboot.crudDemo.repository.CloudVendorRepository;

public class CloudVendorServiceTest {

	@Mock
	private CloudVendorRepository cloudVendorRepository;
	
	private CloudVendorService cloudVendorService;
	AutoCloseable autoCloseable;
	CloudVendor cloudVendor;
	
	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
		cloudVendor = new CloudVendor("1","Amazon","USA","xxxx");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}
	
	@Test
	void testCreateVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.createVendor(cloudVendor)).isEqualTo("Success");
	}
	
	@Test
	void testUpdateVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.updateVendor(cloudVendor)).isEqualTo("Success");
	}
	
	@Test
	void testGetVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
		assertThat(cloudVendorService.getVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());
	}
	
	@Test
	void testGetByVendorName() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findByVendorName("Amazon")).
			thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
		assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}
	
	@Test
	void testGetAllVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findAll()).
			thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
		assertThat(cloudVendorService.getAllVendor().get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}
	
	@Test
	void testDeleteCloudVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
		
		doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
		assertThat(cloudVendorService.deleteVendor("1")).isEqualTo("Success");
	}
	
}
