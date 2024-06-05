package com.springboot.chatwebsocket.models.service;

import com.springboot.chatwebsocket.models.documents.Mensaje;
import com.springboot.chatwebsocket.models.repository.ChatRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRespository chatRespository;

    @Override
    public List<Mensaje> obtenerUltimos10Mensajes() {
        return chatRespository.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardarMensaje(Mensaje mensaje) {
        return chatRespository.save(mensaje);
    }
}
