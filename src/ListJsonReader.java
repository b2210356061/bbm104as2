import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ListJsonReader {
    private ArrayList<Card> chanceCards = new ArrayList<Card>();
    private ArrayList<Card> chestCards = new ArrayList<Card>();

    public ListJsonReader() {
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("list.json")) {
            JSONObject jsonfile = (JSONObject) processor.parse(file);

            JSONArray chanceList = (JSONArray) jsonfile.get("chanceList");
            for (Object i : chanceList) {
                String item = ((String) ((JSONObject) i).get("item"));
                chanceCards.add(new Card(item));
            }
            
            JSONArray communityChestList = (JSONArray) jsonfile.get("communityChestList");
            for (Object i : communityChestList) {
                String item = ((String) ((JSONObject) i).get("item"));
                chestCards.add(new Card(item));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Card> getChanceCards() {
        return chanceCards;
    }

    public ArrayList<Card> getChestCards() {
        return chestCards;
    }
}
