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
import com.jzhl.kfsq.dataset.sm.FeatureDataSet;
import com.jzhl.kfsq.dto.sm.FeatureDto;
import com.jzhl.kfsq.entity.sm.Feature;
import com.jzhl.kfsq.service.sm.IFeatureService;

/**
 * 特色对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class FeatureController {

	@Autowired
	private IFeatureService featureService;

	/**
	 * 参数设置-特色列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/feature/featurelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findFeatureList(FeatureDto featureDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", featureDto.getRowStart());
		map.put("offset", featureDto.getOffset());

		List<Feature> pushInfoList = featureService.findFeatureList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(pushInfoList);

		// 总页数
		int dataCount = featureService.getFeatureDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(
				listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 参数设置-特色列表-新增
	 */
	@RequestMapping(value = "/serv/feature/insertfeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> insertFeature(FeatureDto featureDto)
			throws Exception {

		Feature feature = new Feature();
		BeanUtils.copyProperties(featureDto, feature);

		// 编辑
		featureService.insertFeature(feature);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("featureId", feature.getFeatureId());

		return new ResponseBean<Map<String, Object>>(map);
	}

	/**
	 * 参数设置-特色列表-编辑
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/feature/updatefeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateFeature(FeatureDto featureDto) throws Exception {

		Feature feature = new Feature();
		BeanUtils.copyProperties(featureDto, feature);

		// 编辑
		featureService.updateFeature(feature);

		ResponseBean result = new ResponseBean<Feature>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 参数设置-特色列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@RequestMapping(value = "/serv/feature/allFeature", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findAllFeature() throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Feature> pushInfoList = featureService.findAllFeature();

		map.put("datalist", pushInfoList);

		return new ResponseBean<Map<String, Object>>(map);
	}

	/**
	 * 查询特色结果集
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/feature/featureDataSet", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findFeature() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FeatureDataSet> list = featureService.findFeatureDataSet();
		map.put("featrues", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(
				map);
		return result;
	}
}
