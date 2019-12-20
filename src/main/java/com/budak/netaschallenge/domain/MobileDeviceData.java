package com.budak.netaschallenge.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Column
    @NotEmpty
    private String os;

    @Column
    @NotEmpty
    private String osVersion;


}
