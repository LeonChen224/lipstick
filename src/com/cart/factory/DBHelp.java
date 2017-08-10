package com.cart.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
* @ClassName: JdbcUtils_DBCP
* @Description: 数据库连接工具类
*/ 
public class DBHelp {
    
    private static DataSource ds = null;
    //在静态代码块中创建数据库连接池
    static{
        try{
             //初始化JNDI
            Context initCtx = new InitialContext();
             //得到JNDI容器
             //  Context envCtx = (Context) initCtx.lookup("java:comp/env/jspwork");
             //从JNDI容器中检索name为jdbc/datasource的数据源
            ds = (DataSource)initCtx.lookup("java:comp/env/JSPWork");
            System.out.println("success");
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
    * @Method: getConnection
    * @Description: 从数据源中获取数据库连接
    * @return Connection
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        //从数据源中获取数据库连接
        return ds.getConnection();
    }
    
    /**
    * @Method: release
    * @Description: 释放资源，
    * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
    * @param conn
    * @param st
    * @param rs
    */ 
    public static void release(Connection conn,Statement stmt,ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                stmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
    public static void release(Connection conn,PreparedStatement pstmt,ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
       
        
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(pstmt!=null){
            try{
                //将Connection连接对象还给数据库连接池
            	pstmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}