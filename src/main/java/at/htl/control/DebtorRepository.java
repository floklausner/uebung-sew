package at.htl.control;

import at.htl.entity.Debtor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class DebtorRepository implements PanacheRepository<Debtor> {

    @Transactional
    public Debtor save(Debtor debtor) {
        return getEntityManager().merge(debtor);
    }

}
