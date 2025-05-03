package com.Code.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Code.model.Vacante;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
@Controller
public class HomeController {

     @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle") //va la url de la web 
    public String mostararDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("ingeniero de obras");
        vacante.setDescripcion("constrecionde edifcios");
        vacante.setFecha(new Date());
        vacante.setSalario(232.323);
        model.addAttribute("vacante", vacante);
        
        return "detalle"; //retorna lo mapeado
    }
    
    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> Lista = new LinkedList<>();
        Lista.add("Ingeniero en sistema");
        Lista.add("Auxiliar de administracion");
        Lista.add("Vendedor");
        Lista.add("Arquitecto");
        model.addAttribute("empleos", Lista);
        return "listado";
    }
    
    @GetMapping("/")
    public String mostrarHome(Model model){
        
//     model.addAttribute("mensaje" , "DESDE LA APP DE EMPLEOS");
//     model.addAttribute("fecha", new Date());

            String nombre = "Auxliar de contabilidad";
            Date fechaPub = new Date();
            double salario = 9.0000;
            boolean vigente = true;

            model.addAttribute("nombre", nombre);
            model.addAttribute("fechaPub", fechaPub);
            model.addAttribute("salario", salario   );
            model.addAttribute("boolean", vigente);
        return "home"; //thymleaf ayuda a no poner .html
    }

    //nuevo metodo
    private List<Vacante> getVacantes(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<Vacante>();
        try {
            //creamoas 4 vacantes
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Inginerio civil");
            vacante1.setDescripcion("Conrtucion de edificios");
            vacante1.setFecha(sdf.parse("04-02-2025"));
            vacante1.setSalario(8000.00);
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
        return lista;
    }
}

