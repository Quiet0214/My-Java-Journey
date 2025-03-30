/*
* 自己实现堆排序。
* 重点是heapfy（堆化）方法。堆排序主要的就是初始化构建堆，和取出根节点元素后如何重构堆，这两个操作都只要理解heapfy方法就可以很简单地实现了。
* 该方法的作用是：
*       对于一个可能不满足堆性质的子树，将它调整为大根（小根）堆。
*
* */
public class Heapsort {
    public static void main(String[] args) {
        int[] array = {5,3,6,1,8,4,2,33,87,32,421,64,62};
        int n =array.length;
        for(int i=n-1;i>=0;i--){
            heapfy(array,i);
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=array[0];
            array[0]=array[n-1-i];
            array[n-1-i]=Integer.MIN_VALUE;
            heapfy(array,0);
        }
        for(int i:ans){
            System.out.print(i+" ");
        }

    }

    public static void heapfy(int[] array,int root){
        int largest = root;
        int left = root*2+1;
        int right = root*2+2;
        if(left<array.length && array[left]>array[largest]){
            largest = left;
        }
        if(right<array.length && array[right]>array[largest]){
            largest = right;
        }
        if(largest!=root){
            int temp = array[largest];
            array[largest] = array[root];
            array[root] = temp;
            heapfy(array,largest);
        }

    }
}



