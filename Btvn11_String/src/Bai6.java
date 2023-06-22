import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        do {
        System.out.println("Nhập 1 câu không quá 20 từ: ");
        str = scanner.nextLine();

        String[] words = str.split("\\s+");

        if (words.length > 20) {
        System.out.println("Câu bạn đã nhập quá 20 từ. Vui lòng nhập lại.");
        continue;
        }

        boolean valid = true;
        for (String word : words) {
        if (word.length() > 10) {
        System.out.println("Có từ bạn đã nhập quá 10 ký tự. Vui lòng nhập lại.");
        valid = false;
        break;
        }
        }

        if (valid) {
        StringBuilder str2 = new StringBuilder();
        for (String word : words) {
        str2.append(word);
        }
        System.out.println("Chuỗi đã tách từ câu: " + str2);

        char[] charArray = str2.toString().toCharArray();
        Arrays.sort(charArray);
        String sortedStr = new String(charArray);
        System.out.println("Chuỗi đã sắp xếp theo thứ tự alphabet: " + sortedStr);

        break;
        }
        } while (true);
        }
        }

