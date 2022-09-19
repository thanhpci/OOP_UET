public class Hello {

    public static void main(String [] args) {

        Student nguyenVanAn = new Student("Nguyen An", "1", "an55@vnu.edu.vn");
        Student anSo2 = new Student(nguyenVanAn);
        anSo2.setGroup("k65CAclc");

        Student an1 = new Student("do nan", "9", "an55@vnu.edu.vn");
        Student an2 = new Student("tam An", "2", "ann@vnu.edu.vn");
        Student an3 = new Student("duc An", "3", "ann@vnu.edu.vn");
        Student an4 = new Student("hai An", "4", "ann@vnu.edu.vn");
        Student an5 = new Student("ngu An", "5", "ann@vnu.edu.vn");

        an3.setGroup("K99BB");

        an5.setGroup("K99BB");

        StudentManagement truongZ = new StudentManagement();

        truongZ.addStudent(nguyenVanAn);
        truongZ.addStudent(anSo2);
        truongZ.addStudent(an1);
        truongZ.addStudent(an3);
        truongZ.addStudent(an4);
        truongZ.addStudent(an5);

        truongZ.removeStudent("1");

        System.out.println(truongZ.studentsByGroup());
//        System.out.println(truongZ.sameGroup(anSo2,nguyenVanAn));


    }


}
