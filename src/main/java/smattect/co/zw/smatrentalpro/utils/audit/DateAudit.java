package smattect.co.zw.smatrentalpro.utils.audit;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"created_at", "updated_at"},
        allowGetters = true
)
@Getter
@Setter
public abstract class DateAudit implements Serializable {


    @CreatedDate
    @Column(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private LocalDateTime createdAt;

    @JsonIgnore
    @CreatedBy
    @Column(name = "CREATED_BY")
    private int createdBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private int updatedBy;


    @JsonIgnore
    @Column(name = "DELETED")
    private  Boolean Deleted=false;

}
