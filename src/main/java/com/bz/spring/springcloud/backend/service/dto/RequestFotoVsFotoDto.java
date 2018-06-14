/**
 * 
 */
package com.bz.spring.springcloud.backend.service.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ajcruzmi
 *
 */
public class RequestFotoVsFotoDto {

	@ApiModelProperty(value = "", required = true, example = "fotoVsFoto", position = 6)
	private String operacion;

	@ApiModelProperty(value = "", required = true, example = "/9sdgfahdjhsjfiusdgyhsajdfsadf", position = 6)
	private String foto1;

	@ApiModelProperty(value = "", required = true, example = "/9safdsgfdaskjhfjhashfja", position = 6)
	private String foto2;

	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion
	 *            the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return the foto1
	 */
	public String getFoto1() {
		return foto1;
	}

	/**
	 * @param foto1
	 *            the foto1 to set
	 */
	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	/**
	 * @return the foto2
	 */
	public String getFoto2() {
		return foto2;
	}

	/**
	 * @param foto2
	 *            the foto2 to set
	 */
	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}
}
