package com.example.measurementconverter;

/**
 * @author Liang
 * @date 2023/6/16 8:50
 * description
 */
public class LengthConverter implements Converter{
    @Override
    public float convert(int src, int dst, float input_data) {
        //全部转换为米
        float[] srcToMeter = {0,input_data, (float) (input_data * 1000.0),(float) (input_data * 1852.0), (float)(input_data * 1609.344),(float) (input_data * 0.3048)};
        float mediaValue = srcToMeter[src];
        float[] MeterToDst = {0, mediaValue, (float) (mediaValue * 0.001), (float) (mediaValue * 0.00054), (float) (mediaValue * 0.0006214), (float) (mediaValue * 3.2808399)};
        return MeterToDst[dst];
    }
}
