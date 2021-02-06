package com.server.websocket.boundary;

import com.server.websocket.configuration.SpringContext;
import com.server.websocket.entity.Echo;
import com.server.websocket.entity.EchoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/userchat")
public class EchoWebSocket2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoWebSocket2.class);

    private final EchoRepository echoRepository;

    public EchoWebSocket2() {
        this.echoRepository = (EchoRepository) SpringContext.getApplicationContext().getBean("echoRepository");
    }

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.info("onOpen " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws InterruptedException {
        try {
            LOGGER.info("onMessage From=" + session.getId());
            LOGGER.info("onMessage Message=" + message);
            Echo echo = new Echo();
            echo.setText(message);
            echoRepository.saveAndFlush(echo);
            Thread.sleep(5000);
            session.getBasicRemote().sendText(message.toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        LOGGER.info("onClose " + session.getId());
    }

    @OnError
    public void onError(Throwable t) {
        LOGGER.error(t.getMessage(), t);
    }
}