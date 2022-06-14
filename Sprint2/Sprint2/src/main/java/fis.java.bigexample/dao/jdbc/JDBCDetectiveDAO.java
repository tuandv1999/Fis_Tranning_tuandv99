package fis.java.bigexample.dao.jdbc;


import fis.java.bigexample.dao.detective.IDetectiveDAO;
import fis.java.bigexample.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO implements IDetectiveDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);
    @Override
    public void save(Detective detective) {

    }

    @Override
    public Optional<Detective> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Detective> getAll() {
        List<Detective> detectives = new ArrayList<>();
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                Detective detective = DatabaseMapper.getDetective(rs);
                if(detective != null) detectives.add(detective);
            } // end of while
        } catch (Exception e) {
            logger.error(e.toString());
        } // end of try-with-resources
        return detectives;
    }

    @Override
    public void update(Detective detective) {

    }

    @Override
    public void delete(Detective detective) {

    }
}
