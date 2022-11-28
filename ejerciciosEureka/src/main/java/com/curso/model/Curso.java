package com.curso.model;

import lombok.Data;
@Data
public class Curso {

  private String codCurso;
  private String nombre;
  private Integer duracion;
  private double precio;

  public Curso(String codCurso, String nombre, Integer duracion, double precio) {
    this.codCurso = codCurso;
    this.nombre = nombre;
    this.duracion = duracion;
    this.precio = precio;
  }
  public Curso(){}

}
