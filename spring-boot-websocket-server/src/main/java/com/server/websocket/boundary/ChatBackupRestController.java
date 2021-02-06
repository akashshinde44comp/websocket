package com.server.websocket.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.websocket.entity.Echo;
import com.server.websocket.entity.EchoRepository;

import java.util.List;

@RequestMapping("/api/echo")
@RestController
public class ChatBackupRestController {

    private final EchoRepository echoRepository;

    public ChatBackupRestController(EchoRepository echoRepository) {
        this.echoRepository = echoRepository;
    }

    @GetMapping
    public List<Echo> get() {
        return echoRepository.findAll();
    }
}
