package com.loadsapi.loadsapi.services;

import java.util.List;
import java.util.UUID;

import com.loadsapi.loadsapi.entities.Load;

public interface LoadService {

    public List<Load> getAllLoads();

    public List<Load> getLoadsByShipperId(UUID shipperId);

    public Load getLoadByLoadId(long loadId);

    public String addLoad(Load load);

    public void updateLoad(long loadId, Load load);

    public void deleteLoad(long loadId);
}
