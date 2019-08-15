package com.jzhl.kfsq.service.mm;

import java.util.List;
import java.util.Map;

import com.jzhl.kfsq.dataset.mm.MemberStatisticalDataSet;
import com.jzhl.kfsq.dataset.mm.MemberVisitDataSet;
import com.jzhl.kfsq.dto.sm.StatisticalDto;
import com.jzhl.kfsq.entity.mm.Member;

/**
 * 用户业务层接口
 * 
 * @author zhouzy
 *
 */
public interface IMemberService {

	/**
	 * 添加会员
	 * 
	 * @param member
	 */
	public void insertMember(Member member);

	/**
	 * 禁用、启用用户
	 * 
	 * 用户实体类
	 */
	public void updateMember(Member member);

	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @return 用户实体类
	 */
	public Member getMember(Member member);

	/**
	 * 查询
	 * 
	 * @return 用户集合
	 */
	public List<Member> getMemberList(Map<String, Object> map);

	/**
	 * 查询
	 * 
	 * @return 用户统计
	 */
	public MemberStatisticalDataSet getMemberStatistical(Map<String, Object> mapp);

	/**
	 * 查询用户列表总数
	 * 
	 */
	public List<Member> findMemberDataCount(Map<String, Object> map);

	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @return 用户实体类
	 */
	public Member getMemberInfo(Member member);

	/**
	 * 根据用户编号查询用户到访记录信息
	 * 
	 * @return 用户实体类集合
	 */
	public List<MemberVisitDataSet> findMemberVisitList(Map<String, Object> map);

	/**
	 * 查询用户到访记录列表总数
	 * 
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
	public Member getListNum(Map<String, Object> mapp);

	/**
	 * 某楼盘一个星期内按天分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumByDayList(StatisticalDto statisticalDto);

	/**
	 * 某楼盘一个月内按周分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumByWeekList(StatisticalDto statisticalDto);

	/**
	 * 某楼盘六个月内按月分组查询到访数量
	 */
	public List<MemberStatisticalDataSet> findVisitNumByMonthList(StatisticalDto statisticalDto);

}
