package redis.clients.jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Protocol {
    public static final String DOLLAR = "$";
    public static final String ASTERISK = "*";
    public static final String PLUS = "+";
    public static final String COLON = ":";
    public static final String COMMAND_DELIMITER = "\r\n";
    public static final int DEFAULT_PORT = 6379;

    public static final byte DOLLAR_BYTE = DOLLAR.getBytes()[0];
    public static final byte ASTERISK_BYTE = ASTERISK.getBytes()[0];
    public static final byte PLUS_BYTE = PLUS.getBytes()[0];
    public static final byte COLON_BYTE = COLON.getBytes()[0];

    public String buildCommand(String name, String... args) {
        StringBuilder builder = new StringBuilder();
        builder.append(ASTERISK).append(args.length+1).append(COMMAND_DELIMITER);
        builder.append(DOLLAR).append(name.length()).append(COMMAND_DELIMITER);
        builder.append(name).append(COMMAND_DELIMITER);
        for (String arg : args) {
            builder.append(DOLLAR).append(arg.length()).append(
                COMMAND_DELIMITER).append(arg).append(COMMAND_DELIMITER);
        }
        return builder.toString();
    }
}
