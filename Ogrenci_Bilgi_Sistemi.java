import java.util.Scanner;

public class Ogrenci_Bilgi_Sistemi {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "TRH");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
        Teacher t3 = new Teacher("Kül Yutmaz", "90550000002", "BIO");

        // dersler
        Course tarih = new Course("Tarih", "101", "TRH");
        tarih.addTeacher(t1);

        Course fizik = new Course("Fizik", "102", "FZK");
        fizik.addTeacher(t2);

        Course biyoloji = new Course("Biyoloji", "103", "BIO");
        biyoloji.addTeacher(t3);

        //öğrenciler
        Student s1=new Student("İnek Şaban","140144015","4",tarih,fizik,biyoloji);
        s1.addBulkExamNote(100,50,40,90,90,90);

        s1.isPass();

        Student s2=new Student("Güdük Necmi","2211133","4",tarih,fizik,biyoloji);
        s2.addBulkExamNote(50,20,40,50,100,100);

        s2.isPass();


    }
}

public class Teacher {
    String name;
    String mpno;
    String branch;

    //constructor
    public Teacher(String name, String mpno, String branch)
    {
        this.name = name;
        this.mpno = mpno;
        this.branch = branch;
    }

    //Metotlar

    void print(){
        System.out.println("Adı: "+this.name);
        System.out.println("Telefon: "+this.mpno);
        System.out.println("Bölümü: "+this.branch);
    }



}

public class Student {
    Course course1;
    Course course2;
    Course course3;
    String name;
    String stuNo;
    String classes;
    double avarage;
    boolean isPass;

    Student(String name, String stuNo, String classes, Course course1, Course course2, Course course3) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.avarage = 0.0;
        this.isPass = false;
    }

    //Metotlar

    void addBulkExamNote(double not1, double not2, double not3,double sNot1,double sNot2,double sNot3) {
        if (not1 >= 0 && not1 <= 100)
            this.course1.note = not1;

        if (not2 >= 0 && not2 <= 100)
            this.course2.note = not2;

        if (not3 >= 0 && not3 <= 100)
            this.course3.note = not3;

        if (sNot1 >= 0 && sNot1 <= 100)
            this.course1.sNote =sNot1;

        if (sNot2 >= 0 && sNot2 <= 100)
            this.course2.sNote = sNot2;

        if (sNot3 >= 0 && sNot3 <= 100)
            this.course3.sNote = sNot3;
    }

    void isPass() {
        System.out.println("--------------------------------------");
        System.out.println(name);
        double course1=(this.course1.sNote*0.20)+(this.course1.note*0.80);
        double course2=(this.course2.sNote*0.20)+(this.course2.note*0.80);
        double course3=(this.course3.sNote*0.20)+(this.course3.note*0.80);
        this.avarage = (course1+course2+course3) / 3.0;
        printNote();
        if (this.avarage > 55) {
            System.out.println("Sınıfı Geçti. ");
            this.isPass = true;
        } else {
            System.out.println("Sınıfta kaldı");
            this.isPass = false;
        }
        //printNote();
    }


    void printNote() {
        System.out.println(this.course1.name + " sınav notu: " + this.course1.note + " sözlü notu: " + this.course1.sNote);
        System.out.println(this.course2.name + " sınav notu: " + this.course2.note + " sözlü notu: " + this.course2.sNote);
        System.out.println(this.course3.name + " sınav notu: " + this.course3.note + " sözlü notu: " + this.course3.sNote);
        System.out.println("Ortalamanız: " + this.avarage);

    }




}

public class Course {
    Teacher teacher;
    String name;
    String code;
    String prefix;
    double note;
    double sNote;

    //constructor
    Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0.0;
        this.sNote = 0.0;
    }

    //Metotlar
    void addTeacher(Teacher teacher)
    {
        if (teacher.branch.equals(this.prefix)) {
            this.teacher = teacher;
        } else
            System.out.println("Öğretmen/Ders uyuşmazlığı!");
    }

    void printTeacher()
    {
        this.teacher.print();
    }

}
