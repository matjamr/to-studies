package org.jamroz.mateusz.context;

import org.jamroz.mateusz.context.repository.Repository;

public interface Context {
    Repository getRepository();
}
