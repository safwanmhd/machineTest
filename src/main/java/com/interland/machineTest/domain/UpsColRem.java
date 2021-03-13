package com.interland.machineTest.domain;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "ups_col_rem")
public class UpsColRem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_id")
    private String clientId;

    @Column(name="scheme_id")
    private String schemeId;

    @Column(name="remitter_id")
    private String remitterId;

    /*@Lob
    private byte[] profilePic;*/

    @Column(name="address")
    private String address;

    @Column(name="national_id")
    private String nationalId;

    public Long getId() {
        return id;
    }

    public UpsColRem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public UpsColRem setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public UpsColRem setSchemeId(String schemeId) {
        this.schemeId = schemeId;
        return this;
    }

    public String getRemitterId() {
        return remitterId;
    }

    public UpsColRem setRemitterId(String remitterId) {
        this.remitterId = remitterId;
        return this;
    }

    /*public byte[] getProfilePic() {
        return profilePic;
    }

    public UpsColRem setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
        return this;
    }*/

    public String getAddress() {
        return address;
    }

    public UpsColRem setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public UpsColRem setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }
}
