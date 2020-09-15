package com.rdsWebExample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.rdsWebExample.domain.Vehicle;

@Configuration //usamos la anotacion configuration
@EnableCaching
public class RedisConf {
	
    @Value("${redis.hostname}")
    private String redisHostName;
 
    @Value("${redis.port}")
    private int redisPort;
 
    @Value("${redis.prefix}")
    private String redisPrefix;
	
	
	//cargamos los Beans
	@Bean//permite crear la conexion a la base de datos
	JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName, redisPort);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
	};
	//Redis template key, value-> ¿que vamos a persistir?
	@Bean
	RedisTemplate<String,Vehicle> redisTemplate(){
		final RedisTemplate<String,Vehicle> redisTemplate= new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		//al objeto redis template le pasamos como referencia el bean creado anteriormente
		return redisTemplate;
	};
	

}
