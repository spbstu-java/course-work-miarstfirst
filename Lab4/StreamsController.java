package Lab4;
import Lab4.Streams.Streams;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.*;

public class StreamsController {
    private interface StringSetter {
        String set(String string);
    }
    public VBox createStreamsInterface(){
        VBox box = new VBox(10);
        VBox average = Helpers.getFromStreams("Среднее", this::getAverage);
        VBox toNewUpperCasa = Helpers.getFromStreams("Строка с префиксом", this::getWithPrefix);
        VBox squaresOfUnique = Helpers.getFromStreams("Квадрат уникальных", this::getSquaresOfUnique);
        VBox lastOfCollection = Helpers.getFromStreams("Последний из коллекции", this::getLastOfCollection);
        VBox sumEvens = Helpers.getFromStreams("Сумма четных", this::getSumEvens);
        VBox colToMap = Helpers.getFromStreams("Коллекция", this::getColToMap);

        box.getChildren().addAll(
            average,
            toNewUpperCasa,
            squaresOfUnique,
            lastOfCollection,
            sumEvens,
            colToMap
        );
        return box;
    }
    // __________________ОСНОВНЫЕ МЕТОДЫ__________________
    private String getAverage(String s){
        try{
            OptionalDouble val = Streams.average(Helpers.getIntList(s));
            return val.isPresent() ?
                String.valueOf(val.getAsDouble()) :
                "Невозможно получить число";
        } catch (Exception e){
            return "Невозможно получить число";
        }
    }
    private String getWithPrefix(String initialString){
        String[] stringArray = initialString.split(",");
        List<String> strings = Streams.toNewUpperCasa(Arrays.asList(stringArray));
        return strings.toString();
    }
    private String getSquaresOfUnique(String initialString){
        try {
            List<Integer> res = Streams.squaresOfUnique(Helpers.getIntList(initialString));
            return res.toString();
        } catch (Exception e){
            return "Невозможно получить число";
        }
    }
    private String getLastOfCollection(String initialString){
        String[] stringArray = initialString.split(",");
        return Streams.lastOfCollection(Arrays.asList(stringArray));
    }
    private String getSumEvens(String initialString){
        try {
            List<Integer> res = Helpers.getIntList(initialString);
            return String.valueOf(Streams.sumEvens( res.stream()
                .mapToInt(Integer::intValue)
                .toArray()));
        } catch (Exception e){
            return "Невозможно получить число";
        }
    }
    private String getColToMap(String initialString){
        String[] stringArray = initialString.split(",");
        try {
            return Streams.colToMap(Arrays.asList(stringArray)).toString();
        } catch (Exception e){
            return e.getMessage();
        }
    }
    //__________________ ВСПОМОГАТЕЛЬНЫЙ КЛАСС __________________
    private static class Helpers {
        static List<Integer> getIntList(String initialString){
            String[] stringArray = initialString.split(",");
            List<Integer> ints = new ArrayList<>();
            for (String string: stringArray){
                ints.add(Integer.parseInt(string.trim()));
            }
            return ints;
        }
        static VBox getFromStreams(String label, StringSetter setter) {
            VBox inputsBox = new VBox(5);

            TextField inputIn = new TextField();
            TextField inputOut = new TextField();
            inputIn
                .textProperty()
                .addListener((_, _, newValue) -> {
                    inputOut.setText(setter.set(newValue));
                });

            inputOut.setDisable(true);
            inputOut.setMinWidth(300);

            HBox hBox = new HBox(10, inputIn, inputOut);
            inputsBox.getChildren().addAll(new Label(label), hBox);
            return  inputsBox;
        }
    }
}
