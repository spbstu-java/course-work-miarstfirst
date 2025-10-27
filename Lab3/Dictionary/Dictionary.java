package Lab3.Dictionary;

import Lab3.Errors.FileReadException;
import Lab3.Errors.InvalidFileFormatException;
import Lab3.FileExtended.FileExtended;

import java.util.Map;

public class Dictionary {

    private Map<String, String> dictionaryFileContent;

    public Dictionary(String path) {
        uploadFile(path);
    }

    /**
     * читаем и сохраняем данные из файла
     */
    private void uploadFile(String path){
        try {
            FileExtended file = new FileExtended(path, ".txt");
            dictionaryFileContent = file.getFileContent();
        } catch (FileReadException | InvalidFileFormatException e){
            System.out.println("ОШИБКА!!! " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * на основе сохраненных данных и полученной строки
     * из консоли формируем и возвращаем новую строку
     */
    public String translate(String input) {
        String result = input;
        String inputLower = input.toLowerCase();

        for (Map.Entry<String, String> entry : dictionaryFileContent.entrySet()) {
            String key = entry.getKey().trim().toLowerCase();
            String value = entry.getValue().trim();

            while (inputLower.contains(key)) {
                int index = inputLower.indexOf(key);
                String before = result.substring(0, index);
                String after = result.substring(index + key.length());
                result = before + value + after;

                inputLower = result.toLowerCase();
            }
        }

        return result;
    }
}



// CUte dog Look to tHe wiNdow, dog look forwArd
// this dog is a good bOy. he deserved a bone definitely