import java.util.Scanner;

public class Bai5 {
//    Bài 5. Viết chương trình thực hiện nhập một xâu họ tên theo cấu trúc:
//    họ…đệm…tên; chuyển xâu đó sang biểu diễn theo cấu trúc tên…họ…đệm.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào họ: ") ;
        String lastName = scanner.nextLine();
        System.out.print("Nhập vào tên đệm : ");
        String middleName = scanner.nextLine();
        System.out.print("Nhập vào tên: ");
        String firstName = scanner.nextLine();

        String str = lastName + " " + middleName + " " + firstName;
        System.out.println("Họ tên đã nhập: " +str);

        String reverseStr = firstName + " " + middleName + " " + lastName;
        System.out.println("Họ tên theo cấu trúc mới: " + reverseStr);

    }
}
