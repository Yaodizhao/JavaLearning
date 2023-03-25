import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 师兄师姐面试题目 {
    //  非连续字符串匹配
    public static Integer findEowrdCount(String s) {
        String mode = "iflytek";
        int[][] matrix = new int[s.length() + 1][mode.length() + 1];
        for (int i = 0; i <= mode.length(); i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            matrix[i][0] = 1;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= mode.length(); j++) {
                if (s.charAt(i - 1) == mode.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[s.length()][mode.length()];
    }
    
    //  url字符串解析
    public static void ParseURL(String s) {
        String[] path = s.split("[?]");
        String[] urlpart = path[0].split("//");
        System.out.println("protocal=" + urlpart[0]);
        String[] urlpath = urlpart[1].split("/");
        System.out.println("hostname=" + urlpath[0]);
        String[] port = urlpath[0].split(":");
        if (port.length > 1) {
            System.out.println("port=" + port[1]);
        } else System.out.println("port=");
        String pathname = "";
        for (int i = 1; i < urlpath.length; i++) {
            pathname = pathname + "/" + urlpath[i];
        }
        System.out.println("pathname=" + pathname);
        String[] urlhash = path[1].split("#");
        System.out.println("hash=#" + urlhash[1]);
        Stream<String> para = Arrays.stream(urlhash[0].split("&")).sorted();
        for (String s1: para.collect(Collectors.toList())) {
            System.out.println("search:" + s1);
        }
    }
    
    public static boolean validQuery() {
        
        int n = 5;
        int k = 4;
        String s = "01101";
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - k + 1; i++) {
            {
                String s1 = "" + c[i] + c[i + 1] + c[i + 2] + c[i + 3];
                if ((s1.equals("1110")) || s1.equals("1101") || (s1.equals("1011")) || (s1.equals("0111"))) {
                    System.out.printf("%d  %d\n", i + 1, i + 4);
                    c[i] = 1;
                    c[i + 1] = 1;
                    c[i + 2] = 1;
                    c[i + 3] = 1;
                }
            }
        }
        
        if (c.toString().contains("0"))
            return false;
        else
            return true;
    }
    
    // total是树总数
    public static int max_tree(int start, int[] tree, int total, int max) {
        int max2;
        int max1 = max2 = tree[start];
        if (start > total)
            return max;
        max += tree[start];
        if (2 * start <= total) {
            max1 = tree[start] + max_tree(2 * start, tree, total, max);
        }
        
        if (2 * start + 1 <= total) {
            max2 = tree[start] + max_tree(2 * start + 1, tree, total, max);
        }
        return Math.max(max1, max2);
    }
    
    //四叉树
    public static class Node {
        public int val;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        
        
        public Node() {
            this.val = - 1;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(int val, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    
    public static Node ConstrctQuadTree(int[][] grid) {
        
        return dfs(grid, 0, 0, grid.length, grid.length);
    }
    
    public static Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        if (r0 + 1 == r1 || c0 + 1 == c1) {
            return new Node(grid[r0][c0], null, null, null, null);
        }
        
        int value = 0;
        for (int i = r0; i < r1; i++) {
            for (int j = c0; j < c1; j++) {
                value += grid[i][j];
            }
        }
        
        return new Node(value,
                dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1));
    }
    
    
}