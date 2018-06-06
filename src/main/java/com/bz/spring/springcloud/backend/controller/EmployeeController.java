package com.bz.spring.springcloud.backend.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bz.spring.springcloud.backend.service.dto.ResponseTO;
import com.bz.spring.springcloud.backend.service.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@Api(value="employees")
public class EmployeeController {
	private static final Logger LOG = Logger.getLogger(EmployeeController.class.getName());
	
	
	@ApiOperation(value = "Find all employees.",
			      notes="Provides an operation to get a Person object by its identifier")
	@ApiResponses(value = {
	        @ApiResponse(code = 404, message = "Ops Not found")})
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDto> findAll() {
    	LOG.log(Level.INFO,"Obteniendo empleados");
        return Arrays.asList(new UserDto("1", "David", "Jimenez"),
                new UserDto("2", "Yanely", "Jimenez"));
    }
    
	@ApiOperation(value = "Find a employe by ID.")
	@ApiResponses(value = {
	        @ApiResponse(code = 404, message = "Ops Not found"),
	        @ApiResponse(code = 200, message = "Sucess", response = UserDto.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
    	if(id == 0){
    		ResponseTO response = new ResponseTO();
    		response.setCode("404");
    		response.setMessage("Ops Not found");
    		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    	}
    	 return new ResponseEntity<UserDto>(new UserDto(id.toString(),"Antonio", "Jimenez"), HttpStatus.OK);
    }
	
	@ApiOperation(value = "Create a employe")
	@ApiResponses(value = {
	        @ApiResponse(code = 404, message = "Ops Not found"),
	        @ApiResponse(code = 400, message="Bad Request", response=ResponseTO.class),
	        @ApiResponse(code = 201, message = "Created", response = ResponseTO.class)})
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody UserDto resource) {
    	ResponseTO response = new ResponseTO();
		response.setCode("0");
		response.setMessage("Success");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
	
	@ApiOperation(value = "Update a employe by ID.")
	@ApiResponses(value = {
	        @ApiResponse(code = 404, message = "Ops Not found"),
	        @ApiResponse(code = 200, message = "Sucess", response = ResponseTO.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable( "id" ) Long id, @RequestBody UserDto resource) {
    	ResponseTO response = new ResponseTO();
    	response.setCode("0");
		response.setMessage("Success");
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
	
	@ApiOperation(value = "Delete a employe by ID.")
	@ApiResponses(value = {
	        @ApiResponse(code = 404, message = "Ops Not found"),
	        @ApiResponse(code = 200, message = "Sucess", response = ResponseTO.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    	ResponseTO response = new ResponseTO();
		response.setCode("0");
		response.setMessage("Success");
		return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
    
    
}