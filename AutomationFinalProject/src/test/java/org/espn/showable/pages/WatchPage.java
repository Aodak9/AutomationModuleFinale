package org.espn.showable.pages;

import org.espn.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WatchPage extends WebOperations {
    @FindBy(css = "section.Carousel")
    private List<WebElement> carouselsContainer;

    @FindBy(css = "section[aria-labelledby^='bucket-40'] li")
    private List<WebElement> carouselCards;

    @FindBy(css = "h2.WatchTile__Title")
    private WebElement cardTitle;

    @FindBy(css = ".WatchTile__Meta")
    private WebElement cardSource;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement exitFromChooseSupplierBtn;

    /**
     * Constructor method for web operations.
     *
     * @param driver : WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    private Boolean carouselsContainerDisplayed(){
        isElementDisplayed(carouselsContainer.get(0), 15);
        return carouselsContainer.size() > 0;
    }

    private Boolean carouselsCardDisplayed(){
        isElementDisplayed(carouselCards.get(0), 15);
        return carouselCards.size() > 0;
    }

    public Boolean carouselsCardTitleDisplayed(){
        List<WebElement> visibleCarouselCards = carouselCards.stream().limit(3).collect(Collectors.toList());

        AtomicInteger truthyValue = new AtomicInteger();

        visibleCarouselCards.forEach(element -> {
            if (!cardTitle.getText().equalsIgnoreCase("") && !cardSource.getText().equalsIgnoreCase("")){
                truthyValue.addAndGet(1);
            }
        });
        return truthyValue.get() == 3;
    }

    public Boolean areWatchPageElementsDisplayed(){
        return carouselsContainerDisplayed() && carouselsCardDisplayed();
    }

    public void clickCarouselCard(int indexCard){
        super.clickElement(carouselCards.get(indexCard), 2);
    }

    public Boolean ExitChooseSupplierButtonDisplayed(){
        return isElementDisplayed(exitFromChooseSupplierBtn, 15);
    }

    public void clickExitFromChooseSupplier(){
        super.clickElement(exitFromChooseSupplierBtn, 5);
    }
}
