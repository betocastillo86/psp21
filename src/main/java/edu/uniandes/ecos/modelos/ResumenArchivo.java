/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelos;

/**
 *
 * @author VirtualW7
 */
public class ResumenArchivo {
    private String nombreArchivo;
    private int numeroLineas;
    private int numeroMetodos;

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }
    
    public Double getPromedioLineas()
    {
        return   Double.parseDouble(String.valueOf(numeroLineas)) / Double.parseDouble(String.valueOf(numeroMetodos));
    }
    

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public int getNumeroMetodos() {
        return numeroMetodos;
    }

    public void setNumeroMetodos(int numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }
    
    
    
}
