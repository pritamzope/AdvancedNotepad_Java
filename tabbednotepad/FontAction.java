import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class FontAction extends JDialog implements ListSelectionListener,ActionListener
{
    String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String[] fontStyles={
         "  Plain  ",
         "  Bold  ",
         "  Italic  ",
         "  Plain+Bold  ",
         "  Plain+Italic  ",
         "  Bold+Italic  ",
         "  Plain+Bold+Italic  "
                                 };
    List lst=new List();
    JList fontsList;
    JList fontStyleList;
    JList fontSizeList;
    JPanel jp1,jp2;
    DefaultListModel model;
    JLabel displayLabel;
    JButton ok,cancel;
    JTextPane textPane;

    static boolean isDarkTheme = false;

    public FontAction(JTextPane tx)
    {
        textPane=tx;

        Container cp=getContentPane();

        isDarkTheme = getNodeTextContent("lookAndFeel").equals("GlobalDark");

        fontsList=new JList(fontNames);
        fontStyleList=new JList(fontStyles);

        fontsList.setFont(new Font("Calibri",Font.PLAIN,14));
        fontStyleList.setFont(new Font("Calibri",Font.PLAIN,14));

        model=new DefaultListModel();
        fontSizeList = new JList(model);
        fontSizeList.setFont(new Font("Calibri", Font.PLAIN, 14));


        for(int i=1;i<=160;i++)
        {
            model.addElement("  "+i+"        ");
        }


        fontsList.setSelectedIndex(8);
        fontStyleList.setSelectedIndex(0);
        fontSizeList.setSelectedIndex(21);

        fontsList.addListSelectionListener(this);
        fontStyleList.addListSelectionListener(this);
        fontSizeList.addListSelectionListener(this);

        jp1=new JPanel();
        jp2=new JPanel();
        JPanel jp3=new JPanel();
        jp3.add(new JScrollPane(fontsList));


        JPanel jp4=new JPanel();
        jp4.setLayout(new GridLayout(0,2));
        jp4.add(new JScrollPane(fontStyleList));
        jp4.add(new JScrollPane(fontSizeList));

        jp1.add(jp3,BorderLayout.WEST);
        jp1.add(jp4,BorderLayout.EAST);

        displayLabel=new JLabel("Java Programming",JLabel.CENTER);
        displayLabel.setFont(new Font("Arial",Font.PLAIN,21));

        jp1.add(displayLabel);

        ok=new JButton("  OK  ");
        cancel=new JButton("  Cancel  ");

        if (isDarkTheme) {
            fontsList.setBackground(new Color(40, 40, 40));
            fontStyleList.setBackground(new Color(40, 40, 40));
            fontSizeList.setBackground(new Color(40, 40, 40));
            displayLabel.setForeground(new Color(240, 240, 240));
        }

        ok.addActionListener(this);
        cancel.addActionListener(this);

        jp2.add(ok);
        jp2.add(cancel);

        cp.add(jp1,BorderLayout.CENTER);
        cp.add(jp2,BorderLayout.SOUTH);

    }

    @Override
    public void valueChanged(ListSelectionEvent evt)
    {
        String fontname=fontsList.getSelectedValue().toString();
        String fontstyle=fontStyleList.getSelectedValue().toString().trim();
        int fontsize=Integer.parseInt(fontSizeList.getSelectedValue().toString().trim());

        switch(fontstyle)
        {
            case "Plain":
                displayLabel.setFont(new Font(fontname, Font.PLAIN, fontsize));
                break;

            case "Bold":
                displayLabel.setFont(new Font(fontname, Font.BOLD, fontsize));
                break;

            case "Italic":
                displayLabel.setFont(new Font(fontname, Font.ITALIC, fontsize));
                break;

            case "Plain+Bold":
                displayLabel.setFont(new Font(fontname, Font.PLAIN + Font.BOLD, fontsize));
                break;

            case "Plain+Italic":
                displayLabel.setFont(new Font(fontname, Font.PLAIN + Font.ITALIC, fontsize));
                break;

            case "Bold+Italic":
                displayLabel.setFont(new Font(fontname, Font.BOLD + Font.ITALIC, fontsize));
                break;

            case "Plain+Bold+Italic":
                displayLabel.setFont(new Font(fontname, Font.PLAIN + Font.BOLD + Font.ITALIC, fontsize));
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Object source=evt.getSource();
        if(source==ok)
        {
            String fontname = fontsList.getSelectedValue().toString();
            String fontstyle = fontStyleList.getSelectedValue().toString().trim();
            int fontsize = Integer.parseInt(fontSizeList.getSelectedValue().toString().trim());

            switch (fontstyle)
            {
                case "Plain":
                    textPane.setFont(new Font(fontname, Font.PLAIN, fontsize));
                    break;

                case "Bold":
                    textPane.setFont(new Font(fontname, Font.BOLD, fontsize));
                    break;

                case "Italic":
                    textPane.setFont(new Font(fontname, Font.ITALIC, fontsize));
                    break;

                case "Plain+Bold":
                    textPane.setFont(new Font(fontname, Font.PLAIN + Font.BOLD, fontsize));
                    break;

                case "Plain+Italic":
                    textPane.setFont(new Font(fontname, Font.PLAIN + Font.ITALIC, fontsize));
                    break;

                case "Bold+Italic":
                    textPane.setFont(new Font(fontname, Font.BOLD + Font.ITALIC, fontsize));
                    break;

                case "Plain+Bold+Italic":
                    textPane.setFont(new Font(fontname, Font.PLAIN + Font.BOLD + Font.ITALIC, fontsize));
                    break;
            }

            this.dispose();
        }
        else if(source==cancel)
        {
            this.dispose();
        }
    }



    //**************************************************
    // returns content of node
    //**************************************************
    public String getNodeTextContent(String nodetag) {
        String content = "";

        try {

            File fXmlFile = new File("files/viewsfile.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("views");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                Element eElement = (Element) nNode;

                content = eElement.getElementsByTagName(nodetag).item(0).getTextContent();

            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
        }

        return content;

    }



}
