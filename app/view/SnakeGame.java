package app.view;


import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import app.machine.Apple;
import app.machine.Direction;
import app.machine.Entity;
import app.machine.Snake;
import app.machine.SnakePart;

public class SnakeGame extends JFrame implements KeyListener{
    private GamePanel gPanel;
    private Snake snake;
    private Apple apple;
    private int gWidth;
    private int gHeight;


    public SnakeGame(int width, int height, int blockSize) {
        if ( ! ((width % blockSize == 0) && (height % blockSize == 0))) {
            System.out.println("Choose different size values");
            return;
        }
        this.gWidth = width/blockSize;
        this.gHeight = height/blockSize;
        this.snake = new Snake(width / (2 * blockSize), height/ (2* blockSize));
        this.apple = new Apple(width/blockSize, height/blockSize);

        setSize(width + 75, height + 100);
        this.gPanel = new GamePanel(width, height, blockSize);

        updateBlockColor(apple);
        updateBlockColor(snake.get(0));
        
        
        add(gPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);

        try {
            action();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void action() throws InterruptedException {
        while (snake.size() != gWidth * gHeight && snake.size() != (gWidth * gHeight) - 1) {
            Thread.sleep(120);
            

            SnakePart sp = snake.get(snake.size() - 1);
            gPanel.updateBlockColor(sp.getX(), sp.getY(), Color.black);
            
            if (apple.samePosition(snake.get(0))) {
                gPanel.updateBlockColor(apple.getX(), apple.getY(), Color.black);
                apple.changeRandomPos();
                
                while (!gPanel.getColor(apple.getX(), apple.getY()).equals(Color.BLACK)) {
                    apple.changeRandomPos();   
                }

                updateBlockColor(apple);
                snake.addCord(sp.getX(), sp.getY());
            }
            
            if (snake.nextX() < 0 || snake.nextX() > gWidth - 1 ||  snake.nextY() < 0 || snake.nextY() > gHeight -1 ) {
                System.out.println("You lost with snake size: " + snake.size());
                return;
            }

            snake.move();

            if (snake.isOverlapping()) {
                System.out.println("You lost with snake size: " + snake.size());
                return;
            }

            for (int i = 0; i < snake.size(); i++) {
                updateBlockColor(snake.get(i));
            }
            
            gPanel.repaint();
        }
        

    }

    private void updateBlockColor(Entity ent) {
        if (ent instanceof Apple) {
           gPanel.updateBlockColor(ent.getX(), ent.getY(), Color.RED); 
        } else {
            gPanel.updateBlockColor(ent.getX(), ent.getY(), Color.GREEN);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Handle arrow key presses to change snake direction
        switch (key) {
            case KeyEvent.VK_UP:
                snake.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                snake.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                snake.changeDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                snake.changeDirection(Direction.RIGHT);
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    
    


    









    



    

    
}
