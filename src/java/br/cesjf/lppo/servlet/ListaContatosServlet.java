
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.Contato;
import br.cesjf.lppo.dao.ContatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListaContatosServlet", urlPatterns = {"/contatos.html"})
public class ListaContatosServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contato> contatos;

        try {
           ContatoDAO dao = new ContatoDAO();
            contatos = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(ListaContatosServlet.class.getName()).log(Level.SEVERE, null, ex);
            contatos = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("contatos", contatos);
        request.getRequestDispatcher("WEB-INF/lista-contatos.jsp").forward(request, response);
    }

 

}
