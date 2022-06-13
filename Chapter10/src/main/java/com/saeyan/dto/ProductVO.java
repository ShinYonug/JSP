package com.saeyan.dto;

import lombok.Data;

@Data

public class ProductVO{
	private Integer code;
	private String name;
	private Integer price;
	private String pictureurl;
	private String description;
}