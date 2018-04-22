package com.dazhumei.love.util;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	private static Logger log = LogManager.getLogger(FileUploadUtil.class);
	
	public static String fileUpload(HttpServletRequest request,MultipartFile files[]) {
		
		StringBuffer pics=new StringBuffer();
		//遍历上传的文件
		for(int i=0;i<files.length;i++) {
			log.info("开始上传第"+ i +"个照片");
			//有值就上传
			if(!files[i].isEmpty()) {
				//上传路径
				StringBuffer path=new StringBuffer();
				String path1=request.getSession().getServletContext().getRealPath("/");
				File f=new File(path1).getParentFile();
				StringBuffer attachmentPath = new StringBuffer();
				
				// 取文件格式后缀名
				String attachmentExt = files[i]
						.getOriginalFilename()
						.substring(files[i].getOriginalFilename().lastIndexOf("."));
				
				Calendar date = Calendar.getInstance();
				// 文件保存路径
				path.append("/upload").append(File.separator).append("picture")
						.append(File.separator);
				path.append(date.get(Calendar.YEAR)).append(File.separator);
				path.append(date.get(Calendar.MONTH) + 1).append(
						File.separator);
				path.append(date.get(Calendar.DAY_OF_MONTH));
				
				// 保存附件存的地址
				attachmentPath.append("/upload").append(File.separator)
						.append("picture").append(File.separator);
				attachmentPath.append(date.get(Calendar.YEAR)).append(
						File.separator);
				attachmentPath.append(date.get(Calendar.MONTH) + 1).append(
						File.separator);
				attachmentPath.append(date.get(Calendar.DAY_OF_MONTH));
				
				File file2 = new File(f+path.toString());
				// 目录不存在则直接创建
				if (!file2.exists()) {
					file2.mkdirs();
				}
				// 定义输出流 将文件保存在path
				Long timeP = System.currentTimeMillis();
				path.append(File.separator).append(timeP)
						.append(attachmentExt);
				
				//地址
				attachmentPath.append(File.separator).append(timeP)
						.append(attachmentExt);
				
				pics.append(attachmentPath).append(",");
				
				log.info("第"+ i +"个图片的路径为：" + attachmentPath);
				File file = new File(f+path.toString());
				//文件上传
				try {
					files[i].transferTo(file);
				}catch (Exception e) {
					log.error("照片上传失败！", e);
				}
				log.info("第"+ i +"个附件保存成功");
				
			} else {
				log.info("第"+ i +"个附件为空");
			}
			
		}
		
		return pics.toString();
	}
	
}
