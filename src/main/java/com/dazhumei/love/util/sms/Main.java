package com.dazhumei.love.util.sms;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class Main {
	
	public static void main(String[] args) throws UnknownHostException {
//		String email="1589500233@qq.com";
//		String num=String.valueOf((int)(Math.random() * 10000 / 1));
//		String text="注册验证码："+num;
//		String title="标题测试";
//		String userName="用户名";
//		SendMail.sendMimeMessage(email, text, title, userName);
		
//		try {
//			System.out.println("本机的IP = " + InetAddress.getLocalHost());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		InetAddress inet=InetAddress.getLocalHost();
		
		System.out.println(inet);
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		
	}
	
	public static String getIpAddress(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	  } 
}
