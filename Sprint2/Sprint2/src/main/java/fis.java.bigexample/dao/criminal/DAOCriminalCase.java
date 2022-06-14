package fis.java.bigexample.dao.criminal;

import fis.java.bigexample.dao.MemoryDataSource;
import fis.java.bigexample.model.CriminalCase;

import java.util.List;
import java.util.Optional;

public class DAOCriminalCase implements IDAOCriminalCase {

    @Override
    public Optional<CriminalCase> get(long id) {

        return MemoryDataSource.CRIMINAL_CASES.stream()
                .filter(criminalCase->criminalCase.getId()==id)
                .findFirst();
    }

    @Override
    public List<CriminalCase> getAll() {
        return null;
    }

    @Override
    public void save(CriminalCase criminalCase) {
        if(
                !MemoryDataSource.CRIMINAL_CASES.stream().filter(item -> item.getId()==criminalCase.getId()).findFirst().isPresent()
        )
            MemoryDataSource.CRIMINAL_CASES.add(criminalCase);
    }

    @Override
    public void update(CriminalCase criminalCase) {
        Optional<CriminalCase> criminal = get(criminalCase.getId());
        if(criminal.isPresent()){
            CriminalCase updatedCriminalCase = criminal.get();
            updatedCriminalCase.replaceWith(criminalCase);
        }
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
    }
}
