/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp;

import edu.uniandes.ecos.modelos.RangoTamano;
import edu.uniandes.ecos.modelos.ResumenArchivo;
import edu.uniandes.ecos.modelos.ResumenPrograma;
import edu.uniandes.ecos.utilidades.CalculosConListas;
import edu.uniandes.ecos.utilidades.CalculosMatematicos;
import java.util.LinkedList;

/**
 *
 * @author VirtualW7
 */
public class MetodoPROBE {
    
    private double b0;
    private double b1;
    private double rXY;
    private double yK;
    private double xK;
    private LinkedList<Double> lista1;
    private LinkedList<Double> lista2;

    public LinkedList<Double> getLista1() 
    {
        return lista1;
    }

    public LinkedList<Double> getLista2() 
    {
        return lista2;
    }

    public double getB0() 
    {
        return b0;
    }

    public void setB0(double b0) 
    {
        this.b0 = b0;
    }

    public double getB1() 
    {
        return b1;
    }

    public void setB1(double b1) 
    {
        this.b1 = b1;
    }

    public double getrXY() 
    {
        return rXY;
    }

    public void setrXY(double rXY) 
    {
        this.rXY = rXY;
    }

    public double getyK() 
    {
        return yK;
    }

    public void setyK(double yK) 
    {
        this.yK = yK;
    }

    public double getxK() 
    {
        return xK;
    }

    public void setxK(double xK) 
    {
        this.xK = xK;
    }

    public double getR2() 
    {
        return this.rXY * this.rXY;
    }
    
    /****
     * Realiza el calculo de la regresión guardando los datos en B1 y B0
     * @param lista1 lista inicial 
     * @param lista2 lista complementaria
     */
    private void CalcularRegresion(LinkedList<Double> lista1, LinkedList<Double> lista2)
    {
       //como la formula es compleja se calcula el coeficiente primero y despues el divisor
       double coeficienteB1 = CalculosConListas.SumatoriaMultiplicada(lista1, lista2) - (lista1.size() * CalculosConListas.CalcularPromedio(lista1) * CalculosConListas.CalcularPromedio(lista2)) ;
       double divisorB1 = CalculosConListas.SumatoriaAlCuadrado(lista1) - (lista1.size() * Math.pow(CalculosConListas.CalcularPromedio(lista1), 2) );
       this.b1 = coeficienteB1 / divisorB1;
       
       //Calcula el b0 con base del b1
       this.b0 = CalculosConListas.CalcularPromedio(lista2) - (this.b1 * CalculosConListas.CalcularPromedio(lista1));
       
       this.yK = this.b0 + (this.b1 * this.xK);
    }
    
    /*****
     * Calcula la correlacion y la asigna a la propiedad Rxy y R2
     * @param lista1 lista inicial
     * @param lista2 lista complementaria
     */
    private void CalcularCorrelacion(LinkedList<Double> lista1, LinkedList<Double> lista2)
    {
        int n = lista1.size();
        double coeficienteRxy = (n * CalculosConListas.SumatoriaMultiplicada(lista1, lista2)) - (CalculosConListas.Sumatoria(lista1) * CalculosConListas.Sumatoria(lista2));
        double divisorRxy = Math.sqrt(((n * CalculosConListas.SumatoriaAlCuadrado(lista1)) - Math.pow(CalculosConListas.Sumatoria(lista1),2)) * ((n * CalculosConListas.SumatoriaAlCuadrado(lista2)) - Math.pow(CalculosConListas.Sumatoria(lista2),2))       );
        this.rXY = coeficienteRxy/divisorRxy;
    }
    
    /***
     * Realiza los caclulos de regresion y correlacion
     * @param xK
     * @param lista1
     * @param lista2
     * @return true si pudo realizar el calculo, false si no puedo realizarlo
     */
    public boolean CalcularPROBE(double xK, LinkedList<Double> lista1, LinkedList<Double> lista2)
    {
        //Valida que las dos listas tengan el mismo tamaño
        if(lista1.size() == lista2.size() && xK > 0)
        {
            this.xK = xK;
            this.lista1 = lista1;
            this.lista2 = lista2;
            CalcularCorrelacion(lista1, lista2);
            CalcularRegresion(lista1, lista2);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /***
     * Calcula los tamaños con base en un objeto resumen programa y devielve los tamaños
     * @param programa datos de los tamaños de los programas
     * @return Rangos de tamaños del programa dado
     */
    public RangoTamano CalcularTamanos(ResumenPrograma programa)
    {
        //Recorre los archivos del programa y carga el promedio de lineas por metodo
        LinkedList<Double> lista = new LinkedList<Double>();
        for (ResumenArchivo archivo : programa.getArchivos()) {
            lista.add(archivo.getPromedioLineas());
        }
        //Retorna el listado de tamaños
        return CalcularTamanos(lista);
    }
    
    /***
     * Calcula los rangos de tamaños según la lista dada y con las formulas de psp11
     * @param listaClases listado de los numeros que se desean calcular
     * @return Rangos de tamaños de acuerdo a los datos ingresados
     */
    public RangoTamano CalcularTamanos(LinkedList<Double> listaClases)
    {
        //Eleva todas las listas al logaritno
        LinkedList<Double> listaLogaritmo = new LinkedList<Double>();
        for (Double clase : listaClases) {
            listaLogaritmo.add(Math.log(clase));
        }
        
        //Calcula la desviacion estandar y el promedio
        Double desviacion = CalculosConListas.CalcularDesviacionEstandar(listaLogaritmo);
        //Calcula el promedio
        Double promedio = CalculosConListas.CalcularPromedio(listaLogaritmo);
        return new RangoTamano(promedio, desviacion);
    }
    
    /****
     * Calcula la integracion numercia de acuerdo al ejercicio PSP2.0
     * @param x valor de la funcion que se desea calcular
     * @param dof Degrees of freedom
     * @return El número calculado de lla INtegracion Numerica
     */
    public Double CalcularIntegracionNumerica(Double x, Double dof)
    {
        Double margenDeError = 0.0001d;
        Double p1 = CalculosMatematicos.ReglaDeSimpson(x, dof, 10);
        Double p2 = CalculosMatematicos.ReglaDeSimpson(x, dof, 20);
        
        if(Math.abs(p1 - p2) <= margenDeError)  
            return p1;
        else
            return Double.NaN;
    }
    
    /***
     * Realiza el calculo de X con los datos de integración númerica y DOF
     * @param dof degrees of freedom
     * @param p integración númerica
     * @param semilla Valor semilla desde el cual se va calcular
     * @return Calculo de X
     */
    public Double CalcularX(Double dof, Double p, Double semilla)
    {
        Double xPosible = 1d;
        Double d = 0.5;
        Double errorAceptable = 0.00001;
        
        //Variable para controlar la diferencia entre los cambios de p
        //Valores posibles, neutro, negativo, positivo
        String signoActual = "neutro";
        
        //Valida que la diferencia no este aumentando
        Double diferenciaAnterior = 0d;
        
        while(xPosible <= 10d && xPosible > 0d )
        {
            
            //Calcula el resultado de  p con la xPosible
            Double pPosible = CalcularIntegracionNumerica(xPosible, dof);
            
            Double diferencia = pPosible - p;
            
            //Si el nivel de error es valido entonces termina el programa
            if(Math.abs(diferencia) <=  errorAceptable)
                break;
            else
            {
                
                //Iguala la diferencia anterior para controlar el valor
                diferenciaAnterior = diferencia;
                //Si pPosible es muy grande le resta D, sino aumenta
                if(diferencia > 0)
                {
                    //Si hubo cambio de simbolo significa que debe dividir el d para dar un dato más exacto
                    if(signoActual.equals("negativo"))
                    {
                        d = d/2;
                    }
                    else
                    {
                        signoActual = "positivo";
                    }
                    
                    xPosible -= d;

                }
                else
                {
                    //Si hubo cambio de simbolo significa que debe dividir el d para dar un dato más exacto
                    if(signoActual.equals("positivo") )
                    {
                        d = d/2;
                    }
                    else
                    {
                        signoActual = "negativo";
                    }
                    
                    xPosible += d;
 
                }

            }

        }
        
        return xPosible;
        
    }
    
    
    
}
