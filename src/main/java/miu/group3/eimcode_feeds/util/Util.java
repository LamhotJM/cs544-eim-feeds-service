package miu.group3.eimcode_feeds.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Util{

    /**
     * Convert an array of bytes into a List of Strings using UTF-8. A line is
     * considered to be terminated by any one of a line feed ('\n'), a carriage
     * return ('\r'), or a carriage return followed immediately by a linefeed.<p/>
     *
     * Can be used to parse the output of
     *
     * @param bytes the array to convert
     * @return A new mutable list containing the Strings in the input array. The
     *         list will be empty if bytes is empty or if it is null.
     */
    public static List<String> bytesToStringList(byte[] bytes) {
      List<String> lines = new ArrayList<String>();

      if (bytes == null) {
        return lines;
      }

      BufferedReader r = null;

      try {
        r = new BufferedReader(
                new InputStreamReader(
                    new ByteArrayInputStream(bytes),
                    "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        // If UTF-8 is not supported we are in big trouble.
        throw new RuntimeException(e);
      }

      try {
        try {
          for (String line = r.readLine(); line != null; line = r.readLine()) {
            lines.add(line);
          }
        } finally {
          r.close();
        }
      } catch (IOException e) {
        // I can't think of a reason we'd get here.
        throw new RuntimeException(e);
      }

      return lines;
    }

}
