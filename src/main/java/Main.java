import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String val = ArgsValidator.validate(args);
        if (val != null) {
            System.out.println(val);
            return;
        }
        Path startPuzzle = Paths.get("../../../files/" + args[2]);
        byte[][] fileImport = FileOperator.readBoard(startPuzzle);
        int rows = FileOperator.getRows();
        int columns = FileOperator.getColumns();
        FifteenPuzzle fp = new FifteenPuzzle(fileImport, rows, columns);
        Path solutionPath = Paths.get("../../../files/" + args[3]);
        Path stats = Paths.get("../../../files/" + args[4]);
        switch (args[0]) {
            case "bfs" -> new BreadthFirstSolve(fp, args[1], rows, columns, solutionPath, stats);
            case "dfs" -> new DepthFirstSolve(fp, args[1], rows, columns, solutionPath, stats);
            case "astr" -> new Astar(fp, args[1], rows, columns, solutionPath, stats);
        }
    }
}
