package sanchayan;

import java.util.*;

class Tree_traversals {


    static void iterPreOrder(Node root){
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return;
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.value);
            if(root.right!=null)
                stack.push(root.right);
            if(root.left!=null)
                stack.push(root.left);
        }
        System.out.println(list);
    }

    static int maxDepth(Node root){
        if(root == null)
            return 0;
        
        int lr = maxDepth(root.left);
        int rr = maxDepth(root.right);

        return 1+Math.max(lr,rr);
    }

    static void preorderTraversal(Node root){
        if(root == null)
            return;
        
        System.out.println(root.value);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static void inorderTraversal(Node root){
        if(root == null)
            return;
        
        inorderTraversal(root.left);
        System.out.println(root.value);
        inorderTraversal(root.right);
    }


    static void postorderTraversal(Node root){
        if(root == null)
            return;
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.value);
    }

    static void levelOrderTraversal(Node root){
        if(root == null)
            return;
        if(root.right==null && root.left==null){
            System.out.println(root.value);
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<List<Integer>>(); 
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list2 = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                if(queue.peek().left!=null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right!=null)
                    queue.offer(queue.peek().right);
                list2.add(queue.poll().value);
            }
            list.add(list2);
        }
        System.out.println(list);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node newNode = new Node(17);

        System.out.println("Inorder");
        inorderTraversal(root);
        System.err.println();
        System.out.println("Preorder");
        preorderTraversal(root);
        System.out.println();
        System.out.println("Iterative Preorder Traversal");
        iterPreOrder(root);
        System.out.println();
        System.out.println("Postorder");
        postorderTraversal(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);
        System.out.println("Height of Tree");
        System.out.println(maxDepth(root));
        
    }
}
