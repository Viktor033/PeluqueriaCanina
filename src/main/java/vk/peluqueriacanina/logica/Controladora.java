package vk.peluqueriacanina.logica;

import java.util.List;
import vk.peluqueriacanina.persistencia.ControladoraPersistencia;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atenEsp,
            String nomDuenio, String celular) {
        
        //Creamos el Duenio y asignamos sus valores
        Duenio duenio = new Duenio(); 
        duenio.setNombre(nomDuenio);
        duenio.setCelDuenio(celular);
        
        //Creamos la mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, masco);
        
        
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
        
    }

    public void borrarMascota(int num_cliente) {
        
        controlPersis.borrarMascota (num_cliente);
        
    }

    public Mascota traerMascota(int num_cliente) {
        
       return controlPersis.traerMascota (num_cliente);
        
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, 
            String color, String observaciones, String alergico, 
            String atenEsp, String nomDuenio, String celular) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        //seteo valores del Duenio
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celular);
        dueno.setNombre(nomDuenio);
        
        //llamar al modificarDuenio
        this.modificarDuenio(dueno);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
    
}
