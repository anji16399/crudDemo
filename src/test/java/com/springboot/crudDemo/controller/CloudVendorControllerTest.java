package com.springboot.crudDemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.crudDemo.model.CloudVendor;
import com.springboot.crudDemo.service.CloudVendorService;

@WebMvcTest(CloudVendorController.class)
@RequestMapping("/cloudvendor")
public class CloudVendorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CloudVendorService cloudVendorService;
	
	CloudVendor cloudVendorOne;
	CloudVendor cloudVendorTwo;
	List<CloudVendor> cloudVendorList = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		cloudVendorOne = new CloudVendor("1","Amazon","USA","xxxx");
		cloudVendorTwo = new CloudVendor("2","GCP","UK","yyyy");
		
		cloudVendorList.add(cloudVendorOne);
		cloudVendorList.add(cloudVendorTwo);
	}
	
	@Test
	void testGetVendor()throws Exception{
		when(cloudVendorService.getVendor("1")).thenReturn(cloudVendorOne);
		this.mockMvc.perform(get("/cloudvendor/" + "1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testGetAllVendors()throws Exception{
		when(cloudVendorService.getAllVendor()).thenReturn(cloudVendorList);
		this.mockMvc.perform(get("/cloudvendor/")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	void testDeleteVendor()throws Exception{
		when(cloudVendorService.deleteVendor("1")).thenReturn("Success");
		this.mockMvc.perform(delete("/cloudvendor/" + "1")).andDo(print()).andExpect(status().isOk());
	}
	
	 @Test
	    void createCloudVendorDetails() throws Exception {
		 
		 	//To convert the object to json format
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	        String requestJson = ow.writeValueAsString(cloudVendorOne);

	        when(cloudVendorService.createVendor(cloudVendorOne)).thenReturn("Success");
	        this.mockMvc.perform(post("/cloudvendor/")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(requestJson))
	                    .andDo(print()).andExpect(status().isOk());
	    }
	
	@Test
    void updateCloudVendorDetails() throws Exception {
		
		//To convert the object to json format
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateVendor(cloudVendorOne)).thenReturn("Cloud Vendor Updated Successfully");
        this.mockMvc.perform(put("/cloudvendor/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestJson))
                	.andDo(print()).andExpect(status().isOk());
    }
}
