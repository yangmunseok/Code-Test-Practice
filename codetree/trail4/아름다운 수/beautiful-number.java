import java.util.*;

public class Main {
    public static int N;
    public static int answer = 0;

    public static void solution(int cur) {
        if(cur == N) {
            answer++;
            return;
        }
        for(int i=1; i < Math.min(N-cur+1,5); i++) {
            solution(cur+i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        
        solution(0);

        System.out.print(answer);
    }
}