package Lab2;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

public class AnnotationController {

    Main2 annotations;
    public TextArea textArea;

    public AnnotationController(){
        AtomicInteger i = new AtomicInteger(1);
        annotations = new Main2();
        textArea = new TextArea("");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(7);
        textArea.setMaxHeight(Double.MAX_VALUE);

        annotations.run(new Test(), text ->
            textArea.setText(
                textArea.getText() +
                i.getAndIncrement() +
                ". " + text + "\n"
            )
        );
    }

    public VBox createAnnotationInterface(){
        VBox box = new VBox(10);

        box
            .getChildren()
            .addAll(new Label("Результат лабораторной работы 2:"), textArea);

        return box;
    }
}
