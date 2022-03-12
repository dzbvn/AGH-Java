import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

import static org.junit.Assert.*;

public class DocumentTest {

    @org.junit.Test
    public void setTitle() {
        Document d = new Document("tytul");
        assertSame("tytul", d.title);
        d.setTitle("tytul2");
        assertSame("tytul2", d.title);
    }

    @org.junit.Test
    public void setPhoto() {
        Document d = new Document("tytul");
        d.setPhoto("https://images.unsplash.com/photo-1508921912186");
        assertEquals("https://images.unsplash.com/photo-1508921912186", d.photo.url);
    }


    @org.junit.Test
    public void addSection() {
        Document d = new Document("tytul");
        d.addSection("sekcja1");
        assertEquals(1, d.sections.size());
        for(int i = 0; i < 10; i++){
            d.addSection("sekcja");
        }
        assertEquals(11, d.sections.size());
    }

    @org.junit.Test
    public void testAddSection() {
        Document d = new Document("tytul");
        for(int i = 0; i < 30; i++){
            Section s = new Section();
            d.addSection(s);
        }
        assertEquals(30, d.sections.size());
    }

    @org.junit.Test
    public void writeHTML() {
        String imageUrl = "jan-kowalski.png";
        // Utwórz strumień zapisujący w pamięci
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        // Utwórz obiekt i zapisz do strumienia
        new Document("tytul").setPhoto(imageUrl).writeHTML(ps);

        String result = null;
        // Pobierz jako String
        try {
            result = os.toString("ISO-8859-2");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //System.out.println(result);

        // Sprawdź, czy result zawiera wybrane elementy
        assertTrue(result.contains("<!DOCTYPE html>"));
        assertTrue(result.contains("<html lang=\"en\">"));
        assertTrue(result.contains("<head>"));
        assertTrue(result.contains("</head>"));
        assertTrue(result.contains("<h1>tytul</h1>"));
        assertTrue(result.contains("<body>"));
        assertTrue(result.contains("</body>"));
        assertTrue(result.contains("</html>"));



    }
}