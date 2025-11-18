
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private GameBoard board;
    private JButton[] buttons;
    private JLabel messageLabel;

    public GamePanel() {
        setLayout(new BorderLayout());
        board = new GameBoard();

        JPanel gridPanel = new JPanel(new GridLayout(4, 4));
        buttons = new JButton[16];

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton();
            buttons[i] = btn;
            gridPanel.add(btn);
            btn.addActionListener(new TileClickListener(i));
        }

        JButton newGameButton = new JButton("Nytt spel");
        newGameButton.addActionListener(e -> {
            board.newGame();
            //updateBoard();
            messageLabel.setText("");
        });

        messageLabel = new JLabel(" ", SwingConstants.CENTER);

        add(gridPanel, BorderLayout.CENTER);
        add(newGameButton, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        //updateBoard();
    }



    private class TileClickListener implements ActionListener {
        private int index;

        public TileClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Här lägger vi till flyttlogiken i nästa steg
        }
    }
}
