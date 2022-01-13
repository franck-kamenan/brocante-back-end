package com.example.brocante.mappers.basemappers;

public interface BaseMapper<TFORM, TENTITY, TDTO> {
    
    public TENTITY formToEntity(TFORM form);

    public TDTO entityToDto(TENTITY entity);

    public TENTITY dtoToEntity(TDTO dto);
}