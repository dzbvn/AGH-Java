import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class UnorderedListTest {

    @Test
    public void addItem() {
        UnorderedList u = new UnorderedList();
        for(int i = 0; i < 30; i++){
            ListItem item = new ListItem("tresc");
            u.addItem(item);
        }
        assertEquals(30, u.listItems.size());

    }

    @Test
    public void testAddItem() {
        UnorderedList u = new UnorderedList();
        for(int i = 0; i < 20; i++){

            u.addItem("tresc");
        }
        assertEquals(20, u.listItems.size());
    }

    @Test
    public void writeHTML() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        String it1 = "pierwszy";
        String it2 = "drugi";
        String it3 = "trzeci";
        UnorderedList u = new UnorderedList();
        u.addItem(it1);
        u.addItem(it2);
        u.addItem(it3);
        u.writeHTML(ps);
        //new UnorderedList().addItem(it1).addItem(it2).addItem(it3).writeHTML(ps);
        String result = null;
        try {
            result = os.toString("ISO-8859-2");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        assertTrue(result.contains("<ul>"));
        assertTrue(result.contains("</ul>"));
        assertTrue(result.contains(it1));
        assertTrue(result.contains(it2));
        assertTrue(result.contains(it3));
        assertEquals(u.listItems.size(),result.split("<li>", -1).length-1);
        assertEquals(u.listItems.size(),result.split("</li>", -1).length-1);


    }
}