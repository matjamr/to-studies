package org.jamroz.mateusz.context;

import org.jamroz.mateusz.context.repository.Repository;

public class CurrencyContext implements Context {

    private final Repository repository;

    private CurrencyContext(Repository repository) {
        this.repository = repository;
    }


    public static CurrencyContext init(Repository repository) {
        return new CurrencyContext(repository);
    }

    @Override
    public Repository getRepository() {
        return repository;
    }
}
