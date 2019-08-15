package com.jzhl.kfsq.controller.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dto.sm.PriceInfoDto;
import com.jzhl.kfsq.entity.sm.PriceInfo;
import com.jzhl.kfsq.service.sm.IPriceInfoService;

/**
 * 价格信息管理类
 * 
 * @author Shaw
 *
 */
@Controller
public class PriceInfoController {

	@Autowired
	private IPriceInfoService priceInfoService;

	/**
	 * 查询状态为1的价格信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/priceInfos", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findPriceInfos() throws Exception {

		List<PriceInfo> priceInfos = priceInfoService.findPriceInfo();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("dataList", priceInfos);

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);

		result.operateSuccess("查询成功");

		return result;
	}

	/**
	 * 查询全部价格信息
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/priceInfo/priceinfolist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findPriceInfoList(PriceInfoDto priceInfoDto) throws Exception {

		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", priceInfoDto.getRowStart());
		map.put("offset", priceInfoDto.getOffset());

		List<PriceInfo> pushInfoList = priceInfoService.findPriceInfoList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(pushInfoList);

		// 总页数
		int dataCount = priceInfoService.getPriceInfoDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 参数设置-单价-添加
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/priceInfo/insertpriceinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertPriceInfo(PriceInfoDto priceInfoDto) throws Exception {

		PriceInfo priceInfo = new PriceInfo();
		BeanUtils.copyProperties(priceInfoDto, priceInfo);

		// 新增
		priceInfoService.insertPriceInfo(priceInfo);

		ResponseBean result = new ResponseBean<PriceInfo>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 参数设置-单价-编辑
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/priceInfo/updatepriceinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updatePriceInfo(PriceInfoDto priceInfoDto) throws Exception {

		PriceInfo priceInfo = new PriceInfo();
		BeanUtils.copyProperties(priceInfoDto, priceInfo);

		// 编辑
		priceInfoService.updatePriceInfo(priceInfo);

		ResponseBean result = new ResponseBean<PriceInfo>();
		result.operateSuccess();
		return result;
	}
	
	/**
	 * 查询价格区间
	 * 
	 * @param 无
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/priceInfo/findpricelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findPriceList(PriceInfoDto priceInfoDto) {

		List<PriceInfo> list = priceInfoService.findPriceList(priceInfoDto);
		Map<String, Object> queryResult = new HashMap<String, Object>();
		// 返回数据添加
		queryResult.put("datalist", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);
		result.operateSuccess();
		return result;
	}
}
