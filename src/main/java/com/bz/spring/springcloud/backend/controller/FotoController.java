/**
 * 
 */
package com.bz.spring.springcloud.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bz.spring.springcloud.backend.service.dto.RequestFotoVsFotoDto;
import com.bz.spring.springcloud.backend.service.dto.ResponseFotoVsFotoTO;
import com.bz.spring.springcloud.backend.service.dto.ResponseValidaFotoTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author ajcruzmi
 *
 */
@RestController
@RequestMapping("/v1/foto")
@Api(value = "foto")
public class FotoController {

	@ApiOperation(value = "Servicio para comparar foto vs foto o plantilla vs foto")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Ops Not found"),
			@ApiResponse(code = 400, message = "Bad Request", response = ResponseFotoVsFotoTO.class),
			@ApiResponse(code = 200, message = "Operacion exitosa", response = ResponseFotoVsFotoTO.class) })
	@RequestMapping(value = "/comparafoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> comparaFotos(@RequestBody RequestFotoVsFotoDto resource) {
		ResponseFotoVsFotoTO response = new ResponseFotoVsFotoTO();
		response.setCodigoOperacion("0");
		response.setDescripcion("Operacion exitosa");

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Servicio para validar una foto b64")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Ops Not found"),
			@ApiResponse(code = 400, message = "Bad Request", response = ResponseValidaFotoTO.class),
			@ApiResponse(code = 200, message = "Operacion exitosa", response = ResponseValidaFotoTO.class) })
	@RequestMapping(value = "/validaFoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> validaFoto(@RequestBody RequestFotoVsFotoDto resource) {
		ResponseValidaFotoTO response = new ResponseValidaFotoTO();
		response.setStatus(true);
		response.setPlantilla("/sdjhjahgfdashfsdfhaslkjfhkafs");

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
