package com.budak.netaschallenge.domain;

import com.budak.netaschallenge.enums.EnumOperatingSystem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Samet BUDAK
 * @since
 */
@Entity
@Table(name = "DEVICE", uniqueConstraints = @UniqueConstraint(columnNames = {"BRAND", "MODEL", "OS_VERSION"}))
@ApiModel(description="All details about the Device. ")
public class Device {

    @GeneratedValue(generator = "device", strategy = GenerationType.AUTO)
    @Id
    @SequenceGenerator(name = "device", sequenceName = "DEVICE_ID_SEQ")
    private Long id;

    @Column(name = "BRAND")
    @NotEmpty(message = "Please enter brand")
    @ApiModelProperty(notes="brand is a mandatory field", example = "XIAOMI")
    private String brand;

    @Column(name = "MODEL")
    @NotEmpty(message = "Please enter model")
    @ApiModelProperty(notes="model is a mandatory field", example = "MI 8 ")
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(name = "OS")
    @NotNull(message = "please enter os")
    @ApiModelProperty(notes="os is Enumerated , it can be either Android or ios", example = "ios")
    private EnumOperatingSystem os;

    @Column(name = "OS_VERSION")
    @NotEmpty(message = "Please enter osVersion")
    @ApiModelProperty(notes="osVersion must not be empty", example = "8.0.1")
    private String osVersion;

    public Device(){

    }

    public Device(@NotEmpty(message = "Please enter brand") String brand, @NotEmpty(message = "Please enter model") String model, @NotNull(message = "please enter os") EnumOperatingSystem os, @NotEmpty(message = "Please enter osVersion") String osVersion) {
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
        return "Device{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os=" + os +
                ", osVersion='" + osVersion + '\'' +
                '}';
    }
}
