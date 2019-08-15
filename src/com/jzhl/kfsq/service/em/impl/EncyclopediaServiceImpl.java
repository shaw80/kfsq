package com.jzhl.kfsq.service.em.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.dao.em.IEncyclopediaClassesMapper;
import com.jzhl.kfsq.dao.em.IEncyclopediaDtoMapper;
import com.jzhl.kfsq.dao.em.IEncyclopediaMapper;
import com.jzhl.kfsq.dataset.em.EncyclopediaClassDataSet;
import com.jzhl.kfsq.dto.em.EncyclopediaDto;
import com.jzhl.kfsq.entity.em.Encyclopedia;
import com.jzhl.kfsq.entity.em.EncyclopediaClasses;
import com.jzhl.kfsq.service.em.IEncyclopediaService;

@Service
public class EncyclopediaServiceImpl implements IEncyclopediaService {

	@Autowired
	private IEncyclopediaClassesMapper encyclopediaClassesDao;

	@Autowired
	private IEncyclopediaDtoMapper encyclopediaDtoDao;

	@Autowired
	private IEncyclopediaMapper encyclopediaDao;

	@Override
	public EncyclopediaClassDataSet findEncyclopediaClasses(String parentId) {

		EncyclopediaClassDataSet result = new EncyclopediaClassDataSet();
		EncyclopediaClasses ec1 = new EncyclopediaClasses();
		ec1.setParentId(0);
		ec1.setIsValid(1);
		List<EncyclopediaClasses> firstClassList = encyclopediaClassesDao.findEncyclopediaClasses(ec1);

		if (firstClassList != null && firstClassList.size() > 0) {
			boolean isFirstTime = false;
			int currFirstClassId = 0;
			String currFirstClassName = "";

			// 判断是是否是首次获取，判断条件parentId为1空或非法
			if (parentId == null) {
				isFirstTime = true;
			} else {
				try {
					currFirstClassId = Integer.parseInt(parentId);
				} catch (Exception e) {
					isFirstTime = true;
				}
			}

			if (isFirstTime) {
				// 首次获取，从firstClassList中获取第一个parentId信息
				for (EncyclopediaClasses encyclopediaClasses : firstClassList) {
					result.addFirstClassList(encyclopediaClasses);
				}
				currFirstClassId = firstClassList.get(0).getClassId();
				currFirstClassName = firstClassList.get(0).getClassName();

			} else {
				// 不是首次获取，从firstClassList中匹配parentId信息，如果匹配不上则从中获取第一个parentId信息
				boolean isExist = false;
				for (EncyclopediaClasses encyclopediaClasses : firstClassList) {

					if (encyclopediaClasses.getClassId() == currFirstClassId) {
						currFirstClassName = encyclopediaClasses.getClassName();
						isExist = true;
					}
					result.addFirstClassList(encyclopediaClasses);
				}
				if (!isExist) {
					currFirstClassId = firstClassList.get(0).getClassId();
					currFirstClassName = firstClassList.get(0).getClassName();
				}
			}
			result.setCurrFirstClassId(currFirstClassId);
			result.setCurrFirstClassName(currFirstClassName);
			EncyclopediaClasses ec2 = new EncyclopediaClasses();
			ec2.setParentId(currFirstClassId);
			ec2.setIsValid(1);
			List<EncyclopediaClasses> secondClassList = encyclopediaClassesDao.findEncyclopediaClasses(ec2);
			for (EncyclopediaClasses dataset : secondClassList) {
				result.addSecondClassList(dataset);
			}
		}
		return result;
	}

	@Override
	public EncyclopediaDto getEncyclopediaDto(EncyclopediaDto encyclopediaDto) {
		return encyclopediaDtoDao.getEncyclopediaDto(encyclopediaDto);
	}

	@Override
	public List<Encyclopedia> findEncyclopedia(Encyclopedia encyclopedia) {
		return encyclopediaDao.findEncyclopedia(encyclopedia);
	}

	/**
	 * 分页查询文章列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<Encyclopedia> findEncyclopediaList(Map<String, Object> map) {
		List<Encyclopedia> result = encyclopediaDao.findEncyclopediaList(map);
		return result;
	}

	/**
	 * 分页查询文章列表总数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getEncyclopediaDataCount(Map<String, Object> map) {
		int dataCount = encyclopediaDao.getEncyclopediaDataCount(map);
		return dataCount;
	}

	/**
	 * 添加文章
	 * 
	 * @author zhouzy
	 */
	@Override
	public void insertEncyclopedia(Encyclopedia encyclopedia) {
		encyclopediaDao.insertEncyclopedia(encyclopedia);
	}

	/**
	 * 编辑文章,启用、禁用
	 * 
	 * @author zhouzy
	 */
	@Override
	public void updateEncyclopedia(Encyclopedia encyclopedia) {
		encyclopediaDao.updateEncyclopedia(encyclopedia);
	}

	/**
	 * 查询所有菜单列表
	 * 
	 * @author zhouzy
	 */
	@Override
	public EncyclopediaClassDataSet findEncyclopediaMenuAllList(String parentId) {
		EncyclopediaClassDataSet result = new EncyclopediaClassDataSet();
		EncyclopediaClasses ec1 = new EncyclopediaClasses();
		ec1.setParentId(0);
		ec1.setIsValid(1);
		List<EncyclopediaClasses> firstClassList = encyclopediaClassesDao.findEncyclopediaClasses(ec1);

		if (firstClassList != null && firstClassList.size() > 0) {
			boolean isFirstTime = false;
			int currFirstClassId = 0;
			String currFirstClassName = "";

			// 判断是是否是首次获取，判断条件parentId为1空或非法
			if (parentId == null) {
				isFirstTime = true;
			} else {
				try {
					currFirstClassId = Integer.parseInt(parentId);
				} catch (Exception e) {
					isFirstTime = true;
				}
			}

			if (isFirstTime) {
				// 首次获取，从firstClassList中获取第一个parentId信息
				for (EncyclopediaClasses encyclopediaClasses : firstClassList) {
					result.addFirstClassList(encyclopediaClasses);
				}
				currFirstClassId = firstClassList.get(0).getClassId();
				currFirstClassName = firstClassList.get(0).getClassName();

			} else {
				// 不是首次获取，从firstClassList中匹配parentId信息，如果匹配不上则从中获取第一个parentId信息
				boolean isExist = false;
				for (EncyclopediaClasses encyclopediaClasses : firstClassList) {

					if (encyclopediaClasses.getClassId() == currFirstClassId) {
						currFirstClassName = encyclopediaClasses.getClassName();
						isExist = true;
					}
					result.addFirstClassList(encyclopediaClasses);
				}
				if (!isExist) {
					currFirstClassId = firstClassList.get(0).getClassId();
					currFirstClassName = firstClassList.get(0).getClassName();
				}
			}
			result.setCurrFirstClassId(currFirstClassId);
			result.setCurrFirstClassName(currFirstClassName);
			EncyclopediaClasses ec2 = new EncyclopediaClasses();
			ec2.setParentId(currFirstClassId);
			List<EncyclopediaClasses> secondClassList = encyclopediaClassesDao.findEncyclopediaClasses(ec2);
			for (EncyclopediaClasses dataset : secondClassList) {
				result.addSecondClassList(dataset);
			}
		}
		return result;
	}

	/**
	 * 查询百科详情
	 * 
	 * @author zhouzy
	 */
	@Override
	public EncyclopediaDto getEncyclopediaInfo(EncyclopediaDto encyclopediaDto) {
		return encyclopediaDtoDao.getEncyclopediaInfo(encyclopediaDto);
	}
}
