public class Search {
    public static boolean search(String word , char ch, int l, int r) {
       if (word.isEmpty())
           return false;
       if (l == r)
           return word.charAt(l) == ch;
       int mid = (l+r)/2;
       return search(word , ch , 0 , mid) || search(word , ch , mid + 1 , r);
    }
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(search(s , 'o' , 0 , s.length()-1));
        System.out.println(s(s , 'l' , 0 , s.length()-1));
    }
    public static int s(String word , char ch , int l , int r){
        if (word == null || word.isEmpty() || l < 0 || r >= word.length() || l > r)
            return 0;
        if (l == r){
            return word.charAt(l) == ch ? 1 : 0;
        }
        int mid = (l + r)/2;
        return s(word , ch , 0 , mid) + s(word , ch , mid + 1 , r);
    }
}
