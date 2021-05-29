package com.example.poalibExWebService.dataservice;

public class AddressConstants {
    public static final String findByPrefix="/findByPrefix";
    public static final String findFatPeopleInIsrael="/findFatPeopleInIsrael";
    public static final String personDataServicePort=":8082";
    public static final String personDataServiceDns="localhost";
    public static final String personEndPoint = "/person";
    public static final String protocol = "http://";
    public static final String personEndService = protocol+personDataServiceDns+personDataServicePort+personEndPoint;
    public static final String findALL="/findAll";
}
