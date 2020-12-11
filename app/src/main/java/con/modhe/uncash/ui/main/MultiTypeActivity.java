package con.modhe.uncash.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

import java.util.Arrays;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import con.modhe.uncash.R;
import con.modhe.uncash.ui.main.ui.LinearLayout1;
import con.modhe.uncash.ui.main.ui.LinearLayout2;

/**
 * author Created by harrishuang on 2020-08-07.
 * email : huangjinping1000@163.com
 */
public class MultiTypeActivity extends AppCompatActivity {

    private LinearLayout2 layout_child;
    private LinearLayout1 layout_parent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multitype);
        initView();
//
        SparseArray<Object> sparseArray = new SparseArray<>();
//        sparseArray.put(0, null);
//        sparseArray.put(1, "fsdfd");
//        sparseArray.put(2, new String("fjdslfjdk"));
//        sparseArray.put(3, 1);
//        sparseArray.put(4, new Boolean(true));
//        sparseArray.put(5, new Object());
//        sparseArray.put(8, new String("42fsjfldk"));
//        sparseArray.put(20, "jfslfjdkfj");
//        sparseArray.put(0, "chongfude");
//        sparseArray.put(12, "chon12gfude");
//        sparseArray.put(15, "chongf12ude");
//        sparseArray.put(18, "chongf18ude");
//        sparseArray.put(300, "chongf300ude");
//        sparseArray.put(200, "chongf200ude");
//        sparseArray.put(100, "chongf100ude");
//        sparseArray.put(101, "chongf101ude");
//        sparseArray.put(111, "chongf111ude");
//        sparseArray.put(11, "chongf11ude");
//
//        int size = sparseArray.size();
//        for (int i = 0; i < size; i++) {
//            Log.d("okhttp", "sparseArraySample: i = " + i + ";value = " + sparseArray.get(sparseArray.keyAt(i)));
//        }
//
//        冒泡排序
//        bubbleSort();
        //选择排序
//        selectSort();
        onBinarySearch();
        Fragment fragment = new Fragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_container, fragment).commitAllowingStateLoss();
        transaction.replace(R.id.layout_container, fragment).commit();
    }


    private void bubbleSort() {
        int[] arr = {3, 2, 1, 3, 1123, 123, 1235, 11, 2, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int a : arr) {
            Log.d("okhttp", "================" + a);
        }

    }

    private void selectSort() {
        int[] arr = {3, 2, 1, 3, 1123, 123, 1235, 11, 2, 6};
        int max = 0;
        int index = 0;
        //外层循环控制次数(arr.lenth-1)次
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                //选择出来最大值；
                if (max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }
            //每次选择完成后，max中存放的是该轮选出的最大值
            //将max指向位置的元素和数组最后一个元素位置互换
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = max;
            arr[index] = temp;
            //清空max和index，便于下次
            max = 0;
            index = 0;
        }

        Log.d("okhttp", "select================select================");
        for (int a : arr) {
            Log.d("okhttp", "select================" + a);
        }
        Log.d("okhttp", "select================select================");

    }


    private void quickSort() {
        int[] arr = {3, 2, 1, 3, 1123, 123, 1235, 11, 2, 6};
        //调用快速排序算法
        quick(arr, 0, arr.length - 1);
        //打印排序的后结果，查看是否正确
        System.out.println(Arrays.toString(arr));
    }


    private void quick(int[] arr, int start, int end) {

        //如果开始位置和结束位置重合，实际上就是一个数字，所以开始位置一定要比结束位置小，而且不能相等
        if (start < end) {
            //设定标准数，也就是快速排序的过程中，和谁进行比较，通常用第一个数字即可
            //注意这里用的是arr[start],按说在第一次的时候是0，应该写成arr[start],但是不可以
            //因为快速排序是一个递归的操作，第二次进来的时候，就不是arr[0]了
            int stand = arr[start];

            //开始找开始位置和结束位置
            //我们知道快速排序其实就是有一个开始位置和一个结束位置，当开始位置比选定的标准数字大的时候，就会替换掉
            //结束位置的数字，这个时候结束位置的下表开始向前移动，然后如果结束位置的数字比标准数字，则替换开始位置的数字
            //在循环的过程中如果开始位置/结束位置的数字 不比标准数字大或者小，这个时候开始位置和结束位置就会向后/向前移动

            //开始位置
            int low = start;
            //结束位置
            int high = end;

            while (low < high) {

                //这个时候我们已经找定了开始位置和结束位置

                //第一次是要拿高位和低位进行比较,如果高位比标准数字大，则高位则向前移动一位
                while (low < high && arr[high] > stand) {
                    high--;
                }
                //当然了并不是所有高位数字都比低位大，如果比低位要小，则这个数字要覆盖低位的数字
                arr[low] = arr[high];

                //然后这个时候低位开始移动，如果低位比标准数字小，则低位的下标向后移动一位
                while (low < high && arr[low] < stand) {
                    low++;
                }

                //当然了并不是所有时候低位都比标准数字要小，如果比标准数字大的话，这个时候就要替换掉高位的数字
                arr[high] = arr[low];
            }

            //经过上面的一番折腾，这个时候就会出现一个情况，低位和高位相同，那么这个位置就用标准数字去替换
            //这里low和high实际上是相同的数字，所以写哪个都无所谓
            arr[low] = stand;

            //然后第一轮排序完毕，我们就会发现以标准数字为分界线，我们有两个学列了，这个时候，我们就调用递归来
            //分别对两个序列进行排序

            //先出来低位的递归,最后的位置实际上有可能是高位，有可能是低位，既然上面写的是低位，这里就写低位就好了
            quick(arr, start, low);
            //然后出来高位的数字
            quick(arr, low + 1, end);
        }
    }

    // This is Arrays.binarySearch(), but doesn't do any argument validation.
    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            Log.d("okhttp", lo + "==lo====" + hi + "===hi====" + mid + "");
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }

//        Log.d("okhttp",  "~"+lo);

        return ~lo;  // value not present
    }


    private void onBinarySearch() {
        int[] arr = {3, 2, 1, 11, 5, 6};


        Log.d("okhttp", "binarySearch================" + binarySearch(arr, arr.length, 11));
//        for (int a : arr) {
//            Log.d("okhttp", "================" + ~a);
//        }
    }

    private void initView() {
        layout_child = (LinearLayout2) findViewById(R.id.layout_child);
        layout_parent = (LinearLayout1) findViewById(R.id.layout_parent);
    }
}
