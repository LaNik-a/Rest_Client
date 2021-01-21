package hw.dz01;

public class ClientDetailsDto {
    private final String country_name;
    private final String region_name;
    private final String city;
    private final double latitude;
    private final double longitude;

    ClientDetailsDto(String cit_name, String reg_name, String city, double ltt, double lgt) {
        country_name = cit_name;
        region_name = reg_name;
        this.city = city;
        latitude = ltt;
        longitude = lgt;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getRegion_name() {
        return region_name;
    }
}
