package JavaCoreLearning2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chap2正则 {
    public static void main(String[] args) {
        String regex = "(?imU:[Jj]ava.)";
        String regex1 = "<\"[^\"]*\">";
        String regex12 = "<\"[.\"]*\">";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("Javaa");
        Matcher matcher1 = pattern.matcher(new StringBuilder("aaa"));
        StringBuilder sb = new StringBuilder("<\"http://www.c.com\">");
        System.out.println(regex1);
        Matcher matcher2 = pattern1.matcher(sb);
        if (matcher2.matches()) {
            System.out.println(1);
        } else System.out.println(2);
        
        
    }
}
