package xml;

import concert.Collective;
import concert.Concert;
import concert.Dancer;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ConcertXMLReader {
    public List<Concert> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Concert> concerts = new ArrayList<>();
            Concert concert = null;
            Dancer dancer = new Dancer();
            Collective collective = new Collective();
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("concert".equals(tagName)) {
                            concert = new Concert();
                            concert.setIdentity(reader.getAttributeValue(null, "id"));
                        } else if ("danceType".equals(tagName)) {
                            concert.setDanceType(reader.getElementText());
                        } else if ("scene".equals(tagName)) {
                            concert.setScene(reader.getElementText());
                        } else if ("numberOfDancers".equals(tagName)) {
                            concert.setNumberOfDancers(Integer.parseInt(reader.getElementText()));
                        } else if ("numberInLine".equals(tagName)) {
                            concert.setNumberInLine(Integer.parseInt(reader.getElementText()));
                        } else if ("liveMusic".equals(tagName)) {
                            concert.setLiveMusic(Boolean.valueOf(reader.getElementText()));
                        } else if ("title".equals(tagName)) {
                            collective.setTitle(tagName);
                        } else if ("yearOfFormation".equals(tagName)) {
                            collective.setYearOfFormation(Integer.parseInt(tagName));
                        } else if ("leaderName".equals(tagName)) {
                            collective.setLeaderName(tagName);
                        }
                        concert.setCollectives(collective);
                        concert.getDancers().add(dancer);

                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("concert".equals(tagName)) {
                            concerts.add(concert);
                        }
                        break;
                    }
                }
            }
            return concerts;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {

            }
        }
    }
}
