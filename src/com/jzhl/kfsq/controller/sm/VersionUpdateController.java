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
import com.jzhl.kfsq.common.service.ISystemInitService;
import com.jzhl.kfsq.dataset.sm.VersionUpdateDataSet;
import com.jzhl.kfsq.dto.sm.VersionAppDto;
import com.jzhl.kfsq.dto.sm.VersionDto;
import com.jzhl.kfsq.dto.sm.VersionUpdateDto;
import com.jzhl.kfsq.entity.sm.VersionUpdate;
import com.jzhl.kfsq.service.sm.IVersionUpdateService;

/**
 * 版本更新对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class VersionUpdateController {

	@Autowired
	private IVersionUpdateService versionUpdateService;
	
	@Autowired
	private ISystemInitService systemInitService;

	/**
	 * 查询各端app版本列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/versionupdate/versionupdatelist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findVersionUpdateList(VersionUpdateDto versionUpdateDto) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		List<VersionUpdate> versionUpdateList = versionUpdateService.findVersionUpdateList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(versionUpdateList);

		// 总页数
		listResult.setDataCount(versionUpdateList.size());

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 新增版本更新
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/versionupdate/insertversionupdate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertVersionUpdate(VersionUpdateDto versionUpdateDto) throws Exception {

		// 插入新盘版数据
		VersionUpdate versionupdate = new VersionUpdate();
		BeanUtils.copyProperties(versionUpdateDto, versionupdate);
		
		// 实现里面有逻辑判断；
		versionUpdateService.insertVersionUpdate(versionupdate);

		ResponseBean result = new ResponseBean<VersionUpdate>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询当前版本
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/versionupdate/f", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getVersionUpdate(VersionUpdate versionUpdate) throws Exception {

		VersionUpdate data = versionUpdateService.selectByisValid(versionUpdate);
		ResponseBean<VersionUpdate> result = new ResponseBean<VersionUpdate>(data);
		result.operateSuccess();
		return result;
	}

	/**
	 * 根据版本编号和客户端类型查询版本更新信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/v1/versionupdate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<VersionUpdateDataSet> getVersionUpdateApp(VersionDto dto) {
		VersionAppDto param = new VersionAppDto();
		param.setVersionCode(Integer.parseInt(dto.getVersionCode()));
		param.setType(Integer.parseInt(dto.getType()));
		VersionUpdateDataSet data = versionUpdateService.findVersionsByCodeAndType(param);
		ResponseBean<VersionUpdateDataSet> result = new ResponseBean<VersionUpdateDataSet>(data);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 装载最新的手机端程序版本信息到缓存
	 */
	@RequestMapping(value = "/serv/versionCache/load", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Object> loadVersionCache() throws Exception {

		this.systemInitService.loadVersionCache();
		ResponseBean<Object> result = new ResponseBean<Object>();
		return result;

	}
	
}
