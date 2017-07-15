package in.codelearn.common;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.codelearn.model.Department;
import in.codelearn.model.Employee;
import in.codelearn.persistence.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Department department = new Department();
		department.setDepartmentName("Sales");

		Employee emp1 = new Employee("Nina", "Mayers", "111");
		Employee emp2 = new Employee("Tony", "Almeida", "222");
		
		department.setEmployees(new ArrayList<Employee>());
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);
		
		emp1.setDepartment(department);
		emp2.setDepartment(department);
		
		session.save(department);

		session.getTransaction().commit();
		session.close();
	}
}
