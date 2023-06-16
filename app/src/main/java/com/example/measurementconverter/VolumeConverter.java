package com.example.measurementconverter;

/**
 * @author Liang
 * @date 2023/6/16 11:53
 * description
 */
public class VolumeConverter implements Converter{

    @Override
    public float convert(int src, int dst, float input_data) {
        float[] srcToCube = {0,input_data, (float) (input_data * 0.0005683),(float) (input_data * 0.1589873),(float) (input_data * 0.0000284)};
        float mediaValue = srcToCube[src];
        float[] CubeToDst = {0, mediaValue, (float) (mediaValue * 1816.1659685) , (float) (mediaValue * 6.2898108), (float) (mediaValue * 35195.0797279)};
        return CubeToDst[dst];
    }
}
