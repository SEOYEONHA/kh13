package com.kh.spring19.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
@ConfigurationProperties(prefix = "custom.jwt")
public class JwtProperties {
	private String keyStr;
	private int expireHour;
	private String issuer;
}
