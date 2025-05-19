package com.example.learnical.core.cache.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext

@Configuration
class RedisCacheConfig {

    @Bean
    fun lyricCacheConfig(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig()
            .disableCachingNullValues()
            .serializeValuesWith(RedisSerializationContext
                .SerializationPair
                .fromSerializer(GenericJackson2JsonRedisSerializer()))
            .prefixCacheNameWith("lyrics::")

    }

    @Bean
    fun cacheManager(
        redisConnectionFactory: RedisConnectionFactory,
        lyricCacheConfig: RedisCacheConfiguration
    ): RedisCacheManager {
        return RedisCacheManager.builder(redisConnectionFactory)
            .cacheDefaults(lyricCacheConfig)
            .build()
    }
}