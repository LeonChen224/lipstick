package com.cart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeImageServlet extends HttpServlet {

	public static final int WIDTH = 120;
	public static final int HEIGHT = 35;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g = (Graphics2D) image.getGraphics();
		
		setBackGround(g);// 设置背景
		setBorder(g);// 设置边框
		setDrawRandomLine(g);// 画干扰线
		String random=drawRandomNum((Graphics2D) g);
		request.getSession().setAttribute("code", random);
		// 图形写给浏览器
		response.setContentType("image/jpeg");
		
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	
	
	private void setBackGround(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);

	}

	private void setBorder(Graphics2D g) {
		g.setColor(Color.red);
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	public static char getRandomChar() {
		Random random = new Random();
		if (random.nextInt(5) < 3) {
			return (char) (65 + random.nextInt(26));
		}
		return (char) (97 + random.nextInt(26));

	}

	private String drawRandomNum(Graphics2D g) {
		g.setColor(getRandomColor());
		g.setFont(getRandomFont());
		StringBuffer sb=new StringBuffer();
		int x = 10;
		for (int i = 0; i < 4; i++) {
			int degree = new Random().nextInt() % 30;// 生成旋转夹角
		   
			String ch = getRandomChar() + "";
			sb.append(ch);
			g.rotate(degree * Math.PI / 180, x, 20);
			g.drawString(ch, x, 20);
			g.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;// 要考虑字体的字号还有空隙
		}
		return sb.toString();
	}

	private Font getRandomFont() {
		  Random random = new Random();
	        return new Font("宋体", Font.BOLD, 20 + random.nextInt(8));
	}

	private Color getRandomColor() {
		  Random random = new Random();
	        return new Color(50 + random.nextInt(100), 50 + random.nextInt(100),
	                50 + random.nextInt(100));
	}

	private int getRandomBgInt() {
		Random random = new Random();
		return 180 + random.nextInt(60);
	}

	private void setDrawRandomLine(Graphics2D g) {
		g.setColor(Color.blue);

		g.setColor(new Color(255, getRandomBgInt(), 255));
		for (int i = 0; i < 5; i++) {
			// 随机生成x y轴坐标
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
