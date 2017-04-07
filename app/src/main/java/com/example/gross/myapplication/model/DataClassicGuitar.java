package com.example.gross.myapplication.model;

import com.example.gross.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gross on 04.04.2017.
 */

public class DataClassicGuitar {

    private static final String[] titles = {"Takamine EG531SSC", "Cort AD810 OP", "Maxtone WGC400N TBK", "Fender CD-60CE", "Grimshaw GSA-60-SB",
            "Fender T-Bucket 300CE QMT TBL ", "LAG Tramontane T100DCE-BLK", "Richwood RD-12-RS", "LAG Tramontane T100ASCE-IVO", "LAG Tramontane T100D-BRS",};
    private static final String[] prices = {"1300 $", "1050 $", "900 $", "700 $", "2500 $", "400 $", "100 $", "300 $", "600 $", "1350 $",};
    private static final int[] fotos = {R.drawable.classic1, R.drawable.classic2, R.drawable.classic3, R.drawable.classic4, R.drawable.classic5,
            R.drawable.classic6, R.drawable.classic7, R.drawable.classic8, R.drawable.classic9, R.drawable.classic10};

    public static List<ListItemGuitar> getListData() {

        List<ListItemGuitar> dataClassicGuitar = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < titles.length; j++) {

                ListItemGuitar item = new ListItemGuitar();
                item.setImageId(fotos[j]);
                item.setTitle(titles[j]);
                item.setPrice(prices[j]);
                dataClassicGuitar.add(item);

            }
        }
        return dataClassicGuitar;
    }

}
