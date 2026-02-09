
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main1 {

    static Connection con;

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/forjdbc",
                    "root",
                    "smrushi1810"
            );

            System.out.println("Database connected successfully!");

            Scanner sc = new Scanner(System.in);


            Student student = new Student(con);

            while (true) {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        student.addStudent();
                        break;
                    case 2:
                        student.showStudents();
                        break;
                    case 3:
                        student.updateStudent();
                        break;
                    case 4:
                        student.deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        con.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

