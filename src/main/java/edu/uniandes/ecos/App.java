package edu.uniandes.ecos;

import edu.uniandes.ecos.psp.MetodoPROBE;
import edu.uniandes.ecos.vistas.ConsolaView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         MetodoPROBE probe = new MetodoPROBE();
        
        ConsolaView vista = new ConsolaView();
        vista.MostrarP(probe.CalcularX(6d, 0.2, 1d), 6d, 0.2);
        vista.MostrarP(probe.CalcularX(15d, 0.45, 1d), 15d, 0.45);
        vista.MostrarP(probe.CalcularX(4d, 0.495, 1d), 4d, 0.495);
        
    }
}
