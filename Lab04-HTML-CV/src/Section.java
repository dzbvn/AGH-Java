import java.util.*;
import java.io.PrintStream;


public class Section {
    String title;
    List<Paragraph> paragraps = new ArrayList<>();

    Section setTitle(String title){
        this.title = title;

        return this;
    };
    Section addParagraph(String paragraphText){
        Paragraph p = new Paragraph().setContent(paragraphText);

        paragraps.add(p);
        return this;
    };
    Section addParagraph(Paragraph p){
        paragraps.add(p);
        return this;
    };
    void writeHTML(PrintStream out){
        out.println("<div>");
        out.println(this.title);
        for(Paragraph p : paragraps){
            p.writeHTML(out);
        }
        out.println("</div>");

    };

}
