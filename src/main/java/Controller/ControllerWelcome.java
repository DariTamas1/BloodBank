package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.ViewWelcome;
import org.hibernate.SessionFactory;

public class ControllerWelcome {
    SessionFactory sessionFactory;
    public ControllerWelcome(SessionFactory sf){
        sessionFactory = sf;
        ViewWelcome view = new ViewWelcome(new LoginListener(), new RegisterListener());
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
