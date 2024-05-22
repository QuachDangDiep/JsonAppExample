package jsonWeather;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.math.BigDecimal;
import java.util.Map;

public class ReadJsonWeather {
    public static void main(String[] args) throws JsonException {
        String URL = "{\n" +
                "{\n" +
                "  \"coord\": {\n" +
                "    \"lon\": -0.1257,\n" +
                "    \"lat\": 51.5085\n" +
                "  },\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 500,\n" +
                "      \"main\": \"Rain\",\n" +
                "      \"description\": \"light rain\",\n" +
                "      \"icon\": \"10d\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"base\": \"stations\",\n" +
                "  \"main\": {\n" +
                "    \"temp\": 287.98,\n" +
                "    \"feels_like\": 287.84,\n" +
                "    \"temp_min\": 286.86,\n" +
                "    \"temp_max\": 289.01,\n" +
                "    \"pressure\": 1006,\n" +
                "    \"humidity\": 89\n" +
                "  },\n" +
                "  \"visibility\": 10000,\n" +
                "  \"wind\": {\n" +
                "    \"speed\": 6.69,\n" +
                "    \"deg\": 240\n" +
                "  },\n" +
                "  \"rain\": {\n" +
                "    \"1h\": 0.91\n" +
                "  },\n" +
                "  \"clouds\": {\n" +
                "    \"all\": 75\n" +
                "  },\n" +
                "  \"dt\": 1716383895,\n" +
                "  \"sys\": {\n" +
                "    \"type\": 2,\n" +
                "    \"id\": 2075535,\n" +
                "    \"country\": \"GB\",\n" +
                "    \"sunrise\": 1716350331,\n" +
                "    \"sunset\": 1716407751\n" +
                "  },\n" +
                "  \"timezone\": 3600,\n" +
                "  \"id\": 2643743,\n" +
                "  \"name\": \"London\",\n" +
                "  \"cod\": 200\n" +
                "}";
        JsonObject parser = (JsonObject) Jsoner.deserialize(URL);
        String base = (String) parser.get("base");
        BigDecimal visibility = (BigDecimal) parser.get("visibility");
        BigDecimal dt = (BigDecimal) parser.get("dt");
        BigDecimal timezone = (BigDecimal) parser.get("timezone");
        BigDecimal id = (BigDecimal) parser.get("id");
        BigDecimal name = (BigDecimal) parser.get("name");
        BigDecimal cod = (BigDecimal) parser.get("cod");
        System.out.println("base: " + base + "\n"
                + "visibility: " + visibility + "\n"
                + "dt: " + dt + "\n"
                + "timezone: " + timezone + "\n"
                + "id: " + id + "\n"
                + "name: " + name + "\n"
                + "cod: " + cod ) ;
        Map<Object, Object> coord = (Map<Object, Object>) parser.get("coord");
        coord.forEach((key, value) -> System.out.println(key + ": " +value));

        JsonArray weather = (JsonArray) parser.get("weather");
        weather.forEach(entry -> {
            JsonObject weathers = (JsonObject) entry;
            System.out.println("id: " +weathers.get("id"));
            System.out.println("main: " +weathers.get("main"));
            System.out.println("description: " +weathers.get("description"));
            System.out.println("icon: " +weathers.get("icon"));
        });

        Map<Object, Object> main = (Map<Object, Object>) parser.get("main");
        main.forEach((key, value) -> System.out.println(key + ": " +value));

        Map<Object, Object> wind = (Map<Object, Object>) parser.get("wind");
        wind.forEach((key, value) -> System.out.println(key + ": " +value));

        Map<Object, Object> clouds = (Map<Object, Object>) parser.get("clouds");
        clouds.forEach((key, value) -> System.out.println(key + ": " +value));

        Map<Object, Object> sys = (Map<Object, Object>) parser.get("syt");
        sys.forEach((key, value) -> System.out.println(key + ": " +value));
    }
}
