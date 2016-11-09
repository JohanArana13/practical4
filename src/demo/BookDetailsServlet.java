package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HaouJohan on 11/7/2016.
 */

@WebServlet(name= "BookDetailsServlet", urlPatterns="/bookdetails")
public class BookDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String bookId = request.getParameter("bookId");
            if(bookId != null){
                BookDBAO db = new BookDBAO();
                BookDetails bd = db.getBookDetails(bookId);
                request.setAttribute("book", bd);
                getServletContext().getRequestDispatcher("/book.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
