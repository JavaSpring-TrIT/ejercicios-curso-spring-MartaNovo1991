package com.curso.controller;

import java.util.List;

import com.curso.model.CursoDto;
import com.curso.model.Formacion;
import com.curso.service.FormacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormacionController {

  @Autowired
  private FormacionService formacionService;

  @GetMapping(value = "/formaciones",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CursoDto> listaFormaciones(){
    return formacionService.listaFormaciones();
  }

  @PostMapping(value = "/altaFormacion")
  public List<CursoDto> altaCurso( @RequestBody CursoDto curso) {
    return formacionService.crearFormacion(curso);
  }
}
