package View;

import Model.Admin;

import java.sql.SQLException;
import java.util.List;

public interface ManageAdmin{
        public Admin Login(String name) ;
    public void insertAdmin(Admin admin) throws SQLException;

    public Admin selectAdmin(int id);

    public List<Admin> selectAllAdmin();

    public boolean deleteAdmin(int id) throws SQLException;

    public boolean updateAdmin(Admin admin) throws SQLException;
}
