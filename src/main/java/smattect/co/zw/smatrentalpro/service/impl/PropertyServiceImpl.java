package smattect.co.zw.smatrentalpro.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smattect.co.zw.smatrentalpro.repository.PropertyRepository;
import smattect.co.zw.smatrentalpro.service.PropertyService;
import smattect.co.zw.smatrentalpro.utils.dao.Facilities;
import smattect.co.zw.smatrentalpro.utils.dao.Property;
import smattect.co.zw.smatrentalpro.utils.dto.request.PropertyRequest;
import smattect.co.zw.smatrentalpro.utils.dto.request.UpdatePropertyRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.FacilitiesResponse;
import smattect.co.zw.smatrentalpro.utils.dto.response.PropertyResponse;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl  implements PropertyService {

    private  final PropertyRepository propertyRepository;
    @Override
    public void addProperty(PropertyRequest propertyRequest) {
        Facilities facilities = Facilities.builder()
                .bathrooms(propertyRequest.getFacilitiesRequest().getBathrooms())
                .parking(propertyRequest.getFacilitiesRequest().getParking())
                .bedrooms(propertyRequest.getFacilitiesRequest().getBedrooms())
                .build();

        Property property = Property.builder()
                .title(propertyRequest.getTitle())
                .description(propertyRequest.getDescription())
                .price(propertyRequest.getPrice())
                .currency(propertyRequest.getCurrency())
                .country(propertyRequest.getCountry())
                .city(propertyRequest.getCity())
                .address(propertyRequest.getAddress())
                .reference("Ref: PB-GAT177989")
                .image(propertyRequest.getImage())
                .propertyType(propertyRequest.getPropertyType())
                .facilities(facilities)
                .build();
        property.setCreatedAt(LocalDateTime.now());
        property.setCreatedBy(1);
        propertyRepository.save(property);
    }

    @Override
    public PropertyResponse getPropertyById(long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new BusinessValidationException(""));
        PropertyResponse propertyResponse=new PropertyResponse();
        propertyResponse.setId(property.getId());
        propertyResponse.setTitle(property.getTitle());
        propertyResponse.setDescription(property.getDescription());
        propertyResponse.setPrice(property.getPrice());
        propertyResponse.setCurrency(property.getCurrency());
        propertyResponse.setCountry(property.getCountry());
        propertyResponse.setCity(property.getCity());
        propertyResponse.setAddress(property.getAddress());
        propertyResponse.setImage(property.getImage());
        propertyResponse.setReference(property.getReference());
        propertyResponse.setPropertyType(property.getPropertyType());
        FacilitiesResponse facilitiesResponse =new FacilitiesResponse();
        facilitiesResponse.setBathrooms(property.getFacilities().getBathrooms());
        facilitiesResponse.setBedrooms(property.getFacilities().getBedrooms());
        facilitiesResponse.setParking(property.getFacilities().getParking());
        propertyResponse.setFacilitiesResponse(facilitiesResponse);
        return  propertyResponse;
    }

    @Override
    public void updateProperty(UpdatePropertyRequest updatePropertyRequest) {
        Property property = propertyRepository.findById(updatePropertyRequest.getId())
                .orElseThrow(() -> new BusinessValidationException(""));
        property.setTitle(updatePropertyRequest.getTitle());
        property.setDescription(updatePropertyRequest.getDescription());
        property.setPrice(updatePropertyRequest.getPrice());
        property.setCountry(updatePropertyRequest.getCountry());
        property.setCity(updatePropertyRequest.getCity());
        property.setAddress(updatePropertyRequest.getAddress());
        property.setImage(updatePropertyRequest.getImage());
        property.setCurrency(updatePropertyRequest.getCurrency());
        property.setPropertyType(updatePropertyRequest.getPropertyType());
        propertyRepository.save(property);
    }

    @Override
    public List<PropertyResponse> findAllProperties() {
        List<PropertyResponse> propertyResponseList=new ArrayList<>();
        propertyRepository.findAll().forEach((item)->{
            PropertyResponse propertyResponse=new PropertyResponse();
            propertyResponse.setId(item.getId());
            propertyResponse.setTitle(item.getTitle());
            propertyResponse.setDescription(item.getDescription());
            propertyResponse.setPrice(item.getPrice());
            propertyResponse.setCountry(item.getCountry());
            propertyResponse.setCity(item.getCity());
            propertyResponse.setAddress(item.getAddress());
            propertyResponse.setPropertyType(item.getPropertyType());
            propertyResponse.setImage(item.getImage());
            propertyResponse.setReference(item.getReference());
            propertyResponse.setCurrency(item.getCurrency());
            FacilitiesResponse facilitiesResponse =new FacilitiesResponse();
            facilitiesResponse.setBathrooms(item.getFacilities().getBathrooms());
            facilitiesResponse.setBedrooms(item.getFacilities().getBedrooms());
            facilitiesResponse.setParking(item.getFacilities().getParking());
            propertyResponse.setFacilitiesResponse(facilitiesResponse);
            propertyResponseList.add(propertyResponse);
        });
        return propertyResponseList;
    }

    @Override
    public void deleteProperty(long id) {
        propertyRepository.findById(id)
                .orElseThrow(()->new BusinessValidationException(""));
     propertyRepository.deleteById(id);
    }
}
