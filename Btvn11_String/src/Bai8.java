import java.util.Scanner;

public class Bai8 {
//    Tìm kiếm vị trí xuất hiện đầu tiên của chuỗi S1 trong S2. Nếu không tìm thấy trả về -1.
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập xâu S1: ");
            String s1 = scanner.nextLine();

            System.out.println("Nhập xâu S2: ");
            String s2 = scanner.nextLine();

            int index = s2.indexOf(s1);
            if (index != -1) {
                System.out.println("Vị trí xuất hiện đầu tiên của S1 trong S2 là " + index);
            } else {
                System.out.println("Không tìm thấy S1 trong S2");
            }
        }

    }
