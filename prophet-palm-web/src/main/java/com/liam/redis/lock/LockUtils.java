package com.liam.redis.lock;//package com.redis.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:redis实现分布式所，可避免客户端挂掉，出现死锁的情况
 * Created by prophet on 2019/8/9 14:35
 */
@Service
public class LockUtils {
    @Resource
    private RedisTemplate<String, String> redisTemplate;


    public boolean lock(String key, int expire) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        long time = System.currentTimeMillis() + expire;
        Boolean notExist = valueOperations.setIfAbsent(key, String.valueOf(time));
        if (notExist) {
            return true;
        }
        //已经存在，但是可能是超时的，校验下
        long oldExpireTime = Long.valueOf(valueOperations.get(key));
        if (oldExpireTime < System.currentTimeMillis()) {
            //超时
            long newExpireTime = System.currentTimeMillis() + expire;
            long currentExpireTime = Long.valueOf(valueOperations.getAndSet(key, String.valueOf(newExpireTime)));
            //这里校验下currentExpireTime与olsExpireTime，防止其他服务获取了锁
            if (currentExpireTime == oldExpireTime) {
                return true;
            }
        }
        return false;
    }

    public Boolean unLock(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        long oldExpireTime = Long.valueOf(valueOperations.get(key));
        if (oldExpireTime > System.currentTimeMillis()) {
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }

}

