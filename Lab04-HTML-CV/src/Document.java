import java.util.*;
import java.io.PrintStream;

public class Document {
    String title;
    Photo photo;
    List<Section> sections = new ArrayList<>();

    Document(String title){
        this.title = title;
    }

    Document setTitle(String title){
        this.title = title;
        return this;
    }

    Document setPhoto(String photoUrl){

        this.photo = new Photo(photoUrl);
        return this;
    }

    Section addSection(String sectionTitle){
        // utwórz sekcję o danym tytule i dodaj do sections
        Section s = new Section().setTitle(sectionTitle);
        sections.add(s);
        return s;
    }
    Document addSection(Section s){
        sections.add(s);
        return this;
    }


    void writeHTML(PrintStream out){
        // zapisz niezbędne znaczniki HTML
        // dodaj tytuł i obrazek
        // dla każdej sekcji wywołaj section.writeHTML(out)
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<style>\n" +
                "body {background-color: lightblue;}\n" +
                "h1   {color: darkblue;}\n" +
                "p    {color: blue;}\n" +
                "body, h1, p, div {font-family: \"Karma\", sans-serif}\n" +
                "div {font-size: x-large}\n" +
                "p {font-size: medium}\n" +
                "</style>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");

        out.println("<h1>" + this.title + "</h1>");
        this.photo.writeHTML(out);
        for(Section s : sections){

            s.writeHTML(out);
        }
        out.println("</body>\n" +
                "</html>");

    }

}
