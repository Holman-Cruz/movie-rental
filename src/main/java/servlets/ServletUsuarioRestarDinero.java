package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuarioRestarDinero", urlPatterns = {"/ServletUsuarioRestarDinero"})
public class ServletUsuarioRestarDinero extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public ServletUsuarioRestarDinero() {
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioController usuario = new UsuarioController();
        
        String username = request.getParameter("username");
        
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        String usuarioStr = usuario.restarDinero(username, saldo);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(usuarioStr);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
