package com.curso.service;

import java.util.List;

import com.curso.model.CursoDto;
import com.curso.model.Formacion;

public interface FormacionService {

  List<CursoDto> listaFormaciones();
  List<CursoDto> crearFormacion(CursoDto cursoDto);

}
