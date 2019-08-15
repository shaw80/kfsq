package com.jzhl.kfsq.common.base;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import com.jzhl.kfsq.common.util.SerializingUtil;
import com.jzhl.kfsq.common.util.ValidateUtil;

/**
 * Redis原生操作类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>Redis原生操作。</li>
 * <p>
 * 1.Redis设置key value内容。 
 * 2.edis取得key对应内容。 
 * 3.Redis清除key对应内容。 
 * 4.Redis根据key模糊匹配查询。 
 * 5.Redis批量插入数据。
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2015/11/11 haojr<br/>
 */
public class RedisOperator {

	/**
	 * 日志输出
	 */
	private static final Logger logger = Logger.getLogger(RedisOperator.class);

	/**
	 * Redis连接池
	 */
	protected static JedisPool jedisPool = SpringContextHolder
			.getBean("jedisPool");

	/**
	 * Redis设置key value内容
	 * 
	 * @param key
	 * @param value
	 */
	public static void addOrUpdateValue(String key, Object value) {

		if (ValidateUtil.isEmpty(key)) {
			throw new RuntimeException("数据更新失败");
		}

		logger.debug("addOrUpdate key:" + key);
		Jedis jedis = jedisPool.getResource();
		if (value == null) {
			logger.debug("value:");
			jedis.del(key);
		} else if (value instanceof String) {
			logger.debug("value:" + value.toString());
			jedis.set(key.getBytes(), String.valueOf(value).getBytes());
		} else {
			logger.debug("value:" + value.toString());
			jedis.set(key.getBytes(), SerializingUtil.serialize(value));
		}
		jedis.close();

	}

	/**
	 * Redis取得key对应内容
	 * 
	 * @param key
	 * @return value
	 */
	public static String loadValue(String key) {

		if (ValidateUtil.isEmpty(key)) {
			throw new RuntimeException("数据获取失败");
		}

		logger.debug("loadValue key:" + key);

		Jedis jedis = jedisPool.getResource();
		String value = jedis.get(key);
		jedis.close();

		logger.debug("loadValue value:" + value);

		return "null".equals(value) ? "" : value;

	}

	/**
	 * Redis清除key对应内容
	 * 
	 * @param key
	 */
	public static void delete(String key) {

		if (ValidateUtil.isEmpty(key)) {
			throw new RuntimeException("数据清除失败");
		}

		logger.debug("delete key:" + key);

		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);

		logger.debug("delete result:" + result);

	}

	/**
	 * Redis根据key模糊匹配查询
	 * 
	 * @param pattern
	 * @return 模糊匹配结果
	 */
	public static Set<String> getValuesByLike(String pattern) {

		if (ValidateUtil.isEmpty(pattern)) {
			throw new RuntimeException("数据获取失败");
		}

		logger.debug("getValuesByLike pattern:" + pattern);

		Jedis jedis = jedisPool.getResource();
		Set<String> results = jedis.keys(pattern);
		jedis.close();

		logger.debug("getValuesByLike results:" + results);

		return results;

	}

	/**
	 * Redis批量插入数据
	 * 
	 * @param params
	 *            批量数据
	 */
	public static void addOrUpdateValue(Map<String, Object> params)
			throws IOException {

		if (ValidateUtil.isEmpty(params)) {
			return;
		}

		logger.debug("addOrUpdateValue batch:" + params);

		Jedis jedis = jedisPool.getResource();
		Transaction tx = jedis.multi();
		for (String key : params.keySet()) {
			if (ValidateUtil.isEmpty(key)) {
				continue;
			}
			Object value = params.get(key);
			if (value == null) {
				tx.del(key);
			} else if (value instanceof String) {
				tx.set(key.getBytes(), String.valueOf(value).getBytes());
			} else {
				tx.set(key.getBytes(), SerializingUtil.serialize(value));
			}
		}
		List<Object> results = tx.exec();
		logger.debug("addOrUpdateValue batch:" + results);
		tx.close();
		if (jedis != null) {
			jedis.close();
		}

	}

}
