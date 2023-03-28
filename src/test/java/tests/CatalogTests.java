package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static enums.Manufacture.*;
import static helpers.CatalogHelper.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogTests extends BaseTest{

    private static final String url = "https://onliner.by";

    @BeforeAll
    public void setUp() {
        open(url);
    }

    @Test
    public void shouldCheckFilterWhenDysonSelected() {
        //when
        driver.findElement(FEN_BUTTON).click();
        driver.findElement(CLOSE_LOCATE_WINDOW).click();
        ScrollPage();
        selectManufacture(DYSON.getText());
        //given
        String tag = driver.findElement(By.xpath(DYSON_TAG)).getText();
        //then
        assertThat(tag).isEqualTo(DYSON.getText());
    }

    @Test
    public void shouldSelectSeveralManufactures() {
        //given
        List<String> manufactures = new ArrayList<>();
        manufactures.add(DYSON.getText());
        manufactures.add(ROWENTA.getText());
        manufactures.add(BABYLISS.getText());
        manufactures.add(BABYLISS_PRO.getText());
        //when
        open(url);
        driver.findElement(FEN_BUTTON).click();
        ScrollPage();
        selectManufacture(manufactures.get(0));
        selectManufacture(manufactures.get(1));
        selectManufacture(manufactures.get(2));
        selectManufacture(manufactures.get(3));
        //then
        assertThat(getTags().containsAll(manufactures)).isTrue();
    }

    @AfterAll
    public void tearDown() {
       close();
    }
}
