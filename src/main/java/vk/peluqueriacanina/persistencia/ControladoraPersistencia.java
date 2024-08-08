package vk.peluqueriacanina.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vk.peluqueriacanina.logica.Duenio;
import vk.peluqueriacanina.logica.Mascota;
import vk.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();   

    public void guardar(Duenio duenio, Mascota masco) {
        
        //Crear en la DB el Duenio
        duenioJpa.create(duenio);
        
        // Crear en la DB la mascota
        mascotaJpa.create(masco);
        
    }

    public List<Mascota> traerMascotas() {
        
        return mascotaJpa.findMascotaEntities();
        
    }
        //Borrado de Mascota
    public void borrarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
        
       return mascotaJpa.findMascota(num_cliente);
        
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
