package com.learn.datastructures.tree;

import java.util.*;

public class TreeParser {

    private Node node;
    private int maxLevel = 0;

    public TreeParser(Node node) {
        this.node = node;
    }

    public void printLeftViewOfTree(Node node){
        this.maxLevel = 0;
        leftViewOfTreeRecursive(node,1);
    }

    private void leftViewOfTreeRecursive(Node node,int level){
        if(node == null){
            return;
        }

        if(this.maxLevel < level){
            System.out.println(node.getData());
            maxLevel = level;
        }
        leftViewOfTreeRecursive(node.getLeft(),level+1);
        leftViewOfTreeRecursive(node.getRight(),level+1);

    }

    public void printRightViewOfTree(Node node){
        this.maxLevel = 0;
        rightViewOfTreeRecursive(node,1);
    }

    private void rightViewOfTreeRecursive(Node node, int level){
        if(node == null){
            return;
        }
        if(maxLevel < level){
            System.out.println(node.getData());
            maxLevel = level;
        }
        rightViewOfTreeRecursive(node.getRight(),level + 1);
        rightViewOfTreeRecursive(node.getRight(),level+1);
    }

    public void printTopViewOfTree(Node node){
        if(node == null){
            return;
        }

        Set<Integer> visitedLevels = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        node.setHd(0);
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            int hd = temp.getHd();
            if(!visitedLevels.contains(hd)){
                System.out.println(temp.getData());
                visitedLevels.add(hd);
            }

            if(node.getLeft() != null){
                node.getLeft().setHd(hd-1);
                queue.add(node.getLeft());
            }

            if(node.getRight() != null){
                node.getRight().setHd(hd+1);
                queue.add(node.getRight());
            }
        }
    }

    public void printBottomViewOfTree(Node node){
        if(node == null) {
            return;
        }

        Map<Integer,Integer> valueMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        node.setHd(0);
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            int hd = temp.getHd();
            valueMap.put(hd,node.getData());
            if(node.getLeft() != null){
                node.getLeft().setHd(hd-1);
                queue.add(node.getLeft());
            }
            if(node.getRight()!= null){
                node.getRight().setHd(hd+1);
                queue.add(node.getRight());
            }
        }

        Set<Map.Entry<Integer,Integer>> valueSet = valueMap.entrySet();
        for (Map.Entry<Integer, Integer> value : valueSet) {
            System.out.println(value.getValue());
        }

    }

    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        else{
            int lHeight = getHeight(node.getLeft());
            int rHeight = getHeight(node.getRight());
            if(lHeight > rHeight){
                return lHeight;
            }
            else{
                return rHeight;
            }
        }
    }

    //Level Order Traversal - O(n2) complexity
    public void topDownLevelOrderTraversal(Node node){

        int height = getHeight(node);
        for(int i=1;i<=height;i++){
            printTopDownLevelOrderTraversal(node,i);
        }

    }
    private void printTopDownLevelOrderTraversal(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 1){
            System.out.println(node.getData());
        }
        else if(level > 1) {
            printTopDownLevelOrderTraversal(node.getLeft(), level - 1);
            printTopDownLevelOrderTraversal(node.getRight(), level - 1);
        }
    }

    //Level Order Traversal - O(n) complexity
    public void printTopDownLevelOrderOptimized(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.println(temp.getData());
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }

    public void topDownLevelOrderSpiralTraversal(Node node){

    }

    public void BottomUpLevelOrderTraversal(Node node){

    }

    public void BottomUpLevelOrderSpiralTraversal(Node node){

    }

    public void verticalOrderTraversal(Node node){

    }

    public void connectRightNeighbourNode(Node node){

    }

    public void preOrderRecursive(Node node){

        if(node == null){
            return;
        }
        System.out.println(node.getData());
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());

    }
    public void inOrderRecursive(Node node){

        if(node == null){
            return;
        }
        preOrderRecursive(node.getLeft());
        System.out.println(node.getData());
        preOrderRecursive(node.getRight());

    }
    public void postOrderRecursive(Node node){
        if(node == null){
            return;
        }
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());
        System.out.println(node.getData());
    }


    public void preOrderIterative(Node node){

        if(node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node temp = stack.peek();
            System.out.println(temp.getData());
            stack.pop();

            if(temp.getRight() != null){
                stack.push(temp.getRight());
            }

            if(temp.getLeft() != null){
                stack.push(temp.getLeft());
            }
        }

    }
    public void inOrderIterative(Node node){

        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = node;
        while(temp != null){
            stack.push(temp);
            temp = temp.getLeft();
        }

        while(stack.size() > 0){
            temp = stack.pop();
            System.out.println(temp.getData());

            if(temp.getRight() != null){
                temp = temp.getRight();
                while(temp != null){
                    stack.push(temp.getLeft());
                    temp = temp.getLeft();
                }
            }
        }
    }
    public void postOrderIterativeUsing1Stack(Node node){

    }

    /**
     *
     * @param node
     */
    public void postOrderIterativeUsing2Stack(Node node){

        if(node == null){
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while(!stack1.isEmpty()){
            Node temp = stack1.pop();
            stack2.push(temp);

            if(temp.getLeft()!= null){
                stack1.push(temp.getLeft());
            }

            if(temp.getRight() != null){
                stack1.push(temp.getRight());
            }
        }

        while(!stack2.isEmpty()){
            Node temp = stack2.pop();
            System.out.println(temp.getData());
        }

    }

    public int printNodesAtDistanceK(Node node,Node targetNode, int k){
        if(node == null){
            return -1;
        }

        if(node.equals(targetNode)){
            printNodesAtDistanceKDown(node,k);
            return 0;
        }

        int dl = printNodesAtDistanceK(node.getLeft(),targetNode,k);
        if(dl != -1){
            if(dl+1 == k){
                System.out.println(node.getData());
            }
            else{
                printNodesAtDistanceKDown(node.getRight(),k-dl-2);
            }
            return 1 + dl;
        }

        int dr = printNodesAtDistanceK(node.getRight(),targetNode,k);
        if(dr != -1){
            if(dr+1 == k){
                System.out.println(node.getData());
            }
            else{
                printNodesAtDistanceKDown(node.getLeft(),k-dr-2);
            }
            return 1+dr;
        }
        return -1;

    }

    private void printNodesAtDistanceKDown(Node node, int k){
        if(node == null){
            return;
        }

        if(k == 0){
            System.out.println(node.getData());
            return;
        }
        printNodesAtDistanceKDown(node.getLeft(),k-1);
        printNodesAtDistanceKDown(node.getRight(),k-1);

    }

    private Node getTargetNode(Node node, int targetNodeValue){
        if(node == null){
            return null;
        }
        if(node.getData() == targetNodeValue){
            return node;
        }
        else {
            Node targetNode = getTargetNode(node.getLeft(), targetNodeValue);
            if (targetNode == null) {
                targetNode = getTargetNode(node.getRight(), targetNodeValue);
            }
            return targetNode;
        }

    }


    private void markRightSiblingIterative(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); //TO mark end of level

        while(!queue.isEmpty()){
            Node temp = queue.peek();
            queue.remove();
            if(temp !=  null){
                temp.setRight(queue.peek());
                if(temp.getLeft() != null){
                    queue.add(temp.getLeft());
                }
                if(temp.getRight() != null){
                    queue.add(temp.getRight());
                }
            }
            else if(!queue.isEmpty()){
                queue.add(null);  //While q is not empty, push null to makr end of level
            }
        }
    }

    public void markRightSiblingCompleteTree(Node node){
        if(node == null){
            return;
        }
        if(node.getLeft() != null){
            node.getLeft().setRight(node.getRight());
        }
        if(node.getRight() != null){
            if(node.getRight() != null){
                node.getRight().setRight(node.getRight().getLeft());
            }
            else{
                node.getRight().setRight(null);
            }
        }
        markRightSiblingCompleteTree(node.getLeft());
        markRightSiblingCompleteTree(node.getRight());
    }

}
