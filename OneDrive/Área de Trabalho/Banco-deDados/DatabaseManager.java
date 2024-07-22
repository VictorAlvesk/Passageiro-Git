import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DatabaseManager {
    private Dao<Passageiro, String> passageiroDao;
    private ConnectionSource connectionSource;

    public DatabaseManager(String databaseUrl) throws SQLException {
        connectionSource = new JdbcConnectionSource(databaseUrl);
        passageiroDao = DaoManager.createDao(connectionSource, Passageiro.class);
    }

    // Create
    public void createPassageiro(Passageiro passageiro) throws SQLException {
        passageiroDao.create(passageiro);
    }

    // Retrieve
    public Passageiro getPassageiro(String cpf) throws SQLException {
        return passageiroDao.queryForId(cpf);
    }

    // Update
    public void updatePassageiro(Passageiro passageiro) throws SQLException {
        passageiroDao.update(passageiro);
    }

    // Delete
    public void deletePassageiro(Passageiro passageiro) throws SQLException {
        passageiroDao.delete(passageiro);
    }

    public void close() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
