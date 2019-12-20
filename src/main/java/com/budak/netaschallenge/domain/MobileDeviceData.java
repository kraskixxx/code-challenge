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
    private EnumOperatingSystem os;

    @Column
    @NotEmpty
    private String osVersion;


}
