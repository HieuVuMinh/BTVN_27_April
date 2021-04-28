import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class StudentManagement {
    public static final String enterID = "Enter id student: ";
    public static final String enterName = "Enter name student: ";
    public static final String enterAddress = "Enter address student: ";
    public static final String enterClassName = "Enter className student: ";
    public static final String enterScore = "Enter score of student: ";
    public static final String notFound = "Can not found";
    public static final String success = "Write file success";
    Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private String address;
    private String className;
    private double score;

    public StudentManagement() {
    }

    // 1. Hiển thi danh sách toàn bộ nhân viên
    public void displayStudent(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.println(student);
        }
    }

    // 2. Thêm thông tin một sinh viên
    public void addStudent(List<Student> studentList) {
        Student student = inputInfoStudent();
        studentList.add(student);
    }

    private Student inputInfoStudent() {
        System.out.println(enterID);
        id = sc.nextInt();
        sc.nextLine();
        System.out.println(enterName);
        name = sc.nextLine();
        System.out.println(enterAddress);
        address = sc.nextLine();
        System.out.println(enterClassName);
        className = sc.nextLine();
        System.out.println(enterScore);
        score = sc.nextDouble();
        Student student = new Student(id, name, address, className, score);
        return student;
    }

    // 3. Cập nhật thông tin sinh viên
    public void fixStudentInfo(int number, List<Student> studentList) {
        sortStudentList(studentList);
        Student student = findStudentByIdWithBinarySearch(number, studentList);
        if (student == null) {
            System.out.println(notFound);
        } else {
            inputInfoStudent();
            student.setId(id);
            student.setName(name);
            student.setAddress(address);
            student.setClassName(className);
            student.setScore(score);
        }
    }

    // 4. Xóa thông tin sinh viên
    public void deleteInfoStudent(int number, List<Student> studentList) {
        sortStudentList(studentList);
        Student student = findStudentByIdWithBinarySearch(number, studentList);
        if (student == null) {
            System.out.println(notFound);
        } else {
            studentList.remove(student);
        }
    }

    // Sắp xếp sinh viên
    public void sortStudentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            int index = i;
            Student temp = studentList.get(i);
            while (index > 0 && temp.getId() < studentList.get(index - 1).getId()) {
                studentList.set(index, studentList.get(index - 1));
                index--;
            }
            studentList.set(index, temp);
        }
    }

    // Tìm kiếm thông tin sinh viên thông qua id dùng tìm kiếm nhị phân
    public Student findStudentByIdWithBinarySearch(int number, List<Student> studentList) {
        int left = 0;
        int right = studentList.size() - 1;
        do {
            int mid = (right + left) / 2;
            int midStudentIndex = studentList.get(mid).getId();
            if (number == midStudentIndex) {
                return studentList.get(mid);
            } else if (number < midStudentIndex) {
                right = mid - 1;
            } else if (number > midStudentIndex) {
                left = mid + 1;
            }
        } while (left <= right);
        return null;
    }

    // 5. Tìm kiếm thông tin sinh viên thông qua tìm kiếm nhị phân
    public void findStudenInforByBinarySearch(List<Student> studentList) {
        sortStudentList(studentList);
        System.out.println(enterID);
        int id = sc.nextInt();
        Student student = findStudentByIdWithBinarySearch(id, studentList);
        System.out.println(student);
    }

    // 6. Sắp xếp sinh viên giảm dần theo Bubble sort
    public void bubbleSort(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = studentList.size() - 1; j > i; j--) {
                if (studentList.get(j).getScore() > studentList.get(j - 1).getScore()) {
                    Student temp = studentList.get(j - 1);
                    studentList.set(j - 1, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }
        displayStudent(studentList);
    }

    // 7. Tìm kiếm sinh viên có điểm cao nhất
    public void findStudentHighestScore(List<Student> studentList) {
        Student studentHighestScore = highestScore(studentList);
        System.out.println("Students has highest score number: " + studentHighestScore);
    }

    public Student highestScore(List<Student> studentList) {
        sortStudentList(studentList);
        Student highestScore = studentList.get(0);
        for (int i = 1; i < studentList.size(); i++) {
            if (highestScore.getScore() < studentList.get(i).getScore()) {
                highestScore = studentList.get(i);
            }
        }
        return highestScore;
    }

    // 8. Thống kê lượng sinh viên của từng lớp
    public void countStudentByClass(List<Student> studentList) {
        HashMap<String, Integer> abc = new HashMap<>();
        for (Student student : studentList) {
            if (abc.containsKey(student.getClassName())) {
                abc.put(student.getClassName(), abc.get(student.getClassName()) + 1);
            } else {
                abc.put(student.getClassName(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : abc.entrySet()) {
            System.out.println("Class " + entry.getKey() + " have " + entry.getValue() + " student.");
        }
    }

    // 9. Ghi danh sách ra file
    public void writeFileStudent(List<Student> studentList) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student List.txt"));
            oos.writeObject(studentList);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(success);
    }

    // 10. Đọc danh sách sinh viên từ file
    public void readFileStudent(List<Student> studentList){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Student List.txt"));
            studentList = (List<Student>) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Student st:
             studentList) {
            System.out.println(st);
        }
    }
}
