package com.bz.spring.springcloud.backend.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bz.spring.springcloud.backend.service.dto.UserDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger LOG = Logger.getLogger(UserController.class.getName());
	
	RestTemplate rest =  new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    public UserController(){
        //For Spring
    }
    @HystrixCommand(fallbackMethod = "getUsersHystrixFallbackMethod")
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
    	LOG.log(Level.INFO, "/elkdemo - &gt; " + "obteniendo usuarios 8081");
    	LOG.info("/elkdemo - &gt; " + "ejemplo");
        return Arrays.asList(new UserDto("1", "admin", "admin"),
                new UserDto("2", "jorge", "hernandez"));
    }
    
    @HystrixCommand(fallbackMethod = "getTokenHystrixFallbackMethod")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getUserAdmins() {
    	String resultado=null;
    	resultado = rest.getForObject("http://10.51.58.242:9090/greeting/test", String.class);
    	LOG.log(Level.INFO, "/elkdemo - &gt; " + resultado);
    	return resultado;
    }
    
	private String getTokenHystrixFallbackMethod() {
		LOG.log(Level.ERROR, "/elkdemo - &error; " + "El servicio se encuentra no disponible. Inténtelo más tarde");
        return "El servicio se encuentra no disponible. Inténtelo más tarde.";
    }
	
	private List<UserDto> getUsersHystrixFallbackMethod() {
		LOG.log(Level.ERROR, "/elkdemo - &error; " + "El servicio se encuentra no disponible. Inténtelo más tarde");
        return Arrays.asList(new UserDto("","",""));
    }
}