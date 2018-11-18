package paixu.gaojipaixu;

public class kuaisupaixu {

    //数组array中下标为i和j位置的元素进行交换
    private static void swap(int[] array , int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void recQuickSort(int[] array,int left,int right){
        if(right <= left){
            return;//终止递归
        }else{
            int partition = partitionIt(array,left,right);
            recQuickSort(array,left,partition-1);// 对上一轮排序(切分)时，基准元素左边的子数组进行递归
            recQuickSort(array,partition+1,right);// 对上一轮排序(切分)时，基准元素右边的子数组进行递归
        }
    }
    private static int partitionIt(int[] array,int left,int right){
        //为什么 j加一个1，而i没有加1,是因为下面的循环判断是从--j和++i开始的.
        //而基准元素选的array[left],即第一个元素，所以左游标从第二个元素开始比较
        int i = left;
        int j = right+1;
        int pivot = array[left];// pivot 为选取的基准元素（头元素）
        while(true){
            while(i<right && array[++i] < pivot){}

            while(j > 0 && array[--j] > pivot){}
            if(i >= j){// 左右游标相遇时候停止， 所以跳出外部while循环
                break;
            }else{
                swap(array, i, j);// 左右游标未相遇时停止, 交换各自所指元素，循环继续
            }
        }
        swap(array, left, j);//基准元素和游标相遇时所指元素交换，为最后一次交换
        return j;// 一趟排序完成， 返回基准元素位置(注意这里基准元素已经交换位置了)
    }
    public static void sort(int[] array){
        recQuickSort(array, 0, array.length-1);
    }
    //测试
    public static void main(String[] args) {
//int[] array = {7,3,5,2,9,8,6,1,4,7};
        int[] array = {9,9,8,7,6,5,4,3,2,1};
        sort(array);
        for(int i : array){
            System.out.print(i +" ");
        }
//打印结果为：1 2 3 4 5 6 7 7 8 9
    }
}

/**
 * youhua
 *
 *
 * //取数组下标第一个数、中间的数、最后一个数的中间值
 * private static int medianOf3(int[] array,int left,int right){
 *     int center = (right-left)/2+left;
 *     if(array[left] > array[right]){ //得到 array[left] < array[right]
 *         swap(array, left, right);
 *     }
 *     if(array[center] > array[right]){ //得到 array[left] array[center] < array[right]
 *         swap(array, center, right);
 *     }
 *     if(array[center] > array[left]){ //得到 array[center] <  array[left] < array[right]
 *         swap(array, center, left);
 *     }
 *
 *     return array[left]; //array[left]的值已经被换成三数中的中位数， 将其返回
 * }
 *
 *
 * private static int partitionIt(int[] array,int left,int right){
 *     //为什么 j加一个1，而i没有加1,是因为下面的循环判断是从--j和++i开始的.
 *     //i++ 是先引用后增加 ,先在i所在的表达式中使用i的当前值，后让i加1
 *
 *    //++i 是先增加后引用,让i先加1，然后在i所在的表达式中使用i的新值
 *
     // 他们其实都是i=i+1的意思，但是在程序中运行的时候的执行的顺序不一样。
 *     //而基准元素选的array[left],即第一个元素，所以左游标从第二个元素开始比较
 *     int i = left;
 *     int j = right+1;
 *     int pivot = array[left];// pivot 为选取的基准元素（头元素）
 *
 *     int size = right - left + 1;
 *     if(size >= 3){
 *         pivot = medianOf3(array, left, right); //数组范围大于3，基准元素选择中间值。
 *     }
 *     while(true){
 *         while(i<right && array[++i] < pivot){}
 *
 *         while(j > 0 && array[--j] > pivot){}
 *
 *         if(i >= j){// 左右游标相遇时候停止， 所以跳出外部while循环
 *             break;
 *         }else{
 *             swap(array, i, j);// 左右游标未相遇时停止, 交换各自所指元素，循环继续
 *         }
 *     }
 *     swap(array, left, j);//基准元素和游标相遇时所指元素交换，为最后一次交换
 *     return j;// 一趟排序完成， 返回基准元素位置(注意这里基准元素已经交换位置了)
 * }
 *
 *
 *
 */
