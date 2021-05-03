package xml;

import concert.Concert;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class RunApp {
    public static void main(String[] args) throws IOException {
        ConcertXmlValidator validator = new ConcertXmlValidator("concerts.xml");
        if (validator.validate()) {
            ConcertXMLReader reader = new ConcertXMLReader();
            List<Concert> concerts = reader.read("concerts.xml");

            Collections.sort(concerts, (o1, o2) -> o2.getNumberInLine().compareTo(o1.getNumberInLine()));

            for (Concert concert : concerts) {
                System.out.println(concert);
            }
        } else {
            System.out.println(validator.getError());
        }
    }
}
