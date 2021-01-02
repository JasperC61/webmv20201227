

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Supplier;
import java.util.*;

@WebServlet("/JPAQueryParamServlet")
public class JPAQueryParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public JPAQueryParamServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("webmv20201227");
		EntityManager entityManager =entityManagerFactory .createEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql="select e from Supplier e where e.supId>=:arg1";
		Query query=entityManager.createQuery(jpql,Supplier.class);
		query.setParameter("arg1", 150);
		List<Supplier> result = query.getResultList();

		request.setAttribute("supplier", result);
		request.getRequestDispatcher("viewSupplier.jsp").forward(request, response);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
