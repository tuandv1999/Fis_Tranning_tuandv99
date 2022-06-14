package fis.java.bigexample.dao.storage;

import fis.java.bigexample.model.Storage;

import java.util.List;
import java.util.Optional;

public class DAOStorageMemImpl implements  IDAOStorage{

    @Override
    public Optional<Storage> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Storage> getAll() {
        return null;
    }

    @Override
    public void save(Storage storage) {

    }

    @Override
    public void update(Storage storage) {

    }

    @Override
    public void delete(Storage storage) {

    }
}
