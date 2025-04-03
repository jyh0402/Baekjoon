import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] board,copy;
    static int Rr,Rc;
    static int hr,hc;
    static int Br,Bc;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayDeque<int[]> que;
    static int min;
    static int nr,nc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        copy = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'O') {
                    hr = i;
                    hc = j;
                } else if (board[i][j] == 'B') {
                    Br = i;
                    Bc = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'R') {
                    Rr = i;
                    Rc = j;
                    board[i][j] = '.';
                }
            }
        }
        que = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < N; i++) {
				copy[i] = Arrays.copyOf(board[i], M);				
			}
            if (Br * dr[d] + Bc * dc[d] < Rr * dr[d] + Rc * dc[d]) {
            	//빨강이 먼저 이동
                if (!move(Rr,Rc,d)) {
                    copy[nr][nc] = 'R';
                }
                int nRr = nr;
                int nRc = nc;
                if (move(Br,Bc,d)) {
                    continue;
                }
                int nBr = nr;
                int nBc = nc;
                que.offer(new int[] {nBr,nBc,nRr,nRc,d,1});
            } else {
                //파랑이 먼저 이동
                if (move(Br,Bc,d)) {
                    continue;
                }
                int nBr = nr;
                int nBc = nc;
                copy[nr][nc] = 'B'; 
                move(Rr,Rc,d);
                int nRr = nr;
                int nRc = nc;
                que.offer(new int[] {nBr,nBc,nRr,nRc,d,1});
            }
        }
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            Br = cur[0];
            Bc = cur[1];
            Rr = cur[2];
            Rc = cur[3];
            int dir = cur[4];
            int count = cur[5];
            //System.out.println(Arrays.toString(cur));
            if (count > 10) {
                min = -1;
                break;
            }
            if (Rr == hr && Rc == hc) {
            	min = count;
            	break;
            }
            
            for (int d = 0; d < 2; d++) {
            	int nd = (dir < 2) ? (2 + d) : d;
                for (int i = 0; i < N; i++) {
    				copy[i] = Arrays.copyOf(board[i], M);				
    			}
                if (Br * dr[nd] + Bc * dc[nd] < Rr * dr[nd] + Rc * dc[nd]) {
                	//빨강이 먼저 이동
                    if (!move(Rr,Rc,nd)) {
                        copy[nr][nc] = 'R';
                    }
                    int nRr = nr;
                    int nRc = nc;
                    if (move(Br,Bc,nd)) {
                        continue;
                    }
                    int nBr = nr;
                    int nBc = nc;
                    que.offer(new int[] {nBr,nBc,nRr,nRc,nd,count+1});
                } else {
                    //파랑이 먼저 이동
                    if (move(Br,Bc,nd)) {
                        continue;
                    }
                    int nBr = nr;
                    int nBc = nc;
                    copy[nBr][nBc] = 'B'; 
                    move(Rr,Rc,nd);
                    int nRr = nr;
                    int nRc = nc;
                    que.offer(new int[] {nBr,nBc,nRr,nRc,nd,count+1});
                }
            }
        }
        System.out.println(min);
    }
    private static boolean move(int r, int c, int d) {
        while(true) {
            r += dr[d];
            c += dc[d];
            if (copy[r][c] == 'O') {
                nr = r;
                nc = c;
                return true;
            } else if (copy[r][c] != '.') {
                nr = r - dr[d];
                nc = c - dc[d];
                return false;
            }
        }
    }
}