import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TextOverlay extends JPanel {

    private BufferedImage image;
    Graphics2D g2d =null;
    Point me=null;
    public TextOverlay() {
        try 
        {
            image = ImageIO.read(new File("stars.jpg"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        this.setPreferredSize(new Dimension(
        image.getWidth(), image.getHeight()));
        
        addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                    me = e.getPoint();
                    repaint();
            }

        });
    }

    private BufferedImage process(BufferedImage old) 
    {
        Composite originalComposite = g2d.getComposite();
        int w = old.getWidth();
        int h = old.getHeight();
        Rectangle   r = new Rectangle(0, 0, w/10, h);
        int i=0;
        if(me!=null)
        {
            i=1;
            while(!r.contains(me))
            {
                i++;
                r = new Rectangle(0, 0, i*(w/10), h);
            }
        }
//        System.out.println(i);
        Rectangle   r1 = new Rectangle(0, 0, i*(w/10), h);
        
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.drawImage(old, 0, 0, null);
//        g2d.draw3DRect(0, 0, w/10, h,false);
        g2d.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)));
        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.fill(r1);
//        g2d.setPaint(Color.red);
//        g2d.setFont(new Font("Serif", Font.BOLD, 20));
//        String s = "Hello, world!";
//        FontMetrics fm = g2d.getFontMetrics();
//        int x = img.getWidth() - fm.stringWidth(s) - 5;
//        int y = fm.getHeight();
//        g2d.drawString(s, x, y);
        
        g2d.setComposite(originalComposite);
//        int type = AlphaComposite.SRC_OVER;
//        g2d.setComposite((AlphaComposite.getInstance(type, 1f)));
        
//        g2d.translate(w/10, 0);
//        g2d.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g2d = (Graphics2D)g;
        BufferedImage imageDraw = process(image);
        g.drawImage(imageDraw, 0, 0, null);
    }

    private static void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new TextOverlay());
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }
}
