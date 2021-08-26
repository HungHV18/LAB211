
import java.util.*;

interface mainInterface {

    public static ArrayList<Student> allStudent = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
}
	// Test
class Main implements mainInterface {
    // Test merge code
    public static void main(String[] args) {
        boolean exitProgram = false;
        while (exitProgram == false) {
            switch (menu()) {
                case "1":
                    create();
                    break;
                case "2":
                    Find_And_Sort();
                    break;
                case "3":
                    Update_Or_Delete();
                    break;
                case "4":
                    report();
                    break;
                case "5":
                    exitProgram = true;
                    break;
                default:
                    System.out.println(
                            "Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program\n");
            }
        }
    }

    public static String menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println(
                "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        return sc.nextLine();
    }

    public static void create() {
        int count = 1;
        while (count < 4) {
            allStudent.add(new Student());
            System.out.println("\nNext Student: ");
            ++count;
        }
        if (isContinue() == true) {
            create();
        }
    }

    public static boolean isContinue() {
        System.out.println("Do you want to continue (Y/N)?");
        switch (sc.nextLine()) {
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
                return false;
            default:
                return isContinue();
        }
    }

    public static void Find_And_Sort() {
        Collections.sort(allStudent);
        System.out.print("Search name student: ");
        String nameFind = sc.nextLine();
        for (Student student : allStudent) {
            if (student.get_Student_Name().contains(nameFind)) {
                student.printStudent();
            }
        }
    }

    public static void Update_Or_Delete() {
        System.out.println("Do you want to update (U) or delete (D) student?");
        switch (sc.nextLine()) {
            case "u":
            case "U":
                update();
                break;
            case "d":
            case "D":
                delete();
                break;
        }
    }

    public static void update() {
        int indexSt = index_By_ID();
        if (indexSt != -1) {
            allStudent.get(indexSt).printStudent();
            allStudent.get(indexSt).create_ID();
            allStudent.get(indexSt).create_Student_Name();
            allStudent.get(indexSt).create_Semester();
            allStudent.get(indexSt).create_Course_Name();
        }
    }

    public static void delete() {
        int indexStudent = index_By_ID();
        if (indexStudent != -1) {
            allStudent.remove(indexStudent);
        }
    }

    public static int index_By_ID() {
        System.out.print("ID: ");
        String ID = sc.nextLine();
        for (int i = 0; i < allStudent.size(); ++i) {
            if (ID.equals(allStudent.get(i).get_ID())) {
                return i;
            }
        }
        System.out.println("Student not found!");
        return -1;
    }

    public static void report() {
        HashMap<String, Integer> dulicateST = new HashMap<>();
        for (Student student : allStudent) {
            String key = student.get_ID() + "|" + student.get_Student_Name() + "|" + student.get_Course_Name();
            if (dulicateST.get(key) == null) {
                dulicateST.put(key, 1);
            } else {
                dulicateST.put(key, dulicateST.get(key) + 1);
            }
        }

        Set<String> keySet = dulicateST.keySet();
        for (String key : keySet) {
            String studentName = key.substring(key.indexOf("|") + 1, key.lastIndexOf("|"));
            String courseName = key.substring(key.lastIndexOf("|") + 1);
            System.out.printf("%-15s|%-10s|%-5d\n\n", studentName, courseName, dulicateST.get(key));
        }
    }

}
