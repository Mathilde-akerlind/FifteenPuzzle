
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

}