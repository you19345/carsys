package com.du.car.util;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 20:31
 **/
@Repository
public class JedisUtil {
    private static JedisPool jedisPool;
    private Jedis jedis;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10); // 最大空闲客户端连接对象数量
        poolConfig.setMaxTotal(1000);//最大的客户端连接对象
        poolConfig.setMaxWaitMillis(2000);//最多等待时间 毫秒
        jedisPool = new JedisPool(poolConfig, "39.105.189.141", 6380);
    }

    public JedisUtil() {
        jedis = jedisPool.getResource();
        jedis.auth("qfjava");
    }

    /**
     * 新增string字符串
     *
     * @param key key键
     * @param val 值
     */
    public void addStr(String key, String val) {
        jedis.set(key, val);
    }

    public void addStr(String key, String val, int seconds) {
        jedis.psetex(key, seconds * 1000, val);
    }

    /**
     * 新增list集合
     *
     * @param key
     * @param arr list集合
     */
    public void addList(String key, String... arr) {
        jedis.lpush(key, arr); //添加到头部
//        jedis.rpush(key, arr); // 添加到尾部
    }

    /**
     * 新增set 集合
     *
     * @param key
     * @param arr set集合
     */
    public void addSet(String key, String... arr) {
        jedis.sadd(key, arr);
    }

    //新增-有序Set ZSet SortSet
    public void addZSet(String key, double score, String val) {
        jedis.zadd(key, score, val);
    }

    //新增-Hash
    public void addHash(String key, String field, String val) {
        jedis.hset(key, field, val);
    }

    //删除
    public void del(String key) {
        jedis.del(key);
    }

    //删除集合数据
    public void delList(String key, String v) {
        jedis.lrem(key, 1, v);
    }

    //查询
    public String getStr(String key) {
        return jedis.get(key);
    }

    public List<String> getList(String key) {
        return jedis.lrange(key, 0, -1);
    }

    public Set<String> getSet(String key) {
        return jedis.smembers(key);
    }

    public Map<String, String> getHash(String key) {
        return jedis.hgetAll(key);
    }

    //检查
    public boolean checkHash(String key, String f) {
        return jedis.hexists(key, f);
    }

    public boolean checkKey(String key) {
        return jedis.exists(key);
    }

    //设置有效期
    public void setExpire(String key, int seconds) {
        jedis.expire(key, seconds);
    }

    //查询剩余有效期  毫秒
    public long ttl(String key) {
        return jedis.ttl(key);
    }
}
