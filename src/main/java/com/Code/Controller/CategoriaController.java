package com.Code.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping( value = "/categorias")
public class CategoriaController {

    //GetMapping("/index") antes en sprint 3 
    @RequestMapping( value = "/index" , method = RequestMethod.GET )
    public String mostrarIndex(Model  model){
        return "categorias/listCategorias";
    } 

    //GetMapping("/create") antes en sprint 3
    @RequestMapping( value = "/create" , method = RequestMethod.GET )
    public String crear(){
        return "categorias/formCategorias";
    }  

       //PostMapping("/save") antes en sprint 3
       @RequestMapping( value = "/save" , method = RequestMethod.POST )
       public String guardar( @RequestParam("nombre")String nombre ,@RequestParam("descripcion") String descripcion){

        System.out.println("Categoria" + nombre);
        System.out.println("descricion" + descripcion);
        
        return "categorias/listCategorias";
       }  

}
