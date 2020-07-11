package order.umbrella_rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RentStrategyCache {

    private static final String REDIS_PREFIX = "rent-";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setRentStrategy(RentStrategyEntity entity) {
        redisTemplate.opsForValue().set(REDIS_PREFIX+entity.getRackId(), entity);
    }

    public void deleteRentStrategy(Long rackId) {
        redisTemplate.delete(REDIS_PREFIX + rackId);
    }
}
