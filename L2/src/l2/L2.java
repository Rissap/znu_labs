package l2;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class L2 {

    public static void main(String[] args) {
        //scalarMul();
        //vectorMul();
        //fibonachi();
        //transp();
        //mulMatrix();
        
        System.out.println("On 10.000 elements: ");
        bubbleSort();
        insertSort();
        quickSortPrep();
        mergeSortPrep();

    }
    
    public static void scalarMul(){
        Scanner in = new Scanner(System.in);
        String sides[] = {"x", "y", "z"};
        int v1[] = new int[3];
        int v2[] = new int[3];
        
        System.out.println("Vector1: ");
        for(int i=0; i<3; i++){
            System.out.println("Ener "+sides[i]+": ");
            v1[i] = in.nextInt();
        }
        System.out.println("Vector2: ");
        for(int i=0; i<3; i++){
            System.out.println("Ener "+sides[i]+": ");
            v2[i] = in.nextInt();
        }
        
        int result = 0;
        for(int i=0; i<3; i++){
            result += v1[i]*v2[i];
        }
        System.out.println(result);
    }
    
    public static void vectorMul(){
        Scanner in = new Scanner(System.in);
        String sides[] = {"x", "y", "z"};
        int v1[] = new int[3];
        int v2[] = new int[3];
        int v3[] = new int[3];
        
        System.out.println("Vector1: ");
        for(int i=0; i<3; i++){
            System.out.println("Ener "+sides[i]+": ");
            v1[i] = in.nextInt();
        }
        System.out.println("Vector2: ");
        for(int i=0; i<3; i++){
            System.out.println("Ener "+sides[i]+": ");
            v2[i] = in.nextInt();
        }
        
        v3[0] = v1[1]*v2[2] - v1[2]*v2[1];
        v3[1] = v1[2]*v2[0] - v1[0]*v2[2];
        v3[2] = v1[0]*v2[1] - v1[1]*v2[0];
        
        System.out.println("Vector: ");
        for(int i=0; i<3; i++){
            System.out.print(v3[i]+" ");
        }
        System.out.println("");
    }
 
    public static void fibonachi(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = in.nextInt();
        
        int array[] = new int[size];
        array[0] = 0;
        array[1] = 1;
        
        for(int i=2; i<array.length; i++){
            array[i] = array[i-1]+array[i-2];
        }
        
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
    
    public static void transp() {
        Scanner in = new Scanner(System.in);
        System.out.println("Size of square matrix: ");
        int m = in.nextInt();
        int n = m;
        
        int array[][] = new int[m][n];
        int result[][] = new int[n][m];
        
        System.out.println("Raw matrix");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                array[i][j] = (int)(Math.random()*10);
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[j][i] = array[i][j];
            }
        }
        
       System.out.println("Transpan matrix");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void mulMatrix(){
        //int size = (int)(Math.random()*10);
        int size = 3;
        int m1[][] = new int[size][size];
        int m2[][] = new int[size][size];
        int res[][] = new int[size][size];
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                m1[i][j] = (int)(Math.random()*5);
                m2[i][j] = (int)(Math.random()*5);
            }
        }
        
        System.out.println("Matrix 1: ");
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                System.out.print(m1[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("Matrix 2: ");
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                System.out.print(m2[i][j]+" ");
            }
            System.out.println();
        }
        
        int tmp = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                
                for(int k=0; k<size; k++){
                    tmp += m1[j][k] * m2[k][i];
                }
                
                res[j][i] = tmp;
                tmp = 0;
            }
            
        }
        
        System.out.println("Result: ");
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    /* sort */
    
    public static void bubbleSort(){
        int size = 10000;
        int array[] = new int[size];
        for(int i=0; i<size; i++){
            array[i] = (int)(-20+Math.random()*40);
            //System.out.print(array[i]+" ");
        }
        //System.out.println();
        
        long t1, t2;
        t1 = System.currentTimeMillis();
        
        int tmp;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if (array[i] < array [j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        t2 = System.currentTimeMillis();
        System.out.println("Buble sort in "+(double)(t2-t1)/1000+" s");
        /*
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
        }
        */
    }
    
    public static void insertSort(){
        int size = 10000;
        int array[] = new int[size];
        for(int i=0; i<size; i++){
            array[i] = (int)(-20+Math.random()*40);
            //System.out.print(array[i]+" ");
        }
        //System.out.println();
        
        long t1, t2;
        t1 = System.currentTimeMillis();
        
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j]> key) {
                array[j + 1]= array[j];
                j = j - 1;
            }
            array[j + 1]= key;
        }
        
        t2 = System.currentTimeMillis();
        System.out.println("Insert sort in "+(double)(t2-t1)/1000+" s");
        /*
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
        }
        */
    }
    
    /* merge sort*/
    public static void mergeSortPrep(){
        int size = 10000;
        int array[] = new int[size];
        for(int i=0; i<size; i++){
            array[i] = (int)(-20+Math.random()*40);
            //System.out.print(array[i]+" ");
        }
        //System.out.println();
        
        long t1, t2;
        t1 = System.currentTimeMillis();
        array = mergeSort(array);
        /*
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
        }
        */
        t2 = System.currentTimeMillis();
        System.out.println("Merge sort in "+(double)(t2-t1)/1000+" s");
    }
    
    public static int[] mergeSort(int[] arr) {
	int len = arr.length;
	if (len < 2) return arr;
	int middle = len / 2;
	return merge(mergeSort(Arrays.copyOfRange(arr, 0, middle)),
	             mergeSort(Arrays.copyOfRange(arr, middle, len)));
    }
    
    public static int[] merge(int[] arr_1, int[] arr_2) {
	int len_1 = arr_1.length, len_2 = arr_2.length;
	int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
	int[] result = new int[len];
	for (int i = 0; i < len; i++) {
		if (b < len_2 && a < len_1) {
			if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
			else result[i] = arr_1[a++];
		} else if (b < len_2) {
			result[i] = arr_2[b++];
		} else {
			result[i] = arr_1[a++];
		}
	}
	return result;
    }
    /* end merge sort */
    
    public static void quickSortPrep(){
        int size = 10000;
        int array[] = new int[size];
        for(int i=0; i<size; i++){
            array[i] = (int)(-20+Math.random()*40);
            //System.out.print(array[i]+" ");
        }
        //System.out.println();
        
        long t1, t2;
        t1 = System.currentTimeMillis();
        quickSort(array, 0, size-1);
        /*
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
        }*/
        
        t2 = System.currentTimeMillis();
        System.out.println("Quick sort in "+(double)(t2-t1)/1000+" s");
    }
    
    public static void quickSort(int[] array, int low, int high) {
            if (array.length == 0)
                return;//завершить выполнение, если длина массива равна 0

            if (low >= high)
                return;//завершить выполнение если уже нечего делить

            // выбрать опорный элемент
            int middle = low + (high - low) / 2;
            int opora = array[middle];

            // разделить на подмассивы, который больше и меньше опорного элемента
            int i = low, j = high;
            while (i <= j) {
                while (array[i] < opora) {
                    i++;
                }

                while (array[j] > opora) {
                    j--;
                }

                if (i <= j) {//меняем местами
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
        }

        // вызов рекурсии для сортировки левой и правой части
            if (low < j)
            quickSort(array, low, j);

        if (high > i)
                quickSort(array, i, high);
        }
}
