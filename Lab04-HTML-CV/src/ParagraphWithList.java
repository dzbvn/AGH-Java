import java.io.PrintStream;
import java.util.List;

public class ParagraphWithList extends Paragraph{
    UnorderedList u = new UnorderedList();
    ListItem addItemToList(ListItem item){
        u.addItem(item);
        return item;
    };
    ParagraphWithList addItemToList(String item){
        u.addItem(item);
        return this;
    };

    ParagraphWithList setContent(String newContent){
        super.setContent(newContent);
        return this;
    }

    void writeHTML(PrintStream out){
        out.println("<p>");
        this.u.writeHTML(out);
        out.println("</p>");
    }
    /*void writeHTML(PrintStream out){
        super.writeHTML(out);
    }*/
}
