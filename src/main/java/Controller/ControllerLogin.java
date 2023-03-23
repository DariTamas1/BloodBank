package Controller;

import Model.User;
import Repository.UserRepository;
import View.ViewLogin;
import org.hibernate.SessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLogin {
    ViewLogin view;
    SessionFactory sessionFactory;

    public ControllerLogin(SessionFactory sf){
        view = new ViewLogin(new BackListener(), new LoginListener());
        sessionFactory = sf;
    }

    class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewLogin.mainFrame.setVisible(false);
            ControllerWelcome controller = new ControllerWelcome(sessionFactory);
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = ViewLogin.username.getText();
            String password = ViewLogin.password.getText();

            User user = UserRepository.findByUsernameAndPassword(username, password, sessionFactory);

            if (user == null) {
                System.out.println("User not found");
            }
            else {
                if (user.getRol().equals("admin")) {
                    ViewLogin.mainFrame.setVisible(false);
                    ControllerAdmin controller = new ControllerAdmin(sessionFactory);
                }

                if (user.getRol().equals("doctor")) {
                    ViewLogin.mainFrame.setVisible(false);
                    ControllerDoctor controller = new ControllerDoctor(sessionFactory);
                }

                if (user.getRol().equals("donator")) {
                    ViewLogin.mainFrame.setVisible(false);
                    ControllerDonator controller = new ControllerDonator(sessionFactory);
                }
            }
        }
    }
}
