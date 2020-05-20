package com.zt.controller;

import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import java.io.IOException;

import java.util.Random;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;

import javax.servlet.ServletOutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	private int width = 100;

	
	private int height = 40;

	
	private int codeCount = 4;

	private int x = 0;


	private int fontHeight;

	private int codeY;

	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',

	'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',

	'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',

	'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',

	'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	
	public ValidateCodeServlet() {

		super();

	}


	public void init() throws ServletException {

		

		String strWidth = this.getInitParameter("width");

		

		String strHeight = this.getInitParameter("height");

		

		String strCodeCount = this.getInitParameter("codeCount");

		

		try {

			if (strWidth != null && strWidth.length() != 0) {

				width = Integer.parseInt(strWidth);

			}

			if (strHeight != null && strHeight.length() != 0) {

				height = Integer.parseInt(strHeight);

			}

			if (strCodeCount != null && strCodeCount.length() != 0) {

				codeCount = Integer.parseInt(strCodeCount);

			}

		} catch (NumberFormatException e) {

		}

		x = width / (codeCount + 2);

		fontHeight = height - 1;

		codeY = height - 4;

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {

		doPost(request, response);

	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {
//		System.out.println("进入图片验证码");
		
		BufferedImage buffImg = new BufferedImage(width, height,

		BufferedImage.TYPE_INT_RGB);

		Graphics2D g = buffImg.createGraphics();

		
		Random random = new Random();

		
		g.setColor(Color.WHITE);

		g.fillRect(0, 0, width, height);

		
		Font font = new Font("宋体", Font.BOLD, fontHeight);

		
		g.setFont(font);

		
		g.setColor(Color.GRAY);

		g.drawRect(0, 0, width - 1, height - 1);

		
		g.setColor(Color.GRAY);

		for (int i = 0; i < 40; i++) {

			int x = random.nextInt(width);

			int y = random.nextInt(height);

			int xl = random.nextInt(2);

			int yl = random.nextInt(2);

			g.drawLine(x, y, x + xl, y + yl);

		}

		
		StringBuffer randomCode = new StringBuffer();

		int red = 0, green = 0, blue = 0;

		
		for (int i = 0; i < codeCount; i++) {

			
			String strRand = String.valueOf(codeSequence[random.nextInt(62)]);

			
			red = random.nextInt(127);

			green = random.nextInt(127);

			blue = random.nextInt(127);

			

			g.setColor(new Color(red, green, blue));

			g.drawString(strRand, (i + 1) * x, codeY);

			

			randomCode.append(strRand);

		}

		
		request.getSession()
				.setAttribute("validateCode", randomCode.toString());

		
		request.getSession()
				.setAttribute("validateCode", randomCode.toString());

	

		response.setHeader("Pragma", "no-cache");

		response.setHeader("Cache-Control", "no-cache");

		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

	

		ServletOutputStream sos = response.getOutputStream();

		ImageIO.write(buffImg, "jpeg", sos);

		sos.flush();

		sos.close();

	}

	public void destroy() {

		super.destroy();

	}

}
