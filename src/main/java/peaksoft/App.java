package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.Employee;
import peaksoft.service.Service;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        HibernateConfig.getSessionFactory();
        Employee employee1 = new Employee("Nurlan", "Mamatkasym uulu", LocalDate.of(1990, 07,13), "nurlan@gmail.com", 980000);
        Service.createTable(employee1);

        Employee employee2 = new Employee("Erkin", "Kubanychbekov", LocalDate.of(1997, 06, 16), "erkin@gmail.com", 560000);
        Service.createTable(employee2);

        Employee employee3 = new Employee("Erlan", "Babaev", LocalDate.of(1994, 10, 25), "erlan@gmail.com", 640000);
        Service.createTable(employee3);

        Employee employee4 = new Employee("Marina", "Volchek", LocalDate.of(1962, 05, 23), "marima@gmail.com", 580000);
        Service.createTable(employee4);

        System.out.println("Get all employees: ");
        Service.getAllEmployees();

        System.out.println("Deleted by id: ");
        Service.deleteById(3L);

        System.out.println("Get by id: ");
        Service.getById(1L);

        System.out.println("Updated by id: ");
        Service.updateEmployee(4L, "Aibek", "Mamatisakov", LocalDate.of(1990, 05, 9), "aibek@gmail.com", 680000);

        System.out.println("Get all employees: ");
        Service.getAllEmployees();

        System.out.println("Deleted all employees: ");
        Service.deleteEmployee();
    }
}
