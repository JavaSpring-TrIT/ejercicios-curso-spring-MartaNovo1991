package com.curso.controller;

import java.util.List;

import com.curso.model.Curso;
import com.curso.service.CursoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CursoController {

  @Autowired
  private CursoService cursoService;

  @ApiOperation(value = "Devuelve una lista de cursos")
  @GetMapping(value = "/cursos",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Curso> todosCursos (){

  return cursoService.listaCursos();
  }

  @ApiOperation(value = "Se crea un nuevo curso recibido en el cuerpo")
  @PostMapping(value = "/nuevoCurso",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<Curso> altaCurso( @ApiParam(value = "JSON que contiene el nuevo curso a crear")@RequestBody Curso curso){
    return cursoService.altaCurso(curso);

  }

  @ApiOperation(value = "Elimina un curso por codCurso")
  @DeleteMapping(value = "/borrarCurso/{codCurso}",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Curso> eliminarCurso(@ApiParam(value = "Codigo curso a eliminar")@PathVariable("codCurso") String codCurso){
    return cursoService.eliminarCurso(codCurso);
  }

  @ApiOperation(value = "Modifica los parámetros de un curso que se pasan por parámetro")
  @PutMapping(value = "/actualizarCurso/{codCurso}/{duracion}")
  public void actualizarCurso(@ApiParam(value = "codCurso nuevo")@PathVariable("codCurso") String codCurso,
      @ApiParam(value = "duracion nueva")@PathVariable("duracion") Integer duracion){
    cursoService.actualizarCurso(codCurso,duracion);
  }

  @ApiOperation(value = "Busca un curso por codCurso")
  @GetMapping(value = "/buscarCurso/{codCurso}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Curso buscarCurso(@ApiParam(value = "codCurso del curso a buscar") @PathVariable String codCurso){
    return cursoService.findCursoBycodCurso(codCurso);
  }
  @ApiOperation(value = "Busca curso entre un precio mínimo y máximo")
  @GetMapping(value = "/buscarCurso/{precioMin}/{precioMax}")
  public List<Curso>buscarCursoByPrecio(@ApiParam(value = "precio minimo para buscar")@PathVariable("precioMin") double precioMin,
      @ApiParam(value = "precio máximo para buscar")@PathVariable("precioMax") double precioMax){
    return cursoService.listCursosRandoPrecio(precioMin,precioMax);

  }
}
