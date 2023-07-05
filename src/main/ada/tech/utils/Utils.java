package ada.tech.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Utils {
    public static String downloadToString(String url) throws IOException {
        InputStream in = URI.create(url).toURL().openStream();
        String text = null;
        try (Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\\A").next();
        }
        return text;
    }

}

