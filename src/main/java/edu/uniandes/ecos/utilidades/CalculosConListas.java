/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.utilidades;

import java.util.LinkedList;

/**
 *
 * @author VirtualW7
 */
public class CalculosConListas {
    
    public static double CalcularPromedio(LinkedList<Double> lista )
    {
        double total = 0;
        
        for(int i = 0; i < lista.size(); i++)
        {
            total += lista.get(i) ;
        }
        
        return total / lista.size();
    }
    
    /****
     * Realiza la sumatoria de una lista al cuadrado y le saca el promedio
     * @param lista lista de numeros a calcular
     * @return primedio total al cuadrado
     */
    public static double CalcularPromedioAlCuadrado(LinkedList<Double> lista)
    {
        double total = SumatoriaAlCuadrado(lista);
        return total / lista.size();
    }
    
    /****
     * Calcula la desviacion estandar de un grupo de numeros
     * @param lista grupo de numeros a calcular
     * @return calculo final de la desviación estandar
     */
    public static double CalcularDesviacionEstandar(LinkedList<Double> lista)
    {
        double promedio = CalcularPromedio(lista);
        
        double sumatoriaDesviacion = 0;
        for(int i = 0; i < lista.size(); i++)
        {
            double valorActual = lista.get(i) ;
            double x_xavg = Math.pow((valorActual - promedio), 2);
            
            sumatoriaDesviacion += x_xavg;
        }
        
        return Math.sqrt( sumatoriaDesviacion / (lista.size() - 1)) ;
    }
    
    /**
     * Realiza la sumatoria del contenido de una lista de numeros      
     * @param lista de numeros
     * @return sumatoria
     */
    public static double Sumatoria(LinkedList<Double> lista)
    {
        double total = 0;
        
        for(int i = 0; i < lista.size(); i++)
        {
            total += lista.get(i) ;
        }
        
        return total;
    }
    
    /**
     * Realiza la sumatoria del contenido de una lista de numeros  elevando al cuadrado cada item   * 
     * @param lista de numeros
     * @return sumatria de los numeros de la lista al cuadrado
     */
    public static double SumatoriaAlCuadrado(LinkedList<Double> lista)
    {
        double total = 0;
        
        for(int i = 0; i < lista.size(); i++)
        {
            total += Math.pow(lista.get(i), 2);
        }
        
        return total;
    }
    /***
     * Realiza la multiplicacion de los items en la lista uno a uno y después su sumatoria.
     * Es decir x1*y1 + x2*y2 + x3*y3 ....
     * @param lista1
     * @param lista2
     * @return Sumatoria de la multiplicacion de los items entre listas
     */
    public static double SumatoriaMultiplicada(LinkedList<Double> lista1, LinkedList<Double> lista2)
    {
        double total = 0;
        
        for(int i = 0; i < lista1.size(); i++)
        {
            total += lista1.get(i) * lista2.get(i);
        }
        
        return total;
    }

}
