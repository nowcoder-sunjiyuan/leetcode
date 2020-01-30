package com.sjiyuan.tree;

import com.sjiyuan.array.Search2DMatrix2_240;

import java.util.Stack;

/**
 * @ClassName SerializeTree_449
 * @Description TODO 序列化与反序列化二叉树
 * @Author sjy
 * @Date 2020/1/29 19:38
 * @Version 1.0
 **/
public class SerializeTree_449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        if (root == null) return "$";
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                result.append(p.val);
                p = p.left;
            } else {
                //遇到null的时候，添加$字符串，然后再去父节点的右节点
                result.append("$");
                TreeNode pop = stack.pop();
                p = pop.right;
            }
            result.append(",");
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    /**
     * 此方法应该会有更容易的解法
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("$")) return null;

        Stack<TreeNode> stack = new Stack<>();

        int tag = 0;
        //true代表向左，false向右
        boolean direction = true;


        TreeNode result = null;
        TreeNode pre = null;
        String[] split = data.split(",");
        for(String c : split){
            TreeNode temp = null;
            if(tag == 0){
                //上面已经把空节点排除了，所以tag为0时，第一个节点肯定是数字
                temp = new TreeNode(Integer.valueOf(c));
                result = temp;
                pre = temp;
                tag = 1;
                stack.push(temp);
            }else{
                if(c.equals("$")){
                    if(direction) pre.left = null;
                    else pre.right = null;

                    /**
                     * 当匹配了一个$后，表示是节点遇到了空
                     * 如果左空，说明下一个节点该向右。如果右空，还是应该向右，所以每次pop后，都应把方向置向右
                     */
                    direction = false;
                    pre = stack.pop();
                }else{
                    temp = new TreeNode(Integer.valueOf(c));
                    if(direction) pre.left = temp;
                    else pre.right = temp;
                    /**
                     * 当匹配一个非空时，表示遇到带值的节点，下一个节点方向应该向左
                     */
                    pre = temp;
                    direction = true;
                    stack.push(temp);
                }
            }

        }

        return result;
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        SerializeTree_449 serializeTree_449 = new SerializeTree_449();
        String serialize = serializeTree_449.serialize(root);
        System.out.println(serialize);

        String s = "4,2,1,$,$,3,$,$,7,6,$,$,9,$";

        TreeNode deserialize = serializeTree_449.deserialize(s);

    }
}
