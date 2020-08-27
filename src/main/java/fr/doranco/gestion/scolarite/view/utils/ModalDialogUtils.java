package fr.doranco.gestion.scolarite.view.utils;

import javax.swing.*;

public class ModalDialogUtils {
    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    public static void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
