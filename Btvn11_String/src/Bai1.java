public class Bai1 {
//    Bài 1. Sử dụng xâu ký tự để viết hàm kiểm tra số thuận nghịch.
//    Áp dụng liệt kê các số thuận nghịch có 6 chữ số.
    public static void main(String[] args) {
        for (int i = 100000; i <= 999999; i++) {
            if (isPalindrome(Integer.toString(i))) {
                System.out.println(i);
            }
        }

    }
    public static boolean isPalindrome(String str){
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }
}
