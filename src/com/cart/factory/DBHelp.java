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
* @Description: ���ݿ����ӹ�����
*/ 
public class DBHelp {
    
    private static DataSource ds = null;
    //�ھ�̬������д������ݿ����ӳ�
    static{
        try{
             //��ʼ��JNDI
            Context initCtx = new InitialContext();
             //�õ�JNDI����
             //  Context envCtx = (Context) initCtx.lookup("java:comp/env/jspwork");
             //��JNDI�����м���nameΪjdbc/datasource������Դ
            ds = (DataSource)initCtx.lookup("java:comp/env/JSPWork");
            System.out.println("success");
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
    * @Method: getConnection
    * @Description: ������Դ�л�ȡ���ݿ�����
    * @return Connection
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        //������Դ�л�ȡ���ݿ�����
        return ds.getConnection();
    }
    
    /**
    * @Method: release
    * @Description: �ͷ���Դ��
    * �ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����Statement���󣬴洢��ѯ�����ResultSet����
    * @param conn
    * @param st
    * @param rs
    */ 
    public static void release(Connection conn,Statement stmt,ResultSet rs){
        if(rs!=null){
            try{
                //�رմ洢��ѯ�����ResultSet����
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try{
                //�رո���ִ��SQL�����Statement����
                stmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //��Connection���Ӷ��󻹸����ݿ����ӳ�
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
    public static void release(Connection conn,PreparedStatement pstmt,ResultSet rs){
        if(rs!=null){
            try{
                //�رմ洢��ѯ�����ResultSet����
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
       
        
        if(conn!=null){
            try{
                //��Connection���Ӷ��󻹸����ݿ����ӳ�
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(pstmt!=null){
            try{
                //��Connection���Ӷ��󻹸����ݿ����ӳ�
            	pstmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}