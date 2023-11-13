import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.CookieHandler;
import java.util.*;

public class uniZoning {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] ipt1 = sc.readLine().split(" ");
        long r = Long.parseLong(ipt1[0]); long c = Long.parseLong(ipt1[1]);
        long f = Long.parseLong(ipt1[2]); long s = Long.parseLong(ipt1[3]);
        long g = Long.parseLong(ipt1[4]);

        if (g == 0) {System.out.println(0); return;}

        HashMap<Long, ArrayList<Long[]>> mapFacToGrid = new HashMap<>();
        for (long i = 0; i < f; i++) {
            long facNo = i + 1;
            ArrayList<Long[]> gridCoOrds = new ArrayList<>();
            String[] ipt2 = sc.readLine().split(" ");
            for (long j = 1; j < ipt2.length - 1; j += 2) {
                long x = Long.parseLong(ipt2[(int) j]); long y = Long.parseLong(ipt2[(int) j + 1]);
                gridCoOrds.add(new Long[]{x, y});
            }
            Collections.sort(gridCoOrds, new Comparator<Long[]>() {
                @Override
                public int compare(Long[] o1, Long[] o2) {
                    if (o1[0].equals(o2[0])) {
                        return (int) (o1[1] - o2[1]);
                    }
                    return (int) (o1[0] - o2[0]);
                }
            });
            mapFacToGrid.put(facNo, gridCoOrds);
        }

        HashMap<Long, ArrayList<Long[]>> mapFacToStudentPos = new HashMap<>();
        for (long i = 0; i < s; i++) {
            String[] ipt3 = sc.readLine().split(" ");
            long x = Long.parseLong(ipt3[0]); long y = Long.parseLong(ipt3[1]);
            long stuNo = Long.parseLong(ipt3[2]); long facNo = Long.parseLong(ipt3[3]);
            if (!mapFacToStudentPos.containsKey(facNo)) {
                mapFacToStudentPos.put(facNo, new ArrayList<>());
            }
            mapFacToStudentPos.get(facNo).add(new Long[]{stuNo, x, y});
        }

        ArrayList<Long> movesPerFac = new ArrayList<>();
        String[] ts = sc.readLine().split(" ");
        for (int i = 0; i < f; i++) {
            long facNo = i + 1;
            long t = Long.parseLong(ts[(int) i]);
            ArrayList<Long[]> coords = mapFacToGrid.get(facNo);
            ArrayList<Long[]> stus = mapFacToStudentPos.get(facNo);
            ArrayList<Long> moves = new ArrayList<>();
            Collections.sort(stus, new Comparator<Long[]>() {
                @Override
                public int compare(Long[] o1, Long[] o2) {
                    return (int) (o1[0] - o2[0]);
                }
            });
            for (long j = 0; j < stus.size(); j++) {
                Long[] assigned_grid = coords.get((int) j);
                Long[] student_ = stus.get((int) j);
                long moves_ = Math.abs(assigned_grid[0] - student_[1]) +
                        Math.abs(assigned_grid[1] - student_[2]);
                moves.add(moves_);
            }
            Collections.sort(moves);
            long tmoves = 0;
            for (long j = 0; j < t; j++) {
                tmoves += moves.get((int) j);
            }
            movesPerFac.add(tmoves);
        }
        long ret = 0;
        Collections.sort(movesPerFac);
        for (long i = 0; i < g; i++) {
            ret += movesPerFac.get((int) i);
        }
        System.out.println(ret);
    }
}
