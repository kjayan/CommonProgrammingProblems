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
        Iterator<Map.Entry<Integer,Integer>> iterator = valueSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getValue());
        }

    }

    private int getHeight(Node node){
        return 0;
    }

    public void topDownLevelOrderTraversal(Node node){

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


    }
    public void inOrderIterative(Node node){

    }
    public void postOrderIterative(Node node){

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
