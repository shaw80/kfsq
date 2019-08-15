package com.jzhl.kfsq.service.fm.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dao.fm.IBuildinigEnvelopeDtoMapper;
import com.jzhl.kfsq.dao.fm.IEnvelopeReceiveMapper;
import com.jzhl.kfsq.dataset.fm.Amount;
import com.jzhl.kfsq.dataset.fm.EnvelopeDealDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeDealReceiveDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeReceiveCountDataSet;
import com.jzhl.kfsq.dataset.fm.EnvelopeStatisticalDatoSet;
import com.jzhl.kfsq.dataset.fm.ReadyEnvelopeDataSet;
import com.jzhl.kfsq.dataset.fm.ReadyEnvelopeReceiveDataSet;
import com.jzhl.kfsq.dto.fm.BuildingEnvelopeBalanceDto;
import com.jzhl.kfsq.dto.fm.SalerTotalRedDto;
import com.jzhl.kfsq.dto.mm.MemberDto;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.fm.EnvelopeReceive;
import com.jzhl.kfsq.service.fm.IEnvelopeReceiveService;

/**
 * 红包领取业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class EnvelopeReceiveServiceImpl implements IEnvelopeReceiveService {

	@Autowired
	private IEnvelopeReceiveMapper envelopeReceiveDao;
	@Autowired
	private IBuildinigEnvelopeDtoMapper BuildinigEnvelopeDao;

	/**
	 * 添加红包领取信息
	 * 
	 * @param er
	 *            红包领取实体类
	 */
	@Override
	public void insertEnvelopeReceive(EnvelopeReceive er) {
		envelopeReceiveDao.insertEnvelopeReceive(er);
	}

	/**
	 * 删除红包领取信息
	 * 
	 * @param receiveId
	 *            领取编号
	 */
	@Override
	public void deleteEnvelopeReceive(int receiveId) {
		envelopeReceiveDao.deleteEnvelopeReceive(receiveId);
	}

	/**
	 * 修改红包领取信息
	 * 
	 * @param er
	 *            红包领取实体类
	 */
	@Override
	public void updateEnvelopeReceive(EnvelopeReceive er) {
		envelopeReceiveDao.updateEnvelopeReceive(er);
	}

	/**
	 * 根据领取编号查询红包领取信息
	 * 
	 * @param receiveId
	 *            领取编号
	 * @return 红包领取实体类
	 */
	@Override
	public EnvelopeReceive getEnvelopeReceive(int receiveId) {
		EnvelopeReceive er = envelopeReceiveDao.getEnvelopeReceive(receiveId);
		return er;
	}

	/**
	 * 根据会员编号查询红包领取DTO
	 * 
	 * @param memberId
	 *            会员编号
	 * @return dto
	 */
	@Override
	public EnvelopeReceiveCountDataSet getCountDataSet(int memberId) {
		EnvelopeReceiveCountDataSet dataSet = envelopeReceiveDao.getCountDataSet(memberId);
		return dataSet;
	}

	/**
	 * 获取红包消耗总数
	 * 
	 * @param map
	 * @return BigDecimal
	 */
	@Override
	public BigDecimal getSumPriceNum(Map<String, Object> map) {
		BigDecimal bigdecimal = envelopeReceiveDao.getSumPriceNum(map);
		return bigdecimal;
	}

	/**
	 * 按城市查询计划总数
	 */
	@Override
	public Integer getPlanNum(Map<String, Object> map) {
		Integer planNum = envelopeReceiveDao.getPlanNum(map);
		return planNum;
	}

	/**
	 * 按城市查询到访总数
	 */
	@Override
	public Integer getVisitNum(Map<String, Object> map) {
		Integer visitNum = envelopeReceiveDao.getVisitNum(map);
		return visitNum;
	}

	/**
	 * 根据会员编号分页查询交易记录红包领取信息
	 * 
	 * @param params
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Override
	public ListResult findEnvelopeDealReceiveDataSet(int memberId, int begin, int length) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("memberId", memberId);

		params.put("begin", begin);

		params.put("length", length);

		List<EnvelopeDealReceiveDataSet> envelopes = envelopeReceiveDao.findEnvelopeDealReceiveDataSet(params);

		List<EnvelopeDealDataSet> dataList = new ArrayList<EnvelopeDealDataSet>();

		for (int i = 0; i < envelopes.size(); i++) {

			EnvelopeDealDataSet edds = new EnvelopeDealDataSet();

			int reveice_date = envelopes.get(i).getReceiveTime().getDate();// 获取支付日期

			int reveice_day = envelopes.get(i).getReceiveTime().getDay(); // 获取申请时间是周几（周日是0，周一是1，以此类推）

			String reveiceTime = "";

			switch (reveice_day) {

			case 1:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期一";

				break;

			case 2:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期二";

				break;

			case 3:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期三";

				break;

			case 4:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期四";

				break;

			case 5:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期五";

				break;

			case 6:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期六";

				break;

			default:

				reveiceTime = String.valueOf(reveice_date) + "日-" + "星期日";

				break;
			}

			edds.setServiceTime(reveiceTime);

			Integer enevlopeType = envelopes.get(i).getEnvelopeType();

			if (enevlopeType == 0) {

				edds.setType("收到看房红包");

			} else {

				edds.setType("收到评论红包");

			}

			edds.setPrice(envelopes.get(i).getPrice());

			dataList.add(edds);

		}

		Integer count = envelopeReceiveDao.countEnvelopeDealReceiveDataSet(memberId);

		ListResult result = new ListResult();

		result.setDataCount(count);

		result.setDataList(dataList);

		return result;
	}

	/**
	 * 现金红包统计及收入
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public EnvelopeReceiveCountDataSet findReadyEnvelopeReceiveDataSet(int memberId, int begin, int length) {

		EnvelopeReceiveCountDataSet dataSet = null;

		dataSet = envelopeReceiveDao.getCountDataSet(memberId);

		if (dataSet != null) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("memberId", memberId);

			map.put("begin", begin);

			map.put("length", length);

			List<ReadyEnvelopeReceiveDataSet> receives = envelopeReceiveDao.findReadyEnvelopeReceiveDataSet(map);

			List<ReadyEnvelopeDataSet> list = new ArrayList<ReadyEnvelopeDataSet>();

			for (int i = 0; i < receives.size(); i++) {

				ReadyEnvelopeDataSet data = new ReadyEnvelopeDataSet();

				data.setPrice("+" + receives.get(i).getPrice());

				data.setSource(receives.get(i).getBuildingName() + receives.get(i).getType());

				data.setType(receives.get(i).getType());

				list.add(data);

			}

			Integer dataCount = envelopeReceiveDao.countReadyEnvelopeReceiveDataSet(memberId);

			ListResult dataList = new ListResult();

			dataList.setDataList(list);

			dataList.setDataCount(dataCount);

			dataSet.setIncomeList(dataList);

		} else {

			dataSet = new EnvelopeReceiveCountDataSet();

			dataSet.setCashAmount(new BigDecimal(0));

			dataSet.setGain(new BigDecimal(0));

			dataSet.setNotActivation(new BigDecimal(0));

			ListResult listResult = new ListResult();

			List dataList = new ArrayList();

			listResult.setDataList(dataList);

			listResult.setDataCount(0);

			dataSet.setIncomeList(listResult);

		}

		return dataSet;

	}

	@Override
	public BigDecimal getBuildingEnvelopeBalance(BuildingEnvelopeBalanceDto buildingEnvelopeBalanceDto) {
		return BuildinigEnvelopeDao.getBuildingEnvelopeBalance(buildingEnvelopeBalanceDto);
	}

	@Override
	public BigDecimal getSalerTotalRed(SalerTotalRedDto salerTotalRedDto) {
		return BuildinigEnvelopeDao.getSalerTotalRed(salerTotalRedDto);
	}

	/**
	 * 楼盘管理后台_财务管理——红包消耗统计-按月分组显示当年红包消耗情况
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<EnvelopeStatisticalDatoSet> findBuildingEnvelopeStatistical(StatisticalDto statisticalDto) {
		List<EnvelopeStatisticalDatoSet> result = envelopeReceiveDao.findBuildingEnvelopeStatistical(statisticalDto);
		return result;
	}
	/**
	 * 楼盘管理后台_财务管理——红包消耗-交易记录
	 * 
	 * @author zhouzy
	 */
	@Override
	public List<EnvelopeReceive> findEnvelopeReceiveList(Map<String, Object> map) {
		List<EnvelopeReceive> result = envelopeReceiveDao.findEnvelopeReceiveList(map);
		return result;
	}

	/**
	 * 楼盘管理后台_财务管理——红包消耗-交易记录总页数
	 * 
	 * @author zhouzy
	 */
	@Override
	public int getEnvelopeReceiveDataCount(Map<String, Object> map) {
		int dataCount = envelopeReceiveDao.getEnvelopeReceiveDataCount(map);
		return dataCount;
	}

	/**
	 * 根据会员编号查询可生成红包金额
	 * @param dto
	 * @return
	 */
	@Override
	public Amount getAmountOfRedPacketsCanBeGenerated(MemberDto dto) {
		Amount amount = envelopeReceiveDao.getAmountOfRedPacketsCanBeGenerated(dto.getMemberId());
		return amount;
	}

}
