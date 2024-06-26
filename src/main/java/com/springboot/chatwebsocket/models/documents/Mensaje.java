package com.springboot.chatwebsocket.models.documents;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "mensajes")
public class Mensaje implements Serializable {

    @Id
    private String id;

    private String texto;
    private Long fecha;
    private String username;
    private String tipo;
    private String color;

    private static final long serialVersionUID = 1L;
}
