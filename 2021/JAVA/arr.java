public class arr {
    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 30 };
        int[] arr2 = arr1;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1[" + i + "] = " + arr1[i]);
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }
        arr2[0] = 100;
        arr2[1] = 200;
        arr2[2] = 300;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1[" + i + "] = " + arr1[i]);
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }
    }
}