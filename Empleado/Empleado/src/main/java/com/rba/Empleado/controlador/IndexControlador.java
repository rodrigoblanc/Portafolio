package com.rba.Empleado.controlador;

import com.rba.Empleado.modelo.Empleado;
import com.rba.Empleado.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexControlador {

    //Esto es para enviar cosas a la consola
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    EmpleadoServicio empleadoServicio;

    //Tenemos que procesar la URL, entonces se la pasamos con el @ junto con el tipo de peti.
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado) -> logger.info(empleado.toString()));

        //También debemos compartir el modelo con la vista. Lo que va entre " es el path modificado
        //del application properties

        modelo.put("empleados", empleados);
        return "index"; //de forma automática se llama a index.jsp

    }
}
