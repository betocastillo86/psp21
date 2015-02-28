/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelos;

import java.util.LinkedList;

/**
 *
 * @author VirtualW7
 */
public class ResumenPrograma {
    public ResumenPrograma()
    {
        this.archivos = new LinkedList<ResumenArchivo>();
    }
    
    private String nombre;
    
    private LinkedList<ResumenArchivo> archivos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalLineas() {
        int total = 0;
        if(archivos != null)
        {
            for (int i = 0; i < archivos.size(); i++) {
                total += archivos.get(i).getNumeroLineas();
            }
        }
        
        return total;
    }

    public LinkedList<ResumenArchivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(LinkedList<ResumenArchivo> archivos) {
        this.archivos = archivos;
    }
    
}
