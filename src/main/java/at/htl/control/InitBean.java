package at.htl.control;

import at.htl.entity.Account;
import at.htl.entity.Debtor;
import at.htl.entity.Entry;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDateTime;

@ApplicationScoped
public class InitBean {

    @Inject
    AcountRepository acountRepository;

    @Inject
    DebtorRepository debtorRepository;

    @Inject
    EntryRepository entryRepository;

    public void init(@Observes StartupEvent event) {

        //Write data into Account table
        Account klausner = new Account(
                "Florian Klausner",
                "Tolmezzo Straße 2",
                "+43 660 8181610",
                "klausnerflo@gmail.com"
        );

        Account dorfinger = new Account(
                "Jonas Dorfinger",
                "Streberstraße 1",
                "+43 664 8987162",
                "dorfingerjonas@gmail.com"
        );

        Account mandel = new Account(
                "Rosalie Mandel",
                "BigBootyStreet 69",
                "+43 660 6969420",
                "mandelrosi@gmail.com"
        );

        acountRepository.save(klausner);
        acountRepository.save(dorfinger);
        acountRepository.save(mandel);

        //Write data into Deptor table
        Debtor starka = new Debtor("Lukas Starka", klausner);
        Debtor wiesinger = new Debtor("Jonas Wiesinger", mandel);
        Debtor scholl = new Debtor("Sebastian Scholl", dorfinger);

        debtorRepository.save(starka);
        debtorRepository.save(wiesinger);
        debtorRepository.save(scholl);

        //Write data into Entry table
        entryRepository.save(
                new Entry(LocalDateTime.now(), 12.40, "Zu viel Swag", false, starka)
        );
        entryRepository.save(
                new Entry(LocalDateTime.now(), 89.00, "Zu wenig Swag", false, wiesinger)
        );
        entryRepository.save(
                new Entry(LocalDateTime.now(), 100.90, "Viel zu viel Swag", false, scholl)
        );
    }
}
