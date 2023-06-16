package com.example.measurementconverter;

/**
 * @author Liang
 * @date 2023/6/16 11:38
 * description
 */
public class temperatureConvert implements  Converter{

    @Override
    public float convert(int src, int dst, float input_data) {
        float[] srcToCentigrade = {0,input_data, (float) ((input_data - 32) / 1.8),(float) (input_data - 273.15)};
        float mediaValue = srcToCentigrade[src];
        float[] CentigradeToDst = {0, mediaValue, (float) (mediaValue * 1.8) + 32, (float) (mediaValue + 273.15)};
        return CentigradeToDst[dst];
    }
}
