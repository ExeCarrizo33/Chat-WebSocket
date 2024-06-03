package com.springboot.chatwebsocket.controllers;

import com.springboot.chatwebsocket.models.documents.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    private String[] colores = {"red", "green", "blue", "yellow", "orange", "magenta", "cyan"};


    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje receiveMessage(Mensaje mensaje) {
        mensaje.setFecha(new Date().getTime());

        if (mensaje.getTipo().equals("NUEVO_USUARIO")){
            mensaje.setColor(colores[(int) (Math.random() * colores.length)]);
            mensaje.setTexto("Nuevo usuario");

        }
        return mensaje;
    }
}
