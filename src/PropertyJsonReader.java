import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class PropertyJsonReader {
    private ArrayList<Square> squares = new ArrayList<Square>();

    public PropertyJsonReader() {
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("property.json")) {
            JSONObject jsonfile = (JSONObject) processor.parse(file);

            JSONArray lands = (JSONArray) jsonfile.get("1");
            for (Object i : lands) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares.add(id, new Property(id, name, cost, Property.Type.LAND));
            }

            JSONArray railRoads = (JSONArray) jsonfile.get("2");
            for (Object i : railRoads) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares.add(id, new Property(id, name, cost, Property.Type.RAILROAD));
            }

            JSONArray companies = (JSONArray) jsonfile.get("3");
            for (Object i : companies) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares.add(id, new Property(id, name, cost, Property.Type.COMPANY));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        squares.add(1, new GoSquare());

        squares.add(3, new ChestSquare());
        squares.add(18, new ChestSquare());
        squares.add(34, new ChestSquare());

        squares.add(8, new ChanceSquare());
        squares.add(23, new ChanceSquare());
        squares.add(37, new ChanceSquare());

        squares.add(5, new TaxSquare());
        squares.add(39, new TaxSquare());

        squares.add(11, new DummySquare()); // Jail
        squares.add(21, new DummySquare()); // Free parking

        squares.add(31, new GoToJailSquare());
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }
}