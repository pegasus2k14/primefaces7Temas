package com.prime.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("currentUser")
@SessionScoped
public class CurrentUser implements Serializable{
    //Atributos
      //Variable que almacenara el tema que sea seleccionado por el usuario en el
     //ThemeSwitcher, es necesario que la variable sea inicializada a un nombre de tema 
     //por defecto
    private String temaSeleccionado = "cupertino";
    
    
  //Getters y Setters
    public String getTemaSeleccionado() {
        return temaSeleccionado;
    }

    public void setTemaSeleccionado(String temaSeleccionado) {
        this.temaSeleccionado = temaSeleccionado;
    }
    
    
}
