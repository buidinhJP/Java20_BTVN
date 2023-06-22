import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = scanner.nextLine();
        System.out.println("Chuỗi đã nhập: " + str);
        String str2 = str.trim();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (i == 0){
                result.append(Character.toUpperCase(str2.charAt(0)));
            } else if (c == ' '){
                continue;

            }else {
                result.append(c);
            }
        }
        System.out.println(result);

    }
}
