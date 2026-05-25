package main;


import com.formdev.flatlaf.FlatDarkLaf;
import core.app.AppContext;
import core.app.Navigator;
import javax.swing.UIManager;

/**
 *
 * @author Catalina Forero
 * @author Daniel Rincon
 * @author Javier Leguizamo
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("flatlaf.useNativeLibrary", "false");

        AppContext appContext = AppContext.createDefault();
        Navigator navigator = new Navigator(appContext);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> navigator.showMain());
    }
    
}
