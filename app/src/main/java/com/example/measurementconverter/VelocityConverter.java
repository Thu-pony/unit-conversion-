package com.example.measurementconverter;

/**
 * @author Liang
 * @date 2023/6/16 11:50
 * description
 */
public class VelocityConverter implements Converter{
    @Override
    public float convert(int src, int dst, float input_data) {
        float[] srcToKilm = {0,input_data, (float) (input_data * 1.61),(float) (input_data * 1.85)};
        float mediaValue = srcToKilm[src];
        float[] KilmToDst = {0, mediaValue, (float) (mediaValue * 0.621 ), (float) (mediaValue * 0.54054)};
        return KilmToDst[dst];
    }
}
