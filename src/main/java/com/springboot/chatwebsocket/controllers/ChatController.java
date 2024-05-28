package com.springboot.chatwebsocket.controllers;


import com.springboot.chatwebsocket.models.documents.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message) {

        message.setFecha(new Date().getTime());
        message.setTexto("Recibido por el Broker: " + message.getTexto());

        return message;
    }

}
