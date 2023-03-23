package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.ViewDonator;
import org.hibernate.SessionFactory;

public class ControllerDonator {
    SessionFactory sessionFactory;
    public ControllerDonator(SessionFactory sf){
        sessionFactory = sf;
        ViewDonator view = new ViewDonator(new LoginListener(), new RegisterListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            View.ViewWelcome.mainFrame.setVisible(false);
            ControllerLogin controller = new ControllerLogin(sessionFactory);
        }
    }

    class RegisterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            View.ViewWelcome.mainFrame.setVisible(false);
            ControllerRegister controller = new ControllerRegister(sessionFactory);
        }
    }
}
