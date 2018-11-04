package gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorGUI extends JTable{


    private int indexFinal;

    public ColorGUI(int index) {
        indexFinal=index;

    }

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);

        component.setBackground(Color.WHITE);
        component.setForeground(Color.BLACK);
        if(column == indexFinal){
            component.setBackground(Color.RED);
            component.setForeground(Color.WHITE);
            component.setFont(new Font("resposta_final", Font.BOLD, 12));
        }

        return component;
    }
}
