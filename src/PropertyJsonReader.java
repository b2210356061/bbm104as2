import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PropertyJsonReader {
    private Square[] squares = new Square[41];

    public PropertyJsonReader() {
        JSONParser processor = new JSONParser();
        try (Reader file = new FileReader("property.json")) {
            JSONObject jsonfile = (JSONObject) processor.parse(file);

            JSONArray lands = (JSONArray) jsonfile.get("1");
            for (Object i : lands) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares[id] = new Property(id, name, cost, Property.Type.LAND);
            }

            JSONArray railRoads = (JSONArray) jsonfile.get("2");
            for (Object i : railRoads) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares[id] = new Property(id, name, cost, Property.Type.RAILROAD);
            }

            JSONArray companies = (JSONArray) jsonfile.get("3");
            for (Object i : companies) {
                int id = Integer.parseInt((String) ((JSONObject) i).get("id"));
                String name = (String) ((JSONObject) i).get("name");
                int cost = Integer.parseInt((String) ((JSONObject) i).get("cost"));
                squares[id] = new Property(id, name, cost, Property.Type.COMPANY);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        squares[1] = new GoSquare();

        squares[3] = new ChestSquare();
        squares[18] = new ChestSquare();
        squares[34] = new ChestSquare();

        squares[8] = new ChanceSquare();
        squares[23] = new ChanceSquare();
        squares[37] = new ChanceSquare();

        squares[5] = new TaxSquare();
        squares[39] = new TaxSquare();

        squares[11] = new GoToJailSquare(); // Jail
        squares[21] = new DummySquare(); // Free parking

        squares[31] = new GoToJailSquare();
    }

    public Square[] getSquares() {
        return squares;
    }
}