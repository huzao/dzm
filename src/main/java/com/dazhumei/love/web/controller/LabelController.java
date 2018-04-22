package com.dazhumei.love.web.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazhumei.love.web.dao.LabelMapper;
import com.dazhumei.love.web.entity.Label;
import com.dazhumei.love.web.service.LabelService;

@Controller
@RequestMapping("/label")
public class LabelController {
	private static Logger log = LogManager.getLogger(LabelController.class);

	@Autowired
	private LabelService labelService;
	@Autowired
	private LabelMapper labelDao;
	
	public static void main(String[] args) throws IOException {
//		for(int i=33;i<=2481;i=i+10){
//			int sta=106;
//			int end=112;
			for(int one=1;one<=255;one++){
				for(int two=1;two<=255;two++){
//			if((i+9)>2481){
//				end=2481;
//			}else {
//				end=i+9;
//			}
			try {
				URL temp = new URL("http://localhost:8080/crawler/testip/testOne");
//				URL temp = new URL("http://119.23.31.208:8082/crawler/controller/beginSelectOneBarFromTest");
				
				HttpURLConnection connection=(HttpURLConnection) temp.openConnection();
				String param1="&one="+one;
				String param2="&two="+two;
//				String param3="&name=武汉纺织大学";
//				String param3="&name=中南财经政法大学";
//				String param4="&baseurl=http://tieba.baidu.com";
//				String param5="&barid=0C65F659DFC34233A7AC9E194CF44540";
				//设置参数
				connection.setDoOutput(true);   //需要输出
				connection.setDoInput(true);   //需要输入
				connection.setUseCaches(false);  //不允许缓存
				connection.setRequestMethod("POST");   //设置POST方式连接
			    //设置请求属性
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
				connection.setRequestProperty("Charset", "UTF-8");

	            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

	            writer.write(param1);
	            writer.write(param2);
//	            writer.write(param3);
//	            writer.write(param4);
//	            writer.write(param5);

	            writer.flush();

	            int responseCode =connection.getResponseCode();//
	            System.err.println(one+"--------------"+two);
	            if (responseCode == 200) {
//	            	System.err.println(sta+"--------------"+end);
//	            	System.out.println("http://localhost:8080/crawler/controller/beginSelectOneBarFromTest?sta="+sta+"&end="+end+"&name=中南财经政法大学"+"&baseurl=http://tieba.baidu.com"+"&barid=AD9596A7C9504B828B662FC5A7E6CDDD");
//	            	System.out.println("http://119.23.31.208:8082/crawler/controller/beginSelectOneBarFromTest?sta="+sta+"&end="+end+"&name=武汉纺织大学外经贸学院"+"&baseurl=http://tieba.baidu.com"+"&barid=AD9596A7C9504B828B662FC5A7E6CDDD");
	            }

			} catch (IOException e) {
				e.printStackTrace();
			}
			
				}
			}
			
//		}
	}


	/**
	 * 添加书签
	 * 
	 * @param label
	 * @return
	 */
	@RequestMapping("/addLabel")
	@ResponseBody
	public String addLabel(Label label) {
		return "ok";
	}

	/**
	 * 查询某人的所以书签
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/selectAllLabelByUserId")
	@ResponseBody
	public Map<String, Object> selectAllLabelByUserId(int userId) {
		log.info("selectAllLabelByUserId:" + "userId:" + userId);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Label> tlist = labelDao.selectAllThemeByUserId(1);
		List<Label> ulist = labelDao.selectAllUrlByUserId(1);
		map.put("tlist", tlist);
		map.put("ulist", ulist);
		return map;
	}

}
