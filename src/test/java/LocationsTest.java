import junitTags.Web;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.LocationCreationPage;
import pageObject.LocationsListerPage;
import utils.dataGeneration.LocationBuilder;

import static com.codeborne.selenide.Selenide.$;
import static utils.dataGeneration.Randomizer.randomizeString;

@Web
public class LocationsTest extends BaseTest {
    LocationsListerPage locationLister = new LocationsListerPage();
    LocationCreationPage locationCreate = new LocationCreationPage();

    @Test
    @DisplayName("Test")
    void visitLocationsPage() {
        LocationBuilder location = new LocationBuilder().toBuilder()
                .name(randomizeString(10))
                .address(randomizeString(10))
                .country("Ukraine")
                .city("Kyiv")
                .build();
        locationLister.openPage(locationLister.pageUrl());
        locationLister.logInAsAdmin();
        int before = locationLister.getLocationsAmount();
        locationLister.addNewLocation();
        locationCreate.fillNewLocation(location);
        int after = locationLister.getLocationsAmount();
        Assert.assertEquals(before+1, after);
        locationLister.searchForLocation(location.getName());
        locationLister.asserts.checkSingleLocationRecordAppears(location.getName());
    }

}
