package com.jiajia.mpchart;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLineChart = (LineChart) findViewById(R.id.lineChart);
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //设置X轴的文字在底部
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);//设置是否显示横轴表格
//        Legend l = mLineChart.getLegend();
//        l.setEnabled(true);
//        l.setForm(Legend.LegendForm.SQUARE);

        List<Entry> valsComp1 = new ArrayList<Entry>();//模拟Y轴数据1
        List<Entry> valsComp2 = new ArrayList<Entry>();//模拟Y轴数据2
        valsComp1.add(new Entry(1, 6));
        valsComp1.add(new Entry(2, 2));
        valsComp1.add(new Entry(3, 5));
        valsComp1.add(new Entry(4, 4));
        valsComp1.add(new Entry(5, 6));
        valsComp1.add(new Entry(6, 2));
        valsComp1.add(new Entry(7, 5));
        valsComp1.add(new Entry(8, 4));
        valsComp2.add(new Entry(1, 4));
        valsComp2.add(new Entry(2, 7));
        valsComp2.add(new Entry(3, 7));
        valsComp2.add(new Entry(4, 5));
        valsComp2.add(new Entry(5, 4));
        valsComp2.add(new Entry(6, 7));
        valsComp2.add(new Entry(7, 8));
        valsComp2.add(new Entry(8, 5));
        /**
         * 曲线样式设置
         */
        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");//构建一个LineDataSet 代表一组Y轴数据
        setComp1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        setComp1.setCubicIntensity(0.3f);//置曲线顺滑度
        // setComp1.setLineWidth(dip2px(this, 1.0f)); //射置曲线width
        //  setComp1.setCircleSize(dip2px(this, 2.0f));//射置曲线上圆点大小
        setComp1.setFillColor(Color.CYAN);//射置曲线填充颜色
        setComp1.setFillAlpha(128);//射置曲线填充颜色透明度
        setComp1.setDrawFilled(true);//设置曲线填冲是否启用
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setCircleColor(Color.RED);//设置圆点颜色
        setComp1.setColor(Color.GRAY);//设置曲线的颜色

        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp2.setColor(Color.RED);
        setComp2.setCircleColor(Color.CYAN);

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        mLineChart.invalidate(); // refresh
//        new Handler().postDelayed(new Runnable(){
//            public void run() {
//                //execute the task
//            }
//        }, 9000);


//        List<ILineDataSet> dataSet = new ArrayList<ILineDataSet>();
//        dataSet.add(setComp1);
//        LineData datas = new LineData(dataSet);
//        mLineChart.setData(datas);
//        mLineChart.invalidate(); // refresh

    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
