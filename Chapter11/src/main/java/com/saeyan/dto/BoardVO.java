
package com.saeyan.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
/*
 * create table board(
 * num number(5) primary key,
 * pass varchar2(30),
 * name varchar2(30),
 * email varchar2(30;),
 * title varchar2(50),
 * title varchar2(50),
 * content varchar2(1000),
 * readcount number(4) default 0,
 * writedate date default sysdate,
 * );
 */
public class BoardVO {
	Integer num;              //int 는 널값 들어가면 뱌로 뻑 근데 인티저는  널들어가도 0으로 인식
	String pass;
	String name;
	String email;
	String title;
	String content;
	Integer readcount;
	Timestamp writedate;
}
