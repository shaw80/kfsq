package com.jzhl.kfsq.controller.sm;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzhl.kfsq.common.base.ResponseBean;
import com.jzhl.kfsq.dataset.sm.AccountDataSet;
import com.jzhl.kfsq.dto.sm.AccountDto;
import com.jzhl.kfsq.dto.sm.AccountNumDto;
import com.jzhl.kfsq.dto.sm.AccountReceiveDto;
import com.jzhl.kfsq.entity.mm.Member;
import com.jzhl.kfsq.entity.sm.Account;
import com.jzhl.kfsq.service.sm.IAccountService;

/**
 * 账号管理接口类
 * 
 * @author zhouzy
 *
 */
@Controller
public class AccountController {

	@Autowired
	private IAccountService accountService;

	private static final Logger logger = Logger
			.getLogger(AccountController.class);

	/**
	 * 开通代理商
	 * 
	 * @return ResponseBean
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/serv/account/insertaccount", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insertAccount(AccountDto accountDto) {
		try {
			Account account = new Account();
			BeanUtils.copyProperties(accountDto, account);
			accountService.insertAccount(account);
			ResponseBean result = new ResponseBean<Account>();
			result.operateSuccess();
			return result;
		} catch (Exception e) {
			logger.debug("[用户信息]--异常信息：" + e.getMessage());
			e.printStackTrace();
			ResponseBean<Object> result = new ResponseBean<Object>();
			result.operateFail("操作失败");
			return new ResponseBean(result);
		}
	}

	/**
	 * 根据会员编号和用户类型查询账户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/serv/account/getAccountByUserIdAndUserType", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AccountDataSet> getAccountByUserIdAndUserType(
			AccountReceiveDto dto) {

		ResponseBean<AccountDataSet> result = new ResponseBean<AccountDataSet>();

		Account account = accountService.getAccountByUserId(
				Integer.parseInt(dto.getUserId()), dto.getUserType(),
				dto.getAccountType());

		if (account != null) {

			AccountDataSet dataSet = new AccountDataSet();

			dataSet.setAccountId(account.getAccountId());

			dataSet.setAccountNum(account.getAccountNum());

			result = new ResponseBean<AccountDataSet>(dataSet);

			result.operateSuccess("查询成功");

		} else {

			result.operateSuccess("未填写账户信息");
		}

		return result;
	}

	/**
	 * 添加账户信息
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serv/account", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AccountDataSet> insertAccount(AccountReceiveDto dto)
			throws Exception {

		Account account = new Account();

		account.setUpdateUserId(Integer.parseInt(dto.getUserId()));

		account.setIsDefault(new Short(dto.getIsDefault()));

		account.setAccountType(dto.getAccountType());

		account.setAccountNum(dto.getAccountNum());

		account.setUserId(Integer.parseInt(dto.getUserId()));

		accountService.insertAccount(account);

		AccountDataSet dataSet = new AccountDataSet();

		dataSet.setAccountId(account.getAccountId());

		dataSet.setAccountNum(account.getAccountNum());

		ResponseBean<AccountDataSet> result = new ResponseBean<AccountDataSet>(
				dataSet);

		result.operateSuccess("添加成功");

		return result;
	}

	/**
	 * 会员更新账户信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/account/m", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<AccountDataSet> updateAccount(AccountReceiveDto dto)
			throws Exception {

		Account account = new Account();

		account.setUpdateUserId(Integer.parseInt(dto.getUserId()));

		account.setIsDefault(new Short(dto.getIsDefault()));

		account.setAccountType(dto.getAccountType());

		account.setAccountId(Integer.parseInt(dto.getAccountId()));

		account.setAccountNum(dto.getAccountNum());

		account.setUserId(Integer.parseInt(dto.getUserId()));

		accountService.updateAccount(account);

		AccountDataSet dataSet = new AccountDataSet();

		dataSet.setAccountId(account.getAccountId());

		dataSet.setAccountNum(account.getAccountNum());

		ResponseBean<AccountDataSet> result = new ResponseBean<AccountDataSet>(
				dataSet);

		result.operateSuccess("更新成功");

		return result;
	}

	/**
	 * 根据账户编号查询账户信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/serv/account/accountId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Account> getAccount(AccountDto dto) {
		Account account = accountService.getAccount(dto.getAccountId());
		ResponseBean<Account> result = new ResponseBean<Account>(account);
		result.operateSuccess("查询成功");
		return result;
	}
	
	/**
	 * 根据支付宝等账户查询账户信息
	 * @param accountNum
	 * @return
	 */
	@RequestMapping(value = "/serv/account/accountNum", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Member> getAccountByAccountNum(AccountNumDto dto){
		Member member = accountService.getMemberByAccountNum(dto);
		ResponseBean<Member> result = new ResponseBean<Member>(member);
		result.operateSuccess("查询成功");
		return result;
	}

}
