/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import edu.uniandes.ecos.modelos.RangoTamano;
import edu.uniandes.ecos.psp.MetodoPROBE;
import edu.uniandes.ecos.vistas.WebView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author Administrator
 */
public class Main extends HttpServlet{
    public static void main(String[] args) 
            throws Exception {
    //Server server = new Server(8080);
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new Main()),"/*");
    server.start();
    server.join();
  }
    
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        
        WebView vista = new WebView();
        
        MetodoPROBE probe = new MetodoPROBE();
        
        String html = "";
        
        html += vista.MostrarP(probe.CalcularX(6d, 0.2, 1d), 6d, 0.2);
        html += vista.MostrarP(probe.CalcularX(15d, 0.45, 1d), 15d, 0.45);
        html += vista.MostrarP(probe.CalcularX(4d, 0.495, 1d), 4d, 0.495);

        resp.getWriter().print( html);
  }
}
