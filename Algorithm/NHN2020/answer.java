import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static boolean[][] visit;
    static int size;
    static int count = 0;
    private static void solution(int sizeOfMatrix, int[][] matrix) {
        int answer = 0;
        size = sizeOfMatrix;
        visit = new boolean[sizeOfMatrix][sizeOfMatrix];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int y = 0;y<sizeOfMatrix;y++) {
            for(int x =0;x<sizeOfMatrix;x++){
                if(visit[y][x] || matrix[y][x] == 0)continue;
                dfs(matrix, y,x);
                answer++;
                arrayList.add(count);
                count=0;
            }
        }
        Collections.sort(arrayList);
        System.out.println(answer);
        for(int num : arrayList){
            System.out.print(num+ " ");
        }
        System.out.println();
    }

    private static void dfs(int[][] matrix, int y, int x) {
        visit[y][x] = true;
        count++;
        if(!isLimit(y+1,x) && !visit[y+1][x] && matrix[y+1][x] == 1) {
            visit[y+1][x] = true;
            dfs(matrix,y+1,x);
        }
        if(!isLimit(y-1,x) && !visit[y-1][x] && matrix[y-1][x] == 1) {
            visit[y-1][x] = true;
            dfs(matrix,y-1,x);
        }
        if(!isLimit(y,x+1) && !visit[y][x+1] && matrix[y][x+1] == 1) {
            visit[y][x+1] = true;
            dfs(matrix,y,x+1);
        }
        if(!isLimit(y,x-1) && !visit[y][x-1] && matrix[y][x-1] == 1) {
            visit[y][x-1] = true;
            dfs(matrix,y,x-1);
        }
    }

    private static boolean isLimit(int y, int x) {
        return y < 0 || x < 0 || x >= size || y >= size;
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}