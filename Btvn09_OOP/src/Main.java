import Entity.Subject;
import Entity.Teacher;
import service.FileUtil;
import teachingTable.Teaching;
import teachingTable.TeachingTimeSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Subject> subjectList = new ArrayList<>();
    private static List<Teacher> teacherList = new ArrayList<>();
    private static List<Teaching> teachingList = new ArrayList<>();

    public static void main(String[] args) {
        // đọc file các thứ ở đây
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
//                    FileUtil.readDataFromFile(subjectList,"MH.txt");
                    createNewSubject();
                    printSubject();
                    break;
                case 2:
//                    FileUtil.readDataFromFile(teacherList,"GV.txt");
                    createNewTeacher();
                    printTeacher();
                    break;
                case 3:
//                    FileUtil.readDataFromFile(teachingList,"TKGD.txt");
                    createTeachingTable();
                    printTeaching();
                    break;
                case 4:
                    sortTeachingTable();
                    break;
                case 5:
                    teacherIncome();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static int functionChoice() {
        System.out.println("-----QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN-------");
        System.out.println("1.Nhập danh sách môn học");
        System.out.println("2.Nhập danh sách giảng viên");
        System.out.println("3.Lập bảng kê khai giảng dạy cho mỗi giảng viên");
        System.out.println("4.Sắp xếp danh sách kê khai giảng dạy");
        System.out.println("5.Lập bảng tính tiền công cho mỗi giảng viên");
        System.out.println("6.Thoát");
        System.out.print("Nhập sự lựa chọn của bạn: ");
        int functionChoice = 0;
        boolean checkFunction = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                checkFunction = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                continue;
            }
            if (functionChoice <= 0 || functionChoice > 6) {
                System.out.print("Nhập số trong khoảng từ 1 đến 6! Nhập lại: ");
                checkFunction = false;
            } else break;
        } while (!checkFunction);
        return functionChoice;
    }

    public static void createNewSubject() {
        System.out.println("Nhập số lượng môn học: ");
        int allSubject = 0;
        boolean checkSubject = true;
        do {
            try {
                allSubject = new Scanner(System.in).nextInt();
                checkSubject = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                checkSubject = false;
                continue;
            }
            if (allSubject <= 0) {
                System.out.print("Số lượng môn học không được nhỏ hơn 0! Nhập lại: ");
                checkSubject = false;
            }
        } while (!checkSubject);

        for (int i = 0; i < allSubject; i++) {
            Subject subject = new Subject();
            subject.informSubjectInfo();
            subjectList.add(subject);
        }
        FileUtil.writeDataToFile(subjectList, "MH.txt");
    }

    public static void printSubject() {
        subjectList.forEach(System.out::println);
    }

    public static void createNewTeacher() {
        System.out.println("Nhập số lượng giáo viên: ");
        int allTeacher = 0;
        boolean checkTeacher = true;
        do {
            try {
                allTeacher = new Scanner(System.in).nextInt();
                checkTeacher = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                checkTeacher = false;
                continue;
            }
            if (allTeacher <= 0) {
                System.out.print("Số lượng giáo viên phải lớn hơn 0! Nhập lại: ");
                checkTeacher = false;
            }
        } while (!checkTeacher);
        for (int i = 0; i < allTeacher; i++) {
            Teacher teacher = new Teacher();
            teacher.informInfo();
            teacherList.add(teacher);
        }
        FileUtil.writeDataToFile(teacherList, "GV.txt");
    }

    public static void printTeacher() {
        teacherList.forEach(System.out::println);
    }

    public static boolean isValidSubjectAndTeacher() {
        return subjectList != null && teacherList != null && !subjectList.isEmpty() && !teacherList.isEmpty();
    }

    public static void createTeachingTable() {
        if (!isValidSubjectAndTeacher()) {
            System.out.println("Bạn cần nhập giảng viên và môn học trước khi thống kê! ");
            return;
        }
        for (int i = 0; i < teacherList.size(); i++) {
            System.out.println("------Kê khai cho giảng viên " + teacherList.get(i).getName() + "----------");
            System.out.print("Nhập số môn học mà giảng viên " + teacherList.get(i).getName() + " dạy :");
            int subjectNumber = 0;
            boolean check = true;
            do {
                try {
                    subjectNumber = new Scanner(System.in).nextInt();
                    check = true;
                } catch (Exception e) {
                    System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                    check = false;
                    continue;
                }
                if (subjectNumber <= 0 || subjectNumber > subjectList.size()) { // <---- dùng subjectList.size()
                    System.out.print("Số môn giảng viên dạy phải lớn hơn 0 và nhỏ hơn tổng số môn! Nhập lại: ");
                    check = false;
                }
            } while (!check);
            List<TeachingTimeSheet> tableList = new ArrayList<>();
            do {
                int sum = 0;
                for (int j = 0; j < subjectNumber; j++) {
                    System.out.print("Nhập id môn thứ " + (j + 1) + " mà giảng viên " + teacherList.get(i).getName() + " dạy: ");
                    int subjectId;
                    int totalClass = 0;
                    do {
                        try {
                            subjectId = new Scanner(System.in).nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("không được có ký tự khác ngoài số! Nhập lại: ");
                            check = false;
                            continue;
                        }
                        Subject subject = searchSubjectId(subjectId);
                        if (subject != null) {
                            System.out.println("Nhập số lớp của môn thứ " + (j + 1) + " mà giảng viên " + teacherList.get(i).getName() + " dạy:");
                            do {
                                try {
                                    totalClass = new Scanner(System.in).nextInt();
                                    check = true;
                                } catch (Exception e) {
                                    System.out.println("Không được có ký tự khác ngoài số! Nhập lại: ");
                                    check = false;
                                    continue;
                                }
                                if (totalClass <= 0 || totalClass > 3) {
                                    System.out.print("Số lớp dạy phải lớn hơn 0 và không lớn hơn 3! Nhập lại: ");
                                    check = false;
                                }
                            } while (!check);
                            // viết hàm tính tổng số tiết của giảng viên
                            sum += subjectList.get(j).getLessonTotal() * totalClass;
                            System.out.println(sum);
                            if (sum > 200) {
                                System.out.println("Tổng số tiết học vượt quá 200! Nhập lại từ đầu cho giảng viên này nhé: ");
                                check = false;
                                break;
                            }
                            else check = true;
                            tableList.add(new TeachingTimeSheet(subject, totalClass));
                            break;
                        } else System.out.print("Không có id môn học vừa nhập! Nhập lại: ");
                    } while (true);
                }
            } while (!check);

            Teaching teaching = new Teaching(teacherList.get(i), tableList);
            teachingList.add(teaching);
        }
        FileUtil.writeDataToFile(teachingList, "TKGD.txt");
    }

    public static void printTeaching() {
        teachingList.forEach(System.out::println);
    }

    public static void sortTeachingTable() {
        if (teacherList == null || teacherList.isEmpty()) {
            System.out.println("Nhập bảng chấm công trước khi sắp xếp");
            return;
        }
        do {
            System.out.println("------Sắp xếp danh sách chấm công---------");
            System.out.println("1.Theo tên giảng viên");
            System.out.println("2.Theo số tiết giảng dạy mỗi môn");
            System.out.println("3.Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            int choice = 0;
            boolean checkChoice = true;
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    checkChoice = true;
                } catch (Exception e) {
                    System.out.println("không được phép có ký tự khác ngoài ký tự số! Nhập lại");
                    checkChoice = false;
                    continue;
                }
                if (choice <= 0 || choice > 3) {
                    System.out.print("Nhập trong khoảng từ 1 đến 3! Nhập lại: ");
                    checkChoice = false;
                }
            } while (!checkChoice);
            switch (choice) {
                case 1:
                    sortByTeacherName();
                    break;
                case 2:
                    sortBySubjectLesson();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    public static void sortByTeacherName() {
        for (int i = 0; i < teachingList.size(); i++) {
            for (int j = i + 1; j < teachingList.size(); j++) {
                if (teachingList.get(i).getTeacher().getName().compareTo(teachingList.get(j).getTeacher().getName()) > 0) {
                    Teaching tmp = teachingList.get(i);
                    teachingList.set(i, teachingList.get(j));
                    teachingList.set(j, tmp);
                }
            }
        }
        printTeaching();
    }

    public static void sortBySubjectLesson() {
        lessonCalculation();
        for (int m = 0; m < teachingList.size(); m++) {
            for (int n = m + 1; n < teachingList.size(); n++) {
                if (teachingList.get(m).getAllLesson() < teachingList.get(n).getAllLesson()) {
                    Teaching tmp = teachingList.get(m);
                    teachingList.set(m, teachingList.get(n));
                    teachingList.set(n, tmp);
                }
            }
            for (int l = 0; l < teachingList.get(m).teachingTimeSheets().size(); l++) {
                for (int h = l + 1; h < teachingList.get(m).teachingTimeSheets().size(); h++) {
                    if (teachingList.get(m).teachingTimeSheets().get(l).getTotallesson()
                            < teachingList.get(m).teachingTimeSheets().get(h).getTotallesson()) {
                        TeachingTimeSheet tmp2 = teachingList.get(m).teachingTimeSheets().get(l);
                        teachingList.get(m).teachingTimeSheets().set(l, teachingList.get(m).teachingTimeSheets().get(h));
                        teachingList.get(m).teachingTimeSheets().set(h, tmp2);
                    }
                }
            }
        }
        teachingList.forEach(System.out::println);
    }

    public static void teacherIncome() {
        if (teacherList == null || teacherList.isEmpty()) {
            System.out.println("Nhập bảng chấm công trước khi tính lương!");
            return;
        }
        for (int i = 0; i < teachingList.size(); i++) {
            System.out.println("-------Tính tiền lương cho giảng viên " + teachingList.get(i).getTeacher().getName() + "---------");
            for (int j = 0; j < teachingList.get(i).teachingTimeSheets().size(); j++) {
                float practice;
                System.out.println("Tính toán tiền cho môn " + teachingList.get(i).teachingTimeSheets().get(j).getSubject().getName());
                System.out.println("Số tiết thực hành :");
                practice = teachingList.get(i).teachingTimeSheets().get(j).getSubject().getLessonTotal()
                        - teachingList.get(i).teachingTimeSheets().get(j).getSubject().getTheoryLesson();
                System.out.println(practice);
                System.out.println("Chi phí cho môn học này là: ");
                float sum = (teachingList.get(i).teachingTimeSheets().get(j).getSubject().getTheoryLesson()
                        * teachingList.get(i).teachingTimeSheets().get(j).getSubject().getExpense()
                        + practice * teachingList.get(i).teachingTimeSheets().get(j).getSubject().getExpense() * 70 / 100)
                        * teachingList.get(i).teachingTimeSheets().get(j).getTotalClass();
                System.out.println(sum);
            }
        }
    }

    public static Subject searchSubjectId(int id) {
//        for (int i = 0; i < subjectList.size(); i++) {
//            if (subjectList.get(i).getId() == id) {
//                return subjectList.get(i);
//            }
//        }
//        return null;

        List<Subject> resultList = subjectList.stream().filter(subject -> subject.getId() == id).collect(Collectors.toList());
        return !resultList.isEmpty() ? resultList.get(0) : null;
    }

    public static void lessonCalculation() {
        for (int i = 0; i < teachingList.size(); i++) {
            List<Double> sumLessonList = new ArrayList<>();
            System.out.println("---------Tính số tiết học cho giảng viên " + teachingList.get(i).getTeacher().getName() + "---------");
            for (int j = 0; j < teachingList.get(i).teachingTimeSheets().size(); j++) {
                System.out.println("Tính số tiết học cho môn " + teachingList.get(i).teachingTimeSheets().get(j).getSubject().getName());
                float sumLesson = teachingList.get(i).teachingTimeSheets().get(j).getSubject().getLessonTotal()
                        * teachingList.get(i).teachingTimeSheets().get(j).getTotalClass();
                System.out.println(sumLesson);
                sumLessonList.add((double) sumLesson);
                teachingList.get(i).teachingTimeSheets().get(j).setTotallesson((int) sumLesson);
            }
            System.out.println("Tổng số tiết học của giảng viên " + teachingList.get(i).getTeacher().getName() + " là: ");
            float temptotal = 0;
            for (int k = 0; k < teachingList.get(i).teachingTimeSheets().size(); k++) {
                temptotal += sumLessonList.get(k);
            }
            System.out.println(temptotal);
            teachingList.get(i).setAllLesson(temptotal);
        }
    }
}