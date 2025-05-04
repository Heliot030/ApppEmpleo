package com.Code.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Code.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService {

    private List<Vacante> lista = null;

    public VacantesServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<Vacante>();
        try {
            // creamoas 4 vacantes
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Inginerio civil");
            vacante1.setDescripcion("Conrtucion de edificios");
            vacante1.setFecha(sdf.parse("04-02-2025"));
            vacante1.setSalario(23300.00);
            vacante1.setDestacado(1);
            vacante1.setImagen("empresa1.png");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Cintador Publico");
            vacante2.setDescripcion("conta con 5 años de experiencia");
            vacante2.setFecha(sdf.parse("04-02-2025"));
            vacante2.setSalario(9999.00);
            vacante2.setDestacado(0);
            vacante2.setImagen("empresa2.png");

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Electricista");
            vacante3.setDescripcion("Empresa internacional solicita electrisicsta con certofcaciones ISO");
            vacante3.setFecha(sdf.parse("04-02-2025"));
            vacante3.setSalario(5000.55);
            vacante3.setDestacado(0);

            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador grafico");
            vacante4.setDescripcion("Campañia de red social de oaxaca orientado objetivos");
            vacante4.setFecha(sdf.parse("04-02-2025"));
            vacante4.setSalario(6000.60);
            vacante4.setDestacado(1);
            vacante4.setImagen("empresa3.png");

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }


    @Override
    public Vacante buscarPorIdVacante(Integer idVacante) {
        for (Vacante v : lista) {
            if (v.getId() == idVacante) {
                return v;
            }
        }
       return null;
    }
}
