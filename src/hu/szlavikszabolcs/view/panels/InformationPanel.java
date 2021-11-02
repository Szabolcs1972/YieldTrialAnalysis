package hu.szlavikszabolcs.view.panels;

import hu.szlavikszabolcs.view.bean.Labels;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class InformationPanel extends JPanel implements ActionListener {
    JScrollPane jScrollPane;
    JEditorPane jEditorPane;
    JPanel jPanel2 = new JPanel();

    JButton button = new JButton(Labels.ok);

    public InformationPanel(){

        try {
            jEditorPane = new JEditorPane(Labels.homeURL);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, Labels.noHTML,Labels.error,JOptionPane.ERROR_MESSAGE);
        }
        setLayout(new BorderLayout());
        jScrollPane = new JScrollPane(jEditorPane);
        add(jScrollPane,BorderLayout.CENTER);
        button.addActionListener(this);
        jPanel2.add(button);
        add(jPanel2,BorderLayout.PAGE_END);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.setVisible(false);
        }
    }
}
