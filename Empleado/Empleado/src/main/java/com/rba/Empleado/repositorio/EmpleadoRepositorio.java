package com.rba.Empleado.repositorio;

import com.rba.Empleado.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    /**con extender esa interfaz se nos permite acceder a todos los métodos típicos
    como agregar, modificar, buscar, etc. También es interesante implementarla, a pesar
     de que se podría conectar la presentación a repositorio para aportar transaccionalidad
     y también seguridad.**/

}
