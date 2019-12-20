package com.budak.netaschallenge.domain;

import com.budak.netaschallenge.enums.EnumOperatingSystem;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Samet BUDAK
 * @since
 */
@Entity
@Table(name = "MOBILE_DEVICE_DATA")
public class MobileDeviceData {

    @GeneratedValue(generator = "modelDeviceData", strategy = GenerationType.AUTO)
    @Id
    @SequenceGenerator(name = "modelDeviceData", sequenceName = "MOBILE_DEVICE_DATA_ID_SEQ")
    private Long id;

    @Column
    @NotEmpty
    private String brand;

    @Column
    @NotEmpty
    private String model;

    @Enumerated(EnumType.STRING)
    @Column
    @NotEmpty
    private EnumOperatingSystem os;

    @Column
    @NotEmpty
    private String osVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EnumOperatingSystem getOs() {
        return os;
    }

    public void setOs(EnumOperatingSystem os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public String toString() {
        return "MobileDeviceData{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os=" + os +
                ", osVersion='" + osVersion + '\'' +
                '}';
    }
}
