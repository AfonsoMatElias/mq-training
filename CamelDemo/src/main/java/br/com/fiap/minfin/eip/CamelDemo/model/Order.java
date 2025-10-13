package br.com.fiap.minfin.eip.CamelDemo.model;

import java.io.Serializable;

public record Order (
    String id,
    String type,
    Double amout,
    String description,
    String customer

) implements Serializable { }
