package com.example.measurementconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liang
 * @date 2023/6/15 15:30
 * description
 * tabFragment 类
 */
public class TabFragment extends Fragment {
    private TextView mTextView;
    private String mTitle;
    private List<String> mDatas;
    private EditText mEdittext;
    private Spinner mSpinnerInput, mSpinnerOutput;
    private Button btn;
    private int src = 0;
    private int dst = 0;
    private int mPos = -1;
    private Converter mConverter;
    private String[][] titles = {{"请选择单位","米(metre)","公里(kilometre)","海里(nautical mile)","英里(mile)","英尺(foot)"},
            {"请选择单位","摄氏度(C)","华氏度(F)","开氏度(K)"},{"请选择单位","瓦(W)","英制马力(HP)","米制马力(PS)"},
            {"请选择单位","公里/时, 千米/时)","(海里/小时)","knot 节"},{"请选择单位","立方米(m3)","品脱(pt)","桶[42加仑]","液量盎司(fl oz)"}};
   // private TextView mInputText, mOutputText;
   private Converter[] mConverters = {new LengthConverter(), new temperatureConvert(),new PowerConverter(),new VelocityConverter(), new VolumeConverter()};
    //构造方法是便于调用各导航栏的任意一个Fragment
    public TabFragment(String title, int pos){
        mTitle = title;
        mPos = pos;
        mConverter = mConverters[pos];
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab,container,false);
        //titleTv = view.findViewById(R.id.measure_title);
        //titleTv.setText(mTitle);
        mSpinnerInput = view.findViewById(R.id.inputSpinner);
        mSpinnerOutput = view.findViewById(R.id.outputSpinner);
//      mOutputText = view.findViewById(R.id.output_measurement);
        btn = view.findViewById(R.id.btn_convert);
        mDatas = new ArrayList<>(Arrays.asList(titles[mPos]));
        mEdittext = view.findViewById(R.id.input_data);
        mTextView = view.findViewById(R.id.output_data);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(mDatas,this.getContext());
        mSpinnerInput.setAdapter(spinnerAdapter);
        mSpinnerInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("AAAAAA","输入单位为：" + mDatas.get(position));
                //mInputText.setText(mDatas.get(position));
                src = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mSpinnerOutput.setAdapter(spinnerAdapter);
        mSpinnerOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("AAAAAA","输出单位为：" + mDatas.get(position));
                dst = position;
               // mOutputText.setText(mDatas.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (src == 0 || dst == 0){
                    Toast.makeText(getActivity(),"请选择输入或输出单位",Toast.LENGTH_SHORT).show();
                    return;
                }
                String input_data = mEdittext.getText().toString();
                if (input_data == null || input_data.isEmpty()) {
                    Toast.makeText(getActivity(),"请输入要转换的数据",Toast.LENGTH_SHORT).show();
                    return;
                }
                float res = mConverter.convert(src, dst, Float.valueOf(input_data));
                mTextView.setText("计算结果为：" + res);
                return;
            }
        });
        return view;
    }
}
