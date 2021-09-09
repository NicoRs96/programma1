

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class CalcolatricePannello extends JPanel {
	   
	   private JButton[] bottoni = {
	            new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
	            new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
	            new JButton("7"), new JButton("8"), new JButton("9"), new JButton("*"),
	            new JButton("0"), new JButton("."), new JButton("="), new JButton("/")
	    };
	   
	    private CalcolatriceFinestra mainFrame;
	   
	    public CalcolatricePannello(CalcolatriceFinestra calcFin) {
	        mainFrame = calcFin;
	        setLayout(new GridLayout(4,4));
	        BottoniListener listenerBottoni = new BottoniListener();
	        for (int i = 0; i < bottoni.length; ++i) {
	            bottoni[i].setBackground(Color.ORANGE);
	            add(bottoni[i]);
	            bottoni[i].addActionListener(listenerBottoni);
	        }
	    }
	   
	    public class BottoniListener implements ActionListener {
	        public void actionPerformed(ActionEvent ev) {
	            JButton pressed = (JButton)ev.getSource();
	            char c = pressed.getText().charAt(0);
	            if ((c >= '0') && (c <= '9')) {
	                mainFrame.inseritaCifra(c);
	            } else if (c == '.') {
	                mainFrame.inseritoPunto();
	            } else {
	                mainFrame.inseritoOperatore(c);  
	            }
	        }
	    }

}
