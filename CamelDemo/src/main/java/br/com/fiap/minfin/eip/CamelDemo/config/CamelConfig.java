package br.com.fiap.minfin.eip.CamelDemo.config;

import org.apache.camel.spi.UuidGenerator;
import org.apache.camel.support.DefaultUuidGenerator;
import org.apache.camel.support.OffUuidGenerator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class CamelConfig {
    @Bean
    public UuidGenerator uuidCgenerator() {
        return new DefaultUuidGenerator();
    }

    public UuidGenerator offGenerator() {
        return new OffUuidGenerator();
    }
}
