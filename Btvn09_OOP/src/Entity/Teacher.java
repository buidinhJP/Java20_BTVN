package Entity;

import java.io.Serializable;
import java.util.Scanner;

public class Teacher extends Person implements Serializable {
    private int id;
    private String level;

    private static final String GS_TS = "Giáo sư - Tiến sĩ";
    private static final String PGS_TS = "Phó giáo sư - Tiến sĩ";
    private static final String MAIN_LECTURER = "Giảng viên chính";
    private static final String THS = "Thạc sĩ";

    private static int AUTO_ID = 100;

    public Teacher() {
    }

    public Teacher(int id, String level) {
        this.id = id;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static String getGsTs() {
        return GS_TS;
    }

    public static String getPgsTs() {
        return PGS_TS;
    }

    public static String getMainLecturer() {
        return MAIN_LECTURER;
    }

    public static String getTHS() {
        return THS;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public void informInfo() {
        this.setId(Teacher.AUTO_ID);

        super.informInfo();
        System.out.println("Nhập trình độ giảng viên: ");
        System.out.println("1.Giáo sư - Tiến sĩ");
        System.out.println("2.Phó giáo sư - Tiến sĩ");
        System.out.println("3.Giảng viên chính");
        System.out.println("4.Thạc sĩ");
        System.out.println("Xin hãy lựa chọn");
        boolean check = true;
        do {
            int choice = 0;
            try {
                choice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            if (choice <= 0 || choice > 4) {
                System.out.print("Nhập số trong khoảng từ 1 đến 4! Nhập lại: ");
                check = false;
                continue;
            }

            switch (choice) {
                case 1:
                    this.setLevel(Teacher.GS_TS);
                    System.out.println("Giáo sư - Tiến sĩ");
                    check = true;
                    break;
                case 2:
                    this.setLevel(Teacher.PGS_TS);
                    System.out.println("Phó giáo sư - Tiến sĩ");
                    check = true;
                    break;
                case 3:
                    this.setLevel(Teacher.MAIN_LECTURER);
                    System.out.println("Giảng viên chính");
                    check = true;
                    break;
                case 4:
                    this.setLevel(Teacher.THS);
                    System.out.println("Thạc sĩ");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 4!");
                    check = false;
                    break;
            }
        } while (!check);
        Teacher.AUTO_ID++;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "id=" + id +
                ", level='" + level + '\'' +
                '}';
    }


}