
import java.sql.*;
        import java.util.Scanner;

public class Student {

    Connection con;
    Scanner sc = new Scanner(System.in);

    public Student(Connection con) {
        this.con = con;
    }

    // ADD STUDENT
    public void addStudent() {
        try {
            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Course: ");
            String course = sc.next();

            String sql = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);

            ps.executeUpdate();
            System.out.println("✅ Student added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SHOW STUDENTS
    public void showStudents() {
        try {
            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID\tNAME\tAGE\tCOURSE");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getInt("age") + "\t" +
                                rs.getString("course")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Name: ");
            String name = sc.next();

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();

            System.out.print("Enter New Course: ");
            String course = sc.next();

            String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            ps.executeUpdate();
            System.out.println("✅ Student updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("✅ Student deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
