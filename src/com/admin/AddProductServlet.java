package com.admin;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.impl.ProductDaoImpl;

public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");       
		PrintWriter out = response.getWriter();         
		
		//���������ļ�������ֽ�
	     int MAX_SIZE = 102400 * 102400; 
	     // ������·���ı������
	      String rootPath;
	      //�����ļ�������
	      DataInputStream in = null;
	      FileOutputStream fileOut = null; 
	      //ȡ�ÿͻ��˵������ַ 
	      String remoteAddr = request.getRemoteAddr(); 
	      //��÷�����������
	      String serverName = request.getServerName();
	      //ȡ�û���������ľ��Ե�ַ  
	      String realPath = request.getRealPath(serverName); 
	      System.out.println("���������Ե�ַrealPath:"+realPath);
	      realPath =  realPath.substring(0,realPath.lastIndexOf("\\")); 
	      System.out.println("���������Ե�ַrealPath��:"+realPath);
	      //�����ļ��ı���Ŀ¼ savepath
		  rootPath = realPath + "\\images\\";
		  System.out.println("�ļ�����Ŀ¼rootPath:"+rootPath);
		  String picname = request.getParameter("upfile");
		  System.out.println("picname:"+picname);
		  String savePath = String.format("%s%s", rootPath,picname);
		  System.out.println("savepath:"+savePath);
		  String savePathstr[] = savePath.split("\\\\");
		  String ppath = savePathstr[savePathstr.length-2]+"/"+savePathstr[savePathstr.length-1];
		  //��ȡ�������Ʒ����Ϣ
		  String pname = request.getParameter("pname");
		  Integer price = Integer.parseInt(request.getParameter("price"));
		  String provider = request.getParameter("provider");
		  String ptype = request.getParameter("ptype");
		  System.out.println("ptype:"+ptype);
		  
		  ProductDaoImpl pdl = new ProductDaoImpl();
		   pdl.addProduct(pname,price,provider,ppath,ptype);
		  request.getRequestDispatcher("JspAdminPage/successAddpro.jsp").forward(request, response);

		/*//ȡ�ÿͻ����ϴ�����������  
		String contentType = request.getContentType(); 
		System.out.println("�ͻ����ϴ���������contentType:"+contentType);
		try{  
			if(contentType.indexOf("utf-8") >= 0){ 
				//�����ϴ�������  
				in = new DataInputStream(request.getInputStream()); 
				int formDataLength = request.getContentLength(); 
				if(formDataLength > MAX_SIZE){  
					out.println("<P>�ϴ����ļ��ֽ��������Գ���" + MAX_SIZE + "</p>"); 
					return; 
					}  
				//�����ϴ��ļ�������  
				byte dataBytes[] = new byte[formDataLength];
				int byteRead = 0; 
				int totalBytesRead = 0; 
				//�ϴ������ݱ�����byte����  
				while(totalBytesRead < formDataLength){ 
					byteRead =  in.read(dataBytes,totalBytesRead,formDataLength); 
					totalBytesRead += byteRead; 
				}  
				//����byte���鴴���ַ���
				 String file = new String(dataBytes); 
				 System.out.println("�ַ���file:"+file);  
				 //ȡ���ϴ������ݵ��ļ��� 
				 String saveFile =  file.substring(file.indexOf("filename=\"") + 10); 
				 System.out.println("������ϴ����ݵ��ļ���saveFile:"+saveFile);
				 saveFile = saveFile.substring(0,saveFile.indexOf("\n")); 
				 saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));  
				System.out.println("�ָ����ļ���savaFile:"+saveFile);
				 int lastIndex = contentType.lastIndexOf("="); 
				 //ȡ�����ݵķָ��ַ���  
				 String boundary = contentType.substring(lastIndex + 1,contentType.length()); 
				 //��������·�����ļ��� 
				 String fileName = rootPath + saveFile; 
				 System.out.println("����·���ļ���fileName��"+fileName); 
				 int pos;  
				 pos = file.indexOf("filename=\""); 
				 pos = file.indexOf("\n",pos) + 1; 
				 pos = file.indexOf("\n",pos) + 1; 
				 pos = file.indexOf("\n",pos) + 1;  
				 int boundaryLocation = file.indexOf(boundary,pos) - 4; 
				 System.out.println("boundaryLocation:"+boundaryLocation); 
				 //ȡ���ļ����ݵĿ�ʼ��λ��  
				 int startPos = ((file.substring(0,pos)).getBytes()).length; 
				 System.out.println("ȡ���ļ����ݵĿ�ʼ��λ��startPos:"+startPos); 
				 //ȡ���ļ����ݵĽ�����λ�� 
				 int endPos =  ((file.substring(0,boundaryLocation)).getBytes()).length; 
				 System.out.println("ȡ���ļ����ݵĽ�����λ��endPos:"+endPos);
				 //��������ļ��Ƿ����  
				 File checkFile = new File(fileName); 
				 if(checkFile.exists()){  
				 	out.println("<p>" + saveFile + "�ļ��Ѿ�����.</p>"); 
				 }  
				 //��������ļ���Ŀ¼�Ƿ����
				 File fileDir = new File(rootPath); 
				 if(!fileDir.exists()){ 
				 	fileDir.mkdirs(); 
				 }  
				 //�����ļ���д����  
				 fileOut = new FileOutputStream(fileName); 
				 //�����ļ�������  
				 fileOut.write(dataBytes,startPos,(endPos - startPos)); 
				 fileOut.close();  
				 out.println(saveFile + "�ļ��ɹ�����.</p>"); 
			}else{  
				String content = request.getContentType(); 
				out.println("<p>�ϴ����������Ͳ���multipart/form-data</p>"); 
				}  
			}catch(Exception ex){  
				ex.printStackTrace();
			//throw new ServletException(ex.getMessage()); 
			}*/
}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
