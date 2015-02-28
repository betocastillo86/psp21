/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.utilidades;



/**
 *
 * @author Administrator
 */
public class CalculosMatematicos {
    
    /***
     * Calcula el factorial de un numero
     * @param valor
     * @return 
     */
    public static Double Factorial(Double valor)
    {
        Double total = 1d;
        for (Double i = valor; i > 0; i--) {
            total = i * total;
        }
        //Si el numero no es entero multiplica la raiz de Pi
        if(valor % 1 != 0)
            total *= Math.sqrt(Math.PI); 
        
        return total;
    }
    
    /***
     * Calcula la Distribución T
     * @param dof
     * @param x
     * @return 
     */
    public static Double DistribucionT(Double dof, Double x)
    {
        Double coeficiente = Factorial(((dof+1)/2)-1);
        Double divisor = Math.sqrt(dof * Math.PI) * Factorial((dof/2)-1);
        Double segundoMultiplicador = Math.pow(1+ (Math.pow(x, 2)/dof), -(dof+1)/2 );
        return (coeficiente/divisor) * segundoMultiplicador;
    }
    
    /***
     * Calcula la regla SimpSon de Acuerdo a un numero determinado de Segmentos
     * @param x
     * @param dof
     * @param segmentos
     * @return 
     */
    public static Double ReglaDeSimpson(Double x, Double dof, int segmentos)
    {
        Double w = x / segmentos;

        Double total = 0d;
        
        //System.out.println("Regla simpson x=>"+x+" dof=>"+dof+" segmentos=>"+segmentos);
        
        for (int i = 0; i <= segmentos; i++) {
            
            int multiplicador;
            
            //Calcula el multiplicador con base en si es par impar, primero o ultimo
            if(i == 0 || i == segmentos)
                multiplicador = 1;
            else if ( i % 2 == 0)
                multiplicador = 2;
            else
                multiplicador = 4;
            
            Double xi = w * i;
            //Calcula la distribución T con el Xi
            Double fxi = DistribucionT(dof, xi);
            
            //System.out.println("X"+i +" -> "+xi);
            //System.out.println("FX"+i +" -> "+fxi);
            
            //Realiza la sumatoria
            Double subtotal = (w/3) * multiplicador * fxi;
            total += subtotal;
        }
        
        return total;
        
    }
    
    
}
