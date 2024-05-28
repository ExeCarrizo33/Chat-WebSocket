package com.springboot.chatwebsocket.models.documents;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Message implements Serializable {

    private String texto;

    private Long fecha;

    private static final long serialVersionUID = 1L;
}
