package jayslabs.corejava.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//use regex to find and replace credit card number with ****
public class CustomFileReader {
    public static String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(maskCreditCardNumbers(line)).append("\n");
            }
            return content.toString();
        }
    }

    private static String maskCreditCardNumbers(String text) {
        // Regex pattern for common credit card formats
        String regex = "\\b(?:\\d{4}[-\\s]?){3}\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String masked = matcher.group().replaceAll("\\d(?=\\d{4})", "*");
            matcher.appendReplacement(sb, masked);
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}

