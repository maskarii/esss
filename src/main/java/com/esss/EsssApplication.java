package com.esss;


import com.esss.dao.*;
import com.esss.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EsssApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsssApplication.class, args);
	}
    @Bean
    CommandLineRunner run(EquipmentDAO equipmentDAO, ExamDAO examDAO, RoleDAO roleDAO, RoomDAO roomDAO, UserDAO userDAO) {
        return args -> {
            Equipment lift = new Equipment("Lift", true);
            Equipment crane = new Equipment("Crane", true);
            Equipment robot = new Equipment("Killer Robot", true);

            equipmentDAO.createEquipment(lift);
            equipmentDAO.createEquipment(crane);
            equipmentDAO.createEquipment(robot);

            Room r100 = new Room("R1 - 1.1", 20);
            Room r200 = new Room("R1 - 2.2", 20);
            Room r300 = new Room("R1 - 1.3", 50);
            Room r400 = new Room("R1 - 2.4", 10);

//			 .createRoom(r100);
            roomDAO.createRoom(r200);
            roomDAO.createRoom(r300);
            roomDAO.createRoom(r400);

            Role role1 = new Role("STUDENT");
            Role role2 = new Role("STAFF");
            Role role3 = new Role("ADMINISTRATOR_STAFF");

            roleDAO.createRole(role1);
            roleDAO.createRole(role2);
            roleDAO.createRole(role3);

            User student1 = new User("student1", "student1@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student2 = new User("student2", "student2@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student3 = new User("student3", "student3@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student4 = new User("student4", "student4@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student5 = new User("student5", "student5@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student6 = new User("student6", "student6@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student7 = new User("student7", "student7@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student8 = new User("student8", "student8@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student9 = new User("student9", "student9@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student10 = new User("student10", "student10@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student11 = new User("student11", "student11@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student12 = new User("student12", "student12@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student13 = new User("student13", "student13@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student14 = new User("student14", "student14@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student15 = new User("student15", "student15@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student16 = new User("student16", "student16@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student17 = new User("student17", "student17@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student18 = new User("student18", "student18@gmail.com", "studentpass", "Student", "Studentov", role1);
            User student19 = new User("student19", "student19@gmail.com", "studentpass", "Student", "Studentov", role1);
            User staff1 = new User("staff", "staff@gmail.com", "staffpass", "Staff", "Staffov", role2);
            User staff2 = new User("staff2", "staff2@gmail.com", "staffpass2", "Staff2", "Staffov2", role2);


            userDAO.createUser(student1);
            userDAO.createUser(student2);
            userDAO.createUser(student3);
            userDAO.createUser(student4);
            userDAO.createUser(student5);
            userDAO.createUser(student6);
            userDAO.createUser(student7);
            userDAO.createUser(student8);
            userDAO.createUser(student9);
            userDAO.createUser(student10);
            userDAO.createUser(student11);
            userDAO.createUser(student12);
            userDAO.createUser(student13);
            userDAO.createUser(student14);
            userDAO.createUser(student15);
            userDAO.createUser(student16);
            userDAO.createUser(student17);
            userDAO.createUser(student18);
            userDAO.createUser(student19);
            userDAO.createUser(staff1);
            userDAO.createUser(staff2);
            userDAO.createUser(new User("admin", "admin@gmail.com", "adminpass", "Admin", "Adminov", role3));


            List<User> students = new ArrayList<>() {{
                add(student1);
                add(student2);
                add(student3);
            }};
            List<User> staff = new ArrayList<>() {{
                add(staff1);
                add(staff2);
            }};
            List<Room> rooms = new ArrayList<>() {{
                add(r100);
                add(r400);
            }};
            List<Equipment> equipment = new ArrayList<>() {{
                add(crane);
            }};
            List<Equipment> equipment2 = new ArrayList<>() {{
                add(crane);
                add(lift);
            }};
            examDAO.createExam(new Exam("Crane Exam", LocalDate.of(2022, 7, 15), LocalTime.of(14, 20), LocalTime.of(15, 20), students, staff, rooms, equipment2));
            examDAO.createExam(new Exam("New Test", LocalDate.of(2022, 6, 20), LocalTime.of(15, 30), LocalTime.of(16, 30), students, staff, rooms, equipment));

        };
    }
}
