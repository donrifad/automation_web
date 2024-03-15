package org.ubs.functions;

import org.openqa.selenium.By;
import org.ubs.data.SearchedItem;
import org.ubs.pages.AmazonHomePage;
import org.ubs.pages.AmazonResultPage;

import java.util.List;

public class AmazonHome  extends FunctionBase{

    private static AmazonHomePage homePage = new AmazonHomePage();
    private static AmazonResultPage amazonResultPage = new AmazonResultPage();

    public static void navigateToMenu(String department, String subMenu, String category){
        homePage.navigateTo(department, subMenu, category);
    }

    public static boolean isMessageDisplayed(String message){
        try {
            return amazonResultPage.isMessageDisplayed(message);
        }
        catch (Exception e){
            return false;
        }
    }

    public static List<SearchedItem> getSearchedResult(){
        return amazonResultPage.getListOfSearchedItems();
    }


    }
