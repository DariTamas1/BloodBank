package Controller;

import Model.Donator;
import Model.User;
import Repository.DonatorRepository;
import Repository.UserRepository;
import View.ViewRegister;
import org.hibernate.SessionFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRegister {
    ViewRegister view;
    SessionFactory sessionFactory;

    public ControllerRegister(SessionFactory sf){
        sessionFactory = sf;
        view = new ViewRegister(new BackListener(), new RegisterListener());
    }

    class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewRegister.mainFrame.setVisible(false);
            ControllerWelcome controller = new ControllerWelcome(sessionFactory);
        }
    }

    class RegisterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User("donator", ViewRegister.username.getText(), ViewRegister.password.getText());
            UserRepository.save(user, sessionFactory);

            Donator donator = new Donator(ViewRegister.name.getText(), ViewRegister.email.getText(), ViewRegister.bloodType.getText(), ViewRegister.address.getText(), user);
            DonatorRepository.save(donator, sessionFactory);

            ViewRegister.mainFrame.setVisible(false);
            ControllerDonator controller = new ControllerDonator(sessionFactory);
        }
    }


}
