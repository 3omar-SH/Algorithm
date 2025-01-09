public class BinaryNum {
    public static void binaryNum(String s ,int n) {
        if (s.length() == n){
            System.out.println(s);
            return;
        }
        binaryNum(s+"0" , n);
        binaryNum(s+"1" , n);
    }
    public static void main(String[] args) {
        binaryNum("" , 3);
    }
}
