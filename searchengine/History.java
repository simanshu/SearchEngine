package com.Accio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/History")
public class History extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        Connection connection = DatabaseConnection.getConnection();
        try{
            ResultSet resultSet=connection.createStatement().executeQuery("Select * from history");
            ArrayList<Historyresult> result=new ArrayList<>();

            while(resultSet.next()){
                Historyresult historyresult=new Historyresult();
                historyresult.setKeyword(resultSet.getString("keyword"));
                historyresult.setLink(resultSet.getString("link"));
                result.add(historyresult);
            }
            request.setAttribute("result",result);
            request.getRequestDispatcher("history.jsp").forward(request,response );
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
        }

        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        catch (ServletException | IOException servletException){
            throw new RuntimeException(servletException);
        }
    }
}
