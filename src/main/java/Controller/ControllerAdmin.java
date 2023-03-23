package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.Doctor;
import Model.User;
import Repository.DoctorRepository;
import Repository.UserRepository;
import View.ViewAdmin;
import org.hibernate.SessionFactory;
import javax.swing.table.DefaultTableModel;

public class ControllerAdmin {
    SessionFactory sessionFactory;
    public ControllerAdmin(SessionFactory sf){
        sessionFactory = sf;
        ViewAdmin view = new ViewAdmin(new AddListener(), new DeleteListener(), new EditListener(), new BackListener());
        setAllDoctors();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewAdmin.mainFrame.setVisible(false);
            ControllerWelcome controller = new ControllerWelcome(sessionFactory);
        }
    }

    public void setAllDoctors(){
        List<Doctor> list = DoctorRepository.findAll(sessionFactory);
        DefaultTableModel model = (DefaultTableModel) ViewAdmin.doctorTable.getModel();
        model.setRowCount(0);
        for(Doctor doctor : list){
            model.addRow(new Object[]{Integer.toString(doctor.getId()), doctor.getUsername(), doctor.getPassword(), doctor.getName(), doctor.getEmail(), doctor.getAddress(), doctor.getUserId()});
        }
    }

    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User("doctor", ViewAdmin.addUsername.getText(), ViewAdmin.addPassword.getText());
            UserRepository.save(user, sessionFactory);

            Doctor doctor = new Doctor(ViewAdmin.addName.getText(), ViewAdmin.addEmail.getText(), ViewAdmin.addAddress.getText(), user);
            DoctorRepository.save(doctor, sessionFactory);

            setAllDoctors();
        }
    }

    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = ViewAdmin.doctorTable.getSelectedRow();
            int id = Integer.parseInt(String.valueOf(ViewAdmin.doctorTable.getValueAt(row, 0)));
            int userId = Integer.parseInt(String.valueOf(ViewAdmin.doctorTable.getValueAt(row, 6)));
            DoctorRepository.deleteById(id, sessionFactory);
            UserRepository.deleteById(userId, sessionFactory);
            setAllDoctors();
        }
    }

    class EditListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = ViewAdmin.doctorTable.getSelectedRow();
            int userId = Integer.parseInt(String.valueOf(ViewAdmin.doctorTable.getValueAt(row, 6)));
            UserRepository.updateById(userId, "doctor", ViewAdmin.doctorTable.getValueAt(row, 1).toString(), ViewAdmin.doctorTable.getValueAt(row, 2).toString(), sessionFactory);
            DoctorRepository.updateById(Integer.parseInt(String.valueOf(ViewAdmin.doctorTable.getValueAt(row, 0))), ViewAdmin.doctorTable.getValueAt(row, 3).toString(), ViewAdmin.doctorTable.getValueAt(row, 4).toString(), ViewAdmin.doctorTable.getValueAt(row, 5).toString(), sessionFactory);
            setAllDoctors();
        }
    }
}
