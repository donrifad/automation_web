package org.ubs.functions;

import org.ubs.pages.SideFilterPanel;

public class AmazonFilters extends FunctionBase{

    private static SideFilterPanel sideFilterPanel = new SideFilterPanel();
    public static void searchFor(String modelYear, String brand, String camera, String minPrice,  String maxPrice) {
        sideFilterPanel.searchFor(modelYear, brand, camera, minPrice, maxPrice);
    }


}
