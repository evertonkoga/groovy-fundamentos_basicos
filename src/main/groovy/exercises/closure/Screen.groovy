package exercises.closure

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import java.awt.FlowLayout

class Screen extends JFrame {
    Screen() {
        setTitle("Title")
        setSize(200, 200)

        def button = new JButton("Click")
        getContentPane().setLayout(new FlowLayout())
        add(button)

        button.addActionListener({ JOptionPane.showMessageDialog(null, "Foi via closure ") })
    }

    static main(args) {
        def screen = new Screen()
        screen.setVisible(true)
    }
}
