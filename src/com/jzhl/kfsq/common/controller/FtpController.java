package com.jzhl.kfsq.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.common.dataset.FtpBean;
import com.jzhl.kfsq.common.util.FTPUtil;
import com.jzhl.kfsq.common.util.SystemConfig;

@Controller
public class FtpController {

	private static final Logger logger = Logger.getLogger(FtpController.class);
	private static String uploadFailMsg = "";

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/serv/upload/{type}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<FtpBean> uploadFile(HttpServletRequest request, @PathVariable("type") String type) throws Exception {
		FtpBean ftpBean = new FtpBean();
		ResponseBean<FtpBean> result = new ResponseBean<FtpBean>(ftpBean);
		logger.debug("[上传文件]--file：" + request.getParameter("file"));
		logger.debug("[上传文件]--文件类型：" + type);
		if (type == null || type.isEmpty()) {
			logger.error("[上传文件]--文件类型为空：" + type);
			result.operateFail(uploadFailMsg);
			return result;
		}
		String ftpPath = SystemConfig.getFtpPathByType(type);
		if (ftpPath == null || ftpPath.isEmpty()) {
			logger.error("[上传文件]--文件类型不存在：" + type);
			result.operateFail(uploadFailMsg);
			return result;
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile imgFile = multipartRequest.getFile("file");
		String sourceName = imgFile.getOriginalFilename();
		logger.debug("[上传文件]--文件名：" + sourceName);
		String extName = sourceName.substring(sourceName.lastIndexOf(".") + 1);
		logger.debug("[上传文件]--文件扩展名：" + extName);
		if (imgFile.getSize() > 20 * 1024 * 1024) {
			logger.error("[上传文件]--文件过大:" + imgFile.getSize());
			result.operateFail(uploadFailMsg);
			return result;
		}
		CommonsMultipartFile cmf = (CommonsMultipartFile) imgFile;
		String imageName = getRanStr() + "." + extName;
		String fileName = FTPUtil.uploadFile(cmf, ftpPath, imageName);
		logger.debug("[上传文件]--上传文件完毕：" + fileName);
		ftpBean.setPath(fileName);
		return result;
	}

	/**
	 * 获取唯一字符串
	 * 
	 * @return
	 */
	private String getRanStr() {
		// TODO 有待确定生成规则
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date()) + FTPUtil.getRandomString();
	}

	@RequestMapping(value = "/test")
	public String test() {
		return "test";
	}
}
