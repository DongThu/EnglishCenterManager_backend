package com.example.EnglishCenterManager_backend.document;


import com.example.EnglishCenterManager_backend.courseType.courseType;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    

    @OneToOne
    @JoinColumn(name = "englishId")
    private courseType nameD;

    // @NotEmpty
    // private String typeD;
    
    private String nameDocument;

    private String typeDocument;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fileData",length = 1000)
    private byte[] fileData;
}
