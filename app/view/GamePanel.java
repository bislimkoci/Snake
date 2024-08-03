package app.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
    private final int width;
    private final int height;
    private final int blockSize;
    private Color[][] blocks;


    public GamePanel(int width, int height, int blockSize) {
        this.width = width;
        this.height = height;
        this.blockSize = blockSize;
        this.blocks = new Color[width / blockSize][height / blockSize];
        
        for (int i = 0; i < width/blockSize; i++) {
            for (int j = 0; j < height/blockSize; j++) {
                blocks[i][j] = Color.BLACK;
            }
        }

        setSize(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < width/blockSize; i++) {
            for (int j = 0; j < height/blockSize; j++) {
                g.setColor(blocks[i][j]);
                fillRectangle(i, j, g);
            }
        }
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < width/blockSize; i++) {
            g.drawLine(blockSize * i, 0, blockSize * i, height);
            g.drawLine(0, i * blockSize, width, i * blockSize);
        }
    } 

    public void updateBlockColor(int x, int y, Color color) {
        blocks[x][y] = color;
    }

    public Color getColor(int x, int y) {
        return blocks[x][y];
    }

    private void fillRectangle(int x, int y, Graphics g) {
        g.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
    }
    

}
