package com.mobileservice.api.s3client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class S3Config {
    @Value("${s3.access.name}")
    String accessKey;
    @Value("${s3.access.secret}")
    String accessSecret;

    @Bean
    public AmazonS3Client generateS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey,accessSecret);
        AmazonS3Client client = new AmazonS3Client(credentials);
        return client;
    }
}