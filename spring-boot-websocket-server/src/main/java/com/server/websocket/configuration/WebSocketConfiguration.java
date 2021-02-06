package com.server.websocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.server.websocket.boundary.EchoWebSocket2;
import com.server.websocket.boundary.ServerWebSocket;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //registry.addHandler(unitWebSocketHandler, "/unit").setAllowedOrigins("*");
    }

    @Bean
    public ServerWebSocket serverWebSocket() {
        return new ServerWebSocket();
    }
    
    @Bean
    public EchoWebSocket2 echoWebSocket2() {
        return new EchoWebSocket2();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
