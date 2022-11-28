package com.curso.controller;

import java.util.List;

import com.curso.model.CursoDto;
import com.curso.model.Formacion;
import com.curso.service.FormacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class FormacionController {

  @Autowired
  private FormacionService formacionService;

  @ApiOperation(value = "Lista de todas las formaciones")
  @GetMapping(value = "/formaciones",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CursoDto> listaFormaciones(){
    return formacionService.listaFormaciones();
  }

  @ApiOperation(value = "Se crea nueva formación que se pasa en el cuerpo")
  @PostMapping(value = "/altaFormacion")
  public List<CursoDto> altaCurso(@ApiParam(value = "JSON de nueva formación creada") @RequestBody CursoDto curso) {
    return formacionService.crearFormacion(curso);
  }
}
