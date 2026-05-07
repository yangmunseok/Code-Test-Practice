import java.util.*;

class Line {
    int x;
    int y;

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static Line[] lines;
    public static Set<Integer> selected_line_idx = new HashSet<>();
    public static int[] dests;
    public static int answer = 100;

    public static boolean calculate() {
        for(int i=0; i<dests.length; i++) {
            int cur = i;
            for(int j=1; j<=15; j++) {
                for(int line_idx: selected_line_idx) {

                    if(lines[line_idx].y==j && (lines[line_idx].x==cur || lines[line_idx].x-1==cur)) {
                        cur = 2*lines[line_idx].x - 1 - cur;
                        break;
                    }
                }
            }
            if(dests[i]!=cur) return false;
        }
        return true;
    }

    public static void comb(int cnt) {
        if(cnt==lines.length) {
            if(selected_line_idx.size()<answer && calculate()) {
                answer = selected_line_idx.size();
            }
            return;
        }

        selected_line_idx.add(cnt);
        comb(cnt+1);
        selected_line_idx.remove(cnt);
        comb(cnt+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        lines = new Line[M];
        dests = new int[N];
        for(int i=0; i<M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            lines[i] = new Line(a, b);
        }

        for(int i=0; i<N; i++) {
            int cur = i;
            for(int j=1; j<=15; j++) {
                for(Line line: lines) {
                    if(line.y==j && (line.x==cur || line.x-1==cur)) {
                        cur = 2*line.x - 1 - cur;
                        break;
                    }
                }
            }
            dests[i] = cur;
        }

        comb(0);

        System.out.print(answer);
    }
}