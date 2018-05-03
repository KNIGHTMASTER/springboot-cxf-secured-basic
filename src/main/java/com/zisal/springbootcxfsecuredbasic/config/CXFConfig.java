package com.zisal.springbootcxfsecuredbasic.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml"})
public class CXFConfig {


    @Autowired
    private ApplicationContext ctx;

    private static final Logger LOGGER = LoggerFactory.getLogger(CXFConfig.class);

    @Value("${cxf.log.request}")
    private boolean logRequests;

    @Bean
    public Server jaxRsServer() {
        // Find all beans annotated with @Path
        List<Object> serviceBeans = new ArrayList<>(ctx.getBeansWithAnnotation(Path.class).values());
        LOGGER.info("Registering service beans: {}" , serviceBeans);

        // Find all beans annotated with @Providers
        List<Object> providers = new ArrayList<>(ctx.getBeansWithAnnotation(Provider.class).values());
        LOGGER.info("Registering providers: {}",  providers);

        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setBus(ctx.getBean(SpringBus.class));
        factory.setAddress("/v1");
        factory.setServiceBeans(serviceBeans);
        factory.setProviders(providers);
        Server server = factory.create();

        if (logRequests) {
            server.getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
        }
        return server;
    }
    @Bean
    @ConditionalOnMissingBean
    public JacksonJsonProvider jsonProvider(ObjectMapper objectMapper) {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(objectMapper);
        return provider;
    }

    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
