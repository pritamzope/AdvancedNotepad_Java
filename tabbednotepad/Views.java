import javax.xml.bind.annotation.*;

@XmlRootElement
public class Views {

    String tabsAlign;
    String documentSelector;
    String toolStrip;
    String statusStrip;
    String lookAndFeel;

    public String getTabsAlignment() {
        return tabsAlign;
    }

    @XmlElement
    public void setTabsAlignment(String tabsAlign) {
        this.tabsAlign = tabsAlign;
    }

    public String getDocumentSelector() {
        return documentSelector;
    }

    @XmlElement
    public void setDocumentSelector(String documentSelector) {
        this.documentSelector = documentSelector;
    }

    public String getToolStrip() {
        return toolStrip;
    }

    @XmlElement
    public void setToolStrip(String toolStrip) {
        this.toolStrip = toolStrip;
    }

    public String getStatusStrip() {
        return statusStrip;
    }

    @XmlElement
    public void setStatusStrip(String statusStrip) {
        this.statusStrip = statusStrip;
    }

    public String getLookAndFeel() {
        return lookAndFeel;
    }

    @XmlElement
    public void setLookAndFeel(String lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

}
