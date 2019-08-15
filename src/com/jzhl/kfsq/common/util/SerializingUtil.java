package com.jzhl.kfsq.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 序列化操作类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>序列化操作类。</li>
 * <p>
 * 1.序列化对象。 
 * 2.反序列化对象。
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2015/11/25 haojr<br/>
 */
public class SerializingUtil {

	/**
	 * 日志输出
	 */
	private static Log logger = LogFactory.getLog(SerializingUtil.class);

	/**
	 * 功能简述: 对实体Bean进行序列化操作.
	 * 
	 * @param source
	 *            待转换的实体
	 * @return 转换之后的字节数组
	 * @throws Exception
	 */
	public static byte[] serialize(Object source) {
		ByteArrayOutputStream byteOut = null;
		ObjectOutputStream ObjOut = null;
		try {
			byteOut = new ByteArrayOutputStream();
			ObjOut = new ObjectOutputStream(byteOut);
			ObjOut.writeObject(source);
			ObjOut.flush();
		} catch (IOException e) {
			logger.error(source.getClass().getName() + " serialized error!", e);
		} finally {
			try {
				if (null != ObjOut) {
					ObjOut.close();
				}
			} catch (IOException e) {
				ObjOut = null;
			}
		}
		return byteOut.toByteArray();
	}

	/**
	 * 功能简述: 将字节数组反序列化为实体Bean.
	 * 
	 * @param source
	 *            需要进行反序列化的字节数组
	 * @return 反序列化后的实体Bean
	 * @throws Exception
	 */
	public static Object deserialize(byte[] source) {
		ObjectInputStream ObjIn = null;
		Object retVal = null;
		try {
			ByteArrayInputStream byteIn = new ByteArrayInputStream(source);
			ObjIn = new ObjectInputStream(byteIn);
			retVal = ObjIn.readObject();
		} catch (Exception e) {
			logger.error("deserialized error!", e);
		} finally {
			try {
				if (null != ObjIn) {
					ObjIn.close();
				}
			} catch (IOException e) {
				ObjIn = null;
			}
		}
		return retVal;
	}

}
