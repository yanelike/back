package com.bz.spring.springcloud.backend.service.dto;


import io.swagger.annotations.ApiModelProperty;

public class UserDto {
	
	@ApiModelProperty(value="", required=true, example="1", position=1)
    private String id;

	@ApiModelProperty(value="", required=false, example="Yanely", position=6)
    private String name;
    
    @ApiModelProperty(value="", required=false, example="yanelike", position=8)
    private String surname;

    public UserDto(){
        super();
    }

    public UserDto(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}