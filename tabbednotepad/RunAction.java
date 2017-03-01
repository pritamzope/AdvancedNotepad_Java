import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class RunAction extends JDialog implements ActionListener
{
    JButton run,cancel,browse;
    JPanel jp1,jp2;
    JTextField txt;

    public RunAction()
    {
        Container cp=getContentPane();

        jp1=new JPanel();
        jp2=new JPanel();

        JLabel lb=new JLabel("Select Program to Run");

        txt=new JTextField(30);

        browse=new JButton(". . .");
        browse.addActionListener(this);

        run=new JButton(" Run ");
        cancel=new JButton(" Cancel ");

        run.addActionListener(this);
        cancel.addActionListener(this);

        jp1.add(lb);
        jp1.add(txt,BorderLayout.CENTER);
        jp1.add(browse,BorderLayout.EAST);

        jp2.add(run);
        jp2.add(cancel);

        cp.add(jp1,BorderLayout.CENTER);
        cp.add(jp2,BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent evt)
    {
        Object src=evt.getSource();
        if(src==browse)
        {
            FileDialog fd=new FileDialog(new JFrame(),"Select File",FileDialog.LOAD);
            fd.show();
            if(fd.getFile()!=null)
            {
                String file=fd.getDirectory()+fd.getFile();
                txt.setText(file);
            }
        }
        else if(src==run)
        {
            if(txt.getText()!=null)
            {
                File file = new File(txt.getText());
                if(file.exists())
                {
                    if(file.toString().contains(".exe"))
                    {
                        try
                        {
                          Runtime.getRuntime().exec(file.toString());
                        }
                        catch(Exception e){ }
                    }
                    else
                    {
                        try
                        {
                            Desktop d = Desktop.getDesktop();
                            d.open(file);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
            dispose();
        }
        else if(src==cancel)
        {
            dispose();
        }
    }

}
