package com.revature.rms.campus.exceptions;

public class ResourcePersistenceException extends RuntimeException {
    ResourcePersistenceException () {
        super("This resource is already in use.");
    }
}
