package cn.jpush.api.examples;

import org.apache.log4j.Logger;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushExample {
	protected static final Logger LOG = Logger.getLogger(PushExample.class);

	// demo App defined in resources/jpush-api.conf
	private static final String appKey = Parameter.appKey;
	private static final String masterSecret = Parameter.masterSecret;

	public static final String TITLE = "Test from API example";// 通知标题
	public static final String ALERT = "Test from API Example - alert";// notification
																		// 通知内容
	public static final String MSG_CONTENT = "Test from API Example - msgContent";// message
																					// 消息内容本身
	public static final String REGISTRATION_ID = "0900e8d85ef";// 唯一标识
	public static final String TAG = "tag_api";

	public static void main(String[] args) {
		testSendPush();
	}

	public static void testSendPush() {
		// HttpProxy proxy = new HttpProxy("localhost", 3128);
		// Can use this https proxy: https://github.com/Exa-Networks/exaproxy
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 1);

		// For push, all you need do is to build PushPayload object.
		// PushPayload payload = buildPushObject_all_all_alert();
		PushPayload payload = buildPushObject_android_tag_alertWithTitle();
		System.out.println("=============" + payload);
		try {
			PushResult result = jpushClient.sendPush(payload);// 推送
			LOG.info("Got result - " + result);

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
		}
	}

	/**
	 * 快捷地构建推送对象:所有平台，所有设备，内容为 ALERT 的通知
	 */
	public static PushPayload buildPushObject_all_all_alert() {
		return PushPayload.alertAll(ALERT);
	}

	/**
	 * 构建推送对象:所有平台
	 */
	public static PushPayload buildPushObject_all_alias_alert() {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias("alias1"))// 推送目标是别名为
																											// "alias1"
				.setNotification(Notification.alert(ALERT))// 通知内容为 ALERT
				.build();
	}

	/**
	 * 构建推送对象:平台是 Android
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle() {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag("tag1"))// tag1是目标tag为tag1的设备
				.setNotification(Notification.android(ALERT, TITLE, null))// 内容是
																			// Android
																			// 通知
																			// ALERT，并且标题为
																			// TITLE
				.build();
	}

	public static PushPayload buildPushObject_android_and_ios() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag("tag1"))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert("alert content")
								.addPlatformNotification(AndroidNotification.newBuilder().setTitle("Android Title").build())
								.addPlatformNotification(
										IosNotification.newBuilder().incrBadge(1).addExtra("extra_key", "extra_value").build()).build())
				.build();
	}

	/**
	 * 构建推送对象:平台是 iOS
	 */
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.tag_and("tag1", "tag_all"))// 推送目标是
																													// "tag1",
																													// "tag_all"
																													// 的交集
				.setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(ALERT)// 通知信息ALERT
						.setBadge(5)// 角标数字为 5
						.setSound("happy")// 通知声音为 "happy"
						.addExtra("from", "JPush")// 附加字段 from = "JPush"
						.build()).build()).setMessage(Message.content(MSG_CONTENT))// 消息内容是
																					// MSG_CONTENT
				.setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
	}

	/**
	 * 构建推送对象:平台是 Andorid 与 iOS
	 */
	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
		return PushPayload.newBuilder().setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))// 推送目标是
																										// （"tag1"
																										// 与
																										// "tag2"
																										// 的并集）且（"alias1"
																										// 与
																										// "alias2"
																										// 的并集）
						.addAudienceTarget(AudienceTarget.alias("alias1", "alias2")).build())
				.setMessage(Message.newBuilder().setMsgContent(MSG_CONTENT)// 内容为
																			// MSG_CONTENT
																			// 的消息
						.addExtra("from", "JPush")// 附加字段 from = JPush
						.build()).build();
	}

}
