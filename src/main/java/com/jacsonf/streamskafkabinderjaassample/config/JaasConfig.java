package com.jacsonf.streamskafkabinderjaassample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class JaasConfig {

    private static final String JAAS_CONFIG = "java.security.auth.login.config";
    private static final String JAAS_CONF_PATH = "jaas.conf";

    @Value("${jaas.conf.user}")
    private String userKafka;

    @Value("${jaas.conf.password}")
    private String passwordKafka;

    @Bean
    public void configureJaas() throws IOException {

        String jaasConf = createJaasConfigContent();

        Path path = Paths.get(JAAS_CONF_PATH);

        Files.write(path, jaasConf.getBytes(StandardCharsets.UTF_8));

        System.setProperty(JAAS_CONFIG, JAAS_CONF_PATH);
    }

    private String createJaasConfigContent() {
        return String.format("KafkaClient {\n" +
                "org.apache.kafka.common.security.plain.PlainLoginModule required\n" +
                "username=\"%s\"\n" +
                "password=\"%s\";\n};", userKafka, passwordKafka);
    }
}
