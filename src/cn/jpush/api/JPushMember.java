package cn.jpush.api;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * @author zhouzy
 *
 */
public class JPushMember {
	protected static final Logger LOG = Logger.getLogger(JPushMember.class);

	private static final String appKey = "0e64dfed29035a0371451e2d";
	private static final String masterSecret = "ad46643218a09c368dd1e201";

	public static void main(String[] args) {
//		send("精致互联，用户端测试", "" ,"","");
		
		JSONObject json = new JSONObject();
		json.put("pushType", "manualPushType");
		json.put("pushId", "2");
		send("群推测试", "收到了么？", json.toString() );
	}

	// 群推
	public static boolean send(String msgTitle, String msgContent, String value) {
		/** 建立推送连接对象 */
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 1);
		/** 建立推送对象 */
		PushPayload pushPayload = buildPushObject_all_alert(msgTitle, msgContent, value);
		LOG.info("Payload is ==" + pushPayload);
		try {
			/** 推送对象获取结果 */
			PushResult result = jpushClient.sendPush(pushPayload);
			LOG.info("Got result -" + result);
		} catch (APIConnectionException e) {
			LOG.error("JPush Connection error. Should retry later. ", e);
			return false;
		} catch (APIRequestException e) {
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
			return false;
		}
		return true;
	}

	// 群推方法
	public static PushPayload buildPushObject_all_alert(String msgTitle, String msgContent, String value) {
		return PushPayload.newBuilder().setPlatform(Platform.all())// 设置接受的平台
				.setAudience(Audience.all())// Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
				.setNotification(
						Notification.newBuilder()
						.addPlatformNotification(
								IosNotification.newBuilder()
								.setAlert(msgTitle)
								.addExtra("pushType", value)
								.build())
						.addPlatformNotification(AndroidNotification.newBuilder()  
                                .setAlert(msgTitle)
                                .addExtra("pushType", value)
                                .build())
						.build())
				.setMessage(Message.newBuilder().setMsgContent(msgContent).build())
				.build();
	}

	// 个推
	public static boolean aliasSend(String alias, String msgTitle, String msgContent, String value) {
		/** 建立推送连接对象 */
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 1);
		/** 建立推送对象 */
		PushPayload pushPayload = buildPushObject_all_alias_alert(alias, msgTitle, msgContent, value);
		LOG.info("Payload is ==" + pushPayload);
		try {
			/** 推送对象获取结果 */
			PushResult result = jpushClient.sendPush(pushPayload);
			LOG.info("Got result -" + result);
		} catch (APIConnectionException e) {
			LOG.error("JPush Connection error. Should retry later. ", e);
			return false;
		} catch (APIRequestException e) {
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
			return false;
		}
		return true;
	}

	// 个推方法
	public static PushPayload buildPushObject_all_alias_alert(String alias, String msgTitle, String msgContent, String value) {
		return PushPayload.newBuilder()
				.setPlatform(Platform.all()) // 设置接受的平台
				.setAudience(Audience.alias(alias)) // 设置别名alias为123的受众，单发
				.setNotification( Notification.newBuilder()
						.addPlatformNotification( IosNotification.newBuilder()
													.setAlert(msgTitle)
													.addExtra("pushType", value)
													.build())
						.addPlatformNotification(AndroidNotification.newBuilder()  
							                        .setAlert(msgTitle)
							                        .addExtra("pushType", value)
							                        .build())
				        .build())
				.setMessage(Message.newBuilder().setMsgContent(msgContent).build())
				.build();
	}
}
