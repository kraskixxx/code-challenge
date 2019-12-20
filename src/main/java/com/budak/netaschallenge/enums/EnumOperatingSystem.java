package com.budak.netaschallenge.enums;

/**
 * @author Samet BUDAK
 * @since
 */

/**
 * OperatingSystem can be either Android or ios
 *
 */
public enum EnumOperatingSystem {

    ANDROID("Android"),
    IOS("ios");

    private final String operatingSystem;

    EnumOperatingSystem(String operatingSystem) {this.operatingSystem = operatingSystem;}

    public String getOperatingSystem() { return operatingSystem; }


}
