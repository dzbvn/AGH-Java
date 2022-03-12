import java.io.PrintStream;

public class Paragraph {
    String content;
    Paragraph setContent(String newContent){
        this.content = newContent;
        return this;
    }
    void writeHTML(PrintStream out){
        out.println("<p>");
        out.println(this.content);
        out.println("</p>");
    };
}
