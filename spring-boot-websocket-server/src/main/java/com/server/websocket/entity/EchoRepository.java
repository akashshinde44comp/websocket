package com.server.websocket.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EchoRepository extends JpaRepository<Echo, Integer> {
}
