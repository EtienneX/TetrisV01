package TetrisPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class IntroScreen extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	private BufferedImage instructions;
	private GameWindow window;

	private BufferedImage[] playButton = new BufferedImage[2];
	private Timer timer;
	
	
	public IntroScreen(GameWindow window){
                instructions = ImageLoader.loadImage("/arrow.png");
		timer = new Timer(1000/60, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
			
		});
		timer.start();
		this.window = window;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT);
		g.drawImage(instructions, GameWindow.WIDTH/2 - instructions.getWidth()/2, 30 - instructions.getHeight()/2 + 150, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Press space to play!", GameWindow.WIDTH/2-142, GameWindow.HEIGHT / 2 + 100);
		g.drawString("____________________", GameWindow.WIDTH/2-175, GameWindow.HEIGHT / 2 + 110);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Creators", GameWindow.WIDTH/3+30, GameWindow.HEIGHT / 2 + 160);
		g.drawString("Etienne Tot & Denis Maslov", GameWindow.WIDTH/3-55, GameWindow.HEIGHT / 2 + 190);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 11));
		g.drawString("Version: 1.0", GameWindow.WIDTH/3+200, GameWindow.HEIGHT/2+260);
	}	

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_SPACE) {
            window.startTetris();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
