package com.jzhl.kfsq.controller.mm;

import java.sql.Timestamp;
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
import com.jzhl.kfsq.common.util.StringEncrypt;
import com.jzhl.kfsq.common.util.ValidateUtil;
import com.jzhl.kfsq.dataset.mm.MemberDataSet;
import com.jzhl.kfsq.dataset.mm.MemberVisitDataSet;
import com.jzhl.kfsq.dto.mm.MemberDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.service.mm.IMemberCacheService;
import com.jzhl.kfsq.service.mm.IMemberService;

/**
 * 用户对外接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class MemberController {

	// private static final Logger logger =
	// Logger.getLogger(MemberController.class);

	@Autowired
	private IMemberService memberService;

	@Autowired
	private IMemberCacheService memberCacheService;

	/**
	 * 查询用户列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/member/memberlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getMemberList(MemberDto memberDto) throws Exception {

		// 城市
		String cityFlag = memberDto.getCityFlag();

		// 日期
		String dateFlag = memberDto.getDateFlag();
		String dateFlag7d = null;
		String dateFlag1m = null;
		String dateFlag3m = null;
		if (dateFlag != null && dateFlag.equals("1")) {
			dateFlag7d = "1";
		} else if (dateFlag != null && dateFlag.equals("2")) {
			dateFlag1m = "2";
		} else if (dateFlag != null && dateFlag.equals("3")) {
			dateFlag3m = "3";
		}
		String dateStart = memberDto.getDateStart();
		String dateEnd = memberDto.getDateEnd();
		// 关键字
		String keyword = memberDto.getKeyword();
		// 分站ID
		Integer branchId = memberDto.getBranchId();

		Map<String, Object> mapp = new HashMap<String, Object>();
		mapp.put("cityFlag", cityFlag);
		mapp.put("cityId", memberDto.getCityId());
		mapp.put("dateFlag7d", dateFlag7d);
		mapp.put("dateFlag1m", dateFlag1m);
		mapp.put("dateFlag3m", dateFlag3m);
		mapp.put("dateStart", dateStart);
		mapp.put("dateEnd", dateEnd);
		mapp.put("keyword", keyword);
		mapp.put("branchId", branchId);
		// 分页查询参数
		mapp.put("rowstart", memberDto.getRowStart());
		mapp.put("offset", memberDto.getOffset());
		mapp.put("isDownFlag", memberDto.getIsDownFlag());

		// 分页查询列表数据
		List<Member> memberlist = memberService.getMemberList(mapp);

		// 分页返回
		MemberDataSet listResult = new MemberDataSet();
		listResult.setDataList(memberlist);

		// 当查询数据不为null时统计
		if (memberlist.size() != 0) {
			// 查寻总列表统计数据
			Member listNum = memberService.getListNum(mapp);
			// 统计返回
			listResult.setPlanListNum(listNum.getPlanListNum());
			listResult.setVisitListNum(listNum.getVisitListNum());
			listResult.setFollowListNum(listNum.getFollowListNum());
			listResult.setBuildingCommentListNum(listNum.getBuildingCommentListNum());
		}

		// 总页数
		List<Member> memberlistCount = memberService.findMemberDataCount(mapp);
		int dataCount = memberlistCount.size();
		listResult.setDataCount(dataCount);

		ResponseBean<MemberDataSet> result = new ResponseBean<MemberDataSet>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询用户详情
	 * 
	 * @param memberId
	 * @return ResponseBean
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/member/memberinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getMemberInfo(MemberDto memberDto) throws Exception {
		Member member = new Member();
		BeanUtils.copyProperties(memberDto, member);
		Member queryResult = memberService.getMember(member);
		ResponseBean<Member> result = new ResponseBean<Member>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询用户详情_包含到访记录
	 * 
	 * @param memberId
	 * @return ResponseBean
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/serv/member/getmembervisitinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getMemberVisitInfo(MemberDto memberDto) throws Exception {

		Member member = new Member();
		BeanUtils.copyProperties(memberDto, member);
		Member queryResult = memberService.getMemberInfo(member);
		// 剩余红包额度=用总额-已领取的看房红包
		if (queryResult != null) {
			// 从配置文件中读取每人获取红包上限；
			// try {
			// Properties prop = new Properties();
			// InputStream in =
			// SystemConfig.class.getResourceAsStream("/system.properties");
			// BufferedReader bf = new BufferedReader(new
			// InputStreamReader(in));
			// prop.load(bf);
			// String upperboundEnveloppe =
			// prop.getProperty("MEMBER_ENVELOPPE_UPPERBOUND");
			// } catch (Exception e) {
			// e.printStackTrace();
			// logger.error("读取system.properties文件异常：" + e.getMessage());
			// }

			// 从代理商表中获取该城市每人领取红包的上限金额；
			if (queryResult.getUpperPrive() != null) {
				queryResult.setRestEnveloppe(queryResult.getUpperPrive() - queryResult.getLookEnveloppe()
						- queryResult.getCommentEnveloppe());
			} else {
				queryResult.setRestEnveloppe(queryResult.getUpperPrive());
			}
		}

		ResponseBean<Member> result = new ResponseBean<Member>(queryResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 查询用户到访记录列表
	 * 
	 * @param
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/member/findmembervisitlist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean findMemberVisitList(MemberDto memberDto) throws Exception {

		// 分页查询参数
		Map<String, Object> mapp = new HashMap<String, Object>();
		mapp.put("rowstart", memberDto.getRowStart());
		mapp.put("offset", memberDto.getOffset());
		// 用户memberId
		Integer memberId = memberDto.getMemberId();
		mapp.put("memberId", memberId);
		// 查询数据
		List<MemberVisitDataSet> memberlist = memberService.findMemberVisitList(mapp);
		// 分页返回
		ListResult listResult = new ListResult();
		listResult.setDataList(memberlist);
		// 总页数
		int dataCount = memberService.findMemberVisitDataCount(mapp);
		listResult.setDataCount(dataCount);
		ResponseBean<ListResult> result = new ResponseBean<ListResult>(listResult);
		result.operateSuccess();
		return result;
	}

	/**
	 * 启用、禁用用户
	 * 
	 * @param memberId
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/serv/member/updatememberinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateMemberInfo(MemberDto memberDto) throws Exception {
		Member member = new Member();
		BeanUtils.copyProperties(memberDto, member);
		if (ValidateUtil.isNotEmpty(memberDto.getLastLoginTime())) {
			member.setLastLogintime(new Timestamp(System.currentTimeMillis()));
		}

		// 如果是重置密码，则默认改为123456
		if (memberDto.getIsValid() == null && memberDto.getPassword() == null && memberDto.getLastLoginTime() == null
				&& memberDto.getAccount() == null && memberDto.getHeadPortrait() == null) {
			String md51 = StringEncrypt.encrypt("123456", "MD5");
			member.setPassword(md51);
		}
		memberService.updateMember(member);

		// 用户冻结时，清除缓存;重新开启时添加缓存
		if (memberDto.getIsValid() != null) {

			int isValid = member.getIsValid();
			member.setIsValid(null);

			Member queryResult = memberService.getMember(member);
			if (queryResult != null) {
				String account = queryResult.getAccount();
				if (isValid == 0) {
					memberCacheService.clearAccount(account);
				} else if (isValid == 1) {
					memberCacheService.addOrUpdate(queryResult);
				}
			}

		}

		ResponseBean result = new ResponseBean<Member>();
		result.operateSuccess();
		return result;

	}

	/**
	 * 添加会员
	 * 
	 * @param memberId
	 * @return ResponseBean
	 */
	@RequestMapping(value = "/serv/member/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Member> addMember(MemberDto memberDto) throws Exception {

		Member member = new Member();
		BeanUtils.copyProperties(memberDto, member);
		if (ValidateUtil.isEmpty(member.getPhone())) {
			member.setPhone(member.getAccount());
		}
		if (ValidateUtil.isEmpty(member.getNickName())) {
			member.setNickName("看房星人");
		}
		memberService.insertMember(member);
		// 向缓存中添加用户
		this.memberCacheService.addOrUpdate(member);
		ResponseBean<Member> result = new ResponseBean<Member>();
		result.operateSuccess();
		return result;

	}

}
