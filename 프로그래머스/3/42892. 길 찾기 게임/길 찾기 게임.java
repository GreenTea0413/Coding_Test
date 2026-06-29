import java.util.*;

class Solution {

    static class Node {
        int x, y, num;
        Node left, right;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(
                    nodeinfo[i][0],
                    nodeinfo[i][1],
                    i + 1
            ));
        }

        // y 내림차순으로 하는 이유가 높이가 높은 것이 부모이기 때문에
        // 최상단 부모 선택
        nodes.sort((a, b) -> b.y - a.y);
        Node root = nodes.get(0);
        
        // node 하나씩 꺼내서 규칙에 맡게 트리 생성
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }

        preorder(root);
        postorder(root);

        int[][] answer = new int[2][nodeinfo.length];

        for (int i = 0; i < pre.size(); i++) {
            answer[0][i] = pre.get(i);
        }

        for (int i = 0; i < post.size(); i++) {
            answer[1][i] = post.get(i);
        }

        return answer;
    }

    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    private void preorder(Node node) {
        if (node == null) return;

        pre.add(node.num);

        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);

        post.add(node.num);
    }
}