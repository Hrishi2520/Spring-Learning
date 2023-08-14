package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        boolean flag = true;
        while(flag) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("PRESS 1 for add new Student");
            System.out.println("PRESS 2 for display all Students");
            System.out.println("PRESS 3 for get detail of single Student");
            System.out.println("PRESS 4 for delete Students");
            System.out.println("PRESS 5 for update Student");
            System.out.println("PRESS 6 for EXIT");

            try {
                int input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 1:

                        studentDao.insert(Main.getStudent());
                        System.out.println("Adding New Student...\n");
                        break;
                    case 2:
                        studentDao.getAllStudents();
                        System.out.println("Getting Student Details...\n");
                        break;
                    case 3:
                        System.out.println("Insert Student ID to Get Student Details:");
                        studentDao.getStudent(br.read());
                        break;
                    case 4:
                        studentDao.deleteStudents(Integer.parseInt(br.readLine()));
                        System.out.println("Delete Student...\n");
                        break;
                    case 5:
                        studentDao.updateStudent(Main.getStudent());
                        System.out.println("Updating Student...\n");
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input Try with another one !!");
                System.out.println(e.getMessage());
            }
        }

    }

    public static Student getStudent() {
        System.out.println("Enter the ID for Student");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Name for Student");
        String name = sc.nextLine();

        System.out.println("Enter the City for Student");
        String studentCity = sc.nextLine();

        Student student = new Student(id, name, studentCity);
        return student;
    }


}