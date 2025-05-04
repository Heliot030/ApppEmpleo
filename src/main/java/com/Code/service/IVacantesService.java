package com.Code.service;

import java.util.List;

import com.Code.model.Vacante;

public interface IVacantesService {

    List<Vacante> buscarTodas();

    Vacante buscarPorIdVacante(Integer idVacante);

}

