/**
 * 
 */
package com.bz.spring.springcloud.backend.service.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ajcruzmi
 *
 */
public class ResponseValidaFotoTO {

	@ApiModelProperty(value = "", required = true, example = "true")
	private boolean status;

	@ApiModelProperty(value = "", required = true, example = "/Zasfeudsifzskjdlakjsdkjalksdjaksjd", position = 1)
	private String plantilla;

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the plantilla
	 */
	public String getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla
	 *            the plantilla to set
	 */
	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

}
