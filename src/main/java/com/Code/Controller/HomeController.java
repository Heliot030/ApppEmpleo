package com.Code.Controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Code.model.Vacante;
import com.Code.service.IVacantesService;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

@Controller // solo porsesamos las peticiones HTTP
public class HomeController {

    @Autowired // inyectamos los datos
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle") // va la url de la web
    public String mostararDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("ingeniero de obras");
        vacante.setDescripcion("constrecionde edifcios");
        vacante.setFecha(new Date());
        vacante.setSalario(232.323);
        model.addAttribute("vacante", vacante);

        return "detalle"; // retorna lo mapeado
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> Lista = new LinkedList<>();
        Lista.add("Ingeniero en sistema");
        Lista.add("Auxiliar de administracion");
        Lista.add("Vendedor");
        Lista.add("Arquitecto");
        model.addAttribute("empleos", Lista);
        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model) {

        // model.addAttribute("mensaje" , "DESDE LA APP DE EMPLEOS");
        // model.addAttribute("fecha", new Date());

        String nombre = "Auxliar de contabilidad";
        Date fechaPub = new Date();
        double salario = 9.0000;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fechaPub", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("boolean", vigente);
        return "home"; // thymleaf ayuda a no poner .html
    }

}
