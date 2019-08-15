package com.jzhl.kfsq.dao.mm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.mm.MemberStatisticalDataSet;
import com.jzhl.kfsq.dataset.mm.MemberVisitDataSet;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.mm.Member;

public interface IMemberMapper {

	/**
	 * 添加会员
	 * 
	 * @param member
	 */
	public void insertMember(Member member);

	/**
	 * 编辑会员
	 * 
	 * @param member
	 */
	public void updateMember(Member member);

	/**
	 * 根据条件查询会员
	 * 
	 * @param id
	 * @return
	 */
	public Member getMember(Member member);

	/**
	 * 根据条件查询会员列表
	 * 
	 * @param map
	 * @return 会员列表
	 */
	public List<Member> getMembers(Map<String, Object> map);

	/**
	 * 查询全部用户
	 * 
	 * @return 用户集合
	 */
	public List<Member> getMemberList(Map<String, Object> map);
	
	/**
	 * 根据名称查询会员
	 * @param map
	 * @return
	 */
	public List<Member> findMemberByName(Map<String, Object> param);

	/**
	 * 用戶統計
	 * 
	 * @return 用户統計
	 */
	public MemberStatisticalDataSet getMemberStatistical(Map<String, Object> map);

	/**
	 * 用戶列表总数
	 * 
	 */
	public List<Member> findMemberDataCount(Map<String, Object> map);

	/**
	 * 根据条件查询会员
	 * 
	 * @param id
	 * @return
	 */
	public Member getMemberInfo(Member param);

	/**
	 * 获取到访记录列表
	 */
	public List<MemberVisitDataSet> findMemberVisitList(Map<String, Object> map);

	/**
	 * 获取到访记录列表总数
	 */
	public int findMemberVisitDataCount(Map<String, Object> map);

	/**
	 * 按照某年月份统计用户总数
	 * 
	 */
	public List<MemberStatisticalDataSet> findMemberNumList(StatisticalDto statisticalDto);

	/**
	 * 按照月份分组查询加入计划数量
	 */
	public List<MemberStatisticalDataSet> findPlanNumList(StatisticalDto statisticalDto);

	/**
	 * 按照月份分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumList(StatisticalDto statisticalDto);

	/**
	 * 按照月份分组查询看房评论圈数量
	 */
	public List<MemberStatisticalDataSet> findBuildingCommentNumList(StatisticalDto statisticalDto);

	/**
	 * 按照月份分组查询看房圈关注数量
	 */
	public List<MemberStatisticalDataSet> findFollowNumList(StatisticalDto statisticalDto);

	/**
	 * 查寻总列表统计数据
	 */
	public Member getListNum(Map<String, Object> map);

	/**
	 * 某楼盘一个星期内按天分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumByDayList(StatisticalDto statisticalDto);

	/**
	 * 某楼盘一个月内按周分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumByWeekList(StatisticalDto statisticalDto);

	/**
	 * 某楼盘一个月内按月分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumByMonthList(StatisticalDto statisticalDto);

}
