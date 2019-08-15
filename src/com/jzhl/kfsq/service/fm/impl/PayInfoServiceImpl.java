package com.jzhl.kfsq.service.fm.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.base.ListResult;
import com.jzhl.kfsq.dao.fm.IPayInfoMapper;
import com.jzhl.kfsq.dataset.fm.BillingDetailDataSet;
import com.jzhl.kfsq.dataset.fm.PayInfoDataSet;
import com.jzhl.kfsq.dataset.mm.MemberBillingDataSet;
import com.jzhl.kfsq.dto.fm.BillingDto;
import com.jzhl.kfsq.dto.fm.PayInfoDto;
import com.jzhl.kfsq.dto.fm.PayParamDto;
import com.jzhl.kfsq.entity.fm.PayInfo;
import com.jzhl.kfsq.service.fm.IPayInfoService;

/**
 * 支付信息业务层实现类
 * 
 * @author Shaw
 *
 */
@Service
public class PayInfoServiceImpl implements IPayInfoService {

	@Autowired
	private IPayInfoMapper payInfoDao;

	/**
	 * 根据用户编号分页查询支付信息
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public ListResult findPayInfoByUserId(PayInfoDto dto) {
		ListResult result = new ListResult();
		PayParamDto param = new PayParamDto();
		param.setUserId(dto.getUserId());
		SimpleDateFormat sdf_param = new SimpleDateFormat("YYYY-MM-dd");
		// 判断传入参数是否为null
		if (dto.getBeginTime() != null) {
			try {
				param.setBeginTime(new Timestamp(sdf_param.parse(dto.getBeginTime()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (dto.getEndTime() != null) {
			try {
				param.setEndTime(new Timestamp(sdf_param.parse(dto.getEndTime()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		param.setRowStart(dto.getRowStart());
		param.setOffset(dto.getOffset());
		// 判断是否为excel导出
		param.setIsDownFlag(dto.getIsDownFlag());

		Integer dataCount = payInfoDao.countPayInfoByUserId(param);
		result.setDataCount(dataCount);
		List<PayInfo> receives = payInfoDao.findPayInfoByUserId(param);
		List<PayInfoDataSet> dataList = new ArrayList<PayInfoDataSet>();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm");
		for (PayInfo payInfo : receives) {
			PayInfoDataSet data = new PayInfoDataSet();
			data.setPayInfoId(payInfo.getPayInfoId());
			data.setSerialNum(payInfo.getSerialNum());
			data.setCountPerson(payInfo.getCountPerson());
			data.setPayPrice(payInfo.getPayPrice());
			data.setManagePrice(payInfo.getManagePrice());
			data.setCreateTime(sdf.format(payInfo.getCreateTime()));
			dataList.add(data);
		}
		result.setDataList(dataList);
		return result;
	}

	/**
	 * 根据流水号查询账单明细
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public BillingDetailDataSet getBillingDetalilDataSet(BillingDto dto) {
		BillingDetailDataSet billing = new BillingDetailDataSet();
		ListResult listResult = new ListResult();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm");
		PayInfo payInfo = payInfoDao.getPayInfoBySerNum(dto.getSerialNum());
		Map<String, Object> params_list = new HashMap<String, Object>();
		params_list.put("serialNum", dto.getSerialNum());
		params_list.put("begin", dto.getRowStart());
		params_list.put("length", dto.getOffset());
		// excel导出时不用分页查询；addby zhouzy 20160427
		params_list.put("isDownFlag", dto.getIsDownFlag());
		List<MemberBillingDataSet> members = payInfoDao.findMemberBySerNum(params_list);
		Integer dataCount = payInfoDao.countMemberBySerNum(dto.getSerialNum());
		listResult.setDataCount(dataCount);
		listResult.setDataList(members);
		billing.setPayInfoId(payInfo.getPayInfoId());
		billing.setSerialNum(payInfo.getSerialNum());
		billing.setPayPrice(payInfo.getPayPrice());
		billing.setManagePrice(payInfo.getManagePrice());
		billing.setCountPerson(payInfo.getCountPerson());
		billing.setCreateTime(sdf.format(payInfo.getCreateTime()));
		billing.setMembers(listResult);
		return billing;
	}

}
