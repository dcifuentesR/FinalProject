/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.managebeans;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author USER
 */

@ManagedBean(name = "Solicitudes")
@SessionScoped

public class SolicitudCancelacionBean {
    int id;
    int estudiante;
    int asignatura;
    Date fecha;
    String estado;
    int decano;
    
    
    public SolicitudCancelacionBean(){
        
    }
    
    /**
     * Algoritmo de cálculo de impacto que se limita
       a indicar, dada la asignatura a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param asig The subject that you want cancel.
     * @return The number of credit that will be pending.
     */
    public int calculoImpactoSimple(Asignatura asig){
        return 0;
        
    }
    
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @return List of Asignatura.
     */
    public List<Asignatura> loadAsignaturasActuales(){
        return null;
    }
    
    /**
     * El sistema debe solcitar y registrar un texto con la justificacion de la solicitud
     */
    
    public void registroJustificacion(){
        
    }
    
    
    
}