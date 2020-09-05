package com.sjiyuan.doublepointer;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import javax.print.attribute.EnumSyntax;
import java.util.EnumSet;

/**
 * 有序数组的两数之和，太简单了吧，双指着
 */
public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int[] result = new int[2];
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                result[0] = index1 + 1;
                result[1] = index2 + 1;
                break;
            }else if(numbers[index1] + numbers[index2] < target){
                /**
                 * 如果和小了，说明左边的小了，左边变大
                 */
                index1++;
            }else{
                /**
                 * 如果和大了，说明右边大了，右边变大
                 */
                index2--;
            }
        }
        return result;
    }
}
