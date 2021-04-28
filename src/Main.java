import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String display = "1. Display the list of students";
    public static final String add = "2. Add student to list";
    public static final String update = "3. Update Information student";
    public static final String delete = "4. Delete Information student";
    public static final String findByBinarySearch = "5. Find student by ID using binary search";
    public static final String sortByBubble = "6. Sort Student list by Bubble Sort";
    public static final String findHighestScore = "7. Find Student has Highest Score";
    public static final String writeToFile = "9. Write list students to file";
    public static final String readFile = "10. Read list students to file";
    public static final String exit = "11. Exit";
    public static final String inputID = "Enter ID: ";
    public static final String countStudent = "8. Count number of student in class";

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Khalid", "Location", "A", 9.3));
        studentList.add(new Student(2, "Johnny Stimson", "Flower ", "B", 8.2));
        studentList.add(new Student(3, "Khalid", "Location", "A", 8.3));
        do {
            menu();

            int selection = sc.nextInt();
            switch (selection) {
                case 1 -> studentManagement.displayStudent(studentList);
                case 2 -> studentManagement.addStudent(studentList);
                case 3 -> {
                    System.out.println(inputID);
                    int id = sc.nextInt();
                    studentManagement.fixStudentInfo(id, studentList);
                }
                case 4 -> {
                    System.out.println(inputID);
                    int id = sc.nextInt();
                    studentManagement.deleteInfoStudent(id, studentList);
                }
                case 5 -> studentManagement.findStudenInforByBinarySearch(studentList);
                case 6 -> studentManagement.bubbleSort(studentList);
                case 7 -> studentManagement.findStudentHighestScore(studentList);
                case 8 -> studentManagement.countStudentByClass(studentList);
                case 9 -> studentManagement.writeFileStudent(studentList);
                case 10 -> studentManagement.readFileStudent(studentList);
            }
        } while (true);
    }

    private static void menu() {
        System.out.println(display);
        System.out.println(add);
        System.out.println(update);
        System.out.println(delete);
        System.out.println(findByBinarySearch);
        System.out.println(sortByBubble);
        System.out.println(findHighestScore);
        System.out.println(countStudent);
        System.out.println(writeToFile);
        System.out.println(readFile);
        System.out.println(exit);
    }
}
