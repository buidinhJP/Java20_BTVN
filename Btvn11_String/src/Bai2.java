import java.util.Scanner;

public class Bai2 {
//    Bài 2. Viết chương trình nhập vào một xâu ký tự s bất kỳ,
//    đó chuyển sang dạng xen kẽ chữ in hoa và chữ in thường.
//    Ví dụ s = ABCDefgh thì kết quả là AbCdEfGh
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào xâu ký tự : ");
        String s = scanner.nextLine();

        String result = convertToMixedCase(s);
        System.out.println("Kết quả : " + result);
    }

    public static String convertToMixedCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }

        }
        return sb.toString();
    }
        }

