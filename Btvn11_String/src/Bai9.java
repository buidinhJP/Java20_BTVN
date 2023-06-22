import java.util.Scanner;

public class Bai9 {
//    Bài 9. Chèn chuỗi S1 vào chuỗi S2 ở vị trí k biết trước với S1, S2 và k nhập vào từ bàn phím.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập xâu S1: ");
        String s1 = scanner.nextLine();

        System.out.println("Nhập xâu S2: ");
        String s2 = scanner.nextLine();

        System.out.println("Chèn s1 vô s2 tại vị trí : ");
        int k = scanner.nextInt();

        StringBuilder sb = new StringBuilder(s2);
        sb.insert(k, s1);

        String result = sb.toString();
        System.out.println(result);
    }
}
