package com.curso.model;

import lombok.Data;

@Data
public class CursoDto {

  private String codCurso;
  private String nombre;
  private Integer duracion;
  private double precio;
  private Integer asignaturas;


}
