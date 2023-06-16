package com.example.measurementconverter;

/**
 * @author Liang
 * @date 2023/6/16 8:49
 * description
 */
public interface Converter {
    public float convert(int src, int dst, float input_data);
}
