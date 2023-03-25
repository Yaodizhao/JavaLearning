package 数据结构;

import java.io.IOException;
import java.util.Scanner;

public class GraphDefine {
    
    // 无向图（邻接矩阵实现）
    public static class MatrixUDG {
        private char[] Vexs;
        private int[][] Matrix;
        private int n, e;
        
        //输入数据建立图
        public MatrixUDG() {
            System.out.println("输入节点总数：");
            this.n = readInt();
            System.out.println("输入边总数：");
            this.e = readInt();
            
            //边，点数出错返回错误
            if (n < 1 || e < 1 || (e > (n * (n - 1)))) {
                System.out.println("input error: invalid parameters!\n");
                return;
            }
            Vexs = new char[n];
            Matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                System.out.printf("请输入点%d:", i);
                Vexs[i] = readChar();
            }
            for (int i = 0; i < e; i++) {
                System.out.printf("请输入边%d（格式如a c）:", i);
                char c1 = readChar();
                char c2 = readChar();
                int p1 = getPosition(c1);
                int p2 = getPosition(c2);
                if (p1 == - 1 || p2 == - 1) {
                    System.out.println("input error: invalid edge!\\n");
                    return;
                }
                Matrix[p1][p2] = 1;
                Matrix[p2][p1] = 1;
            }
            
        }
        
        public MatrixUDG(char[] vexs, char[][] edges) {
            this.e = edges.length;
            this.n = vexs.length;
            
            Vexs = new char[n];
            Matrix = new int[n][n];
            System.arraycopy(vexs, 0, Vexs, 0, n);
            for (int i = 0; i < e; i++) {
                int p1 = getPosition(edges[i][0]);
                int p2 = getPosition(edges[i][1]);
                if (p1 == - 1 || p2 == - 1) {
                    System.out.println("input error: invalid edge!\\n");
                    return;
                }
                Matrix[p1][p2] = 1;
                Matrix[p2][p1] = 1;
            }
            
        }
        
        private int getPosition(char c) {
            for (int i = 0; i < Vexs.length; i++)
                if (Vexs[i] == c)
                    return i;
            return - 1;
        }
        
        private char readChar() {
            char ch = '0';
            do {
                try {
                    ch = (char)System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (! ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
            return ch;
        }
        
        private int readInt() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }
        
        private int firstVertex(int v) {
            if (v < 0 || v > (Vexs.length - 1))
                return - 1;
            
            for (int i = 0; i < Vexs.length; i++)
                if (Matrix[v][i] == 1)
                    return i;
            
            return - 1;
        }
        
        private int nextVertex(int v, int w) {
            
            if (v < 0 || v > (Vexs.length - 1) || w < 0 || w > (Vexs.length - 1))
                return - 1;
            
            for (int i = w + 1; i < Vexs.length; i++)
                if (Matrix[v][i] == 1)
                    return i;
            
            return - 1;
        }
        
        public void DFS_Recursion(int i, boolean[] visited) {
            visited[i] = true;
            System.out.printf("%c ", Vexs[i]);
            for (int w = firstVertex(i); w != - 1; w = nextVertex(i, w)) {
                if (! visited[w]) {
                    DFS_Recursion(w, visited);
                }
            }
        }
        
        public void DFS() {
            boolean[] visited = new boolean[this.n];
            
            System.out.print("DFS:");
            for (int i = 0; i < this.n; i++) {
                if (! visited[i]) {
                    DFS_Recursion(i, visited);
                }
            }
        }
        
        public void DFS_NoRecursion() {
            
            boolean[] visited = new boolean[this.n];
            
            // 节点栈
            char[] stack = new char[this.n];
            int top = - 1;
            
            stack[++ top] = Vexs[0];
            visited[0] = true;
            while (top != - 1) {
                char cur = stack[top--];
                for (int i = firstVertex(getPosition(cur)); i != - 1 && i < this.n; i = nextVertex(getPosition(cur), i)) {
                    if (! visited[i]) {
                        stack[++ top] = Vexs[i];
                        visited[i] = true;
                    }
                }
                System.out.printf("%c ", cur);
            }
        }
        
        public void BFS() {
            int front = 0, rear = 0;
            int[] queue = new int[this.n];
            boolean[] visited = new boolean[this.n];
            System.out.print("BFS:");
            for (int i = 0; i < this.n; i++) {
                if (! visited[i]) {
                    visited[i] = true;
                    System.out.printf("%c ", Vexs[i]);
                    queue[rear++] = i;
                }
                while (front != rear) {
                    int j = queue[front++];
                    for (int k = firstVertex(j); k != - 1; k = nextVertex(j, k)) {
                        if (! visited[k]) {
                            visited[k] = true;
                            System.out.printf("%c ", Vexs[k]);
                            queue[rear++] = k;
                        }
                    }
                }
            }
        }
    }
    
    // 无向图（邻接表实现）
    public static class ListUDG {
        
        private static class ENode {
            int adjvex;
            ENode next;
        }
        
        private static class VNode {
            char data;
            ENode FirstEdge;
        }
        
        private VNode[] Vexs;
        private int n, e;
        
        public ListUDG() {
            System.out.println("输入节点总数：");
            this.n = readInt();
            System.out.println("输入边总数：");
            this.e = readInt();
            
            //边，点数出错返回错误
            if (n < 1 || e < 1 || (e > (n * (n - 1)))) {
                System.out.println("input error: invalid parameters!\n");
                return;
            }
            Vexs = new VNode[n];
            
            for (int i = 0; i < n; i++) {
                System.out.printf("请输入点%d:", i);
                Vexs[i] = new VNode();
                Vexs[i].data = readChar();
                Vexs[i].FirstEdge = null;
            }
            for (int i = 0; i < e; i++) {
                System.out.printf("请输入边%d（格式如a c）:", i);
                char c1 = readChar();
                char c2 = readChar();
                int p1 = getPosition(c1);
                int p2 = getPosition(c2);
                
                ENode e1 = new ENode();
                e1.adjvex = p2;
                if (Vexs[p1].FirstEdge == null) {
                    Vexs[p1].FirstEdge = e1;
                } else {
                    linkLast(Vexs[p1].FirstEdge, e1);
                }
                
                ENode e2 = new ENode();
                e2.adjvex = p1;
                if (Vexs[p2].FirstEdge == null) {
                    Vexs[p2].FirstEdge = e2;
                } else {
                    linkLast(Vexs[p2].FirstEdge, e2);
                }
            }
        }
        
        public ListUDG(char[] vexs, char[][] edges) {
            this.n = vexs.length;
            this.e = edges.length;
            
            //边，点数出错返回错误
            Vexs = new VNode[n];
            
            for (int i = 0; i < n; i++) {
                Vexs[i] = new VNode();
                Vexs[i].data = vexs[i];
                Vexs[i].FirstEdge = null;
            }
            for (int i = 0; i < e; i++) {
                int p1 = getPosition(edges[i][0]);
                int p2 = getPosition(edges[i][1]);
                
                ENode e1 = new ENode();
                e1.adjvex = p2;
                if (Vexs[p1].FirstEdge == null) {
                    Vexs[p1].FirstEdge = e1;
                } else {
                    linkLast(Vexs[p1].FirstEdge, e1);
                }
                
                ENode e2 = new ENode();
                e2.adjvex = p1;
                if (Vexs[p2].FirstEdge == null) {
                    Vexs[p2].FirstEdge = e2;
                } else {
                    linkLast(Vexs[p2].FirstEdge, e2);
                }
            }
        }
        
        private void linkLast(ENode list, ENode node) {
            ENode p = list;
            
            while (p.next != null)
                p = p.next;
            p.next = node;
        }
        
        private int getPosition(char c) {
            for (int i = 0; i < Vexs.length; i++)
                if (Vexs[i].data == c)
                    return i;
            return - 1;
        }
        
        private char readChar() {
            char ch = '0';
            do {
                try {
                    ch = (char)System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (! ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
            return ch;
        }
        
        private int readInt() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        }
        
    }
    
}
