package com.jzhl.kfsq.service.mm.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzhl.kfsq.common.util.StringEncrypt;
import com.jzhl.kfsq.dao.mm.IMemberMapper;
import com.jzhl.kfsq.dataset.mm.MemberStatisticalDataSet;
import com.jzhl.kfsq.dataset.mm.MemberVisitDataSet;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.service.mm.IMemberService;

/**
 * 用户业务层实现类
 * 
 * @author zhouzy
 *
 */
@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberMapper memberDao;

	public void insertMember(Member member) {

		// 口令MD5加密
		String password = member.getPassword();
		member.setPassword(StringEncrypt.MD5(password));
		memberDao.insertMember(member);

	}

	/**
	 * 修改用户
	 * 
	 * 用户实体类
	 */
	@Override
	public void updateMember(Member member) {
		// 口令MD5加密
		if (member.getPassword() != null) {
			String password = member.getPassword();
			member.setPassword(StringEncrypt.MD5(password));
		}
		memberDao.updateMember(member);
	}

	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @return 用户实体类
	 */

	@Override
	public Member getMember(Member param) {

		// 口令MD5加密
		String password = param.getPassword();
		param.setPassword(StringEncrypt.MD5(password));

		Member member = memberDao.getMember(param);
		return member;
	}

	/**
	 * 查询全部用户
	 * 
	 * @return 用户集合
	 */
	@Override
	public List<Member> getMemberList(Map<String, Object> map) {
		List<Member> result = memberDao.getMemberList(map);
		return result;
	}

	/**
	 * 用户统计
	 * 
	 * @return 用户统计
	 */
	@Override
	public MemberStatisticalDataSet getMemberStatistical(Map<String, Object> map) {
		MemberStatisticalDataSet memberStatistical = memberDao.getMemberStatistical(map);
		return memberStatistical;
	}

	/**
	 * 用户统计
	 * 
	 * @return 用户统计
	 */
	@Override
	public List<Member> findMemberDataCount(Map<String, Object> map) {
		List<Member> result = memberDao.findMemberDataCount(map);
		return result;
	}

	/**
	 * 获取用户详情_包含到访记录
	 */
	@Override
	public Member getMemberInfo(Member param) {
		Member member = memberDao.getMemberInfo(param);
		return member;
	}

	/**
	 * 获取到访记录列表
	 */
	@Override
	public List<MemberVisitDataSet> findMemberVisitList(Map<String, Object> map) {
		List<MemberVisitDataSet> result = memberDao.findMemberVisitList(map);
		return result;
	}

	/**
	 * 获取到访记录列表总数
	 */
	@Override
	public int findMemberVisitDataCount(Map<String, Object> map) {
		int dataCount = memberDao.findMemberVisitDataCount(map);
		return dataCount;
	}

	/**
	 * 按照某年月份统计用户总数
	 * 
	 */
	@Override
	public List<MemberStatisticalDataSet> findMemberNumList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findMemberNumList(statisticalDto);
		return result;
	}

	/**
	 * 按照月份分组查询加入计划数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findPlanNumList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findPlanNumList(statisticalDto);
		return result;
	}

	/**
	 * 按照月份分组查询到访数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findVisitNumList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findVisitNumList(statisticalDto);
		return result;
	}

	/**
	 * 按照月份分组查询看房评论圈数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findBuildingCommentNumList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findBuildingCommentNumList(statisticalDto);
		return result;
	}

	/**
	 * 按照月份分组查询看房圈关注数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findFollowNumList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findFollowNumList(statisticalDto);
		return result;
	}

	/**
	 * 查寻总列表统计数据
	 */
	@Override
	public Member getListNum(Map<String, Object> map) {
		Member member = memberDao.getListNum(map);
		return member;
	}

	/**
	 * 某楼盘一个星期内按天分组查询到访数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findVisitNumByDayList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findVisitNumByDayList(statisticalDto);
		return result;
	}

	/**
	 * 某楼盘一个月内按周分组查询到访数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findVisitNumByWeekList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findVisitNumByWeekList(statisticalDto);
		return result;
	}

	/**
	 * 某楼盘六个月内按月分组查询到访数量
	 */
	@Override
	public List<MemberStatisticalDataSet> findVisitNumByMonthList(StatisticalDto statisticalDto) {
		List<MemberStatisticalDataSet> result = memberDao.findVisitNumByMonthList(statisticalDto);
		return result;
	}

}
