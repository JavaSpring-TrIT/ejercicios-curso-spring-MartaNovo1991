package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.curso.model.Curso;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService{

  List<Curso>cursos;

  public CursoServiceImpl(){
    cursos = new ArrayList<>();
    cursos.add(new Curso("001","Informática",100,650));
    cursos.add(new Curso("002","Comercial",150,250.50));
    cursos.add(new Curso("003","Teleoperador",80,520.50));
    cursos.add(new Curso("004","Cocina",20,150));
    cursos.add(new Curso("005","Integración social",40,200));
  }


  @Override
  public List<Curso> listaCursos() {
    return cursos;
  }

  @Override
  public Curso findCursoBycodCurso(String codCurso) {
    return cursos.stream().filter(curso -> curso.getCodCurso().equalsIgnoreCase(codCurso)).findFirst().orElse(null) ;
  }


  @Override
  public List<Curso> listCursosRandoPrecio(double precioMin, double precioMax) {
    return cursos.stream().filter(curso -> curso.getPrecio()>=precioMin && curso.getPrecio() <= precioMax).collect(Collectors.toList());
  }

  @Override
  public List<Curso> altaCurso(Curso curso) {
    cursos.add(curso);
    return listaCursos();
  }

  @Override
  public void actualizarCurso(String codCurso, Integer duracion) {
    Curso curso = findCursoBycodCurso(codCurso);
    if(curso.getCodCurso() != null){
      curso.setCodCurso(codCurso);
      curso.setDuracion(duracion);

    }

  }

  @Override
  public List<Curso> eliminarCurso(String codCurso) {
    cursos.removeIf(c -> c.getCodCurso().equalsIgnoreCase(codCurso));
    return cursos;
  }
}
