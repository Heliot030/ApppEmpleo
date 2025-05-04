package com.Code.Controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Code.model.Vacante;
import com.Code.service.IVacantesService;

@Controller
@RequestMapping( "/vacantes")
public class VacantesController {

    @Autowired // inyectamos los datos
    private IVacantesService serviceVacantes;

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante ,Model model){
        System.out.println("id eliminado " +  idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }  

    @GetMapping("/view/{id}")
    public String verDetalle( @PathVariable("id") int idVacante , Model model){

        Vacante vacante = serviceVacantes.buscarPorIdVacante(idVacante);

        System.out.println("Vacante " +  vacante);
        model.addAttribute("vacante" ,  vacante);

        //BUscar detallles en base de datos 
        return "detalle";
    }
}
