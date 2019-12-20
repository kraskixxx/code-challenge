package com.budak.netaschallenge.domain;

import com.budak.netaschallenge.enums.EnumOperatingSystem;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Samet BUDAK
 * @since
 */
@Entity
@Table(name = "MOBILE_DEVICE_DATA", uniqueConstraints = @UniqueConstraint(columnNames = {"BRAND", "MODEL", "OS_VERSION"}))
public class MobileDeviceData {

    @GeneratedValue(generator = "modelDeviceData", strategy = GenerationType.AUTO)
    @Id
    @SequenceGenerator(name = "modelDeviceData", sequenceName = "MOBILE_DEVICE_DATA_ID_SEQ")
    private Long id;

    @Column(name = "BRAND")
    @NotEmpty(message = "Please enter brand")
    private String brand;

    @Column(name = "MODEL")
    @NotEmpty(message = "Please enter model")
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(name = "OS")
    @NotNull(message = "please enter os")
    private EnumOperatingSystem os;

    @Column(name = "OS_VERSION")
    @NotEmpty(message = "Please enter osVersion")
    private String osVersion;

    public MobileDeviceData(){

    }

    public MobileDeviceData(@NotEmpty(message = "Please enter brand") String brand, @NotEmpty(message = "Please enter model") String model, @NotNull(message = "please enter os") EnumOperatingSystem os, @NotEmpty(message = "Please enter osVersion") String osVersion) {
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.osVersion = osVersion;
    }

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
