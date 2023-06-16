package JAVA;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;
public class J5 {
       public static void main(String[] args) throws IOException {
        int [] list = {10, 2, 8, 4, 6};
        System.out.println(Arrays.toString(list));
        int temp = 0;
        int size = list.length;
        Logger ll = Logger.getLogger(J5.class.getName());
        String logsPath = "log.txt";
        FileHandler writer = new FileHandler(logsPath, false);
        ll.addHandler((writer));
        SimpleFormatter formatter = new SimpleFormatter();
        writer.setFormatter(formatter);
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 1; j < (size - i); j++) {
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    ll.log(Level.INFO,"element: " + Arrays.toString(list));
                }
        System.out.println(Arrays.toString(list));
    }
    ll.log(Level.WARNING,"logger off");
//     ll.info("test");
//     ll.warning("logsPath");
}
}
}



