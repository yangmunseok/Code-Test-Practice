import java.util.*;

public class Main {
    public static int K, N;
    public static int[] sequence;


    public static void solution(int cnt) {
        if(cnt==sequence.length) {
            for(int num: sequence) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.print("\n");
            return;
        }

        for(int i=1; i<=K; i++) {
            sequence[cnt] = i;
            solution(cnt+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        K = scanner.nextInt();
        N = scanner.nextInt();
        sequence = new int[N];

        solution(0);
    }
}