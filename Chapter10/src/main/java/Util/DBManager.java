package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
   public static Connection getConnection() {
      Connection conn = null;
      try {
         Context initContext = new InitialContext();
         Context envContext  = (Context)initContext.lookup("java:/comp/env");
         // jdbc/myoracle 이란 이름의 객체를 찾아서 DataSource가 받는다.
         DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
         //ds가 생성되었으므로 Connection을 구한다.
         conn = ds.getConnection();
         System.out.println("DB연결 성공");
      }catch(Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
   // select 를 수행한 후 리소스 해제를 위한 메서드 
   public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
      try {
       if(rs != null)  rs.close();
        if( stmt != null) stmt.close();
        if( conn != null) conn.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   // insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메서드
   public static void closeConnection(Connection conn, Statement stmt) {
      try {   
    	  if( stmt != null)   stmt.close();
    	  if( conn != null)   conn.close();
      }catch(Exception e   ) {
         e.printStackTrace();
      }
   }
}