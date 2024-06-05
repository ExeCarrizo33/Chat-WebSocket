package com.springboot.chatwebsocket.models.service;

import com.springboot.chatwebsocket.models.documents.Mensaje;

import java.util.List;

public interface ChatService {

    public List<Mensaje> obtenerUltimos10Mensajes();
    public Mensaje guardarMensaje(Mensaje mensaje);
}
