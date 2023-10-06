package exercises.gdk

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JOptionPane
import java.awt.BorderLayout

class SwingBuilders {
    static main(args) {
        SwingBuilder builder = new SwingBuilder()
        JFrame tela = builder.frame(title: "Tela", size: [300, 120], defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
                locationRelativeTo: null){
            panel( constraints: BorderLayout.CENTER) {
                label(text: "Nome:")
                textField(id: "nome", columns: 20)
                label(text: "E-mail:")
                textField(id: "email", text: "", columns: 20)
            }
            panel( constraints: BorderLayout.SOUTH) {
                button(text: "Gravar", actionPerformed: {
                    JOptionPane.showMessageDialog(null,
                            "gravou nome:" + nome.text +" - email:" + email.text)
                    nome.text = ""
                    email.text  =""
                })
                button(text: "Fechar", actionPerformed: { System.exit(0)})
            }
        }
        tela.setVisible(true)
    }
}
