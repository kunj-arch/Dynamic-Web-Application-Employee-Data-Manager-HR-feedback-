import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        //name, password, email, country, joiningDate, department, Designation, ratingbymanager, ratingbyhr

        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country"); 
        String joiningDate=request.getParameter("joiningDate");
        String  department= request.getParameter("department");
        String  Designation= request.getParameter("Designation");
        String  ratingbymanager= request.getParameter("ratingbymanager");
        String  ratingbyhr= request.getParameter("ratingbyhr");
        Emp e=new Emp();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);
        e.setJoiningDate(joiningDate);
        e.setDepartment(department);
        e.setDesignation(Designation);
        e.setRatingbymanager(ratingbymanager);
        e.setRatingbyhr(ratingbyhr);
          
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
