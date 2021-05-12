import java.util.Scanner;

public class arr2 {
    public static void main(String[] args) {
        String[] name = { "철수", "영희" };
        String[] subject = { "국어", "영어", "수학" };
        int sum = 0;
        int stotal, ntotal = 0;

        // 개인 평균
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < subject.length; j++) {
                System.out.print(name[i] + " 학생 " + subject[j] + " 점수를 입력하세요 : ");
                sum += sc.nextInt();
            }
            stotal = sum / subject.length;
            System.out.println(name[i] + " 학생의 평균 점수는 " + stotal);
            System.out.println("");
            ntotal += stotal;
            sum = 0;
        }
        System.out.println("두 학생의 평균 점수는: " + (ntotal / name.length));
    }
}
