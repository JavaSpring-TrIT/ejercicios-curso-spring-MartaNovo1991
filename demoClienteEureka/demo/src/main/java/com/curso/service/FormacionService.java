package com.curso.service;

import java.util.List;

import com.curso.model.CursoDto;

public interface FormacionService {

  List<CursoDto> listaFormaciones();
  List<CursoDto> crearFormacion(CursoDto cursoDto);

}
