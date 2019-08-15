package com.jzhl.kfsq.dto.fm;
/**
 * 支付宝回调函数里红包领取DTO
 * @author Shaw
 *
 */
public class EnvelopeReceiveCallBackDto {
	
	private int receiveId;// 领取编号
	
	private int status;// 状态

	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EnvelopeReceiveCallBackDto [receiveId=" + receiveId
				+ ", status=" + status + "]";
	}

}
