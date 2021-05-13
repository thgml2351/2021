public class Reference {
    int value;

    public static void main(String[] args) {
        int a = 20;
        int b = 60;
        swap(a, b);
        System.out.println(a + " " + b);
    }

    public static void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
