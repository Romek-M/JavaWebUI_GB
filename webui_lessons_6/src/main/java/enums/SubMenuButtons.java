package enums;

import org.openqa.selenium.By;
import IMenuButtons;

public enum SubMenuButtons implements IMenuButtons {
    MY_PROJECT(".//li[@data-routes='[\"\\/^crm_project_my\\/\"]']"),
    BUSINESS_TRIPS(".//li[@data-routes='[\"\\/^crm_project_[^bonus]\\/\"]']");
//    CENTER_COSTS("TODO"),
//    BUSINESS_CONTRACTS("TODO");

    private final By by;

    SubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}

