package com.redhat.example.entity.listener;

import java.util.logging.Logger;

import javax.persistence.PostPersist;

public class PersistEntityLogging {
    static Logger log = Logger.getLogger(PersistEntityLogging.class.getName());

    @PostPersist
    public void logPersist(Object entity) {
        log.info("### Persisted entity : "+entity);
    }
}