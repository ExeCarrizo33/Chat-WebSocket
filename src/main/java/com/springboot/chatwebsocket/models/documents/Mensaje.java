package com.springboot.chatwebsocket.models.documents;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Mensaje implements Serializable {

    private String texto;
    private Long fecha;
    private String username;
    private String tipo;
    private String color;

    private static final long serialVersionUID = 1L;
}
