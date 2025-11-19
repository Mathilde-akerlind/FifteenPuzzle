import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {
    private List<Integer> tiles;
    private final int size = 4;

    public GameBoard() {
        newGame();
    }

    public void newGame() {
        tiles = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            tiles.add(i); // 0-15
        }
        Collections.shuffle(tiles);
    }

    public List<Integer> getTiles() {
        return tiles;
    }

    public int getSize() {
        return size;
    }

    public boolean isSolved() {
        for (int i = 0; i < tiles.size() - 1; i++) {
            if (tiles.get(i) != i + 1) return false;
        }
        return tiles.get(tiles.size() - 1) == 0;
    }

    public boolean tryMove(int index) {
        int emptyIndex = tiles.indexOf(0);

        int row = index / size;
        int col = index % size;

        int emptyRow = emptyIndex / size;
        int emptyCol = emptyIndex % size;

        boolean adjacent =
                (row == emptyRow && Math.abs(col - emptyCol) == 1) ||
                        (col == emptyCol && Math.abs(row - emptyRow) == 1);

        if (!adjacent) return false;

        Collections.swap(tiles, index, emptyIndex);
        return true;
    }

}
