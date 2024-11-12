package jayslabs.corejava;

public class PeakBST {
    public static void main(String[] args) {
        System.out.println("PeakBST");

        int[] intsArr = {43,2,1,3,7,87,43,2,5,8,1};

        int peakIdx = findPeakIdx(intsArr);
        int peakVal = intsArr[peakIdx];
        System.out.println("Peak index: " + peakIdx);
        System.out.println("Peak value: " + peakVal);

    }

    public static int findPeakIdx(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int rVal =0;
        int lVal =0;
        // binary search
        while (left < right) {
            int midIdx = left + (right - left) / 2;
            rVal = arr[midIdx + 1];
            lVal = arr[midIdx];

            if (lVal > rVal){
                right = midIdx;
            } else {
                left = midIdx + 1;
            }
        }
        return left;
    }

}
