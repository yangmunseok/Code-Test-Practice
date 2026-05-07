import java.util.*;

class Line {
    int l;
    int r;
    public Line(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
public class Main {

    public static int answer = 0;

    public static Line[] lines;
    public static int MAX_N = 1000;

    public static boolean[] valid = new boolean[MAX_N+1];
    public static Set<Integer> selected_line_idx = new HashSet<>();

    public static boolean isValid() {
        for(int i=0; i<MAX_N+1; i++) {
            valid[i] = true;
        }
        
        for(int idx: selected_line_idx) {
            for(int x = lines[idx].l; x < lines[idx].r + 1; x++) {
                if(!valid[x]) return false;
                valid[x] = false;
            }
        }

        return true;
    }

    public static void comb(int cnt) {
        if(cnt==lines.length) {
            if(selected_line_idx.size()>answer && isValid())
            answer = selected_line_idx.size();
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
        lines = new Line[N];

        for(int i=0; i<N; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            lines[i] = new Line(l,r);
        }
        
        comb(0);

        System.out.print(answer);
    }
}