import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Document cv = new Document("Jana Kowalski - CV");
        cv.setPhoto("https://www.sprintcv.com/assets/sprintcv-helps-java-consultant-to-generate-amazing-cv-1228395647dab08deb54ccec4dd549db6477ded6803a1f00ac7fbc499b66555c.jpg");
        cv.addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("2012-2015 II LO im. Stefanii Sempołowskiej w Katowicach")
                .addParagraph("2015-2020 Akademia Górniczo-Hutnicza w Krakowie");
        cv.addSection("Umiejętności")
                .addParagraph(
                        new ParagraphWithList().setContent("Umiejętności")
                                .addItemToList("C")
                                .addItemToList("C++")
                                .addItemToList("Java")
                );

        cv.writeHTML(System.out);
        //cv.writeHTML(new PrintStream("cv.html", "ISO-8859-2"));

    }
}