package com.curso.controller;

import java.util.List;

import com.curso.model.Curso;
import com.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CursoController {

  @Autowired
  private CursoService cursoService;

  @GetMapping(value = "/cursos",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Curso> todosCursos (){
    return cursoService.listaCursos();
  }

  @PostMapping(value = "/nuevoCurso",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
  public List<Curso> altaCurso( @RequestBody Curso curso){
    return cursoService.altaCurso(curso);

  }

  @DeleteMapping(value = "/borrarCurso/{codCurso}",produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Curso> eliminarCurso(@PathVariable("codCurso") String codCurso){
    return cursoService.eliminarCurso(codCurso);
  }

  @PutMapping(value = "/actualizarCurso/{codCurso}/{duracion}")
  public void actualizarCurso(@PathVariable("codCurso") String codCurso,@PathVariable("duracion") Integer duracion){
    cursoService.actualizarCurso(codCurso,duracion);
  }

  @GetMapping(value = "/buscarCurso/{codCurso}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Curso buscarCurso(@PathVariable String codCurso){
    return cursoService.findCursoBycodCurso(codCurso);
  }
  @GetMapping(value = "/buscarCurso/{precioMin}/{precioMax}")
  public List<Curso>buscarCursoByPrecio(@PathVariable("precioMin") double precioMin,@PathVariable("precioMax") double precioMax){
    return cursoService.listCursosRandoPrecio(precioMin,precioMax);

  }
}
