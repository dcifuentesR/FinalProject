/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.finalproject.mybatis.DecanoDAOMyBatis;
import edu.eci.pdsw.finalproject.mybatis.EstudianteDAOMyBatis;
import edu.eci.pdsw.finalproject.persistence.DecanoDAO;
import edu.eci.pdsw.finalproject.persistence.EstudianteDAO;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

/**
 *
 * @author USER
 */
public class SolicitudesFactory {
    private static SolicitudesFactory instance = new SolicitudesFactory();

    private static Injector injector;
    
    private static Injector testInjector;

    public SolicitudesFactory() {
        
         injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);              
                setClassPathResource("mybatis-config.xml");
                
                bind(EstudianteDAO.class).to(EstudianteDAOMyBatis.class);                
                bind(DecanoDAO.class).to(DecanoDAOMyBatis.class);
            }

        }
        );

        testInjector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                
                bind(EstudianteDAO.class).to(EstudianteDAOMyBatis.class);             
                bind(DecanoDAO.class).to(DecanoDAOMyBatis.class);
            }

        }
        );

    }

    public Solicitudes getSolicitudes() {
        return injector.getInstance(Solicitudes.class);
    }

    public Solicitudes getTestingSolicitudes() {
        return testInjector.getInstance(Solicitudes.class);
    }
    
    public static SolicitudesFactory getInstance() {
        return instance;
    }

}

