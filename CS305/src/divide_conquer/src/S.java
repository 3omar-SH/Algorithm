public class S {
    public String reString(String str , char ch) {
        if (str == "")
            return str;
        char last = str.charAt(str.length()-1);
        if (last == ch)
            return last + reString(str.substring(0,str.length()-1), ch);
        else
            return reString(str.substring(0,str.length()-1), ch) + last;
    }


    public static void main(String[] args) {
        S s = new S();
        System.out.println(s.reString("cscscscs", 'c'));
    }
}
