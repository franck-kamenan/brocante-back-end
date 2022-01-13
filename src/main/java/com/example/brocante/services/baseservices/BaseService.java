package com.example.brocante.services.baseservices;

import java.util.List;

public interface BaseService<TDTO, TID, TFORM> {
    
    // Create one
    TDTO insert(TFORM form);
    // Create multiple
    
    // Read or Retrieve one by id
    TDTO getOneById(TID id);
    // Read or Retrieve multiple
    // Read or Retrieve all
    List<TDTO> getAll();

    // Update one by id
    TDTO update(TFORM form, TID id);
    // Update multiple
    // Update all
    
    // Delete one by id
    TID delete(TID id);
    // Delete multiple
    // Delete all
}