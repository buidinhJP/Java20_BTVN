import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi: ");
        String str = scanner.nextLine();

        String[] words = str.split(" ");
        String longestWord = "";
        int position = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > longestWord.length()){
                longestWord = word;
                position = i;
            }
        }
        System.out.println("Từ dài nhất : " + longestWord);
        System.out.println("Vị trí: " + position);
    }
}
