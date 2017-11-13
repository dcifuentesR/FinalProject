/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services.impl;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.Estudiante;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import edu.eci.pdsw.finalproject.services.Solicitudes;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author USER
 */
public final class SolicitudesCancelacionMock implements Solicitudes{
    
    private final Map<Tupla<Integer, String>, Estudiante> estudiantes;
    private final List<Asignatura> asignaturasPlanEstudios;
    private final List<Asignatura> vistasActualmente;
    
    public SolicitudesCancelacionMock(){
        this.estudiantes = new LinkedHashMap<>();
        asignaturasPlanEstudios = new LinkedList<>();
        vistasActualmente= new LinkedList<>();
        cargarDatosPrueba();
        cargarDatosEstaticosGrafo();
        
    }
    /**
     * Algoritmo de cálculo de impacto que se limita
       a indicar, dado el estudiante y la asignatura a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param asig The subject that you want cancel.
     * @param e The student.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes si el estudiante o la asignatura no existen
     */
    public int calculoImpactoSimple(Estudiante e,Asignatura asig) throws ExcepcionSolicitudes{
        return 0;

    }
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @param e
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public List<Asignatura> loadAsignaturasActuales(Estudiante e) throws ExcepcionSolicitudes{
        throw new ExcepcionSolicitudes("No implementado aun");
    }
    
    
    
    /**
     * El sistema debe solcitar y registrar un texto con la justificacion de la solicitud
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    
    @Override
    public String registroJustificacion() throws ExcepcionSolicitudes{

        //throw new ExcepcionSolicitudes("No implementado aun");
        return " ";
       
    }

    public List<Asignatura> getAsignaturasPlanEstudios() {
        return asignaturasPlanEstudios;
    }

    public List<Asignatura> getVistasActualmente() {
        return vistasActualmente;
    }
    
    @Override
    public List<Asignatura> loadAsignaturasPlanEstudios(PlanEstudios plan) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void cargarDatosPrueba(){
        
        ProgramaAcademico p1= new ProgramaAcademico(1, "Ingenieria Sistemas", 10, 210, 150);
      
        Asignatura as1 = new Asignatura(101, "Logica", p1, "Departamento Matematica", 504,3);
        Asignatura as2 = new Asignatura(102, "Modelos", p1, "Departamento Matematica", 505,4);
        Asignatura as3 = new Asignatura(103, "Redes", p1, "Departamento Matematica", 510,3);
        
        asignaturasPlanEstudios.add(as1);
        asignaturasPlanEstudios.add(as2);
        asignaturasPlanEstudios.add(as3);
        
        vistasActualmente.add(as1); 
        
        PlanEstudios plan= new PlanEstudios(1, 3, p1, asignaturasPlanEstudios);
        
        Estudiante est= new Estudiante(2104481, "daniel", "cas", 6,78, 001, 313, 9, vistasActualmente);

    }
    private void cargarDatosEstaticosGrafo()
    {
        
        
        Asignatura a1 =new Asignatura(0, "materia1", new ProgramaAcademico(), "pajarito", 1, 4);
        Asignatura a4 =new Asignatura(0, "materia4", new ProgramaAcademico(), "pajarito", 1, 3);
        Asignatura a5 =new Asignatura(0, "materia5", new ProgramaAcademico(), "pajarito", 1, 3);
        Asignatura a3 =new Asignatura(0, "materia3", new ProgramaAcademico(), "pajarito", 1, 4,Arrays.asList(a5));
        Asignatura a2 =new Asignatura(0, "materia2", new ProgramaAcademico(), "pajarito", 1, 2,Arrays.asList(a3,a4));
        
        PlanEstudios pe=new PlanEstudios(1, 5, new ProgramaAcademico(),Arrays.asList(a1,a2,a3,a4,a5));
        
    }

    @Override
    public int calculoImpactoSimple(Asignatura asig) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    class Tupla<A, B> {

    A a;
    B b;

    public Tupla(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tupla<?, ?>) {
            return ((Tupla<?, ?>) obj).getA().equals(this.getA())
                    && ((Tupla<?, ?>) obj).getB().equals(this.getB());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Touple:(" + a.toString() + "," + b.toString() + ")";
    }
}
