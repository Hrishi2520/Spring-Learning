package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
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
                        //add a new Students
                        //taking inputs from users
                        System.out.println("Enter user id: ");
                        int uid = Integer.parseInt(br.readLine());

                        System.out.println("Enter user Name: ");
                        String  uName = br.readLine();

                        System.out.println("Enter user City: ");
                        String uCity = br.readLine();

                        //creating student object and setting values
                        Student student = new Student(uid, uName, uCity);

                        //saving student object to database by calling insert of student dao
                        int r = studentDao.insert(student);
                        System.out.println(r + " Student Added");
                        System.out.println("********************\n");
                        break;
                    case 2:
                        List<Student> students = studentDao.getAllStudents();
                        students.forEach(System.out::println);
                        System.out.println("********************\n");
                        break;
                    case 3:
                        //get single student data
                        System.out.println("Enter User id: ");
                        int userId = Integer.parseInt(br.readLine());
                        Student student1 = studentDao.getStudent(userId);
                        System.out.println("Id: "+ student1.getStudentId());
                        System.out.println("Name: "+student1.getStudentName());
                        System.out.println("City: "+ student1.getStudentCity());
                        System.out.println("-----------------------------------");
                        break;
                    case 4:
                        System.out.println("Enter user id: ");
                        int id = Integer.parseInt(br.readLine());
                        studentDao.deleteStudents(id);
                        System.out.println("Student deleted...\n");
                        break;
                    case 5:
                        //taking inputs from users
                        System.out.println("Enter user id: ");
                        int userid = Integer.parseInt(br.readLine());

                        System.out.println("Enter user Name: ");
                        String  userName = br.readLine();

                        System.out.println("Enter user City: ");
                        String userCity = br.readLine();

                        //creating student object and setting values
                        Student student2 = new Student(userid, userName, userCity);
                        //Updating student object to database by calling insert of student dao
                        studentDao.updateStudent(student2);
                        System.out.println("Updating Student data...\n");
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
}