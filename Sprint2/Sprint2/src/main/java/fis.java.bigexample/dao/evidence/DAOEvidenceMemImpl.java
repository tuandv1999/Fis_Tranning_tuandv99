package fis.java.bigexample.dao.evidence;

import fis.java.bigexample.dao.MemoryDataSource;
import fis.java.bigexample.model.Evidence;

import java.util.List;
import java.util.Optional;

public class DAOEvidenceMemImpl implements IDAOEvidence {

    @Override
    public Optional<Evidence> get(long id) {
        return MemoryDataSource.EVIDENCES.stream()
                .filter(evidence -> evidence.getId()==id)
                .findFirst();
    }

    @Override
    public List<Evidence> getAll() {
        return null;
    }

    @Override
    public void save(Evidence evidence) {
        if(
                !MemoryDataSource.EVIDENCES.stream().filter(item -> item.getId()==evidence.getId()).findFirst().isPresent()
        )
            MemoryDataSource.EVIDENCES.add(evidence);

    }

    @Override
    public void update(Evidence evidence) {
        Optional<Evidence> evidences = get(evidence.getId());
        if(evidences.isPresent()){
            Evidence updatedEvidence = evidences.get();
            updatedEvidence.replaceWith(evidence);
        }
    }

    @Override
    public void delete(Evidence evidence) {
        MemoryDataSource.EVIDENCES.remove(evidence);

    }
}
