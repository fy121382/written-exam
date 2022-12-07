package questionandanswer;
//        第三题
public class Three {
    public static void start(Integer[] array){
        process(array,0,array.length-1);
    }

    public static void process(Integer[] array, Integer l, Integer r) {
        //去除长度为一的数组
        if(l==r){
            return;
        }
        //找到中间值，将数组分为左右两部分
        Integer mid = ((l+r)>>1);
        //排序左边
        process(array,l,mid);
        //排序右边
        process(array,mid+1,r);
        merge(array,l,mid,r);
    }

    public static void merge(Integer[] array, Integer l, Integer mid, Integer r) {
        Integer temp[] = new Integer[r - l + 1];
        Integer p1 = l;
        Integer p2 = mid + 1;
        Integer i = 0;
        while (p1 <= mid && p2 <= r) {
            temp[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }
        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }
        while (p2 <= r) {
            temp[i++] = array[p2++];
        }
        for (Integer i1 = 0; i1 < temp.length; i1++) {
            array[l + i1] = temp[i1];
        }
    }
}
