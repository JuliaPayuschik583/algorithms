package timecomplexity;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        if(X == Y) {
            return 0;
        }
        if(D >= Y) {
            return 1;
        }

        return (int) Math.ceil((Y-X)/(double)D);
    }

    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;
        FrogJmp frogJmp = new FrogJmp();
        int result = frogJmp.solution(X, Y, D);
        System.out.println(result);
    }
}
