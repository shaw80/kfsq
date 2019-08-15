package com.jzhl.kfsq.controller.em;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.em.EncyclopediaClassDataSet;
import com.jzhl.kfsq.dto.em.EncyclopediaClassDto;
import com.jzhl.kfsq.dto.em.EncyclopediaDto;
import com.jzhl.kfsq.entity.em.Encyclopedia;
import com.jzhl.kfsq.entity.em.EncyclopediaClasses;
import com.jzhl.kfsq.service.em.IEncyclopediaClassService;
import com.jzhl.kfsq.service.em.IEncyclopediaService;

@Controller
public class EncyclopediaController {

	@Autowired
	private IEncyclopediaService encyclopediaService;

	@Autowired
	private IEncyclopediaClassService encyclopediaClassService;

	private static final Logger logger = Logger.getLogger(EncyclopediaController.class);

	/**
	 * 查询百科分类
	 * 
	 * @param parentId
	 * @param curPage
	 * @return
	 */
	@RequestMapping(value = "/serv/encyclopediaClasses", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EncyclopediaClassDataSet> findEncyclopediaClasses(String parentId) throws Exception {

		logger.debug("[查询百科分类]--查询");
		EncyclopediaClassDataSet encyclopediaClassDataSet = encyclopediaService.findEncyclopediaClasses(parentId);
		ResponseBean<EncyclopediaClassDataSet> result = new ResponseBean<EncyclopediaClassDataSet>(encyclopediaClassDataSet);
		logger.debug("[查询百科分类]--查询成功");
		return result;

	}

	@RequestMapping(value = "/serv/encyclopedias", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Map<String, Object>> findEncyclopedias(int classId) throws Exception {

		Map<String, Object> queryResult = new HashMap<String, Object>();
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(queryResult);

		Encyclopedia encyclopedia = new Encyclopedia();
		encyclopedia.setClassId(classId);
		List<Encyclopedia> encyclopediaList = encyclopediaService.findEncyclopedia(encyclopedia);
		queryResult.put("dataList", encyclopediaList);
		queryResult.put("dataCount", encyclopediaList.size()); // 不分页
		return result;

	}

	/**
	 * 查询百科详情
	 * 
	 * @param classId
	 * @param curPage
	 * @return
	 */
	@RequestMapping(value = "/serv/encyclopediaInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EncyclopediaDto> getEncyclopedias(int encyclopediaId) {
		EncyclopediaDto encyclopediaDto = new EncyclopediaDto();
		encyclopediaDto.setEncyclopediaId(encyclopediaId);
		encyclopediaDto = encyclopediaService.getEncyclopediaDto(encyclopediaDto);
		ResponseBean<EncyclopediaDto> result = new ResponseBean<EncyclopediaDto>(encyclopediaDto);
		return result;

	}

	/**
	 * 查询百科详情
	 * 
	 * @author zhouzy
	 */
	@RequestMapping(value = "/serv/encyclopediainfoobj", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EncyclopediaDto> getEncyclopedias(EncyclopediaDto encyclopediaDto) {
		encyclopediaDto = encyclopediaService.getEncyclopediaInfo(encyclopediaDto);
		ResponseBean<EncyclopediaDto> result = new ResponseBean<EncyclopediaDto>(encyclopediaDto);
		return result;
	}

	/**
	 * 查询百科分类- 菜单列表；包含一级菜单，二级菜单
	 * 
	 * @author zhouzy
	 */
	@RequestMapping(value = "/serv/encyclopedia/encyclopediamenulist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<EncyclopediaClassDataSet> findEncyclopediaMenuAllList(EncyclopediaDto encyclopediaDto) throws Exception {
		// 查询参数
		Integer parentId = encyclopediaDto.getParentId();

		EncyclopediaClassDataSet encyclopediaClassDataSet = encyclopediaService.findEncyclopediaMenuAllList(parentId.toString());
		ResponseBean<EncyclopediaClassDataSet> result = new ResponseBean<EncyclopediaClassDataSet>(encyclopediaClassDataSet);
		return result;
	}

	/**
	 * 新增二级菜单
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/encyclopedia/insertencyclopediaclassmenu", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertEncyclopediaClassMenu(EncyclopediaClassDto encyclopediaClassDto) throws Exception {

		EncyclopediaClasses encyclopediaClass = new EncyclopediaClasses();

		BeanUtils.copyProperties(encyclopediaClassDto, encyclopediaClass);

		encyclopediaClassService.insertEncyclopediaClassMenu(encyclopediaClass);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 编辑二级菜单
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/encyclopedia/updateencyclopediaclassmenu", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateEncyclopediaClassMenu(EncyclopediaClassDto encyclopediaClassDto) throws Exception {

		EncyclopediaClasses encyclopediaClass = new EncyclopediaClasses();

		BeanUtils.copyProperties(encyclopediaClassDto, encyclopediaClass);

		encyclopediaClassService.updateEncyclopediaClassMenu(encyclopediaClass);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 分页查询文章列表
	 * 
	 * @author zhouzy
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/encyclopedia/encyclopedialist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findEncyclopediaList(EncyclopediaDto encyclopediaDto) throws Exception {
		// 分页查询参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowstart", encyclopediaDto.getRowStart());
		map.put("offset", encyclopediaDto.getOffset());

		// 条件查询参数；
		map.put("classId", encyclopediaDto.getClassId());
		map.put("title", encyclopediaDto.getTitle());
		List<Encyclopedia> branchList = encyclopediaService.findEncyclopediaList(map);

		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(branchList);

		// 总页数
		int dataCount = encyclopediaService.getEncyclopediaDataCount(map);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 添加文章
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/encyclopedia/insertencyclopedia", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertEncyclopedia(EncyclopediaDto encyclopediaDto) throws Exception {

		Encyclopedia encyclopedia = new Encyclopedia();

		BeanUtils.copyProperties(encyclopediaDto, encyclopedia);

		// 插入数据
		encyclopediaService.insertEncyclopedia(encyclopedia);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}

	/**
	 * 编辑文章,启用、禁用
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/encyclopedia/updateencyclopedia", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateEncyclopedia(EncyclopediaDto encyclopediaDto) throws Exception {

		Encyclopedia encyclopedia = new Encyclopedia();

		BeanUtils.copyProperties(encyclopediaDto, encyclopedia);

		encyclopediaService.updateEncyclopedia(encyclopedia);

		ResponseBean result = new ResponseBean();
		result.operateSuccess();
		return result;
	}
}
