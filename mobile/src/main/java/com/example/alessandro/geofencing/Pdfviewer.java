package com.example.alessandro.geofencing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

public class Pdfviewer extends AppCompatActivity implements OnPageChangeListener
{

    public static final String THE_FILE = "04_RIVISTA_APRILE.pdf";
    String pdfName = THE_FILE;
    Integer pageNumber = 1;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
        pdfView = (PDFView)findViewById(R.id.pdfview);
        display(pdfName,true);
    }

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage)
            pageNumber = 1;
        setTitle(pdfName = assetFileName);

        pdfView.fromAsset(assetFileName).defaultPage(pageNumber).showMinimap(true)  .onPageChange(this).load();
    }

    @Override
    public void onPageChanged(int page, int pageCount)
    {
        pageNumber = page;
        setTitle(pdfName = pageNumber + "");
    }
}
