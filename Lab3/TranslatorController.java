package Lab3;

import Lab3.Dictionary.Dictionary;
import Lab3.Errors.FileReadException;
import Lab3.Errors.InvalidFileFormatException;
import Lab3.FileExtended.FileExtended;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class TranslatorController {

    public  VBox createTranslatorInterface () {

        VBox box = new VBox(10);

        TextField inputPath1 = new TextField("");

        TextField inputPath2 = new TextField("");

        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(4);

        TextArea textArea2 = new TextArea();
        textArea2.setPrefRowCount(4);
        textArea2.setEditable(false);

        Button button = getButton(
            inputPath1,
            inputPath2,
            textArea,
            textArea2
        );

        box.getChildren().addAll(
            button,
            new Label("Путь к файлу (.txt) словаря:"),
            inputPath1,
            new Label("Путь к файлу (.txt) текста:"),
            inputPath2,
            new Label("Введите текст для перевода (приоритет перед файлом):"),
            textArea,
            new Label("Результат:"),
            textArea2
        );

        return box;
    }

    private static Button getButton(TextField inputPath1,TextField inputPath2, TextArea textArea, TextArea textArea2) {
        Button button = new Button("Перевести");

        button.setOnAction(e->{
            if(!Objects.equals(inputPath1.getText(),"")){
                Dictionary dictionary = new Dictionary(inputPath1.getText());
                if(!Objects.equals(textArea.getText(), "")){
                    System.out.println(textArea.getText());
                    textArea2.setText(dictionary.translate(textArea.getText()));
                } else if(!Objects.equals(inputPath2.getText(), "")){
                    try {
                        FileExtended file = new FileExtended(inputPath2.getText());
                        String text = file.getFileContentString();
                        textArea2.setText(dictionary.translate(text));
                    } catch (FileReadException | InvalidFileFormatException ex){
                        throw new RuntimeException(ex);
                    }
                } else {
                    textArea2.setText("Нечего переводить!");
                }
            } else {
                textArea2.setText("Не указан путь к словарю");
            }

        });
        return button;
    }
}
