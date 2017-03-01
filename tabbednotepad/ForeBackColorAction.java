import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ForeBackColorAction
{

   static class ForeColor_Action extends JDialog implements ActionListener
    {
        JColorChooser chooser = new JColorChooser(Color.WHITE);
        JPanel jp;
        JButton ok, cancel;
        JTextPane textPane;

        public ForeColor_Action(JTextPane tx)
        {
            textPane = tx;

            Container cp = getContentPane();

            jp = new JPanel();

            ok = new JButton("  OK  ");
            cancel = new JButton(" Cancel ");

            ok.addActionListener(this);
            cancel.addActionListener(this);

            jp.add(ok);
            jp.add(cancel);

            cp.add(chooser, BorderLayout.CENTER);
            cp.add(jp, BorderLayout.SOUTH);
        }

        public void actionPerformed(ActionEvent evt)
        {
            Object src = evt.getSource();
            if (src == ok)
            {
                Color color = chooser.getColor();
                if (color != null)
                {
                    textPane.setForeground(color);
                }
                this.dispose();
            }
            else if (src == cancel)
            {
                this.dispose();
            }
        }
    }


    static class BackColor_Action extends JDialog implements ActionListener
    {
        JColorChooser chooser = new JColorChooser(Color.WHITE);
        JPanel jp;
        JButton ok, cancel;
        JTextPane textPane;

        public BackColor_Action(JTextPane tx)
        {
            textPane = tx;

            Container cp = getContentPane();

            jp = new JPanel();

            ok = new JButton("  OK  ");
            cancel = new JButton(" Cancel ");

            ok.addActionListener(this);
            cancel.addActionListener(this);

            jp.add(ok);
            jp.add(cancel);

            cp.add(chooser, BorderLayout.CENTER);
            cp.add(jp, BorderLayout.SOUTH);
        }

        public void actionPerformed(ActionEvent evt)
        {
            Object src = evt.getSource();
            if (src == ok)
            {
                Color color = chooser.getColor();
                if (color != null)
                {
                    textPane.setBackground(color);
                }
                this.dispose();
            }
            else if (src == cancel)
            {
                this.dispose();
            }
        }
    }

}
