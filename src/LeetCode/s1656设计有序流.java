package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class s1656设计有序流 {
    public static class OrderedStream {
        
        public String[] os;
        int ptr;
        int n;
        
        public OrderedStream(int n) {
            this.os = new String[n + 1];
            this.ptr = 1;
            this.n = n;
        }
        
        public List<String> insert(int idKey, String value) {
            os[idKey] = value;
            List<String> ans = new ArrayList<>();
            if (os[ptr] != null) {
                int i = ptr;
                //先判断坐标在判断右侧
                for (; i < n + 1 && os[i] != null; ) {
                    ans.add(os[i]);
                    i++;
                }
                ptr = i;
            }
            
            return ans;
        }
    }
}
