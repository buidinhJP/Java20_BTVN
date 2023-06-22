import java.util.*;

public class Bai7 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập xâu S1: ");
            String s1 = scanner.nextLine();

            System.out.println("Nhập xâu S2: ");
            String s2 = scanner.nextLine();

            while (s1.contains(s2)) {
                s1 = s1.replace(s2, "");
            }

            System.out.println("Xâu S1 sau khi loại bỏ S2: " + s1);

        }
    }

