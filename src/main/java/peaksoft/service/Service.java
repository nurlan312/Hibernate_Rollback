package peaksoft.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Employee;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class Service {

    public static int createTable(Employee employee) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
//            session.getTransaction().rollback();
            session.close();
            System.out.println("Successfully added: " + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Math.toIntExact(employee.getId());
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employeeList = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employeeList = session.createQuery("from Employee").getResultList();
            session.getTransaction().commit();
//            session.getTransaction().rollback();
            session.close();
            System.out.println("Number " + employeeList.size() + " employee.");
            System.out.println(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static Employee getById(Long id) {
        Employee employee = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
//            session.getTransaction().rollback();
            session.close();
            System.out.println("Get by id: " + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static void deleteById(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit();
//            session.getTransaction().rollback();
            session.close();
            System.out.println("Successfully deleted: " + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployee(Long id, String name, String surname, LocalDate birthdate, String email, int salary) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            employee.setName(name);
            employee.setSurname(surname);
            employee.setEmail(email);
            employee.setBirthdate(birthdate);
            employee.setSalary(salary);
            session.getTransaction().commit();
//            session.getTransaction().rollback();
            session.close();
            System.out.println("Successfully updated: " + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query hql = session.createQuery("delete from Employee");
            hql.executeUpdate();
//            session.getTransaction().commit();
            session.getTransaction().rollback();
            session.close();
            System.out.println("Successfully deleted employees.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
