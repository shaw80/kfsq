package com.jzhl.kfsq.common.base;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis操作模板抽象类。<br/>
 * <br/>
 * 
 * 【功能详细】<br/>
 * <ol>
 * <li>Redis操作模板抽象类。</li>
 * <p>
 * 1.Redis设置key value内容。 
 * 2.edis取得key对应内容。 
 * 3.Redis清除key对应内容。 
 * </p>
 * </ol>
 * 
 * @author jzhl haojr
 * @version V1.0 2015/11/25 haojr<br/>
 */
public abstract class AbstractBaseRedisDAO<K, V> {

	/**
	 * Redis操作模板对象
	 */
	protected RedisTemplate<K, V> redisTemplate = null;

	/**
	 * Redis操作模板对象实例化
	 * 
	 * @param K Redis数据key
	 * @param V Redis数据Value
	 */
	public AbstractBaseRedisDAO(K key, V value) {
		this.redisTemplate = SpringContextHolder.getBean("redisTemplate");
	}

	/**
	 * Redis设置key value内容
	 * 
	 * @param K Redis数据key
	 * @param V Redis数据Value
	 */	
	public void addOrUpdateValue(K key, V value) {
		this.redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * Redis取得key对应内容
	 * 
	 * @param K Redis数据key
	 * @return 数据内容
	 */	
	public V loadValue(K key) {
		return this.redisTemplate.opsForValue().get(key);
	}

	/**
	 * Redis清除key对应内容
	 * 
	 * @param K Redis数据key
	 */		
	public void delete(K key) {
		this.redisTemplate.delete(key);
	}

}
