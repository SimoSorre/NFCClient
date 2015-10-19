package it.linksmt.android.nfcclient;

/**
 * Created by sorrentinos on 16/10/15.
 */
public class Utils {

    private static Utils instance = null;

    public static Utils getInstance() {
        if (instance == null)
            instance = new Utils();
        return instance;
    }

    public String getHexString(byte[] raw) {

        byte[] HEX_CHAR_TABLE = {(byte) '0', (byte) '1',
                (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6',
                (byte) '7', (byte) '8', (byte) '9', (byte) 'A', (byte) 'B',
                (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F'};

        byte[] hex = new byte[2 * raw.length];
        int index = 0;
        int pos = 0;

        for (byte b : raw) {
            if (pos >= raw.length)
                break;

            pos++;
            int v = b & 0xFF;
            hex[index++] = HEX_CHAR_TABLE[v >>> 4];
            hex[index++] = HEX_CHAR_TABLE[v & 0xF];
        }

        return new String(hex);
    }
}
