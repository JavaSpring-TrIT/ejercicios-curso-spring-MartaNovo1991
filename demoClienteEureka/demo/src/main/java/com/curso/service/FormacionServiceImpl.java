package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.curso.model.CursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FormacionServiceImpl implements FormacionService {

  @Autowired
  RestTemplate template;

  private String url = "http://servicio-cursos/";
  @Override
  public List<CursoDto> listaFormaciones() {
    List<CursoDto> listaCursos;

    listaCursos=  Arrays.asList(template.getForObject(url  + "cursos",CursoDto[].class));

    for (CursoDto cursoDto:listaCursos) {
      if(cursoDto.getDuracion()>=50)
        cursoDto.setAsignaturas(10);
      else
        cursoDto.setAsignaturas(5);

    }
    return listaCursos;
  }

  @Override
  public List<CursoDto> crearFormacion(CursoDto cursoDto) {
    List<CursoDto> cursos = listaFormaciones();
    boolean existe = false;

    for (CursoDto c:cursos) {
      if (c.getNombre().equalsIgnoreCase(cursoDto.getNombre())) {
        existe = true;
        break;

      }
    }
    if(existe)
      return new ArrayList<>();
    else{
      cursoDto.setDuracion(cursoDto.getAsignaturas()*10);
      cursoDto.setCodCurso(renombradoCurso(cursoDto.getNombre(),cursoDto.getDuracion()));
      template.postForLocation(url + "nuevoCurso",cursoDto);//altaFormacion
      return listaFormaciones();
    }

  }

  private String renombradoCurso(String nombre,int duracion){
    String sSubCadena =nombre.substring(0,3);
    return sSubCadena + duracion;

  }
}
