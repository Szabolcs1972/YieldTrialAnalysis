package hu.szlavikszabolcs.view.panels;


import hu.szlavikszabolcs.view.bean.Labels;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseListener;
import java.util.Locale;


public class ShowDatabase extends JPanel implements ActionListener, MouseListener {
    JPanel jPanel = new JPanel();
    public AbstractTableModel abstractTableModel;
    JTable table;
    JScrollPane scrollPane;
    JButton button = new JButton(Labels.ok);

    public ShowDatabase(AbstractTableModel abstractTableModel) {

        this.abstractTableModel = abstractTableModel;

        setLayout(new BorderLayout());

        table = new JTable(abstractTableModel){

            //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
            //How to use tables
            public String getToolTipText(MouseEvent e) {//set the tooltiptext of the columns
                String tip = null;
                java.awt.Point p = e.getPoint();
                int colIndex = table.columnAtPoint(p);

                //int colIndex = table.columnAtPoint(p);

                tip = abstractTableModel.getColumnName(colIndex);
                //System.out.println("A tip az = " + tip);
                //System.out.println("A rowindex : " + rowIndex);
                //System.out.println("A colindex : " + colIndex);

                return tip;
            }

            protected JTableHeader createDefaultTableHeader() {
                return new JTableHeader(columnModel) {
                    public String getToolTipText(MouseEvent e) {
                        String tip = null;
                        java.awt.Point p = e.getPoint();
                        int index = columnModel.getColumnIndexAtX(p.x);
                        int realIndex = columnModel.getColumn(index).getModelIndex();
                        return abstractTableModel.getColumnName(realIndex);
                    }
                };
            }

        };
        table.setAutoCreateRowSorter(true);
        table.addMouseListener(this);


        scrollPane = new JScrollPane(table);


        add(scrollPane,BorderLayout.CENTER);

        jPanel.add(button);
        add(jPanel,BorderLayout.PAGE_END);

        button.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {

            this.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*
        java.awt.Point p = e.getPoint();
        System.out.println("Az egér most itt van: " + p);
        getToolTipText(e);
        //renderer.setToolTipText(getToolTipText(e));
        //createDefaultTableHeader();
        table.setToolTipText(getToolTipText(e));

         */
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        table.setToolTipText(getToolTipText(e));


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
