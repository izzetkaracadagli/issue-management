package com.karacadaglii.issuemanagement.Entity.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass //Bu class ın otomatikmen diğer classlar da extend edilebilir anlamına gelir
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "created_by",length = 100)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by",length = 100)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;
}

