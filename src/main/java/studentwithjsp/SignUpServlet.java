package studentwithjsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;

public class SignUpServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String address=req.getParameter("address");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));
	double fees=Double.parseDouble(getServletContext().getInitParameter("fees"));
	
	Student student=new Student();
	student.setAddress(address);
	student.setEmail(email);
	student.setFees(fees);
	student.setName(name);
	student.setPassword(password);
	student.setPhone(phone);
	
	StudentDao dao=new StudentDao();
    List<Student> students=dao.getALlStudent();
	
    boolean value=true;
    
    for(Student st:students) {
    	if(email.equals(st.getEmail())) {
    		value=false;
    		break;
    	}    		
    }
    
    if(value) {
//    	value=true when that particular email is not mapped to any of the student which is present in the db
    	dao.saveStudent(student);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
    	dispatcher.forward(req, resp);
    }else {
//    	email is already mapped to other student 
    	req.setAttribute("message", "Sorry email already exist please try with the other email");
    	RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
    	dispatcher.include(req, resp);
    }
	
	
	
}
}
