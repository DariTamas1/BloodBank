package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ViewAdmin;
import View.ViewDoctor;
import View.ViewWelcome;
import org.hibernate.SessionFactory;

public class ControllerDoctor {
    SessionFactory sessionFactory;
    public ControllerDoctor(SessionFactory sf){
        sessionFactory = sf;
        ViewDoctor view = new ViewDoctor(new LoginListener(), new RegisterListener());
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
