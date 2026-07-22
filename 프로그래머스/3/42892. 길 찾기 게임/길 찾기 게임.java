import java.util.*;

class Solution {
    class Node{
        int x;
        int y;
        int idx;
        
        Node left;
        Node right;
        
        Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];
        
        List<Node> nodes = new ArrayList<>();
        
        // node객체를 만들어서 해당 값을 넣어주기
        for(int i = 0 ; i < n; i++){
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        
        // y 좌표들을 기준으로 해서 높은 것을 부모로
        nodes.sort((a,b) -> (b.y - a.y));
        Node root = nodes.get(0);
        
        for(int i = 1; i < n; i++){
            insert(root, nodes.get(i));
        }
        
        preorder(root);
        postorder(root);
        
        for(int i = 0; i < n; i++){answer[0][i] = pre.get(i);}
        for(int i = 0; i < n; i++){answer[1][i] = post.get(i);}
        return answer;
    }
    
    public void insert(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left != null){
                insert(parent.left, child);
            }
            else{
                parent.left = child;
            }
        }
        else{
            if(parent.x < child.x){
                if(parent.right != null){
                    insert(parent.right, child);
                }
                else{
                    parent.right = child;
                }
            }
        }
    }
    
    public void preorder(Node root){
        if(root != null){
            pre.add(root.idx);
            
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            post.add(root.idx);
        }
    }
}