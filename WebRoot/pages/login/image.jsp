<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.awt.*" %>
    <%@ page import="java.awt.image.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="javax.imageio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证码的生成</title>
</head>
<body>
<%!
    Color getRandColor(int fc,int bc){
	Random random=new Random();
	if(fc>225) fc=225;
	if(bc>225) bc=225;
	int r=fc+random.nextInt(bc-fc);
	int g=fc+random.nextInt(bc-fc);
	int b=fc+random.nextInt(bc-fc);
	return new Color(r,g,b);
}
%>
<%
   response.setHeader("Pragma","NO-cache");
   response.setHeader("Cache-control","no-cache");
   response.setDateHeader("Expires", 0);
   
   int iwidth=60;
   int iheight=20;
   BufferedImage image = new  BufferedImage( iwidth, iheight,BufferedImage.TYPE_INT_RGB);
   Graphics g = image.getGraphics();
   
   Random random = new Random();
   g.setColor(getRandColor(200,250));
   g.fillRect(0, 0, iwidth, iheight);
   
   g.setFont(new Font("Times New Roman",Font.PLAIN,18));
   
   g.setColor(getRandColor(160,200));
   
   for(int i=0;i<155;i++){
	   int ix=random.nextInt(iwidth);
	   int iy=random.nextInt(iheight);
	   int ixl=random.nextInt(12);
	   int iyl=random.nextInt(12);
	   g.drawLine(ix, iy, ix+ixl, iy+iyl);
   }
   
   String sRand="";
   for(int i=0;i<4;i++){
	   String rand=String.valueOf(random.nextInt(10));
	   
	   sRand+=rand;
	   
	   g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
	   
	   g.drawString(rand,13*i+6,16);
   }
   
   //将验证码保存到session中
   session.setAttribute("Rand", sRand);
   g.dispose();
   ImageIO.write(image, "JPEG", response.getOutputStream());
   
   /*
   使用以下两行代码的原因是
   jsp中 response.getWriter()和response.getOutputStream()相互冲突
   */
   out.clear();
   out=pageContext.pushBody();
%>
</body>
</html>