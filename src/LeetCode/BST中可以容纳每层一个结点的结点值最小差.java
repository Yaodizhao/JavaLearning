package LeetCode;


//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {
    
    static Node buildTree(String str) {
        
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
            
            // Get the current node's value from the string
            String currVal = ip[i];
            
            // If the left child is not null
            if (! currVal.equals("N")) {
                
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
            
            // For the right child
            i++;
            if (i >= ip.length) break;
            
            currVal = ip[i];
            
            // If the right child is not null
            if (! currVal.equals("N")) {
                
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    static void printInorder(Node root) {
        if (root == null) return;
        
        printInorder(root.left);
        System.out.print(root.data + " ");
        
        printInorder(root.right);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution sln = new Solution();
            Range rng = sln.shortestRange(root);
            System.out.println(rng.x + " " + rng.y);
        }
    }
}
//1
// 8 3 10 2 6 N 14 N N 4 7 12 N N N N N 11 13

class Range {
    int x, y;
    
    Range() {
        this.x = 0;
        this.y = 0;
    }
    
    Range(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// } Driver Code Ends


// User function Template for Java

// please refer the Range class in driver code
class Solution {
    public Range shortestRange(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (! q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                temp.add(curr.data);
                // System.out.print(curr.data+" ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            levels.add(temp);
        }
        
        int[] a = smallestRange(levels);
        Range ans = new Range(a[0], a[1]);
        return ans;
        
    }
    
    
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        
        int max = - 100000;
        int[] res = {- 100000, 100000};
        
        for (int i = 0; i < nums.size(); i++) {
            int mol = nums.get(i).get(0);
            max = Math.max(max, mol);
            int arr[] = {mol, 0, i};
            pq.add(arr);
        }
        
        
        while (true) {
            int arr[] = pq.remove();
            if (res[1] - res[0] > max - arr[0]) {
                res[0] = arr[0];
                res[1] = max;
            }
            arr[1]++;
            int i = arr[2];
            
            if (arr[1] == nums.get(i).size()) {
                break;
            } else {
                arr[0] = nums.get(i).get(arr[1]);
                max = Math.max(max, arr[0]);
                pq.add(arr);
            }
        }
        
        return res;
    }
}
