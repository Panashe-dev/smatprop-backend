package smattect.co.zw.smatrentalpro.service;

import smattect.co.zw.smatrentalpro.utils.dto.request.PropertyRequest;
import smattect.co.zw.smatrentalpro.utils.dto.request.UpdatePropertyRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.PropertyResponse;

import java.util.List;

public interface PropertyService {
    void addProperty(PropertyRequest propertyRequest);

    PropertyResponse getPropertyById(long id);

    void  updateProperty(UpdatePropertyRequest updatePropertyRequest);

    List<PropertyResponse> findAllProperties();

    void deleteProperty(long id);
}
