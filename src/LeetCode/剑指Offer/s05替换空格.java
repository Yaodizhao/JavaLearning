package LeetCode.剑指Offer;

/**
 * @author 如月车站
 */
public class s05替换空格 {
    public static void main(String[] args) {
        String s = new s05替换空格().replaceSpace("We are happy.");
        System.out.println(s);
    }

    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer(s);
        int len1 = s.length();
        for(int i=0; i<len1; i++) {
            if(s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        int len2 = sb.length();
        int p1 = len1-1;
        int p2 = len2-1;
        while(p1>=0 && p1<p2) {
            char c = s.charAt(p1--);
            if(c == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            }
            else{
                sb.setCharAt(p2--, c);
            }
        }
        return sb.toString();
    }

}
