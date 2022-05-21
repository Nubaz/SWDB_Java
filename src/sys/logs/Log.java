package sys.logs;

import java.io.*;
import java.sql.Timestamp;

public class Log {
    File f = new File("src/sys/logs/logs.csv");
    FileWriter fw;

    {
        try {
            fw = new FileWriter(f,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedWriter bw = new BufferedWriter(fw);

    Timestamp ts;

    private static Log l = null;

    private Log() throws IOException {
        if(!f.exists()){
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
    }

    public static Log getInstance() throws IOException {
        if(l == null)
            l = new Log();
        return l;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void log(String msg) throws IOException {
        ts = new Timestamp(System.currentTimeMillis());
        bw.write(msg + "," + ts + ",");
        bw.newLine();
    }

    public void clearLog() throws IOException {
        fw = new FileWriter(f, false);
        bw = new BufferedWriter(fw);
        bw.write("");
    }
}
