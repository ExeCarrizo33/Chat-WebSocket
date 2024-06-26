package com.springboot.chatwebsocket.controllers;

import com.springboot.chatwebsocket.models.documents.Mensaje;
import com.springboot.chatwebsocket.models.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    private String[] colores = {"red", "green", "blue", "yellow", "orange", "magenta", "cyan"};

    @Autowired
    private ChatService chatService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje receiveMessage(Mensaje mensaje) {
        mensaje.setFecha(new Date().getTime());

        if (mensaje.getTipo().equals("NUEVO_USUARIO")){
            mensaje.setColor(colores[(int) (Math.random() * colores.length)]);
            mensaje.setTexto("Nuevo usuario");
        }else {
            chatService.guardarMensaje(mensaje);
        }
        return mensaje;
    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String estaEscribiendo(String username) {
        return  username.concat(" está escribiendo...");
    }

    @MessageMapping("/historial")
    public void historial(String clienteId) {
        messagingTemplate.convertAndSend("/chat/historial/" + clienteId, chatService.obtenerUltimos10Mensajes());
    }
}
