/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelos;

/**
 *
 * @author Administrator
 */
public class RangoTamano {
    
    private Double promedio;
    private Double desviacion;

    public RangoTamano(Double promedio, Double desviacion)
    {
        this.promedio = promedio;
        this.desviacion = desviacion;
    }

    public Double getMuyGrande() 
    {
        return Math.exp(promedio + (2 * desviacion))  ;
    }

    public Double getGrande() 
    {
        return Math.exp(promedio + desviacion);
    }

    public Double getMedio() 
    {
        return Math.exp(promedio);
    }

    public Double getPequeno() 
    {
        return Math.exp(promedio - desviacion);
    }

    public Double getMuyPequeno() 
    {
        return Math.exp(promedio - (2 * desviacion));
    }

    
    
    
}
