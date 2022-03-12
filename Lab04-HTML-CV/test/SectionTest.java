import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class SectionTest {

    @Test
    public void setTitle() {
        Section s = new Section();
        s.setTitle("sekcja1");
        assertEquals("sekcja1", s.title);
    }

    @Test
    public void addParagraph() {
        Section s = new Section();
        for(int i = 0; i < 10; i ++){
            Paragraph p = new Paragraph();
            s.addParagraph(p);
        }
        assertEquals(10, s.paragraps.size());
    }

    @Test
    public void testAddParagraph() {
        Section s = new Section();
        for(int i = 0; i < 10; i ++){
            s.addParagraph("paragraf");
        }
        assertEquals(10, s.paragraps.size());
    }

    @Test
    public void writeHTML() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        String sTitle = "tytul";
        String pTitle1 = "paragraf1";
        String pTitle2 = "paragraf2";
        Section s = new Section();
        s.setTitle(sTitle);
        s.addParagraph(pTitle1);
        s.addParagraph(pTitle2);
        s.writeHTML(ps);
        //new Section().setTitle(sTitle).addParagraph(pTitle1).addParagraph(pTitle2).writeHTML(ps);
        String result = null;
        try {
            result = os.toString("ISO-8859-2");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(result);

        assertTrue(result.contains("<div>"));
        assertTrue(result.contains(sTitle));
        assertTrue(result.contains(pTitle1));
        assertTrue(result.contains(pTitle2));
        assertTrue(result.contains("</div>"));
        assertEquals(s.paragraps.size(),result.split("<p>", -1).length-1);
        assertEquals(s.paragraps.size(),result.split("</p>", -1).length-1);


    }
}