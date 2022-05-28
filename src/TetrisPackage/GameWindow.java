package TetrisPackage;

import javax.swing.*;

public class GameWindow {
    public static final int WIDTH = 460, HEIGHT = 638;

    private Board board;
    private IntroScreen introScreen;
    private JFrame window;
    public static int tmrVlaue=0;

    public GameWindow() {
        JLabel counterLabel = new JLabel("");
        window = new JFrame("Tetris");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        board = new Board();
        introScreen = new IntroScreen(this);

        window.addKeyListener(board);
        window.addKeyListener(introScreen);

        window.add(introScreen);

        window.setVisible(true);
    }

    public void startTetris(){
        window.remove(introScreen);
        window.addMouseMotionListener(board);
        window.addMouseListener(board);
        window.add(board);
        board.startGame();
        window.revalidate();
        //make true for music to play
        MusicPlayer.MusicState=true;
        new MusicPlayer();
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
