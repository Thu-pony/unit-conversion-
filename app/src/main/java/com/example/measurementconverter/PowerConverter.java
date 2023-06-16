package com.example.measurementconverter;

/**
 * @author Liang
 * @date 2023/6/16 11:47
 * description
 */
public class PowerConverter implements Converter{
    @Override
    public float convert(int src, int dst, float input_data) {
        float[] srcToWatt = {0,input_data, (float) (input_data * 745.712172),(float) (input_data * 735.2941)};
        float mediaValue = srcToWatt[src];
        float[] WattToDst = {0, mediaValue, (float) (mediaValue * 0.001341) + 32, (float) (mediaValue * 0.0013600)};
        return WattToDst[dst];
    }
}
