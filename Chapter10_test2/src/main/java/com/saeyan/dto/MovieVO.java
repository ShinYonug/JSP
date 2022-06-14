package com.saeyan.dto;

import lombok.Data;

@Data

public class MovieVO{
	
	private Integer code;
	private String title;
	private String director;
	private String actor;
	private Integer price;
	private String synopsis;
	private String poster;

}
