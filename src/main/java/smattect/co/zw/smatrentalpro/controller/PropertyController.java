package smattect.co.zw.smatrentalpro.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import smattect.co.zw.smatrentalpro.service.PropertyService;
import smattect.co.zw.smatrentalpro.utils.dto.request.PropertyRequest;
import smattect.co.zw.smatrentalpro.utils.dto.request.UpdatePropertyRequest;
import smattect.co.zw.smatrentalpro.utils.dto.response.PropertyResponse;
import smattect.co.zw.smatrentalpro.utils.dto.response.ResponseMessage;
import smattect.co.zw.smatrentalpro.utils.exception.BusinessValidationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/property")
@Tag(name = "Property Controller", description = "Property Controller")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addProperty(@RequestBody PropertyRequest propertyRequest){
        propertyService.addProperty(propertyRequest);
        return ResponseEntity.ok(new ResponseMessage("property created success"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropertyResponse>> getProperties(){
        return ResponseEntity.ok(propertyService.findAllProperties());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProperty(@RequestBody @Valid UpdatePropertyRequest updatePropertyRequest) {

        propertyService.updateProperty(updatePropertyRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable long propertyId) {

        PropertyResponse property = propertyService.getPropertyById(propertyId);

        return ResponseEntity.ok(property);
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<?> deleteProperty(@PathVariable long propertyId) {

      propertyService.deleteProperty(propertyId)
      ;
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/image/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        if (file == null) {
            throw new BusinessValidationException("Invalid Image!!");
        }
        UUID uuid = UUID.randomUUID();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Files.createDirectories(Paths.get("images"));
        Path path = Paths.get("images/" + uuid.toString() + "__" + fileName);
        Path absolutePath = path.toAbsolutePath();
        try {
            Files.copy(file.getInputStream(), absolutePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> response = new HashMap<>();
        response.put("imageId", uuid.toString() + "__" + fileName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/image/{imageId}")
    public ResponseEntity<?> getImage(@PathVariable String imageId) throws IOException {
        Optional<Path> images = Files.list(Paths.get("images")).filter(img -> img.getFileName().toString().equals(imageId)).findFirst();
        if (images.isPresent()) {
            final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(images.get()));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.IMAGE_JPEG)
                    .contentLength(inputStream.contentLength())
                    .body(inputStream);
        }
        return ResponseEntity.ok().build();
    }

}
