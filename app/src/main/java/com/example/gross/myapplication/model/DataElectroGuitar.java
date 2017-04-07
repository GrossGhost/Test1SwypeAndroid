package com.example.gross.myapplication.model;

import com.example.gross.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gross on 04.04.2017.
 */

public class DataElectroGuitar {

    private static final String[] titles = {"PRS S2 Custom 24", "Ibanez S770PB", "Schecter Hellraiser C-1", "Epiphone Les Paul Custom Pro",
            "Ibanez S521 S Series", "Squier Affinity Stratocaster", "Yamaha Pacifica 112J BL", "Fender Broadcaster", "Gibson SG", "Washburn 22 series Hawk",};
    private static final String[] prices = {"1300 $", "1050 $", "900 $", "700 $", "2500 $", "400 $", "100 $", "300 $", "600 $", "1350 $",};
    private static final int[] fotos = {R.drawable.electro1, R.drawable.electro2, R.drawable.electro3, R.drawable.electro4, R.drawable.electro5,
            R.drawable.electro6, R.drawable.electro7, R.drawable.electro8, R.drawable.electro9, R.drawable.electro10};

    public static List<ListItemGuitar> getListData() {
        List<ListItemGuitar> dataElectroGuitar = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < titles.length; j++) {

                ListItemGuitar item = new ListItemGuitar();
                item.setImageId(fotos[j]);
                item.setTitle(titles[j]);
                item.setPrice(prices[j]);
                dataElectroGuitar.add(item);

            }
        }
        return dataElectroGuitar;
    }

}
