package server.runtime;

import java.sql.Timestamp;

public class RuntimeFields {

    public static String user;

    public static String GetTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }
}
