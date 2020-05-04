package empspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext factory= 
				new ClassPathXmlApplicationContext
				("empspring/emp.xml");
		
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		dao.insertEmp();
		
	}

}





