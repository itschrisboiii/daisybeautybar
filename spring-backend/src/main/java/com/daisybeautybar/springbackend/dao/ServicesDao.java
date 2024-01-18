package com.daisybeautybar.springbackend.dao;



import com.daisybeautybar.springbackend.model.Service;

import java.util.List;

public interface ServicesDao {
    Service getServiceById(int serviceId);

    List<Service> getServices();

    Service newService (Service service);

    Service updateService (Service updatedService);

    int deleteServiceById(int serviceId);
}
