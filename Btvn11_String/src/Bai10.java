import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập xâu S1: ");
        String s1 = scanner.nextLine();

        System.out.println("Nhập xâu S2: ");
        String s2 = scanner.nextLine();

        StringBuilder sb = new StringBuilder(s2);
        String result = sb.replace(0, sb.length(), sb.toString().replace(s1, "")).toString();

        System.out.println("Chuỗi mới sau khi loại bỏ: " + result);
    }
}
