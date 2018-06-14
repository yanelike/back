/**
 * 
 */
package com.bz.spring.springcloud.backend.service.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ajcruzmi
 *
 */
public class ResponseFotoVsFotoTO {

	@ApiModelProperty(value = "", required = true, example = "true", position = 1)
	private boolean estatusComparacion;

	@ApiModelProperty(value = "", required = true, example = "0", position = 1)
	private String codigoOperacion;

	@ApiModelProperty(value = "", required = true, example = "Operacion exitosa", position = 1)
	private String descripcion;

	@ApiModelProperty(value = "", required = true, example = "99.8", position = 1)
	private double procentaje;

	/**
	 * @return the estatusComparacion
	 */
	public boolean isEstatusComparacion() {
		return estatusComparacion;
	}

	/**
	 * @param estatusComparacion
	 *            the estatusComparacion to set
	 */
	public void setEstatusComparacion(boolean estatusComparacion) {
		this.estatusComparacion = estatusComparacion;
	}

	/**
	 * @return the codigoOperacion
	 */
	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	/**
	 * @param codigoOperacion
	 *            the codigoOperacion to set
	 */
	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the procentaje
	 */
	public double getProcentaje() {
		return procentaje;
	}

	/**
	 * @param procentaje
	 *            the procentaje to set
	 */
	public void setProcentaje(double procentaje) {
		this.procentaje = procentaje;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseFotoVsFotoTO [estatusComparacion=");
		builder.append(estatusComparacion);
		builder.append(", codigoOperacion=");
		builder.append(codigoOperacion);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", procentaje=");
		builder.append(procentaje);
		builder.append("]");
		return builder.toString();
	}

}
