package theuz.com;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MinhaJanela extends JFrame {
    JButton botao = new JButton("clique aqui");
    JPanel painel = new JPanel();

   public MinhaJanela() {
      super("Minha Janela");
      setSize(300, 150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);

      //Criando um paninel (Container generico)
      add(painel);

      //Adicionando um botao ao painel
      painel.add(botao);
      
      botao.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Ola mundo!");
        }
      });
   }
}