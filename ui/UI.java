package AIOWoodcutter.ui;

/**
 * Created by Mitch on 10/04/2015.
 */

import AIOWoodcutter.Methods;
import AIOWoodcutter.data.Location;
import AIOWoodcutter.data.Tree;
import AIOWoodcutter.data.Variables;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    private final ButtonGroup woodcutOptionButtonGroup = new ButtonGroup();
    private JPanel contentPane;
    private JComboBox location = new JComboBox();
    private JComboBox treeSelect = new JComboBox();
    private JRadioButton bank = new JRadioButton("Bank");
    private JRadioButton drop = new JRadioButton("Drop");

    public UI() {
        setTitle("AIO Woodcutter");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 426, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 421, 280);
        contentPane.add(tabbedPane);

        JPanel fletchPanel = new JPanel();
        tabbedPane.addTab("Woodcutting", null, fletchPanel, null);
        fletchPanel.setLayout(null);

        woodcutOptionButtonGroup.add(bank);
        bank.setSelected(true);
        bank.setBounds(79, 49, 109, 23);
        fletchPanel.add(bank);

        woodcutOptionButtonGroup.add(drop);
        drop.setBounds(223, 49, 109, 23);
        fletchPanel.add(drop);

        JLabel lblMulingLocation = new JLabel("Location");
        lblMulingLocation.setBounds(50, 96, 73, 20);
        fletchPanel.add(lblMulingLocation);


        location.setModel(
                new DefaultComboBoxModel(Methods.locationToStringArray()));
        location.setBounds(50, 123, 300, 20);
        fletchPanel.add(location);

        JLabel lblTree = new JLabel("Tree");
        lblTree.setBounds(50, 150, 73, 20);
        fletchPanel.add(lblTree);

        treeSelect.setModel(
                new DefaultComboBoxModel(Methods.treeToStringArray(Location.DRAYNOR)));
        treeSelect.setBounds(50, 180, 300, 20);
        fletchPanel.add(treeSelect);

        location.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                for (Location loc : Location.values()) {
                    if (loc.getName().equalsIgnoreCase(location.getSelectedItem().toString())) {
                        treeSelect.setModel(
                                new DefaultComboBoxModel(Methods.treeToStringArray(loc)));
                    }
                }
            }
        });

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                for (Location loc : Location.values()) {
                    if (loc.getName().equalsIgnoreCase(location.getSelectedItem().toString())) {
                        Variables.setLocation(loc);
                    }
                }
                for (Tree selectedTree : Tree.values()) {
                    if (selectedTree.getName().equalsIgnoreCase(treeSelect.getSelectedItem().toString())) {
                        Variables.setTree(selectedTree);
                        System.out.println(selectedTree.getName());
                    }
                }
                if (drop.isSelected()) {
                    Variables.setDrop(true);
                }
                if (bank.isSelected()) {
                    Variables.setSell(true);
                }
                dispose();
            }
        });
        start.setBounds(0, 280, 421, 20);
        contentPane.add(start);
    }
}