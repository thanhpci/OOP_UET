public class StudentManagement {
    Student[] students;
    int studentCount;

    StudentManagement() {
        students = new Student[100];
        studentCount = 0;
    }

    public void addStudent(Student newStudent) {
        students[studentCount] = newStudent;
        studentCount++;
    }


    /**
     * Same group.
     */

    public static boolean sameGroup(Student s1, Student s2) {


        String groupS1 = s1.getGroup();
        String groupS2 = s2.getGroup();

        if (groupS2.equals(groupS1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Students by group.
     */

    public String studentsByGroup() {
        boolean[] printed = new boolean[studentCount];
        String groupCurrent;
        String  result = "";

        for (int i = 0; i < studentCount; i++) {
            printed[i] = false;
        }

        for (int i = 0; i < studentCount; i++) {
            groupCurrent = students[i].getGroup();
            if (printed[i]) {
                continue;
            }

            result += groupCurrent + "\n";

            for (int j = 0; j < studentCount; j++) {
                if (!printed[j] && students[j].getGroup().equals(groupCurrent)) {
                    result += students[j].getInfo() + "\n";
                    printed[j] = true;
                }
            }
        }
        return result;
    }

    /**
     * Students remove group.
     */

    public void removeStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                i--;
                studentCount--;
            }
        }
    }



}
