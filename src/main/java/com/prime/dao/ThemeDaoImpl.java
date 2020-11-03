package com.prime.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

@Named("themedao") //Indicamos que esta Clase sera un controlador
@RequestScoped
public class ThemeDaoImpl implements Serializable{
    
    private List<String> themeNames;
    
    //constructor vacio
    public ThemeDaoImpl(){
        
    }
    
    @PostConstruct
    public void init(){
        Logger.getAnonymousLogger().info("Entraste al postconstruct");
        themePrep();
    }
    
    
    public void themePrep(){
        Logger.getAnonymousLogger().info("Entraste al metodo q lee el nombre de los temas desde el archivo");
        String path="/WEB-INF/txts/temas.txt";
        
        themeNames = new ArrayList<>();
        
        try{
            //Obtenemos el contexto de la aplicacion
                     
            ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            //recuperamos el archivo como un flujo de entrada
            InputStream input = context.getResourceAsStream(path);
            //Creamos un flujo de entrada de lectura
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            
            //Creamos un buffer de lectura
            BufferedReader buffer = new BufferedReader(isr);
            
            //Leemos del buffer de lectura cada linea que se obtuvo del archivo
            String cadena;
            while((cadena=buffer.readLine()) != null){
                //Agregamos a la lista la cadena con el nombre del thema
                themeNames.add(cadena.trim());
            }
            //Cerramos el Buffer de lectura
            buffer.close();
            
            //Cerramos el contexto
            //FacesContext.getCurrentInstance().responseComplete();
            
            //Reuperamos del Buffer de lectura cada linea que se leyo desde el archivo
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //Getters y Setters

    public List<String> getThemeNames() {
        return themeNames;
    }

    public void setThemeNames(List<String> themeNames) {
        this.themeNames = themeNames;
    }

    
}
