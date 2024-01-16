import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);

        int left = 0; int right = 0; int thirdNum;
        int m = 0; int n = 1; int provisional;

        int refer;
        int indexThirdNum;

        TreeSet<Triplet> tripletsAll = new TreeSet<>();

        while (m < nums.length - 1) {

            left = nums[m];
            right = nums[n];

            refer = -left - right;
            indexThirdNum = Arrays.binarySearch(nums, refer);

            if (indexThirdNum > -1) {

                thirdNum = nums[indexThirdNum];

                if (m != n && m != indexThirdNum && n != indexThirdNum) {

                    tripletsAll.add(new Triplet(left,right,thirdNum));
                }
            }
            if (n < nums.length) {
                n++;
            }
            if (n == nums.length) {
                m++;
                n = m + 1;
            }
        }
        System.out.println(tripletsAll);
    }
    public static class Triplet implements Comparable<Triplet>{
        public Integer n1;
        public Integer n2;
        public Integer n3;

        Triplet(){}
        Triplet(Integer left, Integer right, Integer thirdNum){
            this.n1 = left;
            this.n2 = right;
            this.n3 = thirdNum;

            int provisional;

            if (n3<n1){
                provisional=n3;
                n3=n1;
                n1=provisional;
            }
            if (n2<n1){
                provisional=n2;
                n2=n1;
                n1=provisional;
            }
            if (n3<n2){
                provisional=n3;
                n3=n2;
                n2=provisional;
            }
        }
        @Override
        public int compareTo(Triplet o) {
            if (n1 > o.n1) {
                return 1;
            } else if (n1 < o.n1) {
                return -1;
            }
            if (n2 > o.n2) {
                return 1;
            } else if (n2 < o.n2) {
                return -1;
            }
            if (n3 > o.n3) {
                return 1;
            } else if (n3 < o.n3) {
                return -1;
            }
            return 0;
        }
        public String toString(){
            return "["+n1+", "+n2+", "+n3+"]" ;
        }
    }
}