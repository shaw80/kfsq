package com.jzhl.kfsq.controller.sm;

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
import com.jzhl.kfsq.common.util.Constant;
import com.jzhl.kfsq.dataset.sm.CommentTagDataSet;
import com.jzhl.kfsq.dataset.sm.FeatureTagDataSet;
import com.jzhl.kfsq.dataset.sm.TagDataSet;
import com.jzhl.kfsq.dto.bm.BuildingTagDto;
import com.jzhl.kfsq.dto.cm.MyCommentDto;
import com.jzhl.kfsq.dto.sm.TagDto;
import com.jzhl.kfsq.entity.sm.Tag;
import com.jzhl.kfsq.service.cm.IBuildingCommentService;
import com.jzhl.kfsq.service.sm.ITagService;

/**
 * 标签外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class TagController {
	
	Logger logger = Logger.getLogger(TagController.class);

	@Autowired
	private ITagService tagService;

	@Autowired
	IBuildingCommentService buildingCommentService;

	/**
	 * 获取标签特色列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findFeatureTag", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findFeatureTag(TagDto tagDto) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FeatureTagDataSet> list = tagService.findFeatureTagDataSet();
		map.put("featureTags", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		return result;
	}

	/**
	 * 获取楼盘好评坏评标签列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findCommentBuildingTag", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findCommentBuildingTag(BuildingTagDto buildingTagDto) throws Exception {

		int commentNum = 0; // 好评、差评评论数；
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("buildingId", buildingTagDto.getBuildingId());
		param.put("isShow", buildingTagDto.getIsShow());
		param.put("tagType", buildingTagDto.getTagType());

		// 标签查询
		List<CommentTagDataSet> list = tagService.findCommentBuildingTagDateSet(param);

		// 好评、差评数查询
		MyCommentDto myCommentDto = new MyCommentDto();
		myCommentDto.setBuildingId(String.valueOf(buildingTagDto.getBuildingId()));
		myCommentDto.setComparisonValue(Constant.COMPARVALUE);
		myCommentDto.setMemberId(String.valueOf(buildingTagDto.getMemberId()));

		// 返回值
		Map<String, Object> map = new HashMap<String, Object>();

		// 否是需要显示，0：不显示，1：好评，2：差评'
		if (buildingTagDto.getIsShow() == null) {
			// isShow 为null 时，查询全部标签列表；用来判断是否存在学区房，和地铁房
			// 如果后台没有不利因素的标签，则判断此楼盘是否具有地铁房、学区房的标签，如果没有，显示非地铁房、非学区房
			map.put("goodCommentTags", list);
		} else if (buildingTagDto.getIsShow() == 1) {
			myCommentDto.setComparisonType(Constant.POSITIVE);
			commentNum = buildingCommentService.countCommentByComparValue(myCommentDto);
			map.put("goodCommentNum", commentNum);
			map.put("goodCommentTags", list);
		} else if (buildingTagDto.getIsShow() == 2) {
			myCommentDto.setComparisonType(Constant.NAGETIVE);
			commentNum = buildingCommentService.countCommentByComparValue(myCommentDto);
			map.put("badCommentNum", commentNum);
			map.put("badCommentTags", list);
		}

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		return result;
	}

	/**
	 * 获取标签列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findTag", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findTag(BuildingTagDto buildingTagDto) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("buildingId", buildingTagDto.getBuildingId());
		param.put("tagType", buildingTagDto.getTagType());
		param.put("isShow", buildingTagDto.getIsShow());

		// 标签查询
		logger.debug("[server端-查询标签列表]，调用实现类tagService的findCommentBuildingTagDateSet方法，参数为param=" + param);
		List<CommentTagDataSet> commentTagDataSets = tagService.findCommentBuildingTagDateSet(param);
		logger.debug("[server端-查询标签列表]，调用结束，结果集为commentTagDataSets=" + commentTagDataSets);
		// 返回
		ListResult listResult = new ListResult();
		listResult.setDataList(commentTagDataSets);
		listResult.setDataCount(commentTagDataSets.size());
		logger.debug("[server端-查询标签列表]，定义并赋值集合结果集listResult，dataList=" + commentTagDataSets + ",dataCount=" + commentTagDataSets.size());
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		logger.debug("[server端-查询标签列表]查询结束，返回结果集result=" + result);
		return result;
	}

	/**
	 * @author zhouzy v1.1 20160617
	 * @param 运营平台
	 *            楼盘详情，标签列表 3 楼盘标签、4 户型标签、5 园区配套标签、6 娱乐设施标签、 7周边商业标签、8 周边环境标签、
	 *            9周边不利因素标签'
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findTagListBean", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findTagListBean(TagDto tagDto) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		// 楼盘ID
		param.put("buildingId", tagDto.getBuildingId());

		// 3 楼盘标签
		param.put("tagType", 3);
		// 标签查询
		List<TagDataSet> buildingTagList = tagService.findTagDateSetList(param);

		// 4 户型标签
		param.put("tagType", 4);
		// 标签查询
		List<TagDataSet> houseTypeList = tagService.findTagDateSetList(param);

		// 5 园区配套标签
		param.put("tagType", 5);
		// 标签查询
		List<TagDataSet> gardenSupportList = tagService.findTagDateSetList(param);

		// 6 娱乐设施标签
		param.put("tagType", 6);
		// 标签查询
		List<TagDataSet> entertainmentSupportList = tagService.findTagDateSetList(param);

		// 7周边商业标签
		param.put("tagType", 7);
		// 标签查询
		List<TagDataSet> surroundSupportList = tagService.findTagDateSetList(param);

		// 8 周边环境标签
		param.put("tagType", 8);
		// 标签查询
		List<TagDataSet> surroundEnvironmentList = tagService.findTagDateSetList(param);

		// 9周边不利因素标签'
		param.put("tagType", 9);
		// 标签查询
		List<TagDataSet> surroundDisadvantageList = tagService.findTagDateSetList(param);

		// 返回值
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("buildingTagList", buildingTagList);
		map.put("houseTypeList", houseTypeList);
		map.put("gardenSupportList", gardenSupportList);
		map.put("entertainmentSupportList", entertainmentSupportList);
		map.put("surroundSupportList", surroundSupportList);
		map.put("surroundEnvironmentList", surroundEnvironmentList);
		map.put("surroundDisadvantageList", surroundDisadvantageList);

		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		return result;
	}

	/**
	 * 获取标签列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findTagList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findTagList(TagDto tagDto) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		// tagType 签标类型，1 用户标签2 房源标签、3 楼盘标签、4 户型标签、5 园区配套标签、6 娱乐设施标签、7 周边商业标签、
		// 8周边环境标签、9 周边不利因素标签
		param.put("tagType", tagDto.getTagType());
		List<TagDataSet> list = tagService.findTagDateSetList(param);
		// 返回值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		return result;
	}

	/**
	 * 获取户型对应标签列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findUnitMapTagList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findUnitMapTagList(TagDto tagDto) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		// 楼盘ID
		param.put("unitMapId", tagDto.getUnitMapId());

		// tagType 签标类型，1 用户标签2 房源标签、3 楼盘标签、4 户型标签、5 园区配套标签、6 娱乐设施标签、7 周边商业标签、
		// 8周边环境标签、9 周边不利因素标签
		param.put("tagType", tagDto.getTagType());
		List<TagDataSet> list = tagService.findUnitMapTagList(param);
		// 返回值
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataList", list);
		ResponseBean<Map<String, Object>> result = new ResponseBean<Map<String, Object>>(map);
		return result;
	}

	/**
	 * 分页查询三级标签列表
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/findThirdTags", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findThirdTags(TagDto tagDto) throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("rowstart", tagDto.getRowStart());
		param.put("offset", tagDto.getOffset());

		param.put("tagTypeName", tagDto.getTagTypeName());
		param.put("isValid", tagDto.getIsValid());
		param.put("isScore", tagDto.getIsScore());
		param.put("tagName", tagDto.getTagName());

		// 标签查询
		List<Tag> commentTagDataSets = tagService.findThirdTags(param);
		// 返回
		ListResult listResult = new ListResult();
		listResult.setDataList(commentTagDataSets);

		// 总页数
		int dataCount = tagService.findThirdTagsDataCount(param);
		listResult.setDataCount(dataCount);

		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 获取标签详情
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/getTagInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getTagInfo(TagDto tagDto) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tagId", tagDto.getTagId());

		TagDataSet tagDataSet = tagService.getTagInfo(param);
		// 返回值
		ResponseBean<TagDataSet> result = new ResponseBean<TagDataSet>(tagDataSet);
		return result;
	}

	/**
	 * 编辑标签
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/updateTagInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateTagInfo(TagDto tagDto) throws Exception {

		// 如果是特色维护，传入的tagId字符串拼接
		if (tagDto.getTagIdList() != null) {
			
			// 清空楼盘标签所有特色
			tagService.updateTagFeature();
			
			String[] tagIdList = tagDto.getTagIdList().split(",");

			for (String tagId : tagIdList) {
				tagDto.setTagId(Integer.parseInt(tagId));
				tagDto.setIsFeature(1);
				tagService.updateTagInfo(tagDto);
			}

		} else {
			// 编辑
			tagService.updateTagInfo(tagDto);
		}

		ResponseBean result = new ResponseBean<>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 编辑标签
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/addTag", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addTag(TagDto tagDto) throws Exception {

		Tag tag = new Tag();
		BeanUtils.copyProperties(tagDto, tag);

		tag.setIsFeature(0); // 暂时不是特色

		// 添加
		tagService.addTag(tag);

		ResponseBean result = new ResponseBean<>();
		result.operateSuccess();
		return result;
	}

	/**
	 * 删除标签
	 * 
	 * @author zhouzy
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/tag/deleteTag", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean deleteTag(TagDto tagDto) throws Exception {

		Tag tag = new Tag();
		BeanUtils.copyProperties(tagDto, tag);

		// 删除标签
		tagService.deleteTag(tag);

		ResponseBean result = new ResponseBean<>();
		result.operateSuccess();
		return result;
	}

}
