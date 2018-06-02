package nuc.edu.action.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.opensymphony.xwork2.ActionSupport;

import nuc.edu.entity.Task;
import nuc.edu.service.task.TaskService;

public class UploadAction extends ActionSupport {
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	private String savePath;
	
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	
	
	public String upload() {
		
		byte[] buffer = new byte[1024];
		
		try {
			FileInputStream fis = new FileInputStream(upload);
			FileOutputStream fos = new FileOutputStream(savePath+"/"+uploadFileName);
			/* 通过session的值，查询老师的t_id */
			
			Task task = new Task();
			task.setT_id(3);/*老师的t_id*/
			task.setTask_url(savePath+"/"+uploadFileName);
			TaskService tservice = new TaskService();
			int rs = tservice.addTask(task);
			
			if(rs==0) {
				System.out.println("插入失败！");
			}
			
			int length = 0;
			
			while((length = fis.read(buffer)) >0) {
					fos.write(buffer,0,length);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "uploadOK";
	}
	
}
