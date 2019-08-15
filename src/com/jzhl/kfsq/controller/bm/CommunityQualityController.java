package com.jzhl.kfsq.controller.bm;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.common.util.FTPUtil;
import com.jzhl.kfsq.dataset.bm.CommunityQualityDataSet;
import com.jzhl.kfsq.dto.bm.CommunityQualityDto;
import com.jzhl.kfsq.service.bm.ICommunityQualityService;

/**
 * 社区品质管理类
 * 
 * @author zhouzy
 *
 */
@Controller
public class CommunityQualityController {
	
	Logger logger = Logger.getLogger(CommunityQualityController.class);

	@Autowired
	private ICommunityQualityService communityQualityService;

	/**
	 * 社区品质详情
	 * 
	 * @param dto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/serv/communityQuality/communityQuality", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<CommunityQualityDataSet> getCommunityQuality(CommunityQualityDto dto) throws IOException {
		
		logger.debug("[server端-社区品质详情]查询开始");
		logger.debug("[server端-社区品质详情]调用实现类communityQualityService的getCommunityQuality方法，参数为dto，dto=" + dto);
		CommunityQualityDataSet data = communityQualityService.getCommunityQuality(dto);
		logger.debug("[server端-社区品质详情]调用实现类结束，返回值类型为CommunityQualityDataSet，结果集为data=" + data);
		// 拼接http地址
		logger.debug("[server端-社区品质详情]拼接http地址开始");
		if (data.getSpaceOfCarImg() != null) {
			data.setSpaceOfCarImg(FTPUtil.getFtpPach() + data.getSpaceOfCarImg());
		}
		if (data.getGreenImg() != null) {
			data.setGreenImg(FTPUtil.getFtpPach() + data.getGreenImg());
		}
		if (data.getParkFacilitiesImg() != null) {
			data.setParkFacilitiesImg(FTPUtil.getFtpPach() + data.getParkFacilitiesImg());
		}
		logger.debug("[server端-社区品质详情]拼接http地址结束");
		ResponseBean<CommunityQualityDataSet> result = new ResponseBean<CommunityQualityDataSet>(data);
		result.operateSuccess("查询成功");
		logger.debug("[server端-社区品质详情]返回值为ResponseBean，结果集result=" + result);
		return result;
	}

}
