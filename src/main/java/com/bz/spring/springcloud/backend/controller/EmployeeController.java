package com.bz.spring.springcloud.backend.controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bz.spring.springcloud.backend.service.dto.UserDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private static final Logger LOG = Logger.getLogger(EmployeeController.class.getName());
    public EmployeeController(){
        //For Spring
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
    	LOG.log(Level.INFO,"Obteniendo empleados");
        return Arrays.asList(new UserDto("1", "David", "Jimenez"),
                new UserDto("2", "Yanely", "Jimenez"));
    }
    
    @HystrixCommand(fallbackMethod = "getMxHystrixFallbackMethod")
    @RequestMapping(value = "/mx", method = RequestMethod.GET)
    public String getEmployeeMx() {
    	LOG.log(Level.INFO,"Empleados mexicanos");
        return "Empleados mexicanos";
    }
    
    @HystrixCommand(fallbackMethod = "getEsHystrixFallbackMethod")
    @RequestMapping(value = "/es", method = RequestMethod.GET)
    public String getEmployeeEs() {
    	LOG.log(Level.INFO,"Empleados españoles");
        return "Empleados españoles";
    }
    
	private String getMxHystrixFallbackMethod() {
        return "El servicio empleados mx se encuentra no disponible.";
    }
	
	private String getEsHystrixFallbackMethod() {
        return "El servicio empleados es se encuentra no disponible.";
    }

}