// 本试卷唯一 ID: 89EC0919825869394507EE864B8D804A, 请勿修改本行内容
/* 注意, 这里不要写包名. 留空 */
/* 这里如果用到其他的类, 记得要引用, 否则编译不过 */

import com.sjiyuan.tree.TreeNode;

import java.util.*;

/**
 * 回答方式: 直接保存或者复制本java文件, 然后在原处作答. 建议重命名成 meta-java-<姓名>.java
 * 选择题改变量赋值的字符串
 * 实现题在原本的函数体里返回正确答案, 注意不要改动函数结构. 用这一个Java文件完成
 * 本卷直接用代码判卷, 没有人工干预. 格式错误, 语法错误, 格式改动会导致试卷无效
 * <p>
 * 注: 一个java文件可以有多个类, 但只能有一个public类. 所以你的实现中可以建内部类, 辅助类. 可以javac编译确认自己语法无误
 * 以下带public static修饰的实现题方法, 不要改变这个签名
 * <p>
 * <p>
 * 这里不要更改默认的类名, 也不要更改修饰符不要加public. 类名保持为 MetaJavaQuestionSheet
 * 可以改文件名, 建议改为 meta-java-<姓名>.java
 */
class MetaJavaQuestionSheet {

    /* qn0:
        只是样例! 不用改动

        A. 也选我, 选我就得分

        B. 选我, 选我就得分

        C. 别选我

        D. 别选我
    */
    public static String qn0 = "AB";


    /* qn1:
        下列代码的输出结果不可能是:
        private static volatile int s = 0;
        private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
                0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        public static void main(String[] args) throws InterruptedException {
            for (int i = 0; i < 10000; i++) {
                async.execute(()-> s++);
            }
            Thread.sleep(5000L);
            System.out.println(s);
        }

        A. 10001

        B. 9998

        C. 9999

        D. 10000
    */
    public static String qn1 = "A";


    /* qn2:
        下面代码会分别输出怎样的结果:
          public static void main(String[] args) {
              Thread t = new Thread() {
                  public void run() {
                      cnn();
                  }
              };
              t.run();
              System.out.print("FakeNews ");
          System.out.print("; ");
              t.start();
              System.out.print("FakeNews ");
          }
          static void cnn() {
              System.out.print("CNN ");
          }

        A. CNN FakeNews 和FakeNews CNN 都有可能 ; CNN FakeNews 和FakeNews CNN 都有可能

        B. CNN FakeNews ; CNN FakeNews

        C. CNN FakeNews 和FakeNews CNN 都有可能 ; CNN FakeNews

        D. CNN FakeNews ; CNN FakeNews 和FakeNews CNN 都有可能
    */
    public static String qn2 = "D";


    /* qn3:
        以下代码编译时哪一行会出错？

        1 package com.metaapp.solution;
        2 public class Solution {
        3     int p1 = 0;
        4     int p2 = 0;
        5     public Solution(int arg){
        6         p1 = arg;
        7     }
        8     public static void main(String args[]){
        9         Solution s1,s2;
       10         int m,n;
       11         m=1;n=2;
       12         s1 = new Solution();
       13         s2 = new Solution(n);
       14     }
       15 }

        A. Line 6

        B. Line 9

        C. Line 12

        D. Line 2
    */
    public static String qn3 = "C";


    /* qn4:
        main()方法如下，try中可以捕获两种类型的异常，如果在该方法运行中产生了一个IOException，将会输出怎样的结果:
          public static void main(String[] args) {
              System.out.print(method(0));
          }
          private static Integer method(Integer i){
              try{
                  if(i++ > 0)
                      throw new IOException();
                  return i++;
              }catch (IOException e){
                  i++;
                  return i++;
              }catch (Exception e){
                  i++;
                  return i++;
              }finally {
                  return i++;
              }
          }

        A. 3

        B. 4

        C. 2

        D. 会抛错 没有输出
    */
    public static String qn4 = "C";


    /* qn5:
        已知一个完全二叉树的第6层有3个叶子结点，则整个二叉树的结点数最多有

        A. 34

        B. 122

        C. 45

        D. 121
    */
    public static String qn5 = "D";


    /* qn6:
        method()方法如下，method()如果调用下面5个不同的update()方法，哪些SQL会被回滚 (多选):
        @Service
        public class TestService {
            @Resource
          TestService testService;

          public void method() {
            1. update1();
            ======================
            2. testService.update2();
            ======================
            3. testService.update3();
            ======================
            4. testService.update4();
            ======================
            5. testService.update5();
          }
          @Transactional
          public void update1() {
            //SQL_1
            throw new Exception();
          }
          @Transactional
          public void update2() {
            //SQL_2
            throw new Exception();
          }
          @Transactional
          private void update3() {
            //SQL_3
            throw new Exception();
          }
          @Transactional
          public void update4() {
            //SQL_4
            throw new Error();
          }
          @Transactional
          public void update5() {
            //SQL_5
            throw new IOException();
          }
        }

        A. SQL_1

        B. SQL_4

        C. SQL_5

        D. SQL_3

        E. SQL_2
    */
    public static String qn6 = "CE";


    /* qn7:
        下面的代码在java(jdk8)最终会产生几个String对象:
        String a = "没人";
        String b = "比我";
        String c = "更懂";
        String d = "java";
        String s = a + b + c + d;

        A. 7

        B. 5

        C. 8

        D. 6
    */
    public static String qn7 = "B";


    /* qn8:
        一棵二叉树后序遍历的节点顺序是: 6 4 5 2 7 3 1 ，中序遍历是: 6 4 2 5 1 3 7 ，则前序遍历结果为:

        A. 1 2 4 6 5 7 3

        B. 1 2 3 4 5 6 7

        C. 1 2 4 6 5 3 7

        D. 1 2 4 5 6 3 7
    */
    public static String qn8 = "C";


    /* qn9:
        下面代码会分别输出怎样的结果:
          public static void main(String[] args) {
              Map<String, Object> map = new HashMap<>();
              String str = "没人比我更懂java";
              StrObject obj = new StrObject("没人比我更懂java");
              map.put("str", str);
              map.put("obj", obj);

              str = "真的没人比我更懂java";
              System.out.printf(map.get("str").toString()+"; ");

              StrObject new_obj = (StrObject) map.get("obj");
              new_obj.setStr("真的没人比我更懂java");
              System.out.printf(map.get("obj").toString()+"; ");
          }
          static class StrObject{
              String str;
              public StrObject(String str){
                  this.str = str;
              }
              public void setStr(String str){
                  this.str = str;
              }
              @Override
              public String toString() {
                  return str;
              }
          }

        A. 真的没人比我更懂java; 没人比我更懂java;

        B. 真的没人比我更懂java; 真的没人比我更懂java;

        C. 没人比我更懂java; 真的没人比我更懂java;

        D. 没人比我更懂java; 没人比我更懂java;
    */
    public static String qn9 = "C";


    /* qn10:
        下面代码会分别输出怎样的结果:
        String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
        String si = "没人比我更懂java";
        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println(s == si.intern());

        A. false true true

        B. true true true

        C. false true false

        D. true false true
    */
    public static String qn10 = "C";


    /* qn11:
        下面代码会输出怎样的结果:
        public class A {

            class Inner {
                public String  v1 = "Fake News";
                public String v2 = "Go ahead";
            }

            private static String GetVal() {
                try {
                    return Inner.class.newInstance().v1;
                } catch (Exception e) {
                    try {
                        return Inner.class.getDeclaredConstructor(A.class).newInstance((A)null).v2;
                    } catch (Exception ee) {
                        ee.printStackTrace();
                        return "Fake News, Go ahead";
                    }
                }
            }
            public static void main(String[] args) {

                System.out.println(GetVal());
            }
        }

        A. 以上都不对

        B. Go ahead

        C. Fake News

        D. Fake News, Go ahead
    */
    public static String qn11 = "B";


    /* qn12:
        "没人比我更懂java".toCharArray(), 在java(jdk8)中关于这个字符数组char[], 以下说法正确的是:

        A. 这个字符串在内存中总共占用 10 byte

        B. 以上说法都不对

        C. 这个字符串在内存中总共占用 16 byte

        D. 这个字符串在内存中总共占用 20 byte
    */
    public static String qn12 = "B";


    /* qn13:
        下面这段程序当n=10的输出是()
      1 public int calc(int n) {
      2     try {
      3         n+=1;
      4         if(n/0 > 0) {
      5             n+=1;
      6         } else {
      7             n-=10;
      8         }
      9         return n;
      10     } catch(Exception e) {
      11         n++;
      12     }
      13     n++;
      14     return n++;

        A. 0

        B. 抛出异常

        C. 14

        D. 13

        E. 12
    */
    public static String qn13 = "D";


    /* qn14:
        若进栈序列为a，b，c，d，e，f，进栈和出栈可以穿插进行，则不可能出现的出栈序列是()

        A. d，c，b，a，e，f

        B. c，b，d，a，f，e

        C. b，d，c，a，e，f

        D. b，c，e，a，f，d
    */
    public static String qn14 = "D";


    /* qn15:
        public class Queue {
          private int size;
          private int[] data;
          private int front, rear;

          public Queue(int size) {
              this.size = size;
              data = new int[size];
              front = 0; rear = 0;
          }
      }
      int MaxSize=10;
      Quene q = new Queue(MaxSize);

      对于q来说，以下能判断队列满的条件是()

        A. q.front == q.rear;

        B. q.front - q.rear == MaxSize;

        C. q.front == (q.rear+1) % MaxSize;

        D. q.front + q.rear == MaxSize;
    */
    public static String qn15 = "C";




    /*
     * 以下是实现题
     */

    /**
     * <b>注意! 本题不要遍历二维数组. 要求时间复杂度严格低于n^2, 否则视为不得分 </b>
     * <p>
     * 现有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度；
     *
     * @return boolean
     */
    public static boolean searchMatrix(int[][] nums, int x) {
        // Todo your code goes here...
        if (nums == null || nums[0] == null) return false;

        int row = nums.length;
        int col = nums[0].length;
        if (nums[row - 1][col - 1] < x || nums[0][0] > x) return false;

        int rowNow = 0;
        for (int i = 0; i < row; i++) {
            if (nums[i][0] > x) {
                rowNow = i - 1;
                break;
            }
            else if (nums[i][0] == x) {
                return true;
            } else if (i == row - 1) {
                // 已经是最后一行了
                rowNow = row - 1;
            }
        }
        //1 2 3 4
        for (int start = 0, end = col - 1; start <= end; ) {
            int middle = (start + end) / 2;
            if (nums[rowNow][middle] == x) return true;
            else if (nums[rowNow][middle] > x) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */
    private static Set<String> result = new HashSet<>();

    public static Set<String> showMap(Map<String, Object> map) {
        //TODO your code goes here...

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            recursion(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void recursion(Object object, String sb) {
        if (object instanceof Map) {
            Map<String, Object> map = (Map) object;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                recursion(entry.getValue(), sb + "." + entry.getKey());
            }
        } else if (object instanceof Object[]) {
            Object[] temp = (Object[]) object;
            for(int i = 0; i < temp.length; i++){
                recursion(temp[i], sb + "["+ i + "]");
            }
        } else {
            String s;
            if(object == null){
                s = sb + " = null";
            }else{
                s = sb + " = " + object.toString();
            }
            result.add(s);
        }
    }

    /**
     * 给定一个二叉树, 检查它是否是镜像对称的
     * 例如以下是镜像对称的
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * <p>
     * 下面这个则不是镜像对称的
     * 1
     * / \
     * 2   2
     * \   \
     * 3   3
     * <p>
     * TreeNode类的定义:
     *
     * @return boolean 是否是对称的
     */

    // 以下给出TreeNode类, 请勿修改
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isTreeSymmetric(TreeNode root) {
        //TODO your code goes here...
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        preorderTraversalLeft(root, left);
        preorderTraversalRight(root, right);
        if (left.size() != right.size()) return false;

        /**
         * 两个序列完全相同才是对称的
         */
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) == null) {
                if (right.get(i) != null) return false;
            } else {
                if (right.get(i) == null || right.get(i).val != left.get(i).val) return false;
            }
        }
        return true;
    }

    public static void preorderTraversalLeft(TreeNode root, List<TreeNode> result) {
        result.add(root);
        if (root == null) return;
        preorderTraversalLeft(root.left, result);
        preorderTraversalLeft(root.right, result);
    }

    public static void preorderTraversalRight(TreeNode root, List<TreeNode> result) {
        result.add(root);
        if (root == null) return;
        preorderTraversalRight(root.right, result);
        preorderTraversalRight(root.left, result);
    }
}