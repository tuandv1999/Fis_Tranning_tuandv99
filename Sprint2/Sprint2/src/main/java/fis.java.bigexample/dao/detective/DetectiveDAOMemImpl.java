package fis.java.bigexample.dao.detective;

import fis.java.bigexample.dao.MemoryDataSource;
import fis.java.bigexample.model.Detective;

import java.util.List;
import java.util.Optional;

public class DetectiveDAOMemImpl implements IDetectiveDAO {

    @Override
    public Optional<Detective> get(long id) {
       return MemoryDataSource.DETECTIVES.stream()
               .filter(detective->detective.getId()==id)
               .findFirst();
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public void save(Detective detective) {
        if(
                !MemoryDataSource.DETECTIVES.stream().filter(item -> item.getId()==detective.getId()).findFirst().isPresent()
        )
            MemoryDataSource.DETECTIVES.add(detective);

    }

    @Override
    public void update(Detective detective) {
        Optional<Detective> detectives = get(detective.getId());
        if(detectives.isPresent()){
            Detective updatedDetective = detectives.get();
            updatedDetective.replaceWith(detective);
        }

    }

    @Override
    public void delete(Detective detective) {
        MemoryDataSource.DETECTIVES.remove(detective);

    }
}
