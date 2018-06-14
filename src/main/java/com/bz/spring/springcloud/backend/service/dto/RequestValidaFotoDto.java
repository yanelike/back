/**
 * 
 */
package com.bz.spring.springcloud.backend.service.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ajcruzmi
 *
 */
public class RequestValidaFotoDto {

	@ApiModelProperty(value = "", required = true, example = "/9dahaydgsiuajnsasjdhkashfdlkasjfkljasd", position = 6)
	private String foto;

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto
	 *            the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
