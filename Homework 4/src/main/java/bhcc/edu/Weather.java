package bhcc.edu;

import java.io.Serializable;


/**
 * This class represents Weather object which is Serializable, so it can be sent through Sockets as bytes.
 */
public class Weather implements Serializable {
    private double precipitation, temp_max, temp_min, wind;
    private String weather;

    /**
     * Constructor that initializes the instance variables
     *
     * @param precipitation
     * @param temp_max
     * @param temp_min
     * @param wind
     * @param weather
     */
    public Weather( double precipitation, double temp_max,  double temp_min, double wind, String weather){
        this.weather = weather;
        this.wind = wind;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.precipitation = precipitation;
    }

    // getter methods

    /**
     * Return instance variable precipitation
     * @return
     */
    public double getPrecipitation() {
        return precipitation;
    }

    /**
     * Return instance variable temp_max
     * @return
     */
    public double getTempMax() {
        return temp_max;
    }

    /**
     * Return instance variable temp_min
     * @return
     */
    public double getTempMin() {
        return temp_min;
    }

    /**
     * Return instance variable wind
     * @return
     */
    public double getWind() {
        return wind;
    }

    /**
     * Return instance variable weather
     * @return
     */
    public String getWeather() {
        return weather;
    }
}
