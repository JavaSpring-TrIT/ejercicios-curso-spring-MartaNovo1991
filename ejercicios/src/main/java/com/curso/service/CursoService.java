package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursoService {

  List<Curso> listaCursos();
  Curso findCursoBycodCurso(String codCurso);
  List<Curso>  listCursosRandoPrecio(double precioMin, double precioMax);
  List<Curso> altaCurso(Curso curso);
  void actualizarCurso(String codCurso, Integer duracion);
  List<Curso> eliminarCurso(String codCurso);



}

