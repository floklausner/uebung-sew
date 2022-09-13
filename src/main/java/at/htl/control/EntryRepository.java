package at.htl.control;

import at.htl.entity.Entry;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class EntryRepository implements PanacheRepository<Entry> {

    @Transactional
    public Entry save(Entry entry) {
        return getEntityManager().merge(entry);
    }

}
