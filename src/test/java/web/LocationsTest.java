package web;

import junitTags.Web;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.web.locations.LocationCreationPage;
import pageObject.web.locations.LocationsListerPage;
import utils.dataGeneration.LocationBuilder;

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
                .description("Test description")
                .address(randomizeString(10))
                .country("Ukraine")
                .city("Kyiv")
                .build();
        locationLister.openPage(locationLister.pageUrl());
        locationLister.logInAsAdmin();
        int before = locationLister.getLocationsAmount();
        locationLister.addNewLocation();
        locationCreate.fillNewLocation(location);
        locationCreate.saveNewLocation();
        int after = locationLister.getLocationsAmount();
        Assert.assertEquals(before+1, after);
        locationLister.searchForLocation(location.getName());
        locationLister.asserts.checkSingleLocationRecordAppears(location.getName());
    }

}
