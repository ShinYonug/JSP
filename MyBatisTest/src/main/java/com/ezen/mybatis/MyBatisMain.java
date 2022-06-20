
package com.ezen.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisMain {

	public static void main(String[] args) {
// 여기 역할 자체는 디비에 연결하는 역할을 한다고 봄!?
		String resource = "com/ezen/mybatis/mybatis-config.xml";
		InputStream inputStream=null;
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
// sql 세션 만들기?
			SqlSession session = sqlSessionFactory.openSession();
			BoardMethod mapper = session.getMapper(BoardMethod.class);
//			BoardVO vo = mapper.selectOne(1);
//			vo.getAddress();

//		 mapper.deleteBoard(2);
//			session.commit();
//			List<BoardVO> list = mapper.selectAllMember()	;
//			for( BoardVO vo2 : list)
//					System.out.println(vo2.toString());
//			session.commit();
			BoardVO vo4 = new BoardVO();
//			vo3.setId(6);
//			vo3.setName("김신영");
//			vo3.setPhone("010-2494-9323");
//			vo3.setAddress("경기도");
//			mapper.insertBoard(vo3);
//			session.commit();
			vo4.setName("맨차쿠차차맨");
			vo4.setPhone("010-1234-9999");
			vo4.setAddress("화성시");
			vo4.setId(11);
			mapper.updateBoard(vo4);
			session.commit();
			System.out.println(vo4.toString());
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
