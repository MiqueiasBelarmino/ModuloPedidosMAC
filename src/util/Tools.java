package util;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

/**
 *
 * @author Miquéias
 */
public class Tools {
    
    /**
     *
     */
    public static final int GRUPO_PRODUTO = 37;
    
    public static Properties getConfig(){
        
        Properties props = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/property/config.properties");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            props.load(file);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return props;
    }

    public static void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        //FileWriter out = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "iso-8859-1"));

        for (int i = 0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i, j).toString() + "\t");
            }
            out.write("\n");
        }
        out.close();

    }

    public static boolean isInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String dateFormat(Date date, String formato) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato, Locale.getDefault());
        return dateFormat.format(date);
    }

    public static boolean numberInputVerifier(Component j, KeyEvent evt, String key) {
        String value = "";
        JTextField txt;

        if ((j instanceof JTextField) || (j instanceof JTextField)) {
            txt = (JTextField) j;
            value = txt.getText();
        }

        if (key.equals("") || key.equals(" ") || key == null) {
            return (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
                    || (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    || (evt.getKeyCode() == KeyEvent.VK_DELETE)
                    || (evt.getKeyCode() == KeyEvent.VK_ENTER);
        } else {
            char c = key.charAt(0);
            return (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
                    || (evt.getKeyChar() == c)
                    || (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    || (evt.getKeyCode() == KeyEvent.VK_DELETE)
                    || (evt.getKeyCode() == KeyEvent.VK_ENTER);
        }
    }
}
